package com.test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Test {
    public static void main(String[] args) throws Exception{
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        String userInput = "var x = 2; x * 3"; // 假设从用户输入获取数学表达式
        Object result = engine.eval(userInput); // 执行用户输入的表达式
        System.out.println("计算结果: " + result);
    }
}
