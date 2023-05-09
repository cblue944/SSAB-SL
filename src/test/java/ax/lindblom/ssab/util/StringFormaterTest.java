package ax.lindblom.ssab.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringFormaterTest {

    @Test
    void cutThrowsExceptionForZeroMaxLengts(){
        assertThrows(IllegalArgumentException.class, ()->StringFormater.cutWithEllipsis("String", 0));
    }
    @Test
    void cutThrowsExceptionForNegativeMaxLengts(){
        assertThrows(IllegalArgumentException.class, ()->StringFormater.cutWithEllipsis("String", -1));
    }
    @Test
    void cutToLongText(){
        String result = StringFormater.cutWithEllipsis("String", 5);
        assertEquals("St...", result);
    }
    @Test
    void cutTextOfEqualLengthAsMaxLength(){
        String result = StringFormater.cutWithEllipsis("String", 6);
        assertEquals("String", result);
    }
    @Test
    void cutTextOfShorterLengtThanMaxLength(){
        String result = StringFormater.cutWithEllipsis("String", 6);
        assertEquals("String", result);
    }
}