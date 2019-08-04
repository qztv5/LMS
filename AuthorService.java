package com.Anderson.LMS;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AuthorService implements Service {

	@Override
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

	@Override
	public void Remove(Object t) {
		List<Author> aList = (List<Author>) t;
		Scanner remove = new Scanner(System.in);
		System.out.println("Enter the Author Name and id number");
		if(remove.hasNext())
		{
			Author a = new Author();
			a.setName(remove.next());
			if(remove.hasNextInt())
				a.setId(remove.nextInt());
			aList.remove(a);
			//aList.forEach(System.out::println);
			
		}
	}

	@Override
	public void Retrieve(Object t) {
		List<Author> aList = (List<Author>) t;
		Scanner retrieve = new Scanner(System.in);
		System.out.println("Enter the Author Name or id number");
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
			System.out.println(name);
			for(Iterator<Author> i = aList.iterator(); i.hasNext();)
			{
				Author a = i.next();
				System.out.println(a.getName());
				if(a.getName().equalsIgnoreCase(name))
				{
					System.out.println(a);
					return;
				}
			}	
		}
		System.out.println("Author not found");
		
	}

	@Override
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
