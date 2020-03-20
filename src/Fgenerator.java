import javax.swing.*;
import java.awt.*;

public class Fgenerator {

    JPanel windowContent;
    JLabel label1;
    JTextField field1;
    JLabel label2;
    JTextField field2;
    JButton go;

    Fgenerator() {
        // Создаём панель
        windowContent = new JPanel();
        // Задаём менеджер отображения для этой панели
        FlowLayout f1 = new FlowLayout();
        windowContent.setLayout(f1);
        // Создаём компоненты в памяти
        label1 = new JLabel("Series:");
        field1 = new JTextField(5);
        label2 = new JLabel("Amount:");
        field2 = new JTextField(5);
        go = new JButton("Go!");
        // Добавляем компоненты на панель
        windowContent.add(label1);
        windowContent.add(field1);
        windowContent.add(label2);
        windowContent.add(field2);
        windowContent.add(go);
        // Создаём фрейм и задаём для него панель
        JFrame frame = new JFrame("F-gen v.2.0");
        frame.setContentPane(windowContent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // задаём и размер и делаем фрейм видимым
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        FgenEngine engine = new FgenEngine(this);
        go.addActionListener(engine);
    }

    public static void main(String[] args) {
        Fgenerator fgenerator = new Fgenerator();
    }
}