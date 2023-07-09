package com.dockerjenkinsmaven.www.lib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class DataGenerator {
	
	
	
	public String generateUniqueEmailAddress() {
		String emailId="foo+";
		String domain="gmail.com";
		SimpleDateFormat time_formatter=new SimpleDateFormat("yyyyMMddHHmmss");
		String current_time_str=time_formatter.format(System.currentTimeMillis());
		String emailAddress=emailId+current_time_str+domain;
		return emailAddress;
	}




public int generateRandomDigitsOf(int n) {
	int m=(int) Math.pow(10, n-1);
	return m + new Random().nextInt(9*m);
}





public String generateRandomAsString(int n) {
	int m=(int) Math.pow(10, n-1);
	int intNumber =m + new Random().nextInt(9*m);
	return String.valueOf(intNumber);
}



public String generateDateOfBirth() throws ParseException {
	Random random=new Random();
	
	int minDay=(int) LocalDate.of(1980, 1, 1).toEpochDay();
	
	int maxDay=(int) LocalDate.of(2010, 1, 1).toEpochDay();
	
	long randomDay=minDay+random.nextInt(maxDay-minDay);
	
	LocalDate randomBirthdate=LocalDate.ofEpochDay(randomDay);
	
	String DOBString=String.valueOf(randomBirthdate);
	
	Date dobDateConvert= new SimpleDateFormat("yyyy-mm-dd").parse(DOBString);
	
	SimpleDateFormat date_formatter=new SimpleDateFormat("MM/dd/yyyy");
	String DateOfBirth=date_formatter.format(dobDateConvert);
	return DateOfBirth;
	
}


public String genarteFirstName() {
//	use FAKER
//	Faker faker=new Faker();
//	String firstName=faker.name().firstName();
	return null;
	
}



public String genarteLastName() {
//	use FAKER
//	Faker faker=new Faker();
//	String lastName=faker.name().firstName();
	return null;
	
}



}