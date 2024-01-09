import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private static JLabel success;


    public static void main(String[] args){
        JPanel supanel = new JPanel();
        suframe = new JFrame();
        suframe.setSize(475,200);
        suframe.setVisible(true);
        suframe.add(supanel);
        suframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        supanel.setLayout(null);
        Color green = new Color(123, 171, 29);
        supanel.setBackground(green);

        su_title_label = new JLabel("Signup Page: ");
        su_title_label.setBounds(10,20,350,25);
        su_title_label.setFont(new Font("Serif", Font.BOLD, 13));
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

        success = new JLabel("");
        success.setBounds(90,140,300,25);
        supanel.add(success);

        suframe.setVisible(true);

        su_button.addActionListener(new Signup());

        }
        @Override
        public void actionPerformed(ActionEvent e) {
            String user = su_username_text.getText();
            String Password = su_Password_text.getText();
            if (user.equals("") && Password.equals("")){
                success.setText("!Something must be inputed!");
                System.out.print("no");
            } else {
                System.out.print("tes");
                suframe.dispose();
                new Login();
            }
        }
    }