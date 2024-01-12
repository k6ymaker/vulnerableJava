package com.test;

import org.mvel2.MVEL;

import java.util.HashMap;
import java.util.Map;

public class NormalCase {
    public static void main(String[] args) {
        // 商品价格
        double originalPrice = 100.0;

        // 创建一个包含折扣规则的映射
        Map<String, Object> discountRules = new HashMap<>();
        discountRules.put("discountPercentage", 10); // 折扣率为10%

        // 创建MVEL表达式
        String mvelExpression = "originalPrice - (originalPrice * (discountPercentage / 100))";

        // 使用MVEL计算折扣后的价格
        Map<String, Object> vars = new HashMap<>();
        vars.put("originalPrice", originalPrice);
        double discountedPrice = (Double) MVEL.eval(mvelExpression, vars, discountRules);

        System.out.println("原始价格: $" + originalPrice);
        System.out.println("折扣后价格: $" + discountedPrice);
    }
}
