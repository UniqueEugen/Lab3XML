package reader;

import animal.Catalog;
import animal.Entity;
import org.xml.sax.helpers.DefaultHandler;

import java.util.jar.Attributes;

public class AnimalXMLHandler extends DefaultHandler {
    Catalog myCatalog;
    Entity animal;

    private boolean type;
    private boolean price;
    private boolean kind;
    private boolean subspecies;
    boolean description;
    String currentCharacters;
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("catalog")) {
            myCatalog = new Catalog();
        } else if (qName.equalsIgnoreCase("animal")) {
            animal = new Entity();
        } else if (qName.equalsIgnoreCase("type")) {
            type = true;
        } else if (qName.equalsIgnoreCase("subspecies")) {
            subspecies = true;
        } else if (qName.equalsIgnoreCase("description")) {
            description = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("catalog")) {
            System.out.println("Done with catalog");
            System.out.println(myCatalog.toString());
        } else if (qName.equalsIgnoreCase("animal")) {
            myCatalog.push(animal);
            System.out.println(animal);
        } else if (qName.equalsIgnoreCase("author")) {
            animal.setAuthor(currentCharacters);
            author = false;
        } else if (qName.equalsIgnoreCase("title")) {
            animal.setTitle(currentCharacters);
            title = false;
        } else if (qName.equalsIgnoreCase("description")) {
            animal.setDescription(currentCharacters);
            description = false;
        }
    }

    @Override
    public void characters(char ch[], int start, int length ) {
        currentCharacters = new String(ch, start, length);
    }

}
