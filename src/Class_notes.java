import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @version (This is going to be the death of moi)
 */
public class Class_notes extends JFrame {
    private static JLabel nlabel;

    private static JLabel label;
    private static JLabel studentname_label;
    private static JButton back_button;

    public static JTextField studentname_text;
    private static JLabel ctittle_label;
    public static JTextField ctittle_text;
    private static JLabel Comment_label;
    public static JTextField Comment_text;
    private static JButton add_button;
    private static JButton view_button;
    private static JButton vnback_button;

    private javax.swing.JTable table;
    private static JFrame nframe;
    private static ArrayList<String> nameList;



    public Class_notes() {
        JPanel npanel = new JPanel();
        nframe = new JFrame();
        nframe.setSize(340, 340);
        nframe.setVisible(true);
        nframe.add(npanel);

        npanel.setLayout(null);
        Color green = new Color(123, 171, 29);
        npanel.setBackground(green);

        nlabel = new JLabel("Notes Page: ");
        nlabel.setBounds(10, 20, 350, 25);
        nlabel.setFont(new Font("Serif", Font.BOLD, 13));
        npanel.add(nlabel);

        studentname_label = new JLabel("Student name:");
        studentname_label.setBounds(10, 60, 400, 25);
        npanel.add(studentname_label);

        JComboBox<String> Studentname = new JComboBox<>();
        Studentname.setBounds(120, 60, 200, 25);
        npanel.add(Studentname);

        try (BufferedReader reader = new BufferedReader(new FileReader("Student_names.txt"))) {
            String line;
            nameList = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] splitNames = line.split(",");
                nameList.addAll(Arrays.asList(splitNames));
            }
            for (String name : nameList) {
                Studentname.addItem(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ctittle_label = new JLabel("Tittle:");
        ctittle_label.setBounds(10, 110, 400, 25);
        npanel.add(ctittle_label);

        ctittle_text = new JTextField(10);
        ctittle_text.setBounds(120, 110, 200, 25);
        npanel.add(ctittle_text);

        Comment_label = new JLabel("Comment:");
        Comment_label.setBounds(10, 140, 200, 25);
        npanel.add(Comment_label);

        Comment_text = new JTextField(10);
        Comment_text.setBounds(120, 140, 200, 100);
        npanel.add(Comment_text);

        add_button = new JButton("Add");
        add_button.setBounds(180, 245, 75, 25);
        add_button.setVisible(true);
        npanel.add(add_button);

        view_button = new JButton("View notes");
        view_button.setBounds(10, 245, 100, 25);
        view_button.setVisible(true);
        npanel.add(view_button);

        back_button = new JButton("Back");
        back_button.setBounds(10, 275, 75, 25);
        back_button.setVisible(true);
        npanel.add(back_button);

        JPanel vnpanel = new JPanel();
        vnpanel.setLayout(null);
        vnpanel.setVisible(false);

        vnback_button = new JButton("Add another note");
        vnback_button.setBounds(560, 250, 180, 25);
        vnback_button.setVisible(true);
        vnpanel.add(vnback_button);

        String[] columnNames = {"Student name", "Comment Title", "Comment"};
        String[][] tableData = new String[10][3]; // Example: 10 rows initially

        final JTable[] table = {new JTable(tableData, columnNames)};
        JScrollPane scrollPane = new JScrollPane(table[0]);

        vnpanel.add(scrollPane);
        scrollPane.setBounds(50,30,700,200);

        String filePath = "cn.txt";
        ArrayList<String>[] tabledata = (ArrayList<String>[])new ArrayList[1];
        tabledata[0] = new ArrayList<>();

        back_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Home();
                nframe.setSize(340, 340);
                nframe.dispose();
            }
        });

        view_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                nframe.add(vnpanel);
                nframe.setSize(880, 380);
                vnpanel.setVisible(true);
                npanel.setVisible(false);

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
                String commentTitle = ctittle_text.getText();
                String comment = Comment_text.getText();

                // Find the first empty row in the table
                int emptyRow = -1;
                for (int row = 0; row < tableData.length; row++) {
                    if (tableData[row][0] == null) {
                        emptyRow = row;
                        break;
                    }
                }
                if (emptyRow != -1) {
                    tableData[emptyRow][0] = (String) Studentname.getSelectedItem();
                    tableData[emptyRow][1] = commentTitle;
                    tableData[emptyRow][2] = comment;

                    table[0].repaint();

                } else {
                    System.out.println("Table is full!");
                }
                try (FileWriter writer = new FileWriter("cn.txt", true)) {
                    writer.write((String) Studentname.getSelectedItem() + "," + commentTitle + "," + comment + "\n");
                    System.out.println("Data has been appended to the file successfully.");
                } catch (IOException ex) {
                    System.out.println("An error occurred while appending the data to the file: " + ex.getMessage());
                }
                ctittle_text.setText(" ");
                Comment_text.setText(" ");
            }
        });

        vnback_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                npanel.setVisible(true);
                vnpanel.setVisible(false);

            }
        });
    }
}



