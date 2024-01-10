import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;

    /**
     * @version (WHY! WHY! WHY!)
     */
    public class Grades extends JFrame {
        private static JLabel studentname_label;
        private static JLabel Glabel;
        private static JLabel Gtittle_label;
        private static JLabel Comment_label;
        private static JLabel grade_label;

        public static JTextField Gtittle_text;
        public static JTextField Comment_text;

        private static JButton add_button;
        private static JButton vgback_button;

        private static JButton view_button;
        private static JButton back_button;
        private static JFrame Gframe;
        private static ArrayList<String> nameList;

        public Grades() {
            JPanel Gpanel = new JPanel();
            Gframe = new JFrame();
            Gframe.setSize(350, 340);
            Gframe.setVisible(true);
            Gframe.add(Gpanel);

            Gpanel.setLayout(null);
            Color green = new Color(123, 171, 29);
            Gpanel.setBackground(green);

            Glabel = new JLabel("Grade Page: ");
            Glabel.setBounds(10, 20, 350, 25);
            Glabel.setFont(new Font("Serif", Font.BOLD, 13));
            Gpanel.add(Glabel);

            studentname_label = new JLabel("Student name:");
            studentname_label.setBounds(10, 60, 400, 25);
            Gpanel.add(studentname_label);

            JComboBox<String> Studentname = new JComboBox<>();
            Studentname.setBounds(120, 60, 200, 25);
            Gpanel.add(Studentname);

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

            Gtittle_label = new JLabel("Tittle:");
            Gtittle_label.setBounds(10, 110, 400, 25);
            Gpanel.add(Gtittle_label);

            Gtittle_text = new JTextField(10);
            Gtittle_text.setBounds(120, 110, 200, 25);
            Gpanel.add(Gtittle_text);

            grade_label = new JLabel("Grade:");
            grade_label.setBounds(10, 140, 200, 25);
            Gpanel.add(grade_label);

            JComboBox<Object> grade = new JComboBox<>();
            grade.setBounds(120, 140, 200, 25);
            Gpanel.add(grade);
            grade.addItem(1);
            grade.addItem(2);
            grade.addItem(3);
            grade.addItem(4);
            grade.addItem(5);
            grade.addItem(6);
            grade.addItem(7);

            Comment_label = new JLabel("Comment:");
            Comment_label.setBounds(10, 170, 200, 25);
            Gpanel.add(Comment_label);

            Comment_text = new JTextField(10);
            Comment_text.setBounds(120, 170, 200, 100);
            Gpanel.add(Comment_text);

            add_button = new JButton("Add");
            add_button.setBounds(180, 290, 75, 25);
            Gpanel.add(add_button);

            back_button = new JButton("Back");
            back_button.setBounds(10, 320, 75, 25);
            back_button.setVisible(true);
            Gpanel.add(back_button);

            view_button = new JButton("View Grades");
            view_button.setBounds(10, 290, 100, 25);
            view_button.setVisible(true);
            Gpanel.add(view_button);

            JPanel vgpanel = new JPanel();
            vgpanel.setLayout(null);
            vgpanel.setVisible(false);

            vgback_button = new JButton("Add another note");
            vgback_button.setBounds(560, 250, 180, 25);
            vgback_button.setVisible(true);
            vgpanel.add(vgback_button);

            String[] columnNames = {"Student name", "Grade", "Tittle", "Comment"};
            String[][] tableData = new String[10][4]; // Example: 10 rows initially
            JTable table = new JTable(tableData, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(50, 30, 700, 200);
            vgpanel.add(scrollPane);

            String filePath = "Grades.txt";
            ArrayList<String>[] tabledata = (ArrayList<String>[])new ArrayList[1];
            tabledata[0] = new ArrayList<>();

            add_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String tittle = Gtittle_text.getText();
                    String comment = Comment_text.getText();

                    int emptyRow = -1;
                    for (int row = 0; row < tableData.length; row++) {
                        if (tableData[row][0] == null) {
                            emptyRow = row;
                            break;
                        }
                    }
                    if (emptyRow != -1) {
                        tableData[emptyRow][0] = (String) Studentname.getSelectedItem();
                        tableData[emptyRow][1] = tittle;
                        tableData[emptyRow][2] = String.valueOf((int) grade.getSelectedItem());
                        tableData[emptyRow][3] = comment;
                        table.repaint();
                    } else {
                        System.out.println("Table is full!");
                    }
                    Gtittle_text.setText(" ");
                    Comment_text.setText(" ");

                    try (FileWriter writer = new FileWriter("Grades.txt", true)) {
                        writer.write((String) Studentname.getSelectedItem() + "," + grade.getSelectedItem() + "," + tittle + "," + comment + "\n");
                        System.out.println("Data has been appended to the file successfully.");
                    } catch (IOException ex) {
                        System.out.println("An error occurred while appending the data to the file: " + ex.getMessage());
                    }
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
            view_button.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    Gframe.add(vgpanel);
                    Gframe.setSize(880, 380);
                    vgpanel.setVisible(true);
                    Gpanel.setVisible(false);

                    // Clear the tableData before populating it with data from the file
                    for (String[] row : tableData) {
                        Arrays.fill(row, null);
                    }

                    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                        String line;
                        int row = 0;
                        while ((line = br.readLine()) != null && row < tableData.length) {
                            String[] values = line.split(",");
                            System.arraycopy(values, 0, tableData[row], 0, values.length);
                            row++;
                        }
                        // Repaint the table to reflect the updated data
                        table.repaint();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            vgback_button.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    Gpanel.setVisible(true);
                    vgpanel.setVisible(false);
                }
            });
        }
}