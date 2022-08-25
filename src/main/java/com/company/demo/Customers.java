package com.company.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customers {

	
	@Id
	private int ID;
	private String NAME;
	private String ADDRESS;
	private long PHONE;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public long getPHONE() {
		return PHONE;
	}
	public void setPHONE(long pHONE) {
		PHONE = pHONE;
	}
	@Override
	public String toString() {
		return "Customers [ID=" + ID + ", NAME=" + NAME + ", ADDRESS=" + ADDRESS + ", PHONE=" + PHONE + "]";
	}
	

	
	
}
