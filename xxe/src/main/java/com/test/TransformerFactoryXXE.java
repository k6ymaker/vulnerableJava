package com.test;

import com.bj58.sec58.security.sdk.SecuritySdk;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.Properties;
import javax.xml.XMLConstants;

/*
* 通过javax.xml.transform.Transformer，进行文本转换，具体的转换形式，参考：
* https://www.w3cschool.cn/java/java-xslt-intro.html
*
* */
public class TransformerFactoryXXE {
    public static void main(String[] args) throws Exception {
        System.setProperty("javax.xml.transform.TransformerFactory","com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl");

        //值修改测试
        String xml = "<?xml version = '1.0' encoding = 'UTF-8'?>" +
                "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";

        //转换工厂函数
        TransformerFactory tf = TransformerFactory.newInstance();
        //TODO 存在异常
        //tf.setAttribute("http://javax.xml.XMLConstants/property/accessExternalDTD", "");
        // tf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        tf.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        tf.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");

        InputStream is = new ByteArrayInputStream(xml.getBytes());
        //数据输入源
        Source source = new StreamSource(is);
        ByteArrayOutputStream byteRep = new ByteArrayOutputStream();


        StringWriter resStringWriter = new StringWriter();
        //输出Result
        Result res = new StreamResult(resStringWriter);

        //转换属性
        Properties outputProperties = new Properties();
        //设置输出为html
        outputProperties.setProperty(OutputKeys.METHOD,"html");

        //Transformer transformer  = tf.newTransformer();

 //       SecuritySdk.transformXmlByTransformerFactory(tf,source,res,null);
//        if (outputProperties != null){
//            transformer.setOutputProperties(outputProperties);
//        }
//
//        transformer.transform(source, res);

        System.out.println(resStringWriter.toString());
    }
}
