package com.example.dom.create;

import java.io.StringWriter;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.dataprovider.DataProvider;
import com.example.model.Customer;

public class CreateXMLWithDOM {

	public static void main(String[] args) throws ParserConfigurationException, TransformerException {

		List<Customer> data = DataProvider.getData(DataProvider.SMALL);
		
		DOMCreator creator = new DOMCreator();
		Document doc = creator.createXMLDoc(data);
		
		DOMSource source = new DOMSource(doc);
		
		StringWriter writer = new StringWriter();
		
		StreamResult result = new StreamResult(writer);
		
		TransformerFactory factory = TransformerFactory.newInstance();
		
		Transformer transformer = factory.newTransformer();
		
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		
		transformer.transform(source, result);
		
		String xmlString = writer.toString();
		
		System.out.println(xmlString);
		
	}

}
