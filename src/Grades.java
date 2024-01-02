import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

/**
 * @version (I AM AN ACADEMIC SLAY)
 */
public class Grades extends JFrame {
    private static JLabel studentname_label;
    private static JTextField studentname_text;
    private static JButton add_button;
    private static JButton back_button;
    private static JFrame Gframe;


    private static ArrayList<String> nameList; // Changed to ArrayList for storing student names

    public Grades(){
        JPanel Gpanel = new JPanel();
        Gframe = new JFrame();
        Gframe.setSize(300, 200);
        Gframe.setVisible(true);
        Gframe.add(Gpanel);

        Gpanel.setLayout(null);

        studentname_label = new JLabel("Student name:");
        studentname_label.setBounds(10, 60, 400, 25);
        Gpanel.add(studentname_label);

        back_button = new JButton("Back");
        back_button.setBounds(10, 120, 75, 25);
        back_button.setVisible(true);
        Gpanel.add(back_button);

        JComboBox<String> cb = new JComboBox<>();
        cb.setBounds(120, 60, 200, 25);
        Gpanel.add(cb);

        // Read student names from the file and add them to the JComboBox
        try (BufferedReader reader = new BufferedReader(new FileReader("Student_names.txt"))) {
            String line;
            nameList = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                nameList.add(line);
            }
            // Add the student names to the JComboBox
            for (String name : nameList) {
                cb.addItem(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        add_button = new JButton("Add");
        add_button.setBounds(155, 120, 70, 25);
        Gpanel.add(add_button);

        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        back_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Home();
                Gframe.setSize(340, 340);
                Gframe.dispose();
            }
        });
    }
}