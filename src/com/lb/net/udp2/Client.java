package com.lb.net.udp2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        // 创建一个DatagramSocket对象
        DatagramSocket socket = new DatagramSocket(7777);

        /*
         * public DatagramPacket(byte buf[], int length) {
         *     this (buf, 0, length);
         * }
         */
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要发送的数据:");
            String line = scanner.nextLine();
            byte[] data = line.getBytes();

            if (line.equals("exit")) {
                System.out.println("客户端已退出!");
                break;
            }
            // 创建一个DatagramPacket对象，指定数据和目标地址
            DatagramPacket packet = new DatagramPacket(data, data.length,
                    InetAddress.getLocalHost(), 6666);

            socket.send(packet);
        }
    }
}
