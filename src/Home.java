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
    private static JButton grades_button;
    private static JButton notes_button;
    private static JButton signout_button;

    private static JFrame frame;


    public Home() {
        JPanel home_panel = new JPanel();
        frame = new JFrame();
        frame.setSize(250,200);
        frame.setVisible(true);
        frame.add(home_panel);

        home_panel.setLayout(null);

        Atten_button = new JButton("Attendance");
        Atten_button.setBounds(50,30,100,25);
        home_panel.add(Atten_button);

        notes_button = new JButton("Notes");
        notes_button.setBounds(50,60,100,25);
        home_panel.add(notes_button);

        grades_button = new JButton("Grade notes");
        grades_button.setBounds(50,90,100,25);
        home_panel.add(grades_button);

        signout_button = new JButton("Signout");
        signout_button.setBounds(145,140,100,25);
        home_panel.add(signout_button);

        Atten_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Atten();
                dispose();
            }
        });

        notes_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)  {
                new Class_notes();
                setVisible(false);
                dispose();
            }
        });

        grades_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Grades();
                setVisible(false);
                dispose();
            }
        });

        signout_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
                setVisible(false);
                frame.dispose();
            }
        });
    }
}

