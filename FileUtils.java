import java.io.*;
import java.util.ArrayList;

public class FileUtils {

    private static final String userFile = "users.txt";

    public static void createAccount(User user) {
        File f = new File(userFile);
        try (BufferedReader bfr = new BufferedReader(new FileReader(userFile));
             PrintWriter pw = new PrintWriter(new FileOutputStream(userFile, true))) {
            pw.println(user.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkUsername(String username) {
        File f = new File(userFile);
        if (!f.exists()) {
            return false;
        }
        try (BufferedReader bfr = new BufferedReader(new FileReader(userFile));
             PrintWriter pw = new PrintWriter(new FileOutputStream(userFile, true))) {
            ArrayList<String> usernames = new ArrayList<>();
            while (true) {
                String line = bfr.readLine();
                if (line == null) {
                    break;
                }
                String[] elements = line.split(",");
                usernames.add(elements[0]);
            }

            for (int i = 0; i < usernames.size(); i++) {
                if (usernames.get(i).equals(username)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static User verifyLogin(User user) {
        File f = new File(userFile);
        if (!f.exists()) {
            return null;
        }
        try (BufferedReader bfr = new BufferedReader(new FileReader(userFile));
             PrintWriter pw = new PrintWriter(new FileOutputStream(userFile, true))) {
            ArrayList<User> users = new ArrayList<>();
            while (true) {
                String line = bfr.readLine();
                if (line == null) {
                    break;
                }
                String[] elements = line.split(",");
                if (elements[0].equals(user.getUsername()) &&
                        elements[1].equals(user.getPassword())) {
                    return new User(elements[0], elements[1],
                            elements[2],elements[3], elements[4]);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
