import java.io.*;
import java.util.ArrayList;

public class FileUtils {

    private static final String userFile = "users.txt";

    public static void createAccount(User user) {
        File f = new File(userFile);
        ArrayList<User> users = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(userFile);
             ObjectInputStream in = new ObjectInputStream(fis)) {
            User u = (User) in.readObject();
            while (u != null) {
                users.add(u);
                u = (User) in.readObject();
            }
        } catch (EOFException e) {
            f.delete();
            try (FileOutputStream fis = new FileOutputStream(userFile);
                 ObjectOutputStream out = new ObjectOutputStream(fis)) {
                for (int i = 0; i < users.size(); i++) {
                    out.writeObject(users.get(i));
                }
                out.writeObject(user);
            } catch (Exception x) {
                x.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkUsername(String username) {
        File f = new File(userFile);
        if (!f.exists()) {
            return false;
        }
        try (FileInputStream fis = new FileInputStream(userFile);
             ObjectInputStream in = new ObjectInputStream(fis)) {
            User u = (User) in.readObject();
            while (u != null) {
                if (username.equals(u.getUsername())) {
                    return true;
                }
                u = (User) in.readObject();
            }
        } catch (EOFException e) {
            // end of file
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
        try (FileInputStream fis = new FileInputStream(userFile); ObjectInputStream in = new ObjectInputStream(fis)) {
            User u = (User) in.readObject();
            while (u != null) {
                if (u.equals(user)) {
                    return u;
                }
                u = (User) in.readObject();
            }
        } catch (EOFException e) {
            // end of file
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeUser(User newUser) {
        File f = new File(userFile);
        ArrayList<User> users = new ArrayList<User>();
        try (FileInputStream fis = new FileInputStream(userFile);
             ObjectInputStream in = new ObjectInputStream(fis)) {
            User u = (User) in.readObject();
            while (u != null) {
                if (u.equals(newUser)) {
                    users.add(newUser);
                }
                else {
                    users.add(u);
                }
                u = (User) in.readObject();
            }
        } catch (EOFException e) {
            f.delete();
            try (FileOutputStream fis = new FileOutputStream(userFile);
                 ObjectOutputStream out = new ObjectOutputStream(fis)) {
                for (int x = 0; x < users.size(); x++) {
                    out.writeObject(users.get(x));
                }
            } catch (Exception m) {
                m.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
