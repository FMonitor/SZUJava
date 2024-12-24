package com.lcmonitor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class chatServer {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024];

            System.out.println("服务器已启动，等待客户端消息...");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("收到客户端消息: " + message);

                String response = scanner.nextLine();
                byte[] sendData = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(),
                        receivePacket.getPort());
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}