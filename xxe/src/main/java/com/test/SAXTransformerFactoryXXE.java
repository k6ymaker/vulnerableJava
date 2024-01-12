package com.test;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamSource;

import com.bj58.sec58.security.sdk.SecuritySdk;
import org.xml.sax.XMLFilter;

//XMLFilter用法
//http://www.cppblog.com/baby-fly/archive/2010/04/23/113301.html
//http://blog.itpub.net/10752043/viewspace-993462/
//TODO 找一个可以运行的demo，xsl文件
public class SAXTransformerFactoryXXE {
    public static void main(String[] args) throws Exception{
        SAXTransformerFactory saxTransformerFactory = (SAXTransformerFactory)SAXTransformerFactory.newInstance();
        StreamSource streamSource = new StreamSource("student.xsl");
        XMLFilter xmlFilter = SecuritySdk.convertXmlFilterBySaxTransformerFactory(saxTransformerFactory,streamSource);
    }
}
