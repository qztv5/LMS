package com.Anderson.LMS.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.Anderson.LMS.Author;
import com.Anderson.LMS.Book;
import com.Anderson.LMS.Publisher;

public class BookService{


	public void Add(Object t, Object a, Object p) {
		List<Book> bList = (List<Book>) t;
		List<Author> aList = (List <Author>) a;
		List<Publisher> pList = (List <Publisher>) p;
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
			List<Author>  aTemp = aList.stream().filter(au -> au.getId() == b.getAuthorId()).collect(Collectors.toList());
			if(aTemp.isEmpty())
			{
				System.out.println("Author not found please add a new author");
				AuthorService as = new AuthorService();
				as.Add(aList);
			}
			List<Publisher>  pTemp = pList.stream().filter(pu -> pu.getId() == b.getPublisherId()).collect(Collectors.toList());
			if(pTemp.isEmpty())
			{
				System.out.println("Publisher not found please add a new publisher");
				PublisherService ps = new PublisherService();
				ps.Add(pList);
			}
			bList.add(b);
			//bList.forEach(System.out::println);
		}
		
	}


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
			//bList.forEach(System.out::println);
			
		}
	}


	public void Retrieve(Object t) {
		List<Book> bList = (List<Book>) t;
		Scanner retrieve = new Scanner(System.in);
		System.out.println("Enter the Book Name or id number to retrieve a specific book");
		System.out.println("Enter all to retrieve all books");
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
			if (name.equalsIgnoreCase("all"))
			{
				bList.forEach(System.out::println);
				return;
			}
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


	public void Update(Object t) {
		List<Book> bList = (List<Book>) t;
		Book b = new Book();
		int pos =-1;
		Scanner update = new Scanner(System.in);
		System.out.println("Enter the Book Name or id number");
		if(update.hasNextInt())
		{
			//System.out.println("In if of update");
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
			//System.out.println("In else in update");
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
					String name = update.next();
					while(update.hasNext() && !update.hasNextInt())
					{
						name += " " + update.next();
					}
					b.setName(name);
					if(update.hasNextInt())
					b.setBookId(update.nextInt());
					if(update.hasNextInt())
					b.setAuthorId(update.nextInt());
					if(update.hasNextInt())
					b.setPublisherId(update.nextInt());
					bList.set(pos, b);
				}
			}
		}
}
