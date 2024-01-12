package com.test;

import com.bj58.sec58.security.sdk.SecuritySdk;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ValidatorXXE {

    //javax.xml.validation.Validator
    //https://www.yiibai.com/xsd/xsd_validation.html
    //xsd校验xml格式

    public static void main(String[] args) {//throws Exception{

        URL studentsXsdURL =  ValidatorXXE.class.getClassLoader().getResource("students.xsd");
        URL studentsXmlURL = ValidatorXXE.class.getClassLoader().getResource("students.xml");
        String studentsXsdPath = studentsXsdURL.getFile();
        String studentsXmlPath = studentsXmlURL.getFile();
//        String studentsXsdPath = "students.xsd";
//        String studentsXmlPath = "students.xml";

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        Schema schema = null;

        try{
            schema = factory.newSchema(new File(studentsXsdPath));
        } catch (SAXException saxException){
            System.out.println(saxException);
        }

        Validator validator = schema.newValidator();
        //validator.validate(new StreamSource(new File(studentsXmlURL.getFile())));
        try {
            SecuritySdk.validXmlByValidator(validator,new StreamSource(new File(studentsXmlPath)));
        } catch (Exception exception){
            System.out.println(exception);
        }
    }
}
