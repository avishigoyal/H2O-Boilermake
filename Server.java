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
            String showerDur = "";
            String teeth = "";
            String toilet = "";
            String washHands = "";
            String clothes = "";
            String cook = "";
            String dishwash = "";
            String handwash = "";
            String watercan = "";
            String sprinkle = "";
            do {
                option = reader.readLine();

                if (option.equals("1")) {
                    String username = reader.readLine();
                    String password = reader.readLine();
                    Integer hash = password.hashCode();
                    user = new User(username, hash.toString());
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
                option = reader.readLine();
                if (option.equals("1")) {
                    String bs = reader.readLine();
                    if (bs.equals("1")) {
                        String bath = reader.readLine();
                        String shower = reader.readLine();
                    } else if (bs.equals("2")) {
                        String bath = reader.readLine();
                        String shower = reader.readLine();
                        showerDur = reader.readLine();
                    }
                    teeth = reader.readLine();
                    toilet = reader.readLine();
                    washHands = reader.readLine();
                    clothes = reader.readLine();
                    cook = reader.readLine();
                    String dd = reader.readLine();
                    if (dd.equals("1")) {
                        String dishwasher = reader.readLine();
                        String hand = reader.readLine();
                        dishwash = reader.readLine();
                    } else if (dd.equals("2")) {
                        String dishwasher = reader.readLine();
                        String hand = reader.readLine();
                        handwash = reader.readLine();
                    }
                    String yn = reader.readLine();
                    if (yn.equals("1")) {
                        String ws = reader.readLine();
                        if (ws.equals("1")) {
                            String can = reader.readLine();
                            String sprinklers = reader.readLine();
                            watercan = reader.readLine();
                        } else if (ws.equals("2")) {
                            String can = reader.readLine();
                            String sprinklers = reader.readLine();
                            sprinkle = reader.readLine();
                        }
                    }
                } else if (option.equals("2")) {
                    //tracker
                }
            } while (!option.equals("1") && !option.equals("2") || message.contains("Invalid"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}