package com.Anderson.LMS.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.Anderson.LMS.Book;
import com.Anderson.LMS.Publisher;

public class PublisherService {


	public void Add(List<Publisher> pList) {
		Scanner add = new Scanner(System.in);
		System.out.println("Enter the Publisher Name followed by an id number, and an address");
		if(add.hasNext())
		{
			Publisher p = new Publisher();
			String name = "";
			name = add.next();
			while(add.hasNext() && !add.hasNextInt())
			{
				name += " " + add.next();
			}
			
			p.setName(name);
			if(add.hasNextInt())
			p.setId(add.nextInt());
			if(add.hasNextLine())
			p.setAddress(add.nextLine());
			pList.add(p);
			//pList.forEach(System.out::println);
		}
		
	}

	public void Remove(List<Publisher> pList, List<Book> bList) {
		Scanner remove = new Scanner(System.in);
		System.out.println("Enter the Publisher Name, id number, and address");
		if(remove.hasNext())
		{
			Publisher p = new Publisher();
			String name = remove.next();
			while(remove.hasNext() && !remove.hasNextInt())
			{
				name += " " + remove.next();
			}
			
			p.setName(name);
			if(remove.hasNextInt())
			p.setId(remove.nextInt());
			if(remove.hasNextLine()) 
			{
				remove.skip(" ");
				p.setAddress(remove.nextLine());
			}
			System.out.println(p);
			pList.remove(p);
			//pList.forEach(System.out::println);
			List<Book>  temp = bList.stream().filter(bk -> bk.getPublisherId() == p.getId()).collect(Collectors.toList());
			//bList.forEach(System.out::println);
			//System.out.println();
			//temp.forEach(System.out::println);
			//System.out.println();
			bList.removeAll(temp);
			//bList.forEach(System.out::println);
			
		}
	}

	public void Retrieve(List<Publisher> pList) {
		Scanner retrieve = new Scanner(System.in);
		System.out.println("Enter the Publisher Name or id number to retrieve a specific publisher");
		System.out.println("Enter all to retrive all Publishers");
		if(retrieve.hasNextInt())
		{
			int id = retrieve.nextInt();
			
			for(Iterator<Publisher> i = pList.iterator(); i.hasNext();)
			{
				Publisher p = i.next();
				if(p.getId() == id)
				{
					System.out.println(p);
					return;
				}
			}
		}
		else 
		{
			String name = retrieve.nextLine();
			if (name.equalsIgnoreCase("all"))
			{
				pList.forEach(System.out::println);
				return;
			}
			//System.out.println(name);
			for(Iterator<Publisher> i = pList.iterator(); i.hasNext();)
			{
				Publisher p = i.next();
				//System.out.println(p.getName());
				if(p.getName().equalsIgnoreCase(name))
				{
					System.out.println(p);
					return;
				}
			}	
		}
		System.out.println("Publisher not found");
		
	}

	public void Update(List<Publisher> pList) {
		Publisher p = new Publisher();
		int pos =-1;
		Scanner update = new Scanner(System.in);
		System.out.println("Enter the Publisher Name or id number");
		if(update.hasNextInt())
		{
			//System.out.println("In if of update");
			int id = update.nextInt();
			for(Iterator<Publisher> i = pList.iterator(); i.hasNext();)
			{
				p = i.next();
				if(p.getId() == id)
				{
					 pos = pList.indexOf(p);
				}
			}
		}
		else
		{
			//System.out.println("In else in update");
			String name = update.nextLine();
			for(Iterator<Publisher> i = pList.iterator(); i.hasNext();)
			{
				p = i.next();
				if(p.getName().equalsIgnoreCase(name))
				{
					 pos = pList.indexOf(p);
				}
			}
			
		}
		
			if(pos == -1)
			{
				System.out.println("Publisher not found");
			}
			else
			{
				System.out.println("Enter the new name, Id number, and address the Publisher");
				if(update.hasNext())
				{
					String name = update.next();
					while(update.hasNext() && !update.hasNextInt())
					{
						name += " " + update.next();
					}
					p.setName(name);
					if(update.hasNextInt())
					p.setId(update.nextInt());
					if(update.hasNextLine())
					p.setAddress(update.nextLine());
					pList.set(pos, p);
				}
			}
		}
}