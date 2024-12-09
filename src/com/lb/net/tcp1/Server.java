package com.lb.net.tcp1;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动......");
        // 创建一个ServerSocket对象，监听8888端口
        ServerSocket serverSocket = new ServerSocket(8899);
        Socket accept = serverSocket.accept();

        // 获取客户端的输入流
        InputStream inputStream = accept.getInputStream();
        // 将输入流包装为DataInputStream对象
        DataInputStream dataInputStream = new DataInputStream(inputStream);

        // 从DataInputStream中读取UTF编码的字符串
        String str = dataInputStream.readUTF();
        // 输出读取到的字符串
        System.out.println(str);

        System.out.println("accept.getRemoteSocketAddress() = " + accept.getRemoteSocketAddress());
        dataInputStream.close();
        serverSocket.close();
    }
}
