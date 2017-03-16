
package practica.pkg6.m9.uf3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;


public class Servidor {
    MulticastSocket socket;
    InetAddress multicastIP;
    int port;
    boolean continueRunning = true;
    
    public void init(String strIp, int portValue) throws socketException, IOException{
        socket = new MulticastSocket(portValue);
        //multicastIP = new InetAddress();
    }
    
    /*
    socket.joinGroup();
    
    
    while(continueRunning){
        packet = new DatagramPacket(recieveData, 1024);
    
        socket.setSoTimeout(5000);
    
        try{
    
            socket.recieve(packet);
    
    
    }
    
    */
}
