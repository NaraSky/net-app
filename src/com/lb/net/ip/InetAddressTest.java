package com.lb.net.ip;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) throws IOException {
        InetAddress localHost = InetAddress.getLocalHost();
        byte[] hostAddress = localHost.getAddress();
        System.out.println(hostAddress);

        for (int i = 0; i < hostAddress.length; i++) {
            System.out.print(hostAddress[i] & 0xff);
        }

        String hostName = localHost.getHostName();
        System.out.println(hostName);

        String address = localHost.getHostAddress();
        System.out.println(address);

        InetAddress ip = InetAddress.getByName("www.baidu.com");
        System.out.println(ip.getHostAddress());
        System.out.println(ip);
        System.out.println(ip.getHostName());

        boolean reachable = ip.isReachable(6000);
        System.out.println(reachable);
    }
}
