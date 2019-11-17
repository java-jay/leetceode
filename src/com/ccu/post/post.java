package com.ccu.post;

import com.ccu.bao.write;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


/**
 * @author Post Method
 */
public class post {
    static String ya;
    static String cookie;

    public static void sendPost1() {

        //paramMap  post请求参数
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("encoded", ya);

        //url  post请求网址
        String url = "http://jwgl.fafu.edu.cn/(e1w4zq55r4yfsbvhzxb0qlam)/default2.aspx";
        //对网址空格的处理  
        url = url.replaceAll(" ", "%20");
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        StringBuffer sb = new StringBuffer();
        //获取教务处的cookie进行对账号绑定
        ccc cc = new ccc();
        cookie = cc.getcookie();
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置请求属性
            conn.setRequestProperty("Accept", "text/html,application/xhtml+xm…plication/xml;q=0.9,*/*;q=0.8");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
            conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
            conn.setRequestProperty("Connection", "keep-alive");
            conn.setRequestProperty("Cache-Control", "max-age=0");
            conn.setRequestProperty("Host", "jwgl.fafu.edu.cn");
            conn.setRequestProperty("Referer", "https://www.baidu.com/link?url…502dc20023f15a000000065dc7bb6a");
            conn.setRequestProperty("Upgrade-Insecure-Requests", "1");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; …) Gecko/20100101 Firefox/70.0");
            // conn.setRequestProperty("Charset", "UTF-8");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());

            // 设置请求属性
            String param = "";
            if (paramMap != null && paramMap.size() > 0) {
                Iterator<String> ite = paramMap.keySet().iterator();
                while (ite.hasNext()) {
                    String key = ite.next();// key
                    String value = paramMap.get(key);
                    param += key + "=" + value + "&";
                }
                param = param.substring(0, param.length() - 1);
            }

            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (Exception e) {
            System.err.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("请输入账号");
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        System.out.println("请输入密码");
        String b = scanner.nextLine();
        /**
         * 对登陆的账号和密码进行加密处理
         */
        BASE64 base64 = new BASE64();
        String JIAMI1 = base64.getBase64(a);
        String JIAMI2 = base64.getBase64(b);
        String acc, acc1;
        acc = JIAMI1.concat("%25%25%25");
        acc1 = acc.concat(JIAMI2);
        if (acc1.endsWith("==")) {
            ya = acc1.replace("==", "%3D%3D");
        } else
            ya = acc1;
        post p = new post();
        //发送post请求
        p.sendPost1();
        //发送get请求
        get g = new get();
        String cccc = g.sendGet();
        //得到课表保存为HTML网页
        write w = new write();
        w.writee(cccc, a);
    }


}
