package com.Anderson.LMS;

import java.util.List;
import java.util.Scanner;

public class Menu {
	Scanner in = new Scanner(System.in);
	AuthorService as = new AuthorService();
	BookService bs = new BookService();
	PublisherService ps = new PublisherService();
	
	public void mainMenu(List<Author> aList, List<Book> bList, List<Publisher> pList)
	{
		
		int choice;
		System.out.println("Enter 1 to add something to the database");
		System.out.println("Enter 2 to remove something from the database");
		System.out.println("Enter 3 to retireve something from the database");
		System.out.println("Enter 4 to update something in the database");
		
		if(in.hasNextInt())
			{
				choice = in.nextInt();
				switch (choice)
				{
				case 1:
					addMenu(aList, bList, pList);
					break;
				case 2:
					removeMenu(aList, bList, pList);
					break;
				case 3:
					retireveMenu(aList, bList, pList);
					break;
				case 4:
					updateMenu(aList, bList, pList);
					break;
				default:
					System.out.println("The number was not between 1 and 4");
				}
			}
		else
			{
				System.out.println("You did not enter an interger");
			}
		}
	
	public void addMenu(List<Author> aList, List<Book> bList, List<Publisher> pList)
	{
		System.out.println("Enter 1 to add an Author");
		System.out.println("Enter 2 to add a Book");
		System.out.println("Enter 3 to add a Publisher");

		int choice;

		if(in.hasNextInt())
			{
				choice = in.nextInt();
				switch (choice)
				{
				case 1:
					as.Add(aList);
					break;
				case 2:
					bs.Add(bList);
					break;
				case 3:
					ps.Add(pList);
					break;
				default:
					System.out.println("The number was not between 1 and 3");
				}
			}
		
		
	}
	
	public void removeMenu(List<Author> aList, List<Book> bList, List<Publisher> pList)
	{
		System.out.println("Enter 1 to remove an Author");
		System.out.println("Enter 2 to remove a Book");
		System.out.println("Enter 3 to remove a Publisher");
		int choice;

		if(in.hasNextInt())
			{
				choice = in.nextInt();
				switch (choice)
				{
				case 1:
					as.Remove(aList);
					break;
				case 2:
					bs.Remove(bList);
					break;
				case 3:
					ps.Remove(pList);
					break;
				default:
					System.out.println("The number was not between 1 and 3");
				}
			}
		
		
	}
	
	public void retireveMenu(List<Author> aList, List<Book> bList, List<Publisher> pList)
	{
		System.out.println("Enter 1 to retireve an Author");
		System.out.println("Enter 2 to retireve a Book");
		System.out.println("Enter 3 to retireve a Publisher");
		int choice;
		if(in.hasNextInt())
			{
				choice = in.nextInt();
				switch (choice)
				{
				case 1:
					as.Retrieve(aList);
					break;
				case 2:
					bs.Retrieve(bList);
					break;
				case 3:
					ps.Retrieve(pList);
					break;
				default:
					System.out.println("The number was not between 1 and 3");
				}
			}
	}
	
	public void updateMenu(List<Author> aList, List<Book> bList, List<Publisher> pList)
	{
		System.out.println("Enter 1 to update an Author");
		System.out.println("Enter 2 to update a Book");
		System.out.println("Enter 3 to update a Publisher");
		int choice;
		if(in.hasNextInt())
			{
				choice = in.nextInt();
				switch (choice)
				{
				case 1:
					as.Update(aList);
					break;
				case 2:
					bs.Update(bList);
					break;
				case 3:
					ps.Update(pList);
					break;
				default:
					System.out.println("The number was not between 1 and 3");
				}
			}
		}

}
