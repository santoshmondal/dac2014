package com.dac.coupling;

/**
 * This is ASPECT CLASS.
 * The methods are known as Aspect Advice/ Common Task. 
 * 
 * This is also termed as CrossCutting Concerns.
 */
public class CommonAspect {
	
	// Adcice NO1.
	public void logRequest() {
		System.out.println("Happy B'Day Jayesh..Jai Ho!!!");
	}
	
	public void afterMethod() {
		System.out.println("Now back to work...!!!");
	}

}
