package sws.msb;

import android.graphics.PointF;

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
    private PointF location;

    // ----------------------------------------------------------
    /**
     * Create a new Atom object.
     * @param element
     */
    public Atom (Element element)
    {
        setElement(element);
        this.location = new PointF(0, 0);
    }

    // ----------------------------------------------------------
    /**
     * Create a new Atom object from a given symbol.
     * @param symbol
     */
    public Atom (String symbol)
    {
        setElement(symbol);
        this.location = new PointF(0, 0);
    }
    
    public Atom (Element element, PointF point) {
        setElement(element);
        this.location = point;
    }
    
    public Atom (String symbol, PointF point) {
        setElement(symbol);
        this.location = point;
    }
    
    public Atom (Element element, float x, float y) {
        setElement(element);
        this.location = new PointF(x, y);
    }
    
    public Atom (String symbol, float x, float y) {
        setElement(symbol);
        this.location = new PointF(x, y);
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
    
    public PointF getLocation() {
        return this.location;
    }
    
    public void setLocation(PointF point) {
        this.location = point;
    }
    
    public void setLocation(float x, float y) {
        this.location = new PointF(x, y);
    }
}