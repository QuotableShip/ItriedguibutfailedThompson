import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
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
    private static JButton add_button; // Renamed from back_button
    private static JFrame SNframe;


    private static ArrayList<String> nameList; // Changed to ArrayList for storing student names

    public static void main(String[] args){
        JPanel Gpanel = new JPanel();
        SNframe = new JFrame();
        SNframe.setSize(300, 200);
        SNframe.setVisible(true);
        SNframe.add(Gpanel);

        Gpanel.setLayout(null);

        studentname_label = new JLabel("Student name:");
        studentname_label.setBounds(10, 60, 400, 25);
        Gpanel.add(studentname_label);

        studentname_text = new JTextField(10);
        studentname_text.setBounds(120, 60, 200, 25);
        Gpanel.add(studentname_text);

        add_button = new JButton("Add");
        add_button.setBounds(155, 140, 70, 25);
        Gpanel.add(add_button);

        nameList = new ArrayList<>();


        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = studentname_text.getText();
                nameList.add(name); // Add the student name to the list

                try {
                    FileOutputStream fos = new FileOutputStream("Student_names.txt");
                    OutputStreamWriter outwrite = new OutputStreamWriter(fos);
                    for (String n : nameList) {
                        outwrite.write(n + ","); // Write each name to the file
                    }
                    outwrite.flush();
                    outwrite.close();
                    fos.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}