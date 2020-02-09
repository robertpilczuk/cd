import org.junit.Assert;
import org.junit.Test;

import javax.management.BadBinaryOpValueExpException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BibliotekaCDTest {
    @Test
    public void shouldAddCD() {
        //given
        PlytaCD cd1 = new PlytaCD(500, 300, "Bbb", "Aaa", new ArrayList<>());
        PlytaCD cd2 = new PlytaCD(500, 300, "Ccc", "Aaa", new ArrayList<>());
        BibliotekaCD biblioteka = new BibliotekaCD("Biblioteka", new ArrayList<>());
        //when
        biblioteka.addCD(cd1);
        biblioteka.addCD(cd2);
        //then
        Assert.assertEquals(1, biblioteka.getListaCD().size());
    }

    @Test
    public void shouldRemoveCD() {
        //given
        PlytaCD cd1 = new PlytaCD(500, 300, "Ccc", "Aaa", new ArrayList<>());
        BibliotekaCD biblioteka = new BibliotekaCD("Biblioteka", new ArrayList<>());
        biblioteka.addCD(cd1);
        Assert.assertEquals(1, biblioteka.getListaCD().size());
        //when
        biblioteka.removeCD("Aaa");
        //then
        Assert.assertTrue(biblioteka.getListaCD().isEmpty());
    }

    @Test
    public void shouldWriteToFile() throws IOException {
        //given
        Utwor utwor1 = new Utwor("PsychoSocial", "Slipknot", 4.5);
        Utwor utwor2 = new Utwor("AllHopeIsGone", "Slipknot", 4);
        Utwor utwor = new Utwor("PulseOfTheMaggots", "Slipknot", 5);
        Utwor utwor3 = new Utwor("PulseOfTheMaggots", "Slipknot", 5);
        Utwor utwor4 = new Utwor("PulseOfTheMaggots", "Slipknot", 5);
        Utwor utwor5 = new Utwor("PulseOfTheMaggots", "Slipknot", 5);

        PlytaCD cd1 = new PlytaCD(500, 300, "Slipknot", "AllHopeIsGone", new ArrayList<>());
        PlytaCD cd2 = new PlytaCD(500, 300, "DeathClock", "MetaloCalypse", new ArrayList<>());
        cd1.dodajUtwor(utwor);
        cd1.dodajUtwor(utwor2);
        cd2.dodajUtwor(utwor1);
        BibliotekaCD biblioteka = new BibliotekaCD("Biblioteka", new ArrayList<>());
        biblioteka.addCD(cd1);
        biblioteka.addCD(cd2);
        //when
        String zapisanaBiblioteka = "zapisanaBiblioteka";
        BibliotekaCD.zapiszNaDysk(biblioteka, zapisanaBiblioteka);
        BibliotekaCD bibliotekaCD = BibliotekaCD.odczytZDysku(zapisanaBiblioteka);
        //then
        Assert.assertEquals("Biblioteka", bibliotekaCD.getName());
        Assert.assertEquals(2, bibliotekaCD.getListaCD().size());
        Assert.assertEquals(2, bibliotekaCD.getListaCD().get(0).getUtwory().size());
        Assert.assertEquals(1, bibliotekaCD.getListaCD().get(1).getUtwory().size());
    }

//    @Test
//    public void testOdczytuZPliku() throws FileNotFoundException {
//        //given
//        String nazwaPliku = "zapisanaBiblioteka";
//        //when
//        BibliotekaCD bibliotekaCD = BibliotekaCD.odczytZDysku(nazwaPliku);
//        //then
//        Assert.assertEquals("Biblioteka", bibliotekaCD.getName());
//        Assert.assertEquals(2, bibliotekaCD.getListaCD().size());
//        Assert.assertEquals(2, bibliotekaCD.getListaCD().get(0).getUtwory().size());
//        Assert.assertEquals(1, bibliotekaCD.getListaCD().get(1).getUtwory().size());
//    }
}