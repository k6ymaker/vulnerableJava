package com.test;

import com.bj58.sec58.security.sdk.SecuritySdk;

import javax.xml.XMLConstants;
import javax.xml.validation.SchemaFactory;

public class SchemaFactoryXXE {
    public static void main(String[] args) throws Exception{
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        schemaFactory = SecuritySdk.configureSafeSchemaFactory(schemaFactory);
    }
}
