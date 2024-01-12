package com.test;

import com.bj58.sec58.security.sdk.SecuritySdk;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class XMLReaderXXE {
    public static void main(String[] args) throws Exception{
        String xml = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";

        SAXParserFactory parserFactory = SAXParserFactory.newInstance();

        XMLReader xmlReader = parserFactory.newSAXParser().getXMLReader();

        InputSource inputSource = new InputSource(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));

        xmlReader = SecuritySdk.convertXmlByXmlReader(xmlReader,inputSource);

    }
}
