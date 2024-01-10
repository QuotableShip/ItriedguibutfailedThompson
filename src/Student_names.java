import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
/**
 * @version (I AM AN ACADEMIC SLAY)
 */
public class Student_names extends JFrame {
    private static JLabel studentname_label;
    private static JTextField studentname_text;
    private static JButton add_button;
    private static JButton back_button;

    private static JFrame SNframe;


    private static ArrayList<String> nameList; // Changed to ArrayList for storing student names

    public Student_names(){
        JPanel SNpanel = new JPanel();
        SNframe = new JFrame();
        SNframe.setSize(330, 200);
        SNframe.setVisible(true);
        SNframe.add(SNpanel);

        SNpanel.setLayout(null);
        Color green = new Color(123, 171, 29);
        SNpanel.setBackground(green);

        studentname_label = new JLabel("Student name:");
        studentname_label.setBounds(10, 60, 400, 25);
        studentname_label.setFont(new Font("Serif", Font.BOLD, 14));
        SNpanel.add(studentname_label);

        studentname_text = new JTextField(10);
        studentname_text.setBounds(120, 60, 200, 25);
        SNpanel.add(studentname_text);

        add_button = new JButton("Add");
        add_button.setBounds(155, 120, 70, 25);
        SNpanel.add(add_button);

        back_button = new JButton("Back");
        back_button.setBounds(10, 120, 75, 25);
        back_button.setVisible(true);
        SNpanel.add(back_button);

        nameList = new ArrayList<>();

        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = studentname_text.getText();
                nameList.add(name); // Add the student name to the list
                try {
                    FileWriter fw = new FileWriter("Student_names.txt", true); // true for append mode
                    for (String n : nameList) {
                        fw.write(n + ","); // Write each name to the file
                    }
                    fw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                studentname_text.setText(" ");
            }
        });
        back_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Home();
                SNframe.setSize(340, 340);
                SNframe.dispose();
            }
        });
    }
}