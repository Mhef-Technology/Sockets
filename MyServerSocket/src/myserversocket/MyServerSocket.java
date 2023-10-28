package myserversocket;

import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyServerSocket implements Serializable {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        int port = 10000;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Servidor en línea");
            while (true) {
                Logger.getLogger(MyServerSocket.class.getName()).log(Level.INFO, "Waiting...");
                socket = serverSocket.accept();
                Thread clienteThread = new Thread(new MiNegocio(socket));
                clienteThread.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(MyServerSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}