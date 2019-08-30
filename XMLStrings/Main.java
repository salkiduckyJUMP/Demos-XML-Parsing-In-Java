package com.collabera.xmlstrings;

import java.io.File;
import java.io.FileReader;

import com.example.dataprovider.DataProvider;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		String fileName = DataProvider.DATADIR + "customers.xml";
		
		StringBuilder builder = new StringBuilder();
		
		FileReader reader = new FileReader(new File(fileName));
		
		int content;
		
		while ((content = reader.read()) != -1) {
			
			builder.append((char)content);
			
		}
		
		reader.close();
		
		System.out.println(builder.toString());
	}

}
