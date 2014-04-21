import java.io.IOException;
import java.net.DatagramPacket;
import java.net.*;//DatagramSocket;
import java.net.InetAddress;
import java.nio.*;//ByteBuffer;
import java.util.Scanner;

public class UDPClient {
    
    public static void main(String[] args) throws IOException {
        
    //}
    
    //public void run() throws IOException {
        
        DatagramSocket socket = new DatagramSocket();
        
        //reads an integer from keyboard input 
        System.out.println("Insert number: ");  
        Scanner s= new Scanner(System.in);
        int num = s.nextInt();
        
        //byte[] byteSend = ByteBuffer.allocate(4).putInt(num).array();
        InetAddress address = InetAddress.getByName("localhost");
        int port = 1999;
        
        //stores num value in a UDP packet of 4 bytes
        byte[] byteSend = ByteBuffer.allocate(4).putInt(num).array();
            
        //sends the UDP packet to the server, on port number 1999
        DatagramPacket packetSend = new DatagramPacket(byteSend, byteSend.length, address, port);
        socket.send(packetSend);
            
        //DatagramPacket packetSend = new DatagramPacket(byteSend, byteSend.length, address, port);
        //socket.send(packetSend);
        
        //byte[] byteReceive = new byte[1];//prev1
        //byte[] byteAck = "*".getBytes();
        //DatagramPacket packetReceive = new DatagramPacket(byteReceive, byteReceive.length);
        //DatagramPacket dpAck = new DatagramPacket(byteAck, byteAck.length, address, port);
        
        //listens for UDP packets from the server (until it receives a packet with a non-positive number)
        //while (true) {

            while (num > 0) {
                byte[] byteReceive = new byte[4];//prev1
                //byte[] byteAck = "*".getBytes();
                DatagramPacket packetReceive = new DatagramPacket(byteReceive, byteReceive.length);
                //DatagramPacket dpAck = new DatagramPacket(byteAck, byteAck.length, address, port);
            
                socket.receive(packetReceive);
                //String alteredNum = new String(packetReceive.getData());
                
                //num = ByteBuffer.wrap(packetReceive.getData()).getInt();
                num = ByteBuffer.wrap(packetReceive.getData()).getInt();
                //num = Integer.parseInt(alteredNum);
            
                System.out.println(num);
                //socket.send(dpAck);
                
                int alteredNum = num-2;
                
                //stores num value in a new UDP packet of 4 bytes
                byteSend = ByteBuffer.allocate(4).putInt(alteredNum).array();
                
                //sends the UDP packet to the server, on port number 1999
                packetSend = new DatagramPacket(byteSend, byteSend.length, address, port);
                socket.send(packetSend);
                
                //num = ByteBuffer.wrap(packetReceive.getData()).getInt();
           
            }
            socket.close();
        //} 
       
    }
}
