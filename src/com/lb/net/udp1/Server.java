package com.lb.net.udp1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(6666);
        byte[] buffer = new byte[1024 * 64];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        socket.receive(packet);
        int length = packet.getLength();
        System.out.println("接收到的数据长度为：" + length);
        System.out.println("接收到的数据内容为：" + new String(buffer,
                0, length));

        System.out.println("packet.getAddress() = " + packet.getAddress());
        System.out.println("packet.getPort() = " + packet.getPort());
        socket.close();
    }

}
