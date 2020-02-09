import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
@AllArgsConstructor
public class PlytaCD {
    private double zajeteMiejsce;
    private double wolneMiejsce;
    private String autor;
    private String tytul;
    private List<Utwor> utwory = new ArrayList<>();

    public void dodajUtwor(Utwor utwor) {
        long count = utwory.stream().filter(e -> e.getNazwaUtworu().equals(utwor.getNazwaUtworu())).count();
        if (count == 0) {
            utwory.add(utwor);
        }
        else{
            System.out.println("Taki utwór został już dodany");
        }
    }
}
