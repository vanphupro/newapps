package com.example.chicky;

import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.example.models.RssItem;


public class RssParser {
	
	public String link;
	public List<RssItem> getNewsList(String link) {
		this.link = link;
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			RssHandler handler = new RssHandler();
			parser.parse(this.link, handler);
			return handler.getItemList();
			
//			URL url = new URL(link);
			// SAXParserFactory factory = SAXParserFactory.newInstance();
//			SAXParser parser = factory.newSAXParser();
//			XMLReader reader = parser.getXMLReader();
//			RssHandler handler = new RssHandler();
//			reader.setContentHandler(handler);
//			InputSource source = new InputSource(url.openStream());
//			reader.parse(source);
//			return handler.getItemList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
