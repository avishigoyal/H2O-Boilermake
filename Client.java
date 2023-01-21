import java.net.Socket;
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
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
