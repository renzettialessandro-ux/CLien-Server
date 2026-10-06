package eserciziosocketserver;

// 1. Importa la classe dal pacchetto "eserciziosocket"
import eserciziosocket.InvioMessaggi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EsercizioSocketServer {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5555);

        try (Socket client = server.accept()) {
            // Ricezione del messaggio dal client
            InputStream inputStream = client.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            String clientMessage = dataInputStream.readUTF();
            System.out.println("Messaggio dal client: " + clientMessage);

            // Istanza della classe InvioMessaggi
            InvioMessaggi invio = new InvioMessaggi();

            // 2. Chiamata al metodo con il nome corretto
            String risposta = invio.chiediEMandaMessaggio();

            // Invio della risposta letta da tastiera
            OutputStream outputStream = client.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(risposta);
        }
    }
}