import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtworTest {

    @Test
    public void shouldCreateUtwor() {
        //given
        String nazwaUtworu = "AllHopeIsGone";
        String autorUtoru = "Slipknot";
        double dlugoscUtowru = 4.5;
        //then
        Utwor utwor = new Utwor(nazwaUtworu,autorUtoru,dlugoscUtowru);
        //when
        Assert.assertEquals(nazwaUtworu, utwor.getNazwaUtworu());
        Assert.assertEquals(autorUtoru, utwor.getAutorUtworu());
        Assert.assertEquals(Double.valueOf(dlugoscUtowru), Double.valueOf(utwor.getDlugoscUtworu()));
    }
}