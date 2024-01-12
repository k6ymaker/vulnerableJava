package com.test;

import org.yaml.snakeyaml.Yaml;

public class Test {
    public static void main(String[] args) {
        unserialize();
    }
    public static void serialize(){
        User user = new User();
        user.setName("DawnT0wn");
        user.setAge(25);
        Yaml yaml = new Yaml();
        String str = yaml.dump(user);
        System.out.println(str);
    }
    public static void unserialize(){
        String str1 = "!!com.test.User {age: 25, name: DawnT0wn}";
        String str2 = "age: 25\n" +
                "name: DawnT0wn";
        Yaml yaml = new Yaml();
        User user1 = (User) yaml.load(str1);
        User user2 = yaml.loadAs(str2, User.class);

        System.out.println(user1);
        System.out.println(user2);
    }
}
