package org.jpcr.controller;

import java.util.Random;

import org.jpcr.exceptions.PasswordException;
import org.jpcr.helpers.Constants;
import org.jpcr.model.Password;

public class PasswordController {

	/**
	 * This method will generate the final password.
	 * @param len
	 * @param symbols
	 * @param numbers
	 * @param lowerChar
	 * @param upperChar
	 * @return password
	 * @throws Exception 
	 */
	public Password generatePassword(int len, boolean symbols, boolean numbers, boolean lowerChar, boolean upperChar) throws PasswordException {

		String passwdTxt = "";
		Random rand = new Random();

		if (!symbols && !numbers && !lowerChar && !upperChar) {
			throw new PasswordException("You must select at least one option.");
		}
		
		for(int i = 0; i < len; i++) {

			int arrayToCheck = rand.nextInt(4);
			int arrayIndex = 0;

			switch (arrayToCheck) {
			case 0: {
				if(symbols) {
					arrayIndex = rand.nextInt(Constants.symbolsArray.length);
					passwdTxt = passwdTxt + String.valueOf(Constants.symbolsArray[arrayIndex]);
				}else {
					i--;
				}
				break;
			}
			case 1: {
				if(numbers) {
					arrayIndex = rand.nextInt(Constants.numbersArray.length);
					passwdTxt = passwdTxt + String.valueOf(Constants.numbersArray[arrayIndex]);
				}else {
					i--;
				}
				break;
			}
			case 2: {
				if(lowerChar) {
					arrayIndex = rand.nextInt(Constants.lowwerCharsArray.length);
					passwdTxt = passwdTxt + String.valueOf(Constants.lowwerCharsArray[arrayIndex]);	

				}else {
					i--;
				}
				break;
			}
			case 3: {
				if(upperChar) {
					arrayIndex = rand.nextInt(Constants.upperCharsArray.length);
					passwdTxt = passwdTxt + String.valueOf(Constants.upperCharsArray[arrayIndex]);

				}else {
					i--;
				}
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + arrayToCheck);
			}
		}

		Password passwd = new Password();
		passwd.setPasswordText(passwdTxt);

		return passwd;
	}
}
