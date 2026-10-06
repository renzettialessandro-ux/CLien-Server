/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eserciziosocketserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author renzetti.alessandro
 */
public class EsercizioSocketServer {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket server= new ServerSocket(5555);
        try (Socket client = server.accept()) {
            InputStream inputStream= client.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            String clientMessage = dataInputStream.readUTF();
            System.out.println("Messaggio dal client: " + clientMessage);
            OutputStream outputStream = client.getOutputStream();
            DataOutputStream dataOutputStream= new DataOutputStream(outputStream);
            String risposta="Ciao Client";
            dataOutputStream.writeUTF(risposta);
        }
    }
    
}
