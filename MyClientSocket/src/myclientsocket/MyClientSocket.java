package myclientsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyClientSocket {

    public static void main(String[] args) {
        Socket socket = null;
        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;
        String ip = "192.168.20.31"; // Cambia a tu dirección IP del servidor
        int port = 10000; // Cambia al puerto correcto
        String msgWrite;
        try {
            socket = new Socket(ip, port);
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            final BufferedReader finalBufferedReader = bufferedReader;
            Thread receptorThread = new Thread(() -> {
                try {
                    while (true) {
                        String msgRead = finalBufferedReader.readLine();
                        String newMsg = desencript(msgRead);
                        System.out.println(newMsg);
                    }
                } catch (Exception e) {
                    System.out.println("Conexión Terminada");
                }
            });
            receptorThread.start();

            System.out.println(" ");
            while (true) {
                BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
                msgWrite = consoleReader.readLine();
                String newMsg = encript(msgWrite);
                printWriter.println(newMsg);
                if (msgWrite.equals("END")) {
                    break;
                }
                printWriter.flush();
            }
            bufferedReader.close();
            printWriter.close();
            socket.close();
            Logger.getLogger(MyClientSocket.class.getName()).log(Level.INFO, "End");
        } catch (IOException ex) {
            Logger.getLogger(MyClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static String desencript(String msgRead) {
        String desencriptada = "";
        if (!msgRead.isEmpty()) {
            int largo = msgRead.length();
            char caracter;
            for (int i = 0; i < largo; i++) {
                caracter = msgRead.charAt(i);
                switch (caracter) {
                    case 'A':
                        desencriptada = desencriptada + 'Q';
                        break;
                    case 'B':
                        desencriptada = desencriptada + 'G';
                        break;
                    case 'C':
                        desencriptada = desencriptada + 'D';
                        break;
                    case 'D':
                        desencriptada = desencriptada + 'E';
                        break;
                    case 'E':
                        desencriptada = desencriptada + '3';
                        break;
                    case 'F':
                        desencriptada = desencriptada + 'R';
                        break;
                    case 'G':
                        desencriptada = desencriptada + 'T';
                        break;
                    case 'H':
                        desencriptada = desencriptada + 'Y';
                        break;
                    case 'I':
                        desencriptada = desencriptada + '8';
                        break;
                    case 'J':
                        desencriptada = desencriptada + 'U';
                        break;
                    case 'K':
                        desencriptada = desencriptada + 'I';
                        break;
                    case 'L':
                        desencriptada = desencriptada + 'O';
                        break;
                    case 'M':
                        desencriptada = desencriptada + 'J';
                        break;
                    case 'N':
                        desencriptada = desencriptada + 'H';
                        break;
                    case 'O':
                        desencriptada = desencriptada + '9';
                        break;
                    case 'P':
                        desencriptada = desencriptada + '0';
                        break;
                    case 'Q':
                        desencriptada = desencriptada + '1';
                        break;
                    case 'R':
                        desencriptada = desencriptada + 'R';
                        break;
                    case 'S':
                        desencriptada = desencriptada + 'W';
                        break;
                    case 'T':
                        desencriptada = desencriptada + '5';
                        break;
                    case 'U':
                        desencriptada = desencriptada + '7';
                        break;
                    case 'V':
                        desencriptada = desencriptada + 'F';
                        break;
                    case 'W':
                        desencriptada = desencriptada + '2';
                        break;
                    case 'X':
                        desencriptada = desencriptada + 'S';
                        break;
                    case 'Y':
                        desencriptada = desencriptada + '6';
                        break;
                    case 'Z':
                        desencriptada = desencriptada + 'A';
                        break;
                    case '1':
                        desencriptada = desencriptada + 'Z';
                        break;
                    case '2':
                        desencriptada = desencriptada + 'X';
                        break;
                    case '3':
                        desencriptada = desencriptada + 'C';
                        break;
                    case '4':
                        desencriptada = desencriptada + 'V';
                        break;
                    case '5':
                        desencriptada = desencriptada + 'B';
                        break;
                    case '6':
                        desencriptada = desencriptada + 'N';
                        break;
                    case '7':
                        desencriptada = desencriptada + 'M';
                        break;
                    case '8':
                        desencriptada = desencriptada + ',';
                        break;
                    case '9':
                        desencriptada = desencriptada + '.';
                        break;
                    case '0':
                        desencriptada = desencriptada + '-';
                        break;
                    case ',':
                        desencriptada = desencriptada + 'K';
                        break;
                    case '.':
                        desencriptada = desencriptada + 'L';
                        break;
                    case '-':
                        desencriptada = desencriptada + 'P';
                        break;
                    case ' ':
                        desencriptada = desencriptada + ' ';
                        break;
                    case '#':
                        desencriptada = desencriptada + '#';
                }
            }
        }
        return desencriptada;
    }
    public static String encript(String msgRead){
        String encriptada = "";
        if (!msgRead.isEmpty()) {
            int largo = msgRead.length();
            char caracter;
            for (int i = 0; i < largo; i++) {
                caracter = msgRead.charAt(i);
                switch (caracter) {
                    case 'a':
                        encriptada = encriptada + 'Z';
                        break;
                    case 'b':
                        encriptada = encriptada + '5';
                        break;
                    case 'c':
                        encriptada = encriptada + '3';
                        break;
                    case 'd':
                        encriptada = encriptada + 'C';
                        break;
                    case 'e':
                        encriptada = encriptada + 'D';
                        break;
                    case 'f':
                        encriptada = encriptada + 'V';
                        break;
                    case 'g':
                        encriptada = encriptada + 'B';
                        break;
                    case 'h':
                        encriptada = encriptada + 'N';
                        break;
                    case 'i':
                        encriptada = encriptada + 'K';
                        break;
                    case 'j':
                        encriptada = encriptada + 'M';
                        break;
                    case 'k':
                        encriptada = encriptada + ',';
                        break;
                    case 'l':
                        encriptada = encriptada + '.';
                        break;
                    case 'm':
                        encriptada = encriptada + '7';
                        break;
                    case 'n':
                        encriptada = encriptada + '6';
                        break;
                    case 'o':
                        encriptada = encriptada + 'L';
                        break;
                    case 'p':
                        encriptada = encriptada + '-';
                        break;
                    case 'q':
                        encriptada = encriptada + 'A';
                        break;
                    case 'r':
                        encriptada = encriptada + 'F';
                        break;
                    case 's':
                        encriptada = encriptada + 'X';
                        break;
                    case 't':
                        encriptada = encriptada + 'G';
                        break;
                    case 'u':
                        encriptada = encriptada + 'J';
                        break;
                    case 'v':
                        encriptada = encriptada + '4';
                        break;
                    case 'w':
                        encriptada = encriptada + 'S';
                        break;
                    case 'x':
                        encriptada = encriptada + '2';
                        break;
                    case 'y':
                        encriptada = encriptada + 'H';
                        break;
                    case 'z':
                        encriptada = encriptada + '1';
                        break;
                    case 'A':
                        encriptada = encriptada + 'Z';
                        break;
                    case 'B':
                        encriptada = encriptada + '5';
                        break;
                    case 'C':
                        encriptada = encriptada + '3';
                        break;
                    case 'D':
                        encriptada = encriptada + 'C';
                        break;
                    case 'E':
                        encriptada = encriptada + 'D';
                        break;
                    case 'F':
                        encriptada = encriptada + 'V';
                        break;
                    case 'G':
                        encriptada = encriptada + 'B';
                        break;
                    case 'H':
                        encriptada = encriptada + 'N';
                        break;
                    case 'I':
                        encriptada = encriptada + 'K';
                        break;
                    case 'J':
                        encriptada = encriptada + 'M';
                        break;
                    case 'K':
                        encriptada = encriptada + ',';
                        break;
                    case 'L':
                        encriptada = encriptada + '.';
                        break;
                    case 'M':
                        encriptada = encriptada + '7';
                        break;
                    case 'N':
                        encriptada = encriptada + '6';
                        break;
                    case 'O':
                        encriptada = encriptada + 'L';
                        break;
                    case 'P':
                        encriptada = encriptada + '-';
                        break;
                    case 'Q':
                        encriptada = encriptada + 'A';
                        break;
                    case 'R':
                        encriptada = encriptada + 'F';
                        break;
                    case 'S':
                        encriptada = encriptada + 'X';
                        break;
                    case 'T':
                        encriptada = encriptada + 'G';
                        break;
                    case 'U':
                        encriptada = encriptada + 'J';
                        break;
                    case 'V':
                        encriptada = encriptada + '4';
                        break;
                    case 'W':
                        encriptada = encriptada + 'S';
                        break;
                    case 'X':
                        encriptada = encriptada + '2';
                        break;
                    case 'Y':
                        encriptada = encriptada + 'H';
                        break;
                    case 'Z':
                        encriptada = encriptada + '1';
                        break;
                    case '1':
                        encriptada = encriptada + 'Q';
                        break;
                    case '2':
                        encriptada = encriptada + 'W';
                        break;
                    case '3':
                        encriptada = encriptada + 'E';
                        break;
                    case '4':
                        encriptada = encriptada + 'R';
                        break;
                    case '5':
                        encriptada = encriptada + 'T';
                        break;
                    case '6':
                        encriptada = encriptada + 'Y';
                        break;
                    case '7':
                        encriptada = encriptada + 'U';
                        break;
                    case '8':
                        encriptada = encriptada + 'I';
                        break;
                    case '9':
                        encriptada = encriptada + 'O';
                        break;
                    case '0':
                        encriptada = encriptada + 'P';
                        break;
                    case ',':
                        encriptada = encriptada + '8';
                        break;
                    case '.':
                        encriptada = encriptada + '9';
                        break;
                    case '-':
                        encriptada = encriptada + '0';
                        break;
                    case ' ':
                        encriptada = encriptada + ' ';
                        break;
                    default:
                        encriptada = encriptada + '#';
                }
            }
        }
        return encriptada;
    }
}
