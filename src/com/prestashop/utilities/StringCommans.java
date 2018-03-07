package com.prestashop.utilities;

public class StringCommans {

	public static void main(String[] args) {
		
	}	
	
	
	public static String extractNumberFromString(String targetString) {
		
		//String employeeID="Cybertek003Tech112ABC";
        String onlyNumber="";
		for (int i = 0; i < targetString.length(); i++) {
			char eachChar=targetString.charAt(i);
			if(Character.isDigit(eachChar)) {
				//System.out.println(eachChar);
				onlyNumber+=eachChar;
			}
		}
		System.out.println(onlyNumber);
		return onlyNumber;
	}
	// same code extractNumberFromString = getOnlyDigits
	
	public static String getOnlyDigits(String str) {
		String result ="";
		for(int i=0;i<str.length();i++) {
			if(Character.isDigit(str.charAt(i))) {
				result+=str.charAt(i)+"";
			}
		}
		
		return result;
	}
	
	
	public static String convertToDoubleBackToString(String price) {
		price = price.replace("$", "");
		Double priceD = Double.parseDouble(price);
		return priceD.toString();
	}
}
