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
                    } else {
                        bath = false;
                        shower = true;
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
