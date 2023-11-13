package com.test;

public class Test {
    public static void main(String[] args) {
        String input = "evil";
        String cmd1 = "touch" + input ;
        String[] cmd = new String[] {"sh", "-c", cmd1};

        try{
            Runtime.getRuntime().exec(cmd);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
