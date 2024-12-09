package com.lb.net.udp1;

import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        // 创建一个DatagramSocket对象
        DatagramSocket socket = new DatagramSocket(7777);

        /*
         * public DatagramPacket(byte buf[], int length) {
         *     this (buf, 0, length);
         * }
         */
        byte[] data = "hello world".getBytes();

        // 创建一个DatagramPacket对象，指定数据和目标地址
        DatagramPacket packet = new DatagramPacket(data, data.length,
                InetAddress.getLocalHost(), 6666);

        socket.send(packet);
        socket.close();
    }

}
