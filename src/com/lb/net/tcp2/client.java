package com.lb.net.tcp2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws IOException {
        // 创建一个Socket对象，连接到本地主机的8899端口
        Socket socket = new Socket("127.0.0.1", 8899);

        // 获取Socket的输出流
        OutputStream outputStream = socket.getOutputStream();

        // 创建一个DataOutputStream对象，用于包装OutputStream
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要发送的数据：");
            String msg = scanner.nextLine();
            dataOutputStream.writeUTF(msg);
            System.out.println("数据发送成功！");
            if (msg.equals("exit")) {
                System.out.println("客户端退出...");
                dataOutputStream.close();
                socket.close();
                break;
            }

            dataOutputStream.flush();
        }
    }

}
