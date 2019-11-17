package com.ccu.bao;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class write {
    public void writee(String aaa , String bbb) {
        String a = "C:/Users/Songzr/Desktop/";
        String b = ".html";
        a = a.concat(bbb);
        a = a.concat(b);
        try {
            FileWriter writer = new FileWriter(a,true);
            writer.write(aaa);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
