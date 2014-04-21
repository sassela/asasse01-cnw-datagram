import java.net.*;
import java.nio.*;
import java.util.Scanner;
import java.io.IOException;

public class Datagram {
    
    public static void main(String[] args) throws IOException {
        
    }
    
    public static DatagramPacket receivePacket(DatagramSocket socket) throws IOException {
        byte[] byteReceive = new byte[4];
        DatagramPacket packetReceive = new DatagramPacket(byteReceive, byteReceive.length);
        socket.receive(packetReceive);
        return packetReceive;
    }
    
    public static int extractInt(DatagramPacket packetReceive) {
        int num = ByteBuffer.wrap(packetReceive.getData()).getInt();
        System.out.println(num);
        return num;
    }
    
     public static InetAddress getReturnAddress(DatagramPacket packetReceive) {
        InetAddress address = packetReceive.getAddress();
        return address;
    }
    
    public static int getReturnPort(DatagramPacket packetReceive) {
        int port = packetReceive.getPort();
        return port;
    }
        
    public static int alterNum(int num) {
        int alteredNum = num-2; 
        return alteredNum;
    }
    
    public static void sendPacket(int num, InetAddress address, int port, DatagramSocket socket) throws IOException {
        byte[] byteSend = ByteBuffer.allocate(4).putInt(num).array();
        DatagramPacket packetSend = new DatagramPacket(byteSend, byteSend.length, address, port);
        socket.send(packetSend);
    }
        
    public static void run() throws IOException {
        
    }
}
