package com.lb.net.tcp1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.Socket;

public class client {
    public static void main(String[] args) throws IOException {
        // 创建一个Socket对象，连接到本地主机的8899端口
        Socket socket = new Socket("127.0.0.1", 8899);

        // 获取Socket的输出流
        OutputStream outputStream = socket.getOutputStream();

        // 创建一个DataOutputStream对象，用于包装OutputStream
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        // 使用DataOutputStream写入UTF编码的字符串"hello"
        dataOutputStream.writeUTF("hello");
        // 刷新DataOutputStream，确保数据被发送出去
        dataOutputStream.flush();

        // 关闭Socket连接
        socket.close();
    }

}
