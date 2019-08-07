package com.Anderson.LMS.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.Anderson.LMS.Author;
import com.Anderson.LMS.Book;

public class AuthorService{

	
	public void Add(Object t) {
		List<Author> aList = (List<Author>) t;
		Scanner add = new Scanner(System.in);
		System.out.println("Enter the Author Name followed by an id number");
		if(add.hasNext())
		{
			Author a = new Author();
			a.setName(add.next());
			if(add.hasNextInt())
			a.setId(add.nextInt());
			aList.add(a);
			//aList.forEach(System.out::println);
		}
		
	}


	public void Remove(Object t, Object b) {
		List<Author> aList = (List<Author>) t;
		List<Book> bList = (List<Book>) b;
		Scanner remove = new Scanner(System.in);
		System.out.println("Enter the Author Name and id number");
		if(remove.hasNext())
		{
			Author a = new Author();
			a.setName(remove.next());
			if(remove.hasNextInt())
				a.setId(remove.nextInt());
			aList.remove(a);
			List<Book>  temp = bList.stream().filter(bk -> bk.getAuthorId() == a.getId()).collect(Collectors.toList());
			//bList.forEach(System.out::println);
			//System.out.println();
			temp.forEach(System.out::println);
			//System.out.println();
			bList.removeAll(temp);
			//bList.forEach(System.out::println);
			//aList.forEach(System.out::println);
			
		}
	}


	public void Retrieve(Object t) {
		List<Author> aList = (List<Author>) t;
		Scanner retrieve = new Scanner(System.in);
		System.out.println("Enter the Author Name or id number ot retreive a specific author");
		System.out.println("Enter all to retreive all authors");
		if(retrieve.hasNextInt())
		{
			int id = retrieve.nextInt();
			
			for(Iterator<Author> i = aList.iterator(); i.hasNext();)
			{
				Author a = i.next();
				if(a.getId() == id)
				{
					System.out.println(a);
					return;
				}
			}
		}
		else 
		{
			String name = retrieve.next();
			if (name.equalsIgnoreCase("all"))
			{
				aList.forEach(System.out::println);
				return;
			}
			//System.out.println(name);
			for(Iterator<Author> i = aList.iterator(); i.hasNext();)
			{
				Author a = i.next();
				//System.out.println(a.getName());
				if(a.getName().equalsIgnoreCase(name))
				{
					System.out.println(a);
					return;
				}
			}	
		}
		System.out.println("Author not found");
		
	}


	public void Update(Object t) {
		List<Author> aList = (List<Author>) t;
		Scanner update = new Scanner(System.in);
		System.out.println("Enter the Author Name and id number");
		if(update.hasNext())
		{
			Author a = new Author();
			a.setName(update.next());
			if(update.hasNextInt())
				a.setId(update.nextInt());
			if(aList.contains(a))
			{
				int pos = aList.indexOf(a);
				System.out.println("Enter the new name or id number for the Author");
				if(update.hasNextInt())
				{
					a.setId(update.nextInt());
					aList.set(pos, a);
					//aList.forEach(System.out::println);
				}
				else
				{
					a.setName(update.next());
					aList.set(pos, a);
					//aList.forEach(System.out::println);
				}
			}
			
		}
	}
}
