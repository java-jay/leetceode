package com.ccu.post;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.List;

public class ccc {
    public String getcookie() {
        try {
            CookieManager manager = new CookieManager();
            manager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
            CookieHandler.setDefault(manager);
            URL url = new URL("http://jwgl.fafu.edu.cn/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.getHeaderFields();
            CookieStore store = manager.getCookieStore();

            List<HttpCookie> lCookies = store.getCookies();
            for (HttpCookie cookie : lCookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    System.out.println(cookie.toString());
                    return cookie.toString();
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args) {
        ccc c = new ccc();
        c.getcookie();
    }

}
