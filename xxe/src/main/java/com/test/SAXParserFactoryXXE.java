package com.test;
import com.bj58.sec58.security.sdk.SecuritySdk;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.io.StringWriter;

public class SAXParserFactoryXXE {

    public static <T> T xmlToBean(String xml, T t) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(t.getClass());
        Unmarshaller um = context.createUnmarshaller();
        StringReader sr = new StringReader(xml);
        t = (T) um.unmarshal(sr);
        return t;
    }

    public static <T> StringWriter beanToXml(T t) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(t.getClass());
        Marshaller m = context.createMarshaller();
        StringWriter sw = new StringWriter();
        m.marshal(t,sw);
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        m.marshal(t,new FileOutputStream("/test.xml"));
        m.marshal(t,System.out);
        return sw;
    }

    //https://blog.csdn.net/qq496013218/article/details/74204782
    public static void main(String[] args) throws Exception{
        String xml = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";

        SAXParserFactory spf = SAXParserFactory.newInstance();

//        Source xmlSource = new SAXSource(spf.newSAXParser().getXMLReader(), new InputSource(new StringReader(xml)));
//
//        Unmarshaller um = JAXBContext.newInstance(Note.class).createUnmarshaller();
//
//        final Object unmarshalObject = um.unmarshal(xmlSource);
//
//        System.out.println( Note.class.cast(unmarshalObject).To);
//        System.out.println(((Note)unmarshalObject).To);

        Object o  = SecuritySdk.convertXmlBySaxParserFactory(spf,xml,Note.class);

        System.out.println(((Note)o).To);
    }
}
