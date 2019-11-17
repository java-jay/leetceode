package com.ccu.post;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class get {
    public static String sendGet() {
        //跳转到课程表的URL
        String url = "http://jwgl.fafu.edu.cn/(e1w4zq55r4yfsbvhzxb0qlam)/xs_main.aspx?xh=";
        //对网址处理
        url = url.replaceAll(" ", "%20");
        //get请求数据
        String param = "Ves632DSdyV=NEW_XSD_PYGL";
        StringBuffer sb = new StringBuffer();
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("Accept", "text/html,application/xhtml+xm…plication/xml;q=0.9,*/*;q=0.8");
            connection.setRequestProperty("Accept-Encoding", "gzip, deflate");
            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("Host", "http://jwgl.fafu.edu.cn");
            connection.setRequestProperty("Referer", "https://www.baidu.com/link?url…502dc20023f15a000000065dc7bb6a");
            connection.setRequestProperty("Upgrade-Insecure-Requests", "1");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:70.0) Gecko/20100101 Firefox/70.0");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            InputStream stream = new GZIPInputStream(connection.getInputStream());
            in = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
            String line;
            int k = 0, a = 0;
            /*
             * 获得自己想获取的源代码段
             */
            while ((line = in.readLine()) != null) {
                if (line.equals("  <div class=\"Nsb_rights\">Copyright (C) 湖南强智科技发展有限公司 2003-2013 All Rights Reserved 湘ICP 备12010071号</div>")) {
                    k = 1;
                }
                if (line.equals("<body>") && a == 1) {
                    k = 0;
                }
                if (k == 0)
                    sb.append(line + "\n");
                if (line.equals("<body>") && a == 0) {
                    a++;
                    k = 1;
                }

                if (line.equals("        <input type=\"checkbox\" name=\"sfFD\" id=\"sfFD\" value=\"1\" οnclick=\"funFD(this.checked)\"  checked>放大")) {
                    k = 0;
                }

            }

        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return sb.toString();
    }

}
