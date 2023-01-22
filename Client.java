import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.*;
import java.net.*;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
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
        String bs = "";
        String showerDur = "";
        String teeth = "";
        String washHands = "";
        String toilet = "";
        String clothes = "";
        String cook = "";
        String dd = "";
        String dishwash = "";
        String handwash = "";
        String yn = "";
        String ws = "";
        String watercan = "";
        String sprinkle = "";

        try {
            Socket socket = new Socket("localhost", 4242);
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            User user = null;
            String option = "";
            String message = "";

            try {
                GUIUtil.outGUI("Welcome to WaterLog!");
            } catch (Exception e) {
            }
            do {
                try {
                    String[] options = new String[2];
                    options[0] = "1. Login";
                    options[1] = "2. Create Account";
                    option = GUIUtil.choiceGUI("Select one of the following:", options);
                } catch (Exception e) {
                }

                writer.write(option);
                writer.println();
                writer.flush();

                if (option.equals("1")) {
                    String username = "";
                    String password = "";

                    do {
                        try {
                            username = GUIUtil.stringGUI("Enter your username.");
                        } catch (Exception e) {
                        }

                        if (username == null || username.contains(" ")) {
                            try {
                                GUIUtil.errorGUI("Invalid username.");
                            } catch (Exception e) {
                            }
                        } else {
                            writer.write(username);
                            writer.println();
                            writer.flush();
                        }
                    } while (username == null || username.contains(" "));

                    do {
                        try {
                            password = GUIUtil.stringGUI("Enter your password.");
                        } catch (Exception e) {
                        }
                        if (password == null || password.contains(" ")) {
                            try {
                                GUIUtil.errorGUI("Invalid password.");
                            } catch (Exception e) {
                            }
                        } else {
                            writer.write(password);
                            writer.println();
                            writer.flush();
                        }
                    } while (password == null || password.contains(" "));
                    message = reader.readLine();
                    try {
                        GUIUtil.outGUI(message);
                    } catch (Exception e) {
                    }

                } else if (option.equals("2")) {
                    String username = "";
                    String password = "";
                    String email = "";
                    String state = "";
                    String county = "";
                    boolean usernameExists;
                    boolean passwordChecker;
                    String emailSubstring = "";
                    String passwordCheck = "";

                    do {
                        try {
                            username = GUIUtil.stringGUI("Enter your username.");
                        } catch (Exception e) {
                        }
                        usernameExists = FileUtils.checkUsername(username);
                        if (username == null || username.contains(" ")) {
                            try {
                                GUIUtil.errorGUI("Invalid username.");
                            } catch (Exception e) {
                            }
                        } else if (usernameExists) {
                            try {
                                GUIUtil.errorGUI("Username taken.");
                            } catch (Exception e) {
                            }
                        } else {
                            writer.write(username);
                            writer.println();
                            writer.flush();
                        }
                    } while (username == null || username.contains(" ") || usernameExists);

                    do {
                        try {
                            password = GUIUtil.stringGUI("Enter your password. (At least 8 characters long and 1 number)");
                        } catch (Exception e) {
                        }
                        passwordChecker = false;
                        for (int i = 0; i < password.length(); i++) {
                            if (Character.isDigit(password.charAt(i))) {
                                passwordChecker = true;
                                break;
                            }
                        }
                        if (password == null ||
                                password.contains(" ") ||
                                !passwordChecker ||
                                (password.length() < 8)) {
                            try {
                                GUIUtil.errorGUI("Invalid password.");
                            } catch (Exception e) {
                            }
                        } else {
                            try {
                                passwordCheck = GUIUtil.stringGUI("Re-enter your password.");
                            } catch (Exception e) {
                            }
                            if (passwordCheck.equals(password)) {
                                Integer hash = password.hashCode();
                                writer.write(hash.toString());
                                writer.println();
                                writer.flush();
                            } else {
                                try {
                                    GUIUtil.errorGUI("Passwords do not match.");
                                } catch (Exception e) {
                                }
                            }
                        }
                    } while (password == null ||
                            password.contains(" ") ||
                            !passwordChecker ||
                            (password.length() < 8) ||
                            !passwordCheck.equals(password));
                    do {
                        try {
                            email = GUIUtil.stringGUI("Enter your email.");
                        } catch (Exception e) {
                        }
                        if (email.contains("@")) {
                            emailSubstring = email.substring(email.indexOf("@"));
                        }
                        if (email == null ||
                                email.contains(" ") ||
                                !email.contains("@") ||
                                !emailSubstring.contains(".")) {
                            try {
                                GUIUtil.errorGUI("Invalid email.");
                            } catch (Exception e) {
                            }
                        } else {
                            writer.write(email);
                            writer.println();
                            writer.flush();
                        }
                    } while (email == null ||
                            email.contains(" ") ||
                            !email.contains("@") ||
                            !emailSubstring.contains("."));

                    String[] abbrev = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA",
                            "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
                            "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
                            "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
                            "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
                    try {
                        String s = GUIUtil.choiceGUI("Choose your state abbreviated. (ex: Alabama = AL)", abbrev);
                        state = abbrev[Integer.parseInt(s) - 1];
                    } catch (Exception e) {
                    }
                    writer.write(state);
                    writer.println();
                    writer.flush();

                    do {
                        try {
                            county = GUIUtil.stringGUI("Enter the name of the county you live in. (ex: San Francisco)");
                        } catch (Exception e) {
                        }
                        if (county == null) {
                            try {
                                GUIUtil.errorGUI("Invalid county.");
                            } catch (Exception e) {
                            }
                        } else {
                            writer.write(county);
                            writer.println();
                            writer.flush();
                        }
                    } while (county == null);

                } else {
                    try {
                        GUIUtil.errorGUI("Error. Please try again.");
                    } catch (Exception e) {
                    }
                }
            } while (!option.equals("1") && !option.equals("2") || message.contains("Invalid"));


            do {
                try {
                    String[] options = {"1. Water Consumption Quiz", "2. Quit"};
                    option = GUIUtil.choiceGUI("What would you like to do?", options);
                } catch (Exception e) {
                }
                writer.write(option);
                writer.println();
                writer.flush();
                if (option.equals("1")) {
                    do {
                        try {
                            String[] options = {"1. Bath", "2. Shower"};
                            bs = GUIUtil.choiceGUI("Do you take a bath or a shower regularly?", options);
                        } catch (Exception e) {
                        }
                        writer.write(bs);
                        writer.println();
                        writer.flush();

                        if (bs.equals("1")) {
                            bath = true;
                            shower = false;
                            writer.write(String.valueOf(bath));
                            writer.write(String.valueOf(shower));
                            writer.println();
                            writer.flush();
                        } else if (bs.equals("2")) {
                            bath = false;
                            shower = true;
                            writer.write(String.valueOf(bath));
                            writer.write(String.valueOf(shower));
                            writer.println();
                            writer.flush();
                            do {
                                try {
                                    String[] options = {"1. 0-10 minutes", "2. 11-20 minutes", "3. 21+ minutes"};
                                    showerDur = GUIUtil.choiceGUI("How long do you shower per day?", options);
                                } catch (Exception e) {
                                }
                                writer.write(showerDur);
                                writer.println();
                                writer.flush();
                            } while (!showerDur.equals("1") && !showerDur.equals("2") && !showerDur.equals("3"));
                        }
                    } while (!bs.equals("1") && !bs.equals("2"));
                    do {
                        try {
                            String[] options = {"1. 1 time", "2. 2 times", "3. 3+ times"};
                            teeth = GUIUtil.choiceGUI("How often do you brush your teeth in a day?", options);
                        } catch (Exception e) {
                        }
                        writer.write(teeth);
                        writer.println();
                        writer.flush();
                    } while (!teeth.equals("1") && !teeth.equals("2") && !teeth.equals("3"));
                    do {
                        try {
                            String[] options = {"1. 0-2 times", "2. 3-6 times", "3. 7+ times"};
                            toilet = GUIUtil.choiceGUI("How many times do you use the toilet in a day?", options);
                        } catch (Exception e) {
                        }
                        writer.write(toilet);
                        writer.println();
                        writer.flush();
                    } while (!toilet.equals("1") && !toilet.equals("2") && !toilet.equals("3"));
                    do {
                        try {
                            String[] options = {"1. 0-4 times", "2. 5-10 times", "3. 11+ times"};
                            washHands = GUIUtil.choiceGUI("How often do you wash your hands in a day?", options);
                        } catch (Exception e) {
                        }
                        writer.write(washHands);
                        writer.println();
                        writer.flush();
                    } while (!washHands.equals("1") && !washHands.equals("2") && !washHands.equals("3"));
                    do {
                        try {
                            String[] options = {"1. 0-1 times", "2. 2-4 times", "3. 5+ times"};
                            clothes = GUIUtil.choiceGUI("How often do you use the washing machine per week?", options);
                        } catch (Exception e) {
                        }
                        writer.write(clothes);
                        writer.println();
                        writer.flush();
                    } while (!clothes.equals("1") && !clothes.equals("2") && !clothes.equals("3"));
                    do {
                        try {
                            String[] options = {"1. 0-4 times", "2. 5-10 times", "3. 11+ times"};
                            cook = GUIUtil.choiceGUI("How often do you cook per week?", options);
                        } catch (Exception e) {
                        }
                        writer.write(cook);
                        writer.println();
                        writer.flush();
                    } while (!cook.equals("1") && !cook.equals("2") && !cook.equals("3"));
                    do {
                        try {
                            String[] options = {"1. Dishwasher", "2. By hand"};
                            dd = GUIUtil.choiceGUI("Do you use a dishwasher or wash dishes by hand regularly?", options);
                        } catch (Exception e) {
                        }
                        writer.write(dd);
                        writer.println();
                        writer.flush();
                        if (dd.equals("1")) {
                            dishwasher = true;
                            hand = false;
                            do {
                                try {
                                    String[] options = {"1. 0-4 times", "2. 5-10 times", "11+ times"};
                                    dishwash = GUIUtil.choiceGUI("How often do you use the dishwasher in a week?", options);
                                } catch (Exception e) {
                                }
                                writer.write(dishwash);
                                writer.println();
                                writer.flush();
                            } while (!dishwash.equals("1") && !dishwash.equals("2") && !dishwash.equals("3"));
                        } else if (dd.equals("2")) {
                            dishwasher = false;
                            hand = true;
                            writer.write(String.valueOf(dishwasher));
                            writer.write(String.valueOf(hand));
                            writer.println();
                            writer.flush();
                            do {
                                try {
                                    String[] options = {"1. 0-4 times", "2. 5-10 times", "11+ times"};
                                    handwash = GUIUtil.choiceGUI("How often do you wash dishes by hand in a week?", options);
                                } catch (Exception e) {
                                }
                                writer.write(handwash);
                                writer.println();
                                writer.flush();
                            } while (!handwash.equals("1") && !handwash.equals("2") && !handwash.equals("3"));
                        }
                    } while (!dd.equals("1") && !dd.equals("2"));
                    do {
                        try {
                            String[] options = {"1. Yes", "2. No"};
                            yn = GUIUtil.choiceGUI("Do you water plants regularly?", options);
                        } catch (Exception e) {
                        }
                        writer.write(yn);
                        writer.println();
                        writer.flush();
                        if (yn.equals("1")) {
                            do {
                                try {
                                    String[] options = {"1. Hand/Watering Can", "2. Sprinklers"};
                                    ws = GUIUtil.choiceGUI("Do you water by hand/watering can or sprinklers?", options);
                                } catch (Exception e) {
                                }
                                writer.write(ws);
                                writer.println();
                                writer.flush();
                                if (ws.equals("1")) {
                                    can = true;
                                    sprinklers = false;
                                    writer.write(String.valueOf(can));
                                    writer.write(String.valueOf(sprinklers));
                                    writer.println();
                                    writer.flush();
                                    do {
                                        try {
                                            String[] options = {"1. 0-2 times", "2. 3-5 times", "3. 6+ times"};
                                            watercan = GUIUtil.choiceGUI("How often do you water your plants by hand/watering can in a week?", options);
                                        } catch (Exception e) {
                                        }
                                        writer.write(watercan);
                                        writer.println();
                                        writer.flush();
                                    } while (!watercan.equals("1") && !watercan.equals("2") && !watercan.equals("3"));
                                } else if (ws.equals("2")) {
                                    can = false;
                                    sprinklers = true;
                                    writer.write(String.valueOf(can));
                                    writer.write(String.valueOf(sprinklers));
                                    writer.println();
                                    writer.flush();
                                    do {
                                        try {
                                            String[] options = {"1. 0-2 times", "2. 3-5 times", "3. 6+ times"};
                                            sprinkle = GUIUtil.choiceGUI("How often do you water your plants by sprinklers in a week?", options);
                                        } catch (Exception e) {
                                        }
                                        writer.write(sprinkle);
                                        writer.println();
                                        writer.flush();
                                    } while (!sprinkle.equals("1") && !sprinkle.equals("2") && !sprinkle.equals("3"));
                                }
                            } while (!ws.equals("1") && !ws.equals("2"));
                        }
                    } while (!yn.equals("1") && !yn.equals("2"));
                    // print info about water usage

                    String comparison = "";
                    for (int i = 0; i < 4; i++) {
                        comparison += reader.readLine() + "\n";
                    }
                    GUIUtil.outGUI(comparison);
                    GUIUtil.closingMessage();
                } else if (option.equals("2")) {
                    GUIUtil.closingMessage();
                }
            } while (!option.equals("1") && !option.equals("2"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}