package runner;

import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class MainApp {
	public static void main(String[] args) throws IOException, SAXException {
	
		XMLReader reader = XMLReaderFactory.createXMLReader();
		reader.parse("resources/food.xml");
	
	}

}
