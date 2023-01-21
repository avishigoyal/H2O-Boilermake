import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4242);
            System.out.println("Waiting for the client to connect...");
            Socket socket = serverSocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            User user = null;
            String option = "";
            String message = "";

            do {
                option = reader.readLine();

                if (option.equals("1")) {
                    String username = reader.readLine();
                    String password = reader.readLine();
                    user = new User(username, password);
                    if (FileUtils.verifyLogin(user) == null) {
                        message = "Invalid";
                        writer.write("Invalid username or password. Try again.");
                        writer.println();
                        writer.flush();
                    } else {
                        writer.write("Successfully logged in!");
                        writer.println();
                        writer.flush();
                        user = FileUtils.verifyLogin(user);
                    }

                } else if (option.equals("2")) {
                    String username;
                    String password;
                    String email;
                    String state;
                    String county;

                    username = reader.readLine();
                    password = reader.readLine();
                    email = reader.readLine();
                    state = reader.readLine();
                    county = reader.readLine();

                    user = new User(username, password, email, state, county);
                    FileUtils.createAccount(user);

                } else {
                    // returns to select the following
                }
            } while (!option.equals("1") && !option.equals("2") || message.contains("Invalid"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}