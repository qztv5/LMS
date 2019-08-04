package com.Anderson.LMS;

import java.io.IOException;
import java.util.List;

public class Main {
	
	public static void main(String[] args)
	{
		AuthorDao aDao = new AuthorDao();
		BookDao bDao = new BookDao();
		Menu menu = new Menu();
	
		try {
			List<Author> authors =aDao.getAll();
			List<Book> books = bDao.getAll();
			//authors.forEach(System.out::println);
			books.forEach(System.out::println);
			menu.mainMenu(authors, books);
			books.forEach(System.out::println);
			aDao.Update(authors);
			bDao.Update(books);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
