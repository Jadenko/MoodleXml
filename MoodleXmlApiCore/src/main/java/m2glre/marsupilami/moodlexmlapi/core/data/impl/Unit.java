package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Unit {

	int imultiplier;
	String sunitname;

	public Unit() {
		super();
	}

	public Unit(int multiplier, String unitname) {
		super();
		this.imultiplier = multiplier;
		this.sunitname = unitname;
	}

	public int getMultiplier() {
		return imultiplier;
	}

	public void setMultiplier(int multiplier) {
		this.imultiplier = multiplier;
	}

	public String getUnitname() {
		return sunitname;
	}

	public void setUnit_name(String unitname) {
		this.sunitname = unitname;
	}

}
