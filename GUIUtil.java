import javax.swing.*;

public class GUIUtil {
    public static final String TITLE = "WaterLog";
    public static final String ERROR = "Invalid Input!";

    public static void errorGUI(String error) {
        JOptionPane.showMessageDialog(null, error, TITLE, JOptionPane.ERROR_MESSAGE);
    }

    public static void outGUI(String message) {
        JOptionPane.showMessageDialog(null, message, TITLE, JOptionPane.INFORMATION_MESSAGE);
    }

    public static String stringGUI(String s) {
        String name;
        do {
            name = JOptionPane.showInputDialog(null, s, TITLE, JOptionPane.QUESTION_MESSAGE);
            if ((name == null) || (name.isEmpty())) {
                errorGUI(ERROR);
            }

        } while ((name == null) || (name.isEmpty()));

        return name;
    }

    public static String intGUI(String s) {
        int reply = 100;
        do {
            reply = JOptionPane.showConfirmDialog(null, s, TITLE, JOptionPane.YES_NO_OPTION);
            if (reply == 100) {
                errorGUI(ERROR);
            }
        } while (reply == 100);

        if (reply == JOptionPane.YES_OPTION) return "yes";
        else if (reply == JOptionPane.NO_OPTION) return "no";
        else return "-1";
    }

    public static String choiceGUI(String question, String[] options) {
        String ans;
        do {
            ans = (String) JOptionPane.showInputDialog(null, question, TITLE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (ans == null) {
                JOptionPane.showMessageDialog(null, "Choice cannot be empty!", TITLE, JOptionPane.ERROR_MESSAGE);

            }

        } while (ans == null);

        for (int i = 0; i < options.length; i++) {
            if (ans.equals(options[i])) return Integer.toString(i + 1);
        }
        return "-1";
    }

    public static void closingMessage() {
        JOptionPane.showMessageDialog(null, "Thank you for using WaterLog!", "Goodbye!", JOptionPane.INFORMATION_MESSAGE);
    }

}
