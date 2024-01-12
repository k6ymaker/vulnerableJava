package com.test;

import java.io.StringWriter;

public class Test {
    public static void main(String[] args) {
        StringWriter stringWriter = new StringWriter();
        stringWriter.write("a");
        System.out.println(stringWriter.toString());
    }
}
