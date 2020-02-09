import org.junit.Assert;
import org.junit.Test;

public class KlientTest {

    @Test
    public void shouldCreateNewKlient(){
        //given
        String imie = "Jan";
        String nazwisko = "Kowalski";
        int nrKlienta = 1;
        String pesel = "52061587512";
        //when
        Klient klientExpected = new Klient(imie, nazwisko, nrKlienta, pesel);
        //then
        Assert.assertEquals(imie, klientExpected.getImie());
        Assert.assertEquals(nazwisko, klientExpected.getNazwisko());
        Assert.assertEquals(nrKlienta, klientExpected.getNrKlienta());
        Assert.assertEquals(pesel, klientExpected.getPesel());
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException(){
        //when
        Klient klient = new Klient("Jan", "Kowalski", 1, "11122234567");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException2(){
        //when
        Klient klient = new Klient("", "", 1, "11122234567");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldCheckPesel(){
        //given
        Klient klient = new Klient("Jan", "Kowalski", 1, "52061587512");
        klient.setPesel("11122234567");

    }
    @Test()
    public void shouldValidatekPesel(){
        //given
        Klient klient = new Klient("Jan", "Kowalski", 1, "52061587512");
        klient.setPesel("70012242789");
        //when
        Assert.assertEquals("70012242789", klient.getPesel());
    }
}