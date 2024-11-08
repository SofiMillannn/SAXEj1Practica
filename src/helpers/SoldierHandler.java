package helpers;

import Models.Soldier;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.swing.text.DefaultHighlighter;
import java.util.ArrayList;

public class SoldierHandler extends DefaultHandler {
    private String valor;
    private final ArrayList<Soldier> soldiers;
    private Soldier soldier;
    public SoldierHandler(ArrayList<Soldier> soldiers) {
        this.soldiers = soldiers;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        valor = null;
        if (qName.equals("soldier")){
            soldier = new Soldier();
            soldier.setId(attributes.getValue("id"));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        valor = new String(ch,start,length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch ((qName)){
            case "name" -> soldier.setName(valor);
            case "age" -> soldier.setAge(Integer.parseInt(valor));
            case "rank" -> soldier.setRank(valor);
            case "soldier" -> soldiers.add(soldier);

        }
    }
}
