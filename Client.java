import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.*;
import java.net.*;
import java.util.Locale;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean bath;
        boolean shower;
        boolean dishwasher;
        boolean hand;
        boolean can;
        boolean sprinklers;

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
         
            System.out.println("What would you like to do?");
            System.out.println("1. Water Consumption Quiz \n2. Water Consumption Tracker");
            choice = scan.nextInt();
            scan.nextLine();
            switch(choice) {
                case 1:
                    System.out.println("Do you take a bath or a shower regularly?");
                    System.out.println("1. Bath \n2. Shower");
                    int bs = scan.nextInt();
                    scan.nextLine();
                    if (bs == 1) {
                        bath = true;
                        shower = false;
                        writer.write(String.valueOf(bath));
                        writer.write(String.valueOf(shower));
                        writer.println();
                        writer.flush();
                    } else {
                        bath = false;
                        shower = true;
                        writer.write(String.valueOf(bath));
                        writer.write(String.valueOf(shower));
                        writer.println();
                        writer.flush();
                        System.out.println("How long do you shower?");
                        System.out.println("1. 0-10 minutes \n2. 11-20 minutes \n3. 21+ minutes");
                        int showerDur = scan.nextInt();
                        scan.nextLine();
                        writer.write(showerDur);
                        writer.println();
                        writer.flush();
                    }
                    System.out.println("How often do you brush your teeth in a day?");
                    System.out.println("1. 1 time \n2. 2 times \n3. 3+ times");
                    int teeth = scan.nextInt();
                    scan.nextLine();
                    writer.write(teeth);
                    writer.println();
                    writer.flush();
                    System.out.println("How many times do you use the toilet?");
                    System.out.println("1. 0-2 times \n2. 3-6 times \n3. 7+ times");
                    int toilet = scan.nextInt();
                    scan.nextLine();
                    writer.write(toilet);
                    writer.println();
                    writer.flush();
                    System.out.println("How often do you wash your hands?");
                    System.out.println("1. 0-4 times \n 5-10 times \n3. 11+ times");
                    int washHands = scan.nextInt();
                    scan.nextLine();
                    writer.write(washHands);
                    writer.println();
                    writer.flush();
                    System.out.println("How often do you use the washing machine per month?");
                    System.out.println("1. 0-1 times \n2. 2-4 times \n3. 5+ times");
                    int clothes = scan.nextInt();
                    scan.nextLine();
                    writer.write(clothes);
                    writer.println();
                    writer.flush();
                    System.out.println("How often do you cook per week?");
                    System.out.println("1. 0-4 times \n2. 5-10 times \n3. 11+ times");
                    int cook = scan.nextInt();
                    scan.nextLine();
                    writer.write(cook);
                    writer.println();
                    writer.flush();
                    System.out.println("Do you use a dishwasher or wash dishes by hand regularly?");
                    System.out.println("1. Dishwasher \n2. By hand");
                    int dd = scan.nextInt();
                    scan.nextLine();
                    if (dd == 1) {
                        dishwasher = true;
                        hand = false;
                        writer.write(String.valueOf(dishwasher));
                        writer.write(String.valueOf(hand));
                        writer.println();
                        writer.flush();
                        System.out.println("How often do you use the dishwasher?");
                        System.out.println("1. 0-4 times \n2. 5-10 times \n3. 11+ times");
                        int dishwash = scan.nextInt();
                        scan.nextLine();
                        writer.write(dishwash);
                        writer.println();
                        writer.flush();
                    } else {
                        dishwasher = false;
                        hand = true;
                        writer.write(String.valueOf(dishwasher));
                        writer.write(String.valueOf(hand));
                        writer.println();
                        writer.flush();
                        System.out.println("How often do you wash dishes by hand?");
                        System.out.println("1. 0-4 times \n2. 5-10 times \n3. 11+ times");
                        int handwash = scan.nextInt();
                        scan.nextLine();
                        writer.write(handwash);
                        writer.println();
                        writer.flush();
                    }
                    System.out.println("Do you water plants regularly?");
                    System.out.println("1. Yes \n2. No");
                    int yn = scan.nextInt();
                    scan.nextLine();
                    if (yn == 1) {
                        System.out.println("Do you water by hand/watering can or sprinklers?");
                        System.out.println("1. Hand/Watering can \n2. Sprinklers");
                        int ws = scan.nextInt();
                        scan.nextLine();
                        if (ws == 1) {
                            can = true;
                            sprinklers = false;
                            writer.write(String.valueOf(can));
                            writer.write(String.valueOf(sprinklers));
                            writer.println();
                            writer.flush();
                            System.out.println("How often do you water your plants by hand/watering can?");
                            System.out.println("1. 0-2 times \n2. 3-5 times \n3. 6+ times");
                            int watercan = scan.nextInt();
                            scan.nextLine();
                            writer.write(watercan);
                            writer.println();
                            writer.flush();
                        } else {
                            can = false;
                            sprinklers = true;
                            writer.write(String.valueOf(can));
                            writer.write(String.valueOf(sprinklers));
                            writer.println();
                            writer.flush();
                            System.out.println("How often do you water your plants by sprinklers?");
                            System.out.println("1. 0-2 times \n2. 3-5 times \n3. 6+ times");
                            int sprinkle = scan.nextInt();
                            scan.nextLine();
                            writer.write(sprinkle);
                            writer.println();
                            writer.flush();
                        }
                    } else {
                        break;
                    }
                    break;
                case 2:

                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}