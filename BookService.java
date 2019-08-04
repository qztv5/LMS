package com.Anderson.LMS;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BookService implements Service {

	@Override
	public void Add(Object t) {
		List<Book> bList = (List<Book>) t;
		Scanner add = new Scanner(System.in);
		System.out.println("Enter the Book Name followed by an id number, author id, and publisher id");
		if(add.hasNext())
		{
			Book b = new Book();
			String name = "";
			name = add.next();
			while(add.hasNext() && !add.hasNextInt())
			{
				name += " " + add.next();
			}
			
			b.setName(name);
			if(add.hasNextInt())
			b.setBookId(add.nextInt());
			b.setAuthorId(add.nextInt());
			b.setPublisherId(add.nextInt());
			bList.add(b);
			bList.forEach(System.out::println);
		}
		
	}

	@Override
	public void Remove(Object t) {
		List<Book> bList = (List<Book>) t;
		Scanner remove = new Scanner(System.in);
		System.out.println("Enter the Book Name, id number, author id, and publisher id");
		if(remove.hasNext())
		{
			Book b = new Book();
			String name = remove.next();
			while(remove.hasNext() && !remove.hasNextInt())
			{
				name += " " + remove.next();
			}
			
			b.setName(name);
			if(remove.hasNextInt())
			b.setBookId(remove.nextInt());
			b.setAuthorId(remove.nextInt());
			b.setPublisherId(remove.nextInt());
			bList.remove(b);
			bList.forEach(System.out::println);
			
		}
	}

	@Override
	public void Retrieve(Object t) {
		List<Book> bList = (List<Book>) t;
		Scanner retrieve = new Scanner(System.in);
		System.out.println("Enter the Book Name or id number");
		if(retrieve.hasNextInt())
		{
			int id = retrieve.nextInt();
			
			for(Iterator<Book> i = bList.iterator(); i.hasNext();)
			{
				Book b = i.next();
				if(b.getBookId() == id)
				{
					System.out.println(b);
					return;
				}
			}
		}
		else 
		{
			String name = retrieve.nextLine();
			//System.out.println(name);
			for(Iterator<Book> i = bList.iterator(); i.hasNext();)
			{
				Book b = i.next();
				//System.out.println(b.getName());
				if(b.getName().equalsIgnoreCase(name))
				{
					System.out.println(b);
					return;
				}
			}	
		}
		System.out.println("Book not found");
		
	}

	@Override
	public void Update(Object t) {
		List<Book> bList = (List<Book>) t;
		Book b = new Book();
		int pos =-1;
		Scanner update = new Scanner(System.in);
		System.out.println("Enter the Book Name or id number");
		if(update.hasNextInt())
		{
			System.out.println("In if of update");
			int id = update.nextInt();
			for(Iterator<Book> i = bList.iterator(); i.hasNext();)
			{
				b = i.next();
				if(b.getBookId() == id)
				{
					 pos = bList.indexOf(b);
				}
			}
		}
		else
		{
			System.out.println("In else in update");
			String name = update.nextLine();
			for(Iterator<Book> i = bList.iterator(); i.hasNext();)
			{
				b = i.next();
				if(b.getName().equalsIgnoreCase(name))
				{
					 pos = bList.indexOf(b);
				}
			}
			
		}
		
			if(pos == -1)
			{
				System.out.println("Book not found");
			}
			else
			{
				System.out.println("Enter the new name, Id number, author Id, publisher id for the Book");
				if(update.hasNext())
				{
					b.setName(update.next());
					b.setBookId(update.nextInt());
					b.setAuthorId(update.nextInt());
					b.setPublisherId(update.nextInt());
					bList.set(pos, b);
				}
			}
		}
}
