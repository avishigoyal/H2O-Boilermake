import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4242);
            System.out.println("Waiting for the client to connect...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
