package practica.pkg6.m9.uf3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class Client {

    private static final int PORT = 5487;
    private static final String HOST = "231.0.0.8";

    public static void main(String[] args) throws UnknownHostException, IOException {
        MulticastSocket socket = new MulticastSocket(PORT);
        InetAddress inet = InetAddress.getByName(HOST);
        DatagramPacket dp;
        String cadena;
        socket.joinGroup(inet);
        byte[] missatge1, missatge2;
        
        //Bucle que s'executara m'entres que la cadena que rep no sigui exit.
        do {
            //Es crea l'array de bytes on ficarem el missatge.    
            missatge1 = new byte[512];
            //Creem el datagramPacket que utlitzarem per enviar el missatge.
            dp = new DatagramPacket(missatge1, missatge1.length);
            
            socket.receive(dp);
            //Indiquem la llargaria i la guardem en una variable.
            int mida = dp.getLength();
            //S'inicialitza l'array on es guardara el missatge amb la mida indicada.
            missatge2 = new byte[mida];
            
            System.arraycopy(missatge1, 0, missatge2, 0, mida);
            //Es guarda el missatge.
            cadena = new String(missatge2);
            //S'imprimeix el missatge.
            System.out.println(cadena);
        } while (!cadena.equals("exit"));
        socket.leaveGroup(inet);
    }

}
