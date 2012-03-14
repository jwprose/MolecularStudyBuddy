package sws.msb;

// -------------------------------------------------------------------------
/**
 *  Elementary, my dear Watson.
 *
 *  @author patrick, jason
 *  @version 2012.03.13
 */
public enum Element {

 // Elements MUST be in order of increasing atomic number, with no gaps, for
 // getNumber() to return the correct value.
    H ("Hydrogen"),
    He ("Helium"),
    Li ("Lithium"),
    Be ("Beryllium"),
    B ("Boron"),
    C ("Carbon"),
    N ("Nitrogen"),
    O ("Oxygen"),
    F ("Fluorine"),
    Ne ("Neon"),
    Na ("Sodium"),
    Mg ("Magnesium"),
    Al ("Aluminum"),
    Si ("Silicon"),
    P ("Phosphorus"),
    S ("Sulfur"),
    Cl ("Chlorine"),
    Ar ("Argon")
 // TODO Add the remaining elements.
    ;

	private final String name;



	// ----------------------------------------------------------
	/**
	 * Create a new Element object.
	 * @param name
	 * @param symbol
	 * @param number
	 */
	private Element(String name) {
	    this.name = name;
	}



	// ----------------------------------------------------------
	/**
	 * @return the English name of the element
	 */
	public String getName()	 {
		return name;
	}

	// ----------------------------------------------------------
	/**
	 * @return the symbol of the element
	 */
	public String getSymbol() {
		return name();
	}

	// ----------------------------------------------------------
	/**
	 * @return the atomic number of the element
	 */
	public int getNumber() {
		return ordinal() + 1;
	}


}