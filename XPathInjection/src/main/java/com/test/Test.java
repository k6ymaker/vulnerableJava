package com.test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import java.io.StringReader;

public class Test {
    public static void main(String[] args) throws Exception {
        String condition = "1";
        String evilCondition = "";//"3";//""1' or '1'='1";

        // 用户提供的查询字符串，未经验证和过滤
        //String userInput = "/users/user[@id='1' or 1=1 or ''='']";
        String userInput = "/users/user[@id='1' or '1'='1']";

        // 解析XML文档
        Document document = parseXmlDocument();

        // 创建XPath对象
        XPath xpath = XPathFactory.newInstance().newXPath();

        // 执行XPath查询
        String result = xpath.evaluate(userInput, document);

        // 输出查询结果
        System.out.println("查询结果: " + result);
    }

    private static Document parseXmlDocument() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<users>\n" +
                "    <user id=\"1\">\n" +
                "        <name>John</name>\n" +
                "        <email>john@example.com</email>\n" +
                "    </user>\n" +
                "    <user id=\"2\">\n" +
                "        <name>Alice</name>\n" +
                "        <email>alice@example.com</email>\n" +
                "    </user>\n" +
                "    <user id=\"3\">\n" +
                "        <name>Bob</name>\n" +
                "        <email>bob@example.com</email>\n" +
                "    </user>\n" +
                "</users>\n";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        return builder.parse(is);
    }
}
