import java.net.*;
import java.nio.*;
import java.util.Scanner;
import java.io.IOException;

public class Datagram {
    
    public static void main(String[] args) throws IOException {
    }
    
    //creates data packet to receive via socket entered as argument
    public static DatagramPacket receivePacket(DatagramSocket socket) throws IOException {
        byte[] byteReceive = new byte[4];
        DatagramPacket packetReceive = new DatagramPacket(byteReceive, byteReceive.length);
        socket.receive(packetReceive);
        return packetReceive;
    }
    
    //extracts & returns integer from received packet
    public static int extractInt(DatagramPacket packetReceive) {
        int num = ByteBuffer.wrap(packetReceive.getData()).getInt();
        System.out.println(num);
        return num;
    }
    
    //returns address of sender. Suitable for use in Server class to establish origin
     public static InetAddress getReturnAddress(DatagramPacket packetReceive) {
        InetAddress address = packetReceive.getAddress();
        return address;
    }
    
    //returns port number of sender. Suitable for use in Server class to establish origin
    public static int getReturnPort(DatagramPacket packetReceive) {
        int port = packetReceive.getPort();
        return port;
    }
    
    //subtracts 2 from the number received by Client & Server as per the CNW brief
    public static int alterNum(int num) {
        int alteredNum = num-2; 
        return alteredNum;
    }
    
    //sends packet containing num to address, on port & via socket entered as arguments
    public static void sendPacket(int num, InetAddress address, int port, DatagramSocket socket) throws IOException {
        byte[] byteSend = ByteBuffer.allocate(4).putInt(num).array();
        DatagramPacket packetSend = new DatagramPacket(byteSend, byteSend.length, address, port);
        socket.send(packetSend);
    }
        
    public static void run() throws IOException {
    }
}
