package com.test;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Test {
    public static void main(String[] args) {
        String userInput = "2*2";//"${T(java.lang.Runtime).getRuntime().exec('/System/Applications/Calculator.app')}";
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(userInput);
        Object result = expression.getValue();
        System.out.println("Result: " + result);
    }
}
