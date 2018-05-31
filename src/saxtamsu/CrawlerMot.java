/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxtamsu;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author ngova
 */
public class CrawlerMot {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        ArrayList<TamSu> list = getTin("https://vnexpress.net/rss/tam-su.rss");
        for (TamSu khoaiTin : list) {
            System.out.println(khoaiTin.getTitle());
        }
    }

    public static ArrayList<TamSu> getTin(String url) {
        ArrayList<TamSu> listTamSu = new ArrayList<>();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandle userHandle = new UserHandle();
            saxParser.parse("https://vnexpress.net/rss/tam-su.rss", userHandle);
            ArrayList<TamSu> list = userHandle.listTamSu;
            for (TamSu tamSu : list) {
                System.out.println(tamSu.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTamSu;
    }
}
