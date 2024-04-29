package com.itheima.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class test_url_get_encode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String name = "张三";

        // 1.先把“张三”按照utf-8方式编码成二进制码，再把二进制码按照URL编码方式编码成“%__%__”形式
        String encode = URLEncoder.encode(name, "utf-8");
        System.out.println(encode);

        // 2.先把“%__%__形式”按照URL编码方式解码成二进制码，再把二进制码按照utf-8编码方式解码成“张三”
        String decode = URLDecoder.decode(encode, "utf-8");
        System.out.println(decode);

        // 3.在Tomcat中，先把“%__%__形式”按照URL编码方式解码成二进制码，再把二进制码按照ISO-8859-1编码方式(写死的，改不了)解码，就变成乱码了
        String decode2 = URLDecoder.decode(encode, "ISO-8859-1");
        System.out.println(decode2);
        // 解决这个乱码问题，思路是它们的二进制码是一样的
        byte[] decode2Bytes = decode2.getBytes("ISO-8859-1");
        String s = new String(decode2Bytes, "utf-8");
        System.out.println(s);

    }
}
