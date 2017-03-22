package practica.pkg6.m9.uf3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import javax.swing.JOptionPane;

public class Servidor {

    private static final int port = 5487;
    private static final String host = "231.0.0.8";

    MulticastSocket socket;
    InetAddress multicastIP;
    boolean continueRunning = true;

    public void init(String strIp, int portValue) throws IOException {
        socket = new MulticastSocket(portValue);
        MulticastSocket socket = new MulticastSocket(port);
        InetAddress inet = InetAddress.getByName(host);
        //Es crea l'array de bytes on ficarem el missatge.
        byte[] dades = new byte[0];
        //Creem el datagramPacket que utlitzarem per enviar el missatge.
        DatagramPacket dp = new DatagramPacket(dades, dades.length, inet, port);
        String recollirMissatge;
        
        //Bucle que s'executara m'entres que la cadena que rep no sigui exit.
        do {
            //S'introdueix el missatge que es vol enviar.
            recollirMissatge = JOptionPane.showInputDialog("Introdueix una cadena:");
            //Es recolleix el missatge.
            dades = recollirMissatge.getBytes();
            //S'afegeix la cadena al datagramPacket que hem creat abans.
            dp.setData(dades);
            //Indiquem la llargaria del datagramPacket.
            dp.setLength(dades.length);
            //Enviem el missatge.
            socket.send(dp);
        } while (!recollirMissatge.equals("exit"));
    }

}
