package com.mebigfatguy.fbcontribcloud;

public class Strings {

    private Strings() {
    }
    
    public static String trim(String s) {
        if (s == null) {
            return "";
        }
        
        return s.trim();
    }
    
    public static boolean isEmpty(String s) {
        return (s == null) || (s.length() == 0);
    }
}
