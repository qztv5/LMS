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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publisher other = (Publisher) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Publisher [name=" + name + ", address=" + address + ", id=" + id + "]";
	}
	
	
}
