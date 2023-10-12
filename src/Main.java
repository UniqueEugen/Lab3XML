import org.xml.sax.SAXException;
import reader.AnimalXMLHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String path = new File("C:/Users/User/Desktop/SAX_1/src/books.xml").getAbsolutePath();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            AnimalXMLHandler handler = new AnimalXMLHandler();
            parser.parse(new File(path), handler);
        } catch (IOException x) {
            System.err.println(x);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }
}