import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * @version (another day, another slay)
 */
public class Atten extends JFrame {
    private static JLabel alabel;

    private static JLabel label;
    private static JButton back_button;
    private static JLabel studentname_label;
    public static JTextField studentname_text;
    private static JLabel status_label;
    public static JTextField status_text;
    private static JButton add_button;
    private static JButton view_button;
    private static JButton vaback_button;

    private javax.swing.JTable atable;

    private static JFrame aframe;


    public Atten() {
        JPanel apanel = new JPanel();
        aframe = new JFrame();
        aframe.setSize(340, 340);
        aframe.setVisible(true);
        aframe.add(apanel);

        apanel.setLayout(null);

        alabel = new JLabel("Notes Page: ");
        alabel.setBounds(10, 20, 350, 25);
        apanel.add(alabel);

        studentname_label = new JLabel("Student name:");
        studentname_label.setBounds(10, 60, 400, 25);
        apanel.add(studentname_label);

        studentname_text = new JTextField(10);
        studentname_text.setBounds(120, 60, 200, 25);
        apanel.add(studentname_text);

        status_label = new JLabel("Status (P = Present, A = Absent, N/A):");
        status_label.setBounds(10, 110, 400, 25);
        apanel.add(status_label);

        status_text = new JTextField(10);
        status_text.setBounds(120, 110, 200, 25);
        apanel.add(status_text);

        add_button = new JButton("Add");
        add_button.setBounds(180, 245, 75, 25);
        add_button.setVisible(true);
        apanel.add(add_button);

        view_button = new JButton("View notes");
        view_button.setBounds(10, 245, 100, 25);
        view_button.setVisible(true);
        apanel.add(view_button);

        back_button = new JButton("Back");
        back_button.setBounds(10, 275, 75, 25);
        back_button.setVisible(true);
        apanel.add(back_button);

        JPanel vapanel = new JPanel();
        vapanel.setLayout(null);
        vapanel.setVisible(false);

        vaback_button = new JButton("Add another note");
        vaback_button.setBounds(560, 250, 180, 25);
        vaback_button.setVisible(true);
        vapanel.add(vaback_button);

        String[] columnNames = {"Student name", "Comment Title", "Comment"};
        String[][] tableData = new String[10][3]; // Example: 10 rows initially
        JTable table = new JTable(tableData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        vapanel.add(scrollPane);
        scrollPane.setBounds(50,30,700,200);

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
            }
        });

        add_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentName = studentname_text.getText();
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
                    tableData[emptyRow][0] = studentName;
                    tableData[emptyRow][1] = commentTitle;
                    tableData[emptyRow][2] = comment;

                    table.repaint();
                } else {
                    System.out.println("Table is full!");
                }

                studentname_text.setText(" ");
                ctittle_text.setText(" ");
                Comment_text.setText(" ");
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
