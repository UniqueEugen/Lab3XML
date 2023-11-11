package reader;

import animal.Catalog;
import animal.Entity;
import myLibrary.console.Console;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AnimalXMLHandler extends DefaultHandler {
    Catalog myCatalog;
    Entity animal;

    private boolean type;
    private boolean price;
    private boolean kind;
    private boolean subspecies;
    boolean description;
    String currentCharacters;
    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("animals")) {
            myCatalog = new Catalog();
        } else if (qName.equalsIgnoreCase("animal")) {
            animal = new Entity();
        }
        else if (qName.equalsIgnoreCase("type")) {
            type = true;
        } else if (qName.equalsIgnoreCase("subspecies")) {
            subspecies = true;
        }
        else if (qName.equalsIgnoreCase("kind")) {
            kind = true;
        }
        else if (qName.equalsIgnoreCase("price")) {
            price = true;
        }
        else if (qName.equalsIgnoreCase("description")) {
            description = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("animals")) {
            Console.log("Done with catalog");
            Console.log(myCatalog.toString());
        } else if (qName.equalsIgnoreCase("animal")) {
            myCatalog.push(animal);
        } else if (qName.equalsIgnoreCase("type")) {
            animal.setType(currentCharacters);
            type=false;
        } else if (qName.equalsIgnoreCase("subspecies")) {
            animal.setSubspecies(currentCharacters);
            subspecies=false;
        }  else if (qName.equalsIgnoreCase("kind")) {
            animal.setKind(currentCharacters);
            kind = false;
        }
        else if (qName.equalsIgnoreCase("price")) {
            try {
                animal.setPrice(Double.parseDouble(currentCharacters));
            }catch (Exception e){
                animal.setPrice(0);
            }
            price = false;
        } else if (qName.equalsIgnoreCase("description")) {
           // Console.log("asdad"+currentCharacters);
            animal.setDescription(currentCharacters);
            description = false;
        }
    }

    @Override
    public void characters(char ch[], int start, int length ) {
       // Console.log(start+" "+ length);
        currentCharacters = new String(ch, start, length).replace("\n", "").trim();
    }
    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        //emit("IGNORABLE");
    }

}
