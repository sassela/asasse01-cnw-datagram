import java.net.*;
import java.nio.*;
import java.util.Scanner;
import java.io.IOException;

public class UDPServer extends Datagram {
    
    public static void main(String[] args) throws IOException {
        run();
    }
    
    
    public static void run() throws IOException {
        DatagramSocket socket = new DatagramSocket(1999);
        while (true) {
            DatagramPacket packet = receivePacket(socket);
            //sets num, port & address variables based on packet received from Client
            int num = extractInt(packet);
            int port = getReturnPort(packet);
            InetAddress address = getReturnAddress(packet);
   
            //returns packet to Client with altered (n-2) integer
            sendPacket(alterNum(num), address, port, socket);
            
        }
    }
}
