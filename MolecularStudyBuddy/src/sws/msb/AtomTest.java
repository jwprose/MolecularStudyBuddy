package sws.msb;

// -------------------------------------------------------------------------
/**
 *  Tests the Atom class.
 *
 *  @author patrick
 *  @version 2012.03.13
 */
public class AtomTest extends student.TestCase
{
    // ----------------------------------------------------------
    /**
     * Tests the constructors of Atom.
     */
    public void testConstructors()
    {
        Atom a = new Atom("Li");
        assertEquals(a.getSymbol(), "Li");
        assertEquals(a.getElement().getName(), "Lithium");

        a = new Atom(Element.Cl);
        assertEquals(a.getElement().getNumber(), 17);
    }
}
