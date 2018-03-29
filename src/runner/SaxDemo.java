package runner;

import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import model.MenuSaxHandler;
import model.Periodic;

public class SaxDemo {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		MenuSaxHandler handler = new MenuSaxHandler();
		reader.setContentHandler(handler);
		reader.parse(new InputSource("resources/library.xml"));
		// ��������� �������� ����������������
		reader.setFeature("http://xml.org/sax/features/validation", true);
		// ��������� ��������� ����������� ����
		reader.setFeature("http://xml.org/sax/features/namespaces", true);
		// ��������� ����������� �����
		reader.setFeature("http://xml.org/sax/features/string-interning", true);
		// ���������� ��������� ����
		reader.setFeature("http://apache.org/xml/features/validation/schema", false);
		List<Periodic> library = handler.getPeriodicList();
		for (Periodic periodic : library) {
			System.out.println("Periodic: " + periodic.getPeriodicType() + ", Available number: " + periodic.getAvailableNumber());
		}
	}
}