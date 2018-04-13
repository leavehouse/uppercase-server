import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: Server <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);

        try (
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(
                    new OutputStreamWriter(clientSocket.getOutputStream()));
            ) {
                String line = null;
                while ((line = in.readLine()) != null) {
                    out.write(line.toUpperCase() + "\n");
                    out.flush();
                }
            // TODO
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
