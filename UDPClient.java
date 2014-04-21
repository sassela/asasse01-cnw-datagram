import java.net.*;
import java.nio.*;
import java.util.Scanner;
import java.io.IOException;

public class UDPClient extends Datagram {
    
    public static void main(String[] args) throws IOException {
        run();
    }
    
    public static void run() throws IOException {
        InetAddress address = InetAddress.getByName("localhost");
        int port = 1999;
        
        //stores user input in variable num as original integer to send
        System.out.println("Please enter an integer: ");  
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        
        DatagramSocket socket = new DatagramSocket();
        
        //sends packet to Server with original integer
        sendPacket(num, address, port, socket);

            while (num > 0) {
                //sets num variable based on packed received from Server
                num = extractInt(receivePacket(socket));
                
                //sends packet to Server with altered (n-2) integer
                sendPacket(alterNum(num), address, port, socket);
           
            }
            
        socket.close();
       
    }
}
