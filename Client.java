import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Locale;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a host name: ");
        String host = scan.nextLine();
        System.out.println("Enter a port number: ");
        int portNumber = scan.nextInt();
        scan.nextLine();
        try {
            Socket socket = new Socket(host, portNumber);
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);

            User user = null;
            String option = "";
            String message = "";

            // TODO: change welcome message according to name
            System.out.println("Welcome to H20's Water Consumption Tracker!");
            do {
                System.out.println("Select one of the following:");
                System.out.println("1. Login\n2. Create Account");
                option = scanner.nextLine();

                writer.write(option);
                writer.println();
                writer.flush();

                if (option.equals("1")) {
                    String username;
                    String password;

                    do {
                        System.out.println("Enter your username.");
                        username = scanner.nextLine();
                        if (username == null || username.contains(" ")) {
                            System.out.println("Invalid username.");
                        } else {
                            writer.write(username);
                            writer.println();
                            writer.flush();
                        }
                    } while (username == null || username.contains(" "));

                    do {
                        System.out.println("Enter your password.");
                        password = scanner.nextLine();
                        if (password == null || password.contains(" ")) {
                            System.out.println("Invalid password.");
                        } else {
                            writer.write(password);
                            writer.println();
                            writer.flush();
                        }
                    } while (password == null || password.contains(" "));
                    message = reader.readLine();
                    System.out.println(message);

                } else if (option.equals("2")) {
                    String username;
                    String password;
                    String email;
                    String state;
                    String county;
                    boolean usernameExists;

                    do {
                        System.out.println("Enter your username.");
                        username = scanner.nextLine();
                        usernameExists = FileUtils.checkUsername(username);
                        if (username == null || username.contains(" ")) {
                            System.out.println("Invalid username.");
                        } else if (usernameExists == true){
                            System.out.println("Username taken.");
                        } else {
                            writer.write(username);
                            writer.println();
                            writer.flush();
                        }
                    } while (username == null || username.contains(" ") || usernameExists == true);

                    do {
                        System.out.println("Enter your password.");
                        password = scanner.nextLine();
                        if (password == null || password.contains(" ")) {
                            System.out.println("Invalid password.");
                        } else {
                            writer.write(password);
                            writer.println();
                            writer.flush();
                        }
                    } while (password == null || password.contains(" "));

                    do {
                        System.out.println("Enter your email.");
                        email = scanner.nextLine();
                        if (email == null ||
                                email.contains(" ") ||
                                !email.contains("@")) {
                            System.out.println("Invalid email.");
                        } else {
                            writer.write(email);
                            writer.println();
                            writer.flush();
                        }
                    } while (email == null ||
                            email.contains(" ") ||
                            !email.contains("@"));

                    do {
                        System.out.println("Enter your state abbreviated. (ex: AL)");
                        state = scanner.nextLine().toUpperCase();
                        if (state == null || state.length() != 2) {
                            System.out.println("Invalid state.");
                        } else {
                            writer.write(state);
                            writer.println();
                            writer.flush();
                        }
                    } while (state == null || state.length() != 2);

                    do {
                        System.out.println("Enter the name of the county you live in. (ex: San Francisco)");
                        county = scanner.nextLine();
                        if (county == null) {
                            System.out.println("Invalid county.");
                        } else {
                            writer.write(county);
                            writer.println();
                            writer.flush();
                        }
                    } while (county == null);

                } else {
                    System.out.println("Error. Please try again.");
                }
            } while (!option.equals("1") && !option.equals("2") || message.contains("Invalid"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}