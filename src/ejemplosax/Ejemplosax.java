/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplosax;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 *
 * @author xp
 */
public class Ejemplosax {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            //creamos los manejadores SAX
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            
            DefaultHandler handler = new DefaultHandler() {
                //cuando se llega al principio de un elemento imprimimos su nombre por pantalla
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                     System.out.println("Start Element :" + qName);
                }
                //cuando se llega al final del elemento lo indicamos por pantalla
//                public void endElement(String uri, String localName, String qName)throws SAXException {
//                     System.out.println("End Element :" + qName);
//                }
                //cuando leemos el contenido de un elemento lo mostramos por pantalla
                public void characters(char ch[], int start, int length)throws SAXException {
                     System.out.println(new String(ch, start, length));
                } 
                
            };
            //Encapsulamos el fichero xml a leer indicando que tiene formato utf-8
                File file = new File("tienda.xml");
                InputStream inputStream= new FileInputStream(file);
                Reader reader = new InputStreamReader(inputStream,"UTF-8");
                InputSource is = new InputSource(reader); 
                is.setEncoding("UTF-8");
                saxParser.parse(is, handler);
        }catch(Exception e){
            e.printStackTrace();
        
    }
    
    }
}
