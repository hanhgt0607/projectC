/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxtamsu;

/**
 *
 * @author ngova
 */
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserHandle extends DefaultHandler {
    
    public static ArrayList<TamSu> listTamSu = new ArrayList<>();
    private TamSu tamSu;
    boolean bTitle = false;
    boolean bDescription = false;
    boolean bPubDate= false;
    boolean bLink = false;
    boolean bImage = false;
    
    
    
    @Override
    public void startElement(String uri,
            String localName, String qName, Attributes attributes) throws SAXException {
        
        if (qName.equalsIgnoreCase("student")) {
            bTitle = true;
        } else if (qName.equalsIgnoreCase("description")) {
            bDescription = true;
        } else if (qName.equalsIgnoreCase("pubDate")) {
            bPubDate = true;
        } else if (qName.equalsIgnoreCase("link")) {
            bLink = true;
        } 
    }
    
    @Override
    public void endElement(String uri,
            String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("tamSu")) {
            listTamSu.add(tamSu);
        }
    }
    
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
       String value =  new String(ch, start, length);
        if (bTitle && tamSu != null) {
            tamSu.setTitle(value);
            bTitle = false;
        } else if (bDescription && tamSu != null) {
            tamSu.setDescription(value);
            bDescription = false;
        } else if (bPubDate && tamSu != null) {
            tamSu.setPubDate(value);
            bPubDate = false;
        } else if (bLink && tamSu != null) {
            tamSu.setLink(value);
            bLink = false;
        }else if (bImage && tamSu != null) {
            tamSu.setLink(value);
            bImage = false;
        }
    }
}
