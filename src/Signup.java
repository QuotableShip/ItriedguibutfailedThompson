

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
/**
 * @version (shoot meeee)
 */
public class Signup implements ActionListener {
    private static JLabel su_username_label;
    public static JTextField su_username_text;
    private static JLabel su_password_label;
    public static JTextField su_Password_text;
    private static JButton su_button;
    private static JLabel su_title_label;
    private static JFrame suframe;



    public static void main(String[] args){
        JPanel supanel = new JPanel();
        suframe = new JFrame();
        suframe.setSize(450,200);
        suframe.setVisible(true);
        suframe.add(supanel);
        suframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        supanel.setLayout(null);
        Color green = new Color(119,141,34);
        supanel.setBackground(green);

        su_title_label = new JLabel("Signup Page: ");
        su_title_label.setBounds(10,20,350,25);
        supanel.add(su_title_label);

        su_username_label = new JLabel("What would you like your username to be?");
        su_username_label.setBounds(10,60,350,25);
        supanel.add(su_username_label);

        su_username_text = new JTextField(10);
        su_username_text.setBounds(300,60,165, 25);
        supanel.add(su_username_text);

        su_password_label = new JLabel("What would you like your password to be?");
        su_password_label.setBounds(10,100,350,25);
        supanel.add(su_password_label);

        su_Password_text = new JTextField(10);
        su_Password_text.setBounds(300,100,165, 25);
        supanel.add(su_Password_text);

        su_button = new JButton("login");
        su_button.setBounds(5,140,80,25);
        supanel.add(su_button);

        suframe.setVisible(true);

        su_button.addActionListener(new Signup());

        }
        @Override
        public void actionPerformed(ActionEvent e) {
            suframe.dispose();
            new Login();
        }
    }