package com.test;

import com.bj58.sec58.security.sdk.SecuritySdk;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

//https://www.cnblogs.com/vastsum/p/5940235.html
//xpath解析xml
public class XPathExpressionXXE {
    public static void main(String[] args) throws Exception {
        String xml = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";


//        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
 //       InputStream inputStream = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
//        //Document
//        Document document = builder.parse(inputStream);
//        //InputSource
        InputSource inputSource = new InputSource(new ByteArrayInputStream(xml.getBytes()));
//
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();
        //XPathExpression
        XPathExpression xPathExpression = xpath.compile("/note/from");
//
//        //System.out.println(xPathExpression.evaluate(document));
//        System.out.println(xPathExpression.evaluate(inputSource));
//        String result = SecuritySdk.evaluateXmlByXpathExpression(xPathExpression,xml,"UTF-8");
        String result = SecuritySdk.evaluateXmlByXpathExpression(xPathExpression,inputSource);
    }
}
