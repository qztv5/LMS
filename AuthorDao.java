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

public class AuthorDao<T>  implements DAO{
	


	@Override
	public List<Author> getAll() throws IOException {
		FileInputStream fin = new FileInputStream("./resources/author");
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(fin));
		List<Author> authors = new ArrayList<Author>();
		String authorLine;
		while((authorLine = buffReader.readLine()) != null) {
			String[] splitLine = authorLine.split(",");
			Author a = new Author();
			a.setId(Integer.parseInt(splitLine[0]));
			a.setName(splitLine[1]);
			authors.add(a);
		}
		buffReader.close();
		return authors;
	}

	@Override
	public void Update(Object t) throws IOException {
		List<Author> authors = (List<Author>) t;
		BufferedWriter writer = new BufferedWriter(new FileWriter("./resources/author"));
		for(Iterator<Author> i = authors.iterator(); i.hasNext();)
		{
		Author a = i.next();
		String written = a.getId() + "," + a.getName();
		writer.write(written);
		writer.newLine();
		}
		writer.close();
		
	}

}
