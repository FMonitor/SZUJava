package client.com.lcmonitor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class chatClient {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName("localhost");
            Scanner scanner = new Scanner(System.in);

            System.out.println("客户端已启动，输入消息发送到服务器:");

            while (true) {
                System.out.print("输入消息: ");
                String message = scanner.nextLine();
                byte[] sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, 9876);
                socket.send(sendPacket);

                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("收到服务器回复: " + response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}