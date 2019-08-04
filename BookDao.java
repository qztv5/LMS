package com.Anderson.LMS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookDao<T> implements DAO{
	


	@Override
	public List<Book> getAll() throws IOException {
		FileInputStream fin = new FileInputStream("./resources/book");
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(fin));
		List<Book> books = new ArrayList<Book>();
		String bookLine;
		while((bookLine = buffReader.readLine()) != null) {
			String[] splitLine = bookLine.split(",");
			Book b = new Book();
			b.setBookId(Integer.parseInt(splitLine[0]));
			b.setAuthorId(Integer.parseInt(splitLine[1]));
			b.setPublisherId(Integer.parseInt(splitLine[2]));
			b.setName(splitLine[3]);
			books.add(b);
		}
		buffReader.close();
		return books;
	}

	@Override
	public void Update(Object t) throws IOException {
		List<Book> authors = (List<Book>) t;
		BufferedWriter writer = new BufferedWriter(new FileWriter("./resources/book"));
		for(Iterator<Book> i = authors.iterator(); i.hasNext();)
		{
		Book b = i.next();
		String written = b.getBookId() + "," + b.getAuthorId() + "," + b.getPublisherId() + "," + b.getName();
		writer.write(written);
		writer.newLine();
		}
		writer.close();
		
	}

}