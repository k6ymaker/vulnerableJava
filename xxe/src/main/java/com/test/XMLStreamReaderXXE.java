package com.test;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.ByteArrayInputStream;
import java.io.StringReader;
import com.bj58.sec58.security.sdk.SecuritySdk;

//XMLInputFactory
public class XMLStreamReaderXXE {


    public static void sanitizer(){
        //SecuritySdk.convertXmlByXmlInputFactory();
    }

    public static void main(String[] args) throws Exception{

//        String xml = "<note>\n" +
//                "<to>Tove</to>\n" +
//                "<from>Jani</from>\n" +
//                "<heading>Reminder</heading>\n" +
//                "<body>Don't forget me this weekend!</body>\n" +
//                "</note>";
//
//        XMLInputFactory factory = XMLInputFactory.newFactory();
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xml.getBytes("UTF-8"));
//        XMLStreamReader xmlStreamReader = factory.createXMLStreamReader(byteArrayInputStream);
//
//        while(xmlStreamReader.hasNext()){
//            final int event = xmlStreamReader.next();
//            if(event == XMLStreamReader.START_ELEMENT){
//                System.out.println(xmlStreamReader.getLocalName());
//            }
//        }
//    }

        String xml = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";  XMLInputFactory factory = XMLInputFactory.newFactory();
        javax.xml.stream.XMLStreamReader xmlStreamReader = SecuritySdk.convertXmlByXmlInputFactory(factory,xml,"UTF-8");



        while(xmlStreamReader.hasNext()){
            final int event = xmlStreamReader.next();
            if(event == javax.xml.stream.XMLStreamReader.START_ELEMENT){
                System.out.println(xmlStreamReader.getLocalName());
            }
        }
    }
}
