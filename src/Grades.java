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
public class Grades extends JFrame {
    private static JLabel studentname_label;
    private static JTextField studentname_text;
    private static JButton add_button; // Renamed from back_button
    private static JFrame Gframe;


    private static ArrayList<String> nameList; // Changed to ArrayList for storing student names

    public static void main(String[] args){
        JPanel Gpanel = new JPanel();
        Gframe = new JFrame();
        Gframe.setSize(300, 200);
        Gframe.setVisible(true);
        Gframe.add(Gpanel);

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



        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}