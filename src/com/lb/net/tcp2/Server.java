package com.lb.net.tcp2;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
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

       while (true) {
           try {
               String msg = dataInputStream.readUTF();
               System.out.println("客户端说：" + msg);
           } catch (IOException e) {
               System.out.println(accept.getRemoteSocketAddress() + "断开了连接");
               dataInputStream.close();
               accept.close();
               break;
           }
       }
    }
}
