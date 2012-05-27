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

	int multiplier;
	String unit_name;

	/**
	 * The default constructor of a new Unit
	 */
	public Unit() {
		super();
	}

	/**
	 * Construct a new Unit with all fields
	 * @param multiplier
	 * @param unit_name
	 */
	public Unit(int multiplier, String unit_name) {
		super();
		this.multiplier = multiplier;
		this.unit_name = unit_name;
	}

	/**
	 * 
	 * @return the multiplier
	 */
	public int getMultiplier() {
		return multiplier;
	}

	/**
	 * 
	 * @param multiplier the multiplier
	 */
	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
	}

	/**
	 * 
	 * @return the unit name
	 */
	public String getUnit_name() {
		return unit_name;
	}

	/**
	 * 
	 * @param unit_name the unit name
	 */
	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}

}
