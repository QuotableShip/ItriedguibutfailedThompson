import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
/**
 * @version (I AM AN ACADEMIC SLAY)
 */
public class Grades extends JFrame {
    private static JLabel label;
    private static JButton back_button;

    public Grades() {
        JPanel Gpanel = new JPanel();
        JFrame Gframe = new JFrame();
        Gframe.setSize(250,200);
        Gframe.setVisible(true);
        Gframe.add(Gpanel);

        Gpanel.setLayout(null);

        label = new JLabel("Class notes");
        label.setBounds(10,60,80,25);
        Gpanel.add(label);

        back_button = new JButton("Back");
        back_button.setBounds(155,140,70,25);
        Gpanel.add(back_button);

        back_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Home();
                setVisible(false);
                dispose();
            }
        });
    }
}



