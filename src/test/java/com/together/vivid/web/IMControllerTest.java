package com.together.vivid.web;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.*;

public class IMControllerTest {
  @Test
  public void pushAll() throws IOException {
    URL url= new URL("http://127.0.0.1:8080/im/push");
    HttpURLConnection conn= (HttpURLConnection) url.openConnection();
    conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64;x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110Safari/537.36");
    conn.setDoOutput(true);
    conn.setDoInput(true);
    OutputStream os = conn.getOutputStream();
    String params= "";
    os.write(params.getBytes("UTF-8"));
    InputStream is = conn.getInputStream();
    byte[] res = new byte[1024];
    StringBuffer sb = new StringBuffer();
    int l = 0;
    while((l = is.read(res)) != -1) {
      sb.append(new String(res, 0, l, "UTF-8"));
    }
    System.out.println(sb);
  }

  @Test
  public void push() throws IOException {
    URL url= new URL("http://127.0.0.1:8080/im/push");
    HttpURLConnection conn= (HttpURLConnection) url.openConnection();
    conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64;x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110Safari/537.36");
    conn.setDoOutput(true);
    conn.setDoInput(true);
    OutputStream os = conn.getOutputStream();
    String params= "sessionId=0";
    os.write(params.getBytes("UTF-8"));
    InputStream is = conn.getInputStream();
    byte[] res = new byte[1024];
    StringBuffer sb = new StringBuffer();
    int l = 0;
    while((l = is.read(res)) != -1) {
      sb.append(new String(res, 0, l, "UTF-8"));
    }
    System.out.println(sb);
  }
}