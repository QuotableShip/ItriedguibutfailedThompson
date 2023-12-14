import javax.swing.*;
import javax.swing.table.TableColumn;


public class Class_Notes_Table extends JFrame {

    Class_Notes_Table() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setTitle("slay");
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        String[] columnNames = {"Student name", "Comment Tittel", "Comment"};

        Object[][] data = {{"Bob", "homework", "bob didnt do his home work today "}};

        JTable table = new JTable(data, columnNames);
        table.getTableHeader().setBounds(50, 30, 700, 20);
        table.setBounds(50, 50, 700, 200);


        this.add(table.getTableHeader());
        this.add(table);

        this.setVisible(true);

    }
}

