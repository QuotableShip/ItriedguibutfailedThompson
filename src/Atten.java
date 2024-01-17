import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @version (another day, another slay)
 */
public class Atten extends JFrame {
    private static JLabel alabel;

    private static JLabel label;
    private static JButton back_button;
    private static JLabel date_label;
    public static JTextField date_text;
    private static JLabel studentname_label;
    public static JTextField studentname_text;
    private static JLabel status_label;
    public static JTextField status_text;
    private static JButton add_button;
    private static JButton view_button;
    private static JButton vaback_button;

    private javax.swing.JTable atable;
    private static JFrame aframe;
    private static JComboBox statusbox;
    private static ArrayList<String> nameList;

    public Atten() {
        JPanel apanel = new JPanel();
        aframe = new JFrame();
        aframe.setSize(500, 340);
        aframe.setVisible(true);
        aframe.add(apanel);

        apanel.setLayout(null);
        Color green = new Color(123, 171, 29);
        apanel.setBackground(green);

        alabel = new JLabel("Attendance Page: ");
        alabel.setBounds(10, 20, 350, 25);
        alabel.setFont(new Font("Serif", Font.BOLD, 13));
        apanel.add(alabel);

        date_label = new JLabel("Date:");
        date_label.setBounds(10, 60, 200, 25);
        apanel.add(date_label);

        date_text = new JTextField(10);
        date_text.setBounds(140, 60, 200, 25);
        apanel.add(date_text);

        studentname_label = new JLabel("Student name:");
        studentname_label.setBounds(10, 90, 400, 25);
        apanel.add(studentname_label);

        JComboBox<String> Studentname = new JComboBox<>();
        Studentname.setBounds(140, 90, 200, 25);
        apanel.add(Studentname);

        try (BufferedReader reader = new BufferedReader(new FileReader("Student_names.txt"))) {
            String line;
            nameList = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] splitNames = line.split(",");
                nameList.addAll(Arrays.asList(splitNames));
            }
            // Add the student names to the JComboBox
            for (String name : nameList) {
                Studentname.addItem(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        status_label = new JLabel("Status:");
        status_label.setBounds(10, 120, 1000, 25);
        apanel.add(status_label);

        statusbox = new JComboBox<>();
        statusbox.setBounds(140, 120, 200, 25);
        apanel.add(statusbox);
        statusbox.addItem("Present");
        statusbox.addItem("N/A");
        statusbox.addItem("Late");


        add_button = new JButton("Add");
        add_button.setBounds(200, 170, 75, 25);
        add_button.setVisible(true);
        apanel.add(add_button);

        view_button = new JButton("View Attendance");
        view_button.setBounds(10, 170, 150, 25);
        view_button.setVisible(true);
        apanel.add(view_button);

        back_button = new JButton("Back");
        back_button.setBounds(10, 200, 75, 25);
        back_button.setVisible(true);
        apanel.add(back_button);


        JPanel vapanel = new JPanel();
        vapanel.setLayout(null);
        vapanel.setVisible(false);

        vaback_button = new JButton("Add another note");
        vaback_button.setBounds(560, 250, 180, 25);
        vaback_button.setVisible(true);
        vapanel.add(vaback_button);

        String[] columnNames = {"Date", "Status ", "Student Name"};
        String[][] tableData = new String[10][3];

        final JTable[] table = {new JTable(tableData, columnNames)};
        JScrollPane scrollPane = new JScrollPane(table[0]);

        vapanel.add(scrollPane);
        scrollPane.setBounds(50,30,700,200);

        String filePath = "Atten.txt";
        ArrayList<String>[] tabledata = (ArrayList<String>[])new ArrayList[1];
        tabledata[0] = new ArrayList<>();


        back_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Home();
                aframe.setSize(340, 340);
                aframe.dispose();
            }
        });

        view_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                aframe.add(vapanel);
                aframe.setSize(880, 380);
                vapanel.setVisible(true);
                apanel.setVisible(false);

                try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    int row = 0;
                    while ((line = br.readLine()) != null && row < tableData.length) {
                        String[] values = line.split(",");
                        tableData[row][0] = values[0];
                        tableData[row][1] = values[1];
                        tableData[row][2] = values[2];
                        row++;
                    }
                    table[0].repaint();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        add_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String date = date_text.getText();
                String studentName = (String) Studentname.getSelectedItem();
                String status = (String) statusbox.getSelectedItem();

                int emptyRow = -1;
                for (int row = 0; row < tableData.length; row++) {
                    if (tableData[row][0] == null) {
                        emptyRow = row;
                        break;
                    }
                }
                if (emptyRow != -1) {
                    tableData[emptyRow][0] = date;
                    tableData[emptyRow][1] = status;
                    tableData[emptyRow][2] = studentName;
                    table[0].repaint();
                } else {
                    System.out.println("Table is full!");
                }
                date_text.setText(" ");

                try (FileWriter writer = new FileWriter("Atten.txt", true)) {
                    writer.write(studentName + "," + status + "," + date + "\n");
                    System.out.println("Data has been appended to the file successfully.");
                } catch (IOException ex) {
                    System.out.println("An error occurred while appending the data to the file: " + ex.getMessage());
                }
            }
        });

        vaback_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                apanel.setVisible(true);
                vapanel.setVisible(false);
            }
        });
    }
}
