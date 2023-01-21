import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.*;
import java.net.*;
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
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            System.out.println("Log in or Sign up?");
            System.out.println("1. Log in \n2. Sign up");
            int choice = scan.nextInt();
            scan.nextLine();
            switch(choice) {
                case 1:
            }
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
                    System.out.println("How long do you brush your teeth?");
                    System.out.println("1. 0-5 minutes \n2. 5-10 minutes \n3. 10+ minutes");
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
