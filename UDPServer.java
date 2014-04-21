import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

public class UDPServer {
    
    public static void main(String[] args) throws IOException {
        
    //}
    
    //public void run() throws IOException {

        DatagramSocket socket = new DatagramSocket(1999);
        
        while (true) {
            byte[] byteReceive = new byte[4];
            DatagramPacket packetReceive = new DatagramPacket(byteReceive, byteReceive.length);
            socket.receive(packetReceive);
            int num = ByteBuffer.wrap(packetReceive.getData()).getInt();
            int alteredNum = num-2;
            
            InetAddress address = packetReceive.getAddress();
            int port = packetReceive.getPort();
            
            byte[] byteSend = ByteBuffer.allocate(4).putInt(alteredNum).array();
            DatagramPacket packetSend = new DatagramPacket(byteSend, byteSend.length, address, port);
            socket.send(packetSend);
            
            num = ByteBuffer.wrap(packetReceive.getData()).getInt();
            
            //byte[] byteAck = new byte[1];
            //DatagramPacket dpAck = new DatagramPacket(byteAck, byteAck.length);
            
            
                //socket.receive(dpAck);

              /*  String stringAck = new String(dpAck.getData());
                if (!"*".equals(stringAck)) {
                    System.out.println("Error!");
                    return;
                }*/
            
        }
    }
}
