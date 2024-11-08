package Main;

import Models.Soldier;
import helpers.SoldierHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Soldier> soldiers = new ArrayList<>();

        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader reader = saxParser.getXMLReader();
            reader.setContentHandler(new SoldierHandler(soldiers));

            reader.parse(new InputSource(new FileInputStream("ficheros/ejemplo.xml")));
            for (Soldier soldier : soldiers){
                System.out.println(soldier);
            }

        } catch (ParserConfigurationException e) {
            System.out.println("Error when parsing " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error with SAX " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Coudnt read file");
        }


    }
}
