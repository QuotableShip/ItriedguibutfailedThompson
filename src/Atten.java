import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
/**
 * @version (another day, another slay)
 */
public class Atten extends JFrame{
    private static JLabel label;
    private static JButton back_button;
    public Atten() {
        JPanel Apanel = new JPanel();
        JFrame Aframe = new JFrame();
        Aframe.setSize(250,200);
        Aframe.setVisible(true);
        Aframe.add(Apanel);

        Apanel.setLayout(null);

        label = new JLabel("Attendance");
        label.setBounds(10,60,80,25);
        Apanel.add(label);

        back_button = new JButton("Back");
        back_button.setBounds(155,140,70,25);
        Apanel.add(back_button);

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
