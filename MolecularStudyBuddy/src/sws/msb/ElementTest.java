package sws.msb;


// -------------------------------------------------------------------------
/**
 *  Tests the Element class.
 *
 *  @author patrick
 *  @version 2012.03.13
 */
public class ElementTest extends student.TestCase
{
    // ----------------------------------------------------------
    /**
     * Tests the getSymbol() method.
     */
    public void testGetSymbol()
    {
        assertEquals("H", Element.H.getSymbol());
        assertEquals("C", Element.C.getSymbol());
    }

    // ----------------------------------------------------------
    /**
     * Tests the getNumber() method.
     */
    public void testGetNumber()
    {
        assertEquals(1, Element.H.getNumber());
        assertEquals(14, Element.Si.getNumber());
        assertEquals(8, Element.O.getNumber());
    }

    // ----------------------------------------------------------
    /**
     * Tests the getName() method.
     */
    public void testGetName()
    {
        assertEquals("Nitrogen", Element.N.getName());
    }
}
