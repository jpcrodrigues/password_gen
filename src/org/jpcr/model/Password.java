package org.jpcr.model;

import java.util.Date;

public class Password {

	private String passwordText;
	private Date generatedOn;
	
	public Password(){
		this.setGeneratedOn(new Date());
	}
	
	public String getPasswordText() {
		return passwordText;
	}
	
	public void setPasswordText(String passwordText) {
		this.passwordText = passwordText;
	}
	
	public Date getGeneratedOn() {
		return generatedOn;
	}
	
	private void setGeneratedOn(Date generatedOn) {
		this.generatedOn = generatedOn;
	}
}
