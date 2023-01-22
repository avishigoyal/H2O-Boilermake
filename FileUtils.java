import java.io.*;
import java.util.ArrayList;

public class FileUtils {

    private static final String userFile = "users.txt";
    private static final String droughtFile = "us-droughts.csv";

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

    public static String CSVDroughtStats(User user) {
        File f = new File(droughtFile);
        try (BufferedReader bfr = new BufferedReader(new FileReader(droughtFile))) {
            double d0avg = 0;
            double d1avg = 0;
            double d2avg = 0;
            double d3avg = 0;
            double d4avg = 0;
            int size = 0;
            String droughtConditions = "";
            while (true) {
                String line = bfr.readLine();
                if (line == null) {
                    break;
                }
                String[] elements = line.split(",");
                if (elements[0].contains("2016") &&
                        elements[3].toUpperCase().contains(user.getState().toUpperCase()) &&
                        elements[2].toLowerCase().contains(user.getCounty().toLowerCase())) {
                    size++;
                    d0avg += Double.parseDouble(elements[5]);
                    d1avg += Double.parseDouble(elements[6]);
                    d2avg += Double.parseDouble(elements[7]);
                    d3avg += Double.parseDouble(elements[8]);
                    d4avg += Double.parseDouble(elements[9]);
                }
            }
            d0avg = d0avg/size;
            d1avg = d1avg/size;
            d2avg = d2avg/size;
            d3avg = d3avg/size;
            d4avg = d4avg/size;
            if (d4avg > 0.0) {
                droughtConditions = "D4 - Exceptional Drought";
            } else if (d3avg > 0.0) {
                droughtConditions = "D3 - Extreme Drought";
            } else if (d2avg > 0.0) {
                droughtConditions = "D2 - Severe Drought";
            } else if (d1avg > 0.0) {
                droughtConditions = "D1 - Moderate Drought";
            } else if (d0avg > 0.0) {
                droughtConditions = "D0 - Abnormally Dry Conditions";
            } else {
                droughtConditions = "Not in Drought";
            }
            return droughtConditions;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}