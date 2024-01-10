import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
/**
 * @version (help meeeeeee)
 */
public class Home extends JFrame {
    private static JButton Atten_button;
    private static JButton Student_names_button;

    private static JButton grades_button;
    private static JButton notes_button;
    private static JButton signout_button;
    private static JButton vi_button;

    private static JFrame frame;

    public Home(){
        JPanel home_panel = new JPanel();
        frame = new JFrame();
        frame.setSize(250,290);
        frame.setVisible(true);
        frame.add(home_panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        home_panel.setLayout(null);

        Student_names_button = new JButton("Add a Student ");
        Student_names_button.setBounds(30,30,140,25);
        home_panel.add(Student_names_button);

        Atten_button = new JButton("Attendance");
        Atten_button.setBounds(50,70,100,25);
        home_panel.add(Atten_button);

        notes_button = new JButton("Notes");
        notes_button.setBounds(50,100,100,25);
        home_panel.add(notes_button);

        grades_button = new JButton("Grade");
        grades_button.setBounds(50,130,100,25);
        home_panel.add(grades_button);

        signout_button = new JButton("Signout");
        signout_button.setBounds(50,210,100,25);
        home_panel.add(signout_button);

        vi_button = new JButton("View student information");
        vi_button.setBounds(10,160,200,25);
        home_panel.add(vi_button);

        Student_names_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Student_names();
                frame.dispose();
            }
        });

        Atten_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Atten();
                frame.dispose();
            }
        });

        notes_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)  {
                new Class_notes();
                frame.dispose();
            }
        });

        grades_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Grades();
                frame.dispose();
            }
        });
        vi_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Viewinfo();
                frame.dispose();
            }
        });

        signout_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
                frame.dispose();
            }
        });
    }
}