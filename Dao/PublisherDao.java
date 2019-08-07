package com.Anderson.LMS.Dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.Anderson.LMS.Publisher;

public class PublisherDao <T> implements DAO{
	


	@Override
	public List<Publisher> getAll() throws IOException {
		FileInputStream fin = new FileInputStream("./resources/publisher");
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(fin));
		List<Publisher> publishers = new ArrayList<Publisher>();
		String bookLine;
		while((bookLine = buffReader.readLine()) != null) {
			String[] splitLine = bookLine.split(",");
			Publisher p = new Publisher();
			p.setId(Integer.parseInt(splitLine[0]));
			p.setName(splitLine[1]);
			p.setAddress(splitLine[2]);
			publishers.add(p);
		}
		buffReader.close();
		return publishers;
	}

	@Override
	public void Update(Object t) throws IOException {
		List<Publisher> publishers = (List<Publisher>) t;
		BufferedWriter writer = new BufferedWriter(new FileWriter("./resources/publisher"));
		for(Iterator<Publisher> i = publishers.iterator(); i.hasNext();)
		{
		Publisher p = i.next();
		String written = p.getId() + "," + p.getName() + "," + p.getAddress();
		writer.write(written);
		writer.newLine();
		}
		writer.close();
		
	}

}