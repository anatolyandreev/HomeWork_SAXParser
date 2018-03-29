package model;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class MenuSaxHandler extends DefaultHandler {
	private List<Periodic> periodicList = new ArrayList<>();
	private Periodic periodic;
	private StringBuilder text;

	public List<Periodic> getPeriodicList() {
		return periodicList;
	}

	public void startDocument() throws SAXException {
		System.out.println("Parsing started.");
	}

	public void endDocument() throws SAXException {
		System.out.println("Parsing ended.");
	}

	public void setAttributes(Attributes attributes) {
		periodic.setIsTakable(attributes.getValue("is-takable"));
		periodic.setAvailableNumber(Integer.parseInt(attributes.getValue("available-number")));
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("startElement -> " + "uri: " + uri + ", localName:" + localName + ", qName: " + qName
				+ ", attributes: " + attributes.getLength());

		text = new StringBuilder();
		if (qName.equals("magazine")) {
			periodic = new Magazine();
			setAttributes(attributes);
		} else if (qName.equals("paper")) {
			periodic = new Paper();
			setAttributes(attributes);
		} else if (qName.equals("book")) {
			periodic = new Book();
			setAttributes(attributes);
		}
	}

	public void characters(char[] buffer, int start, int length) {
		text.append(buffer, start, length);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		MenuTagName tagName = MenuTagName.valueOf(qName.toUpperCase().replace("-", "_"));
		switch (tagName) {
		case READINGROOM:
			periodic.setIsTaken(text.toString());
			break;
		case HOME:
			periodic.setIsTaken(text.toString());
			break;
		case FALSE:
			periodic.setIsTaken(text.toString());
			break;
		case MAX_EXPIRE_DAYS:
			((Book) periodic).setMaxExpireDays(Integer.parseInt(text.toString()));
			break;
		case MAGAZINE:
			periodicList.add(periodic);
			periodic = null;
			break;
		case BOOK:
			periodicList.add(periodic);
			periodic = null;
			break;
		case PAPER:
			periodicList.add(periodic);
			periodic = null;
			break;
		}
	}

	public void warning(SAXParseException exception) {
		System.err.println("WARNING: line " + exception.getLineNumber() + ": " + exception.getMessage());
	}

	public void error(SAXParseException exception) {
		System.err.println("ERROR: line " + exception.getLineNumber() + ": " + exception.getMessage());
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		System.err.println("FATAL: line " + exception.getLineNumber() + ": " + exception.getMessage());
		throw (exception);
	}
}