package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Class representing an unit. 
 * Unit tags have names and multipliers. 
 * E.g. if the main answer is in kilometers, an additional answer could be the equivalent in meters with a multiplier of 1000.
 * @author Marsupilami's Band
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Unit {

	int imultiplier;
	String sunitname;

	/**
	 * The default constructor of a new Unit
	 */
	public Unit() {
		super();
	}


	/**
	 * Construct a new Unit with all fields
	 * @param multiplier
	 * @param unitname
	 */
	public Unit(int multiplier, String unitname) {
		super();
		this.imultiplier = multiplier;
		this.sunitname = unitname;
	}

	/**
	 * 
	 * @return the multiplier
	 */
	public int getMultiplier() {
		return imultiplier;
	}

	/**
	 * 
	 * @param multiplier the multiplier
	 */
	public void setMultiplier(int multiplier) {
		this.imultiplier = multiplier;
	}


	/**
	 * 
	 * @return the unit name
	 */
	public String getUnitname() {
		return sunitname;
	}
	/**
	 * 
	 * @param unit_name the unit name
	 */
	public void setUnit_name(String unitname) {
		this.sunitname = unitname;
	}

}
