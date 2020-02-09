import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.management.BadBinaryOpValueExpException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@AllArgsConstructor
@Getter
public class BibliotekaCD {
    private String name;
    private List<PlytaCD> listaCD = new ArrayList<>();

    public void addCD(PlytaCD cd) {
        long cout = listaCD.stream().filter(e -> e.getTytul().equals(cd.getTytul())).count();
        if (cout == 0) {
            listaCD.add(cd);
        } else {
            System.out.println("Płyta jest już na liście");
        }
    }

    public void removeCD(String title) {
        Optional<PlytaCD> cd = listaCD.stream().filter(e -> e.getTytul().equals(title)).findAny();
        if (cd.isPresent()) {
            listaCD.remove(cd.get());
        }
    }

    public static BibliotekaCD odczytZDysku(String nazwaPliku) throws FileNotFoundException {
        Scanner odczyt = new Scanner(new File(nazwaPliku));
        boolean czyIstnieje = false;
        BibliotekaCD bibliotekaCD = null;
        while (odczyt.hasNextLine()) {
            String linia = odczyt.nextLine();
            if (!czyIstnieje) {
                bibliotekaCD = new BibliotekaCD(linia, new ArrayList<>());
                czyIstnieje = true;
            } else {
                String[] poPodziale = linia.split("#");
                String plytaCDtest = poPodziale[0].trim();
                String[] plytaCdDane = plytaCDtest.split(";");
                PlytaCD plytaCD = new PlytaCD(Double.valueOf(plytaCdDane[3]), Double.valueOf(plytaCdDane[2]),
                        plytaCdDane[0], plytaCdDane[1], new ArrayList<>());
                bibliotekaCD.addCD(plytaCD);

                String[] podzialPoUtworach = poPodziale[1].trim().split("@");
                for (String s: podzialPoUtworach) {
                    String[] daneUtworow = s.trim().split(";");
                    Utwor utwor = new Utwor(daneUtworow[0],daneUtworow[1],Double.valueOf(daneUtworow[2]));
                    plytaCD.dodajUtwor(utwor);
                }
            }
        }
        return bibliotekaCD;
    }

    public static void zapiszNaDysk(BibliotekaCD bibliotekaCD, String nazwaPliku) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(nazwaPliku));
        String nazwaBiblioteki = bibliotekaCD.getName();
        List<PlytaCD> listaCD = bibliotekaCD.getListaCD();
        writer.write(nazwaBiblioteki);
        writer.write("\n");
        for (PlytaCD cd : listaCD) {
            writer.write(cd.getAutor());
            writer.write(";");
            writer.write(cd.getTytul());
            writer.write(";");
            writer.write(String.valueOf(cd.getWolneMiejsce()));
            writer.write(";");
            writer.write(String.valueOf(cd.getZajeteMiejsce()));
            writer.write("#");
//            writer.write("\n");

            for (Utwor u : cd.getUtwory()) {
                writer.write(u.getNazwaUtworu());
                writer.write(";");
                writer.write(u.getAutorUtworu());
                writer.write(";");
                writer.write(String.valueOf(u.getDlugoscUtworu()));
                writer.write("@");

            }
            writer.write("\n");
        }
        writer.close();
    }
}
