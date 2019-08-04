package com.Anderson.LMS;

public class Publisher {
	
	private String name;
	private String address;
	int id;
	
	
	public String getName()
	
	{
		return name;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String ad)
	{
		address = ad;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int I)
	{
		id = I;
	}
	
	public Publisher()
	{
		setName("none");
		setAddress("none");
		setId(0);
	}
	public Publisher(String n, String ad, int I)
	{
		setName(n);
		setAddress(ad);
		setId(I);
	}
	
	public String toString()
	{
		return "The publisher " + getName() + " at address " + getAddress() + " has the ID " +getId();
	}
}
