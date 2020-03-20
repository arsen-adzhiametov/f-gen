import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FgenEngine implements ActionListener {

    Fgenerator parent;

    String series = null;
    String amount = null;

    FgenEngine(Fgenerator parent) {
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source instanceof JButton) {
            try {
                series = parent.field1.getText();
                amount = parent.field2.getText();
                if (series.isEmpty() || amount.isEmpty()||  isChar(amount) == true || series.length() > 5
                        || amount.length() > 5 || Integer.parseInt(amount) == 0) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "invalid value");
                    System.exit(0);
                }
                calculate();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        System.exit(0);
    }

    public boolean isChar(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (57 < Integer.valueOf(arr[i]) || Integer.valueOf(arr[i]) < 48) {
                return true;
            }
        }
        return false;
    }

    public void calculate() throws IOException {

        FileOutputStream fos = new FileOutputStream(series + ".txt");

        DataOutputStream outStream = new DataOutputStream(fos);

        for (int i = 1; i < Integer.parseInt(amount) + 1; i++) {
            String number = String.valueOf(i);

            while (number.length() < 4) {
                number = "0" + number;
            }
            outStream.writeBytes(series + "-" + number + "\n");
            outStream.flush();
        }
        outStream.close();
//        String[] cmd = {"cmd", "/C", "C:\\Users\\Kalpazan\\Dropbox\\Java\\IdeaProjects\\F-gen v2.0\\"+series+".txt"};
//        Runtime runtime = Runtime.getRuntime();
//        runtime.exec(cmd);
    }
}