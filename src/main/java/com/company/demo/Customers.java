package com.company.demo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customers implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	private int ID;
	private String NAME;
	private String ADDRESS;
	private long PHONE;
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
	
	public int getID() {
		return ID;
	}
	
	public void setID(int Id) {
		ID = Id;
	}
	 
	}
	

	
	

