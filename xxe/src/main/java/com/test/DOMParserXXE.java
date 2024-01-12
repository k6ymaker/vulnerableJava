package com.test;

import com.bj58.sec58.security.sdk.SecuritySdk;
import oracle.xml.parser.v2.DOMParser;
import oracle.xml.parser.v2.XMLDocument;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.StringReader;

public class DOMParserXXE {
    public static void main(String[] args) throws Exception {
        String xml = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";

        DOMParser domParser = new DOMParser();



//        domParser.parse(new StringReader(xml));
//
//        XMLDocument document = domParser.getDocument();

        XMLDocument document = SecuritySdk.convertXmlByDomParser(domParser,xml);

        NodeList nl = document.getElementsByTagName("*");

        for(int i=0;i<nl.getLength();i++){
            System.out.println(nl.item(i).getNodeName());
        }
    }
}
