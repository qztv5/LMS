package com.Anderson.LMS;

public class Author {
	
	String name;
	int id;

	public String getName()
	
	{
		return name;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int I)
	{
		id = I;
	}
	
	public Author()
	{
		setName("none");
		setId(0);
	}
	
	public Author(String n, int I)
	{
		setName(n);
		setId(I);
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Author other = (Author) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
