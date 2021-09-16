package com.codeup.adlister.util;

public class Redirect {

    public static String returnAdress(StringBuffer url, String query) {
        String webAddress = "";
        String urlToString = url.toString();
        if (!urlToString.isEmpty()) {
            webAddress += urlToString;
            if (query != null && !query.isEmpty() && !query.equals("null")) {
                webAddress += "?" + query;
            }
        }
        return webAddress;
    }
}

