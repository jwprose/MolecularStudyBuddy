package sws.msb;

//-------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author patrick
 *  @version 2012.03.13
 */
public class Atom
{
    private Element element;

    // ----------------------------------------------------------
    /**
     * Create a new Atom object.
     * @param element
     */
    public Atom (Element element)
    {
        setElement(element);
    }

    // ----------------------------------------------------------
    /**
     * Create a new Atom object from a given symbol.
     * @param symbol
     */
    public Atom (String symbol)
    {
        setElement(symbol);
    }

    // ----------------------------------------------------------
    /**
     * Get the symbol.
     * @return the symbol of the element.
     */
    public String getSymbol()
    {
        return element.getSymbol();
    }

    // ----------------------------------------------------------
    /**
     * @return the element
     */
    public Element getElement()
    {
        return element;
    }

    // ----------------------------------------------------------
    /**
     * Set the element.
     * @param e
     */
    public void setElement(Element e)
    {
        this.element = e;
    }

    // ----------------------------------------------------------
    /**
     * Set the element based on a given symbol.
     * @param symbol
     */
    public void setElement(String symbol)
    {
        setElement(Element.valueOf(symbol));
    }
}