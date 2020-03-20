import javax.swing.*;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args) throws Exception {

        String series = JOptionPane.showInputDialog("Please, enter series, for example F1234");
        JFormattedTextField s = new JFormattedTextField(new SimpleFormatter());

        String amount = JOptionPane.showInputDialog("How many numbers to generate?");
        if (amount.length()>4){
            System.exit(0);
        }

        FileOutputStream fos = new FileOutputStream(series + ".txt");
        DataOutputStream outStream = new DataOutputStream(fos);

        for (int i = 1; i < Integer.parseInt(amount) + 1; i++) {
            String number = String.valueOf(i);

            while (number.length() != 4) {
                number = "0" + number;
            }
            outStream.writeBytes(series + "-" + number + "\n");
            outStream.flush();
        }

        outStream.close();
    }
}
