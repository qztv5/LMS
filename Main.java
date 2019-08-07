package com.Anderson.LMS;

import java.io.IOException;
import java.util.List;

import com.Anderson.LMS.Dao.AuthorDao;
import com.Anderson.LMS.Dao.BookDao;
import com.Anderson.LMS.Dao.PublisherDao;

public class Main {
	
	public static void main(String[] args)
	{
		AuthorDao aDao = new AuthorDao();
		BookDao bDao = new BookDao();
		PublisherDao pDao = new PublisherDao();
		Menu menu = new Menu();
	while(true)
	{
		try {
			List<Author> authors =aDao.getAll();
			List<Book> books = bDao.getAll();
			List<Publisher> publishers = pDao.getAll();
			//authors.forEach(System.out::println);
			//books.forEach(System.out::println);
			//publishers.forEach(System.out::println);
			menu.mainMenu(authors, books, publishers);
			//books.forEach(System.out::println);
			aDao.Update(authors);
			bDao.Update(books);
			pDao.Update(publishers);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	}

}
