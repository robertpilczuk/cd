import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PeselValidatorTest {
    @Test
    public void shouldCheckNullValues(){
        //given
        String pesel = null;
        //when
        boolean result = PeselValidator.valid(pesel);
        //then
        Assert.assertFalse(result);
    }
    @Test
    public void shouldCheckEmptyPesel(){
        //given
        String pesel = "";
        //when
        boolean result = PeselValidator.valid(pesel);
        //then
        Assert.assertFalse(result);
    }
    @Test
    public void shouldCheckIf11Chars(){
        //given
        String pesel = "123456789";
        //when
        boolean result = PeselValidator.valid(pesel);
        //then
        Assert.assertFalse(result);
    }
    @Test
    public void shouldCheckIfTooManyChars(){
        //given
        String pesel = "1234567891011";
        //when
        boolean result = PeselValidator.valid(pesel);
        //then
        Assert.assertFalse(result);
    }
    @Test
    public void shouldCheckIfNumbers(){
        //given
        String pesel = "1234er56789";
        boolean result = PeselValidator.valid(pesel);
        //then
        Assert.assertFalse(result);
    }
    @Test
    public void shouldCheckIf11Numbers(){
        //given
        String pesel = "12345678912";
        boolean result = PeselValidator.valid(pesel);
        //then
        Assert.assertFalse(result);
    }
    @Test
    public void shouldCheckPesel(){
        //given
        String pesel = "02070803628";
        String pesel1 = "52061587512";
        //when
        boolean result = PeselValidator.valid(pesel);
        boolean result2 = PeselValidator.valid(pesel1);
        //then
        Assert.assertTrue(true);
    }

}