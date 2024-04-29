package com.itheima;

// import sun.misc.IOUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/*
* 服务器在接收到“请求”之后的解析怎么实现，以及服务器回复的“响应”怎么生成？
* 这个问题通过写Java代码可以解决，就是我们学过的Java中Socket类和serverSocket类，下面的Java代码就是示例。
* 服务器接收到“请求”之后，Socket类可以实现解析“请求”，接下来要回复，serverSocket类可以实现生成“响应”。
* */

/*
* 自己定义一个Server类，运行起来之后，我这台电脑就可以相当于一个“半吊子服务器”了
* */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080); // 监听指定端口
        System.out.println("server is running...");
        while (true){
            Socket sock = ss.accept();
            System.out.println("connected from " + sock.getRemoteSocketAddress());
            Thread t = new Handler(sock);
            t.start();
        }
    }
}

class Handler extends Thread {
    Socket sock;

    public Handler(Socket sock) {
        this.sock = sock;
    }

    public void run() {
        try (InputStream input = this.sock.getInputStream()) {
            try (OutputStream output = this.sock.getOutputStream()) {
                handle(input, output);
            }
        } catch (Exception e) {
            try {
                this.sock.close();
            } catch (IOException ioe) {
            }
            System.out.println("client disconnected.");
        }
    }

    private void handle(InputStream input, OutputStream output) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        // 解析“请求”:
        boolean requestOk = false;
        String first = reader.readLine();
        if (first.startsWith("GET / HTTP/1.")) {  // 请求行
            requestOk = true;
        }
        for (;;) {
            String header = reader.readLine();
            if (header.isEmpty()) { // 读取到空行时，表示 请求头 结束
                break;
            }
            System.out.println(header);
        }

        // 这里的设计是：
        // 若requestOk为真，表示收到请求，正常回复“响应”；
        // 若requestOk为假，表示未收到请求或者“请求”格式错误，回复告诉浏览器你发送的“请求”是错的；
        System.out.println(requestOk ? "Response OK" : "Response Error");
        if (!requestOk) {
            // 回复告诉浏览器你发送的“请求”是错的:
            writer.write("HTTP/1.0 404 Not Found\r\n");  // 响应行

            writer.write("Content-Length: 0\r\n");  // 响应头

            writer.write("\r\n");  // 空行标识 响应头 与 响应体的分隔，没有响应体也要加空行

            writer.flush();
        } else {
            // 正常回复“响应”:
            // 读取html文件，转换为字符串
            BufferedReader br = new BufferedReader(new FileReader("html/a.html"));
            StringBuilder data = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null){
                data.append(line);
            }
            br.close();
            int length = data.toString().getBytes(StandardCharsets.UTF_8).length;  // 计算的是编码后的响应体长度

            writer.write("HTTP/1.1 200 OK\r\n");  // 响应行

            writer.write("Connection: keep-alive\r\n");  // 响应头
            writer.write("Content-Type: text/html\r\n");
            writer.write("Content-Length: " + length + "\r\n");

            writer.write("\r\n");  // 空行标识 响应头 和 响应体 的分隔

            writer.write(data.toString());  // 响应体
            writer.flush();
        }
    }
}