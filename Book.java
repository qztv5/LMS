package com.Anderson.LMS;

public class Book {
	
	String name;
	int BookId;
	int AuthorId;
	int PublisherId;
	
	public String getName()
	
	{
		return name;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public int getBookId()
	{
		return BookId;
	}
	
	public void setBookId(int Bid)
	{
		BookId = Bid;
	}
	
	public int getAuthorId()
	{
		return AuthorId;
	}
	
	public void setAuthorId(int Aid)
	{
		AuthorId = Aid;
	}
	
	public int getPublisherId()
	{
		return PublisherId;
	}
	
	public void setPublisherId(int Pid)
	{
		PublisherId = Pid;
	}
	
	public Book ()
	{
		setName("none");
		setBookId(0);
		setAuthorId(0);
		setPublisherId(0);
	}
	
	public Book(String n, int Bid, int Aid, int Pid)
	{
		setName(n);
		setBookId(Bid);
		setAuthorId(Aid);
		setPublisherId(Pid);
		
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", BookId=" + BookId + ", AuthorId=" + AuthorId + ", PublisherId=" + PublisherId
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + AuthorId;
		result = prime * result + BookId;
		result = prime * result + PublisherId;
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
		Book other = (Book) obj;
		if (AuthorId != other.AuthorId)
			return false;
		if (BookId != other.BookId)
			return false;
		if (PublisherId != other.PublisherId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	

	
}
