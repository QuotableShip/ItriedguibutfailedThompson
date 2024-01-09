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
 * @version (aggggggggggggg)
 */
public  class Login extends JFrame  {
    private static JLabel username_label;
    private static JTextField username_text;
    private static JLabel password_label;
    private static JPasswordField Password_text;
    private static JButton button;
    private static JLabel success;
    private static JLabel title_label;
    private static JFrame frame;

    public Login(){
        JPanel panel = new JPanel();
        frame = new JFrame();
        frame.setSize(300,200);
        frame.setVisible(true);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel.setLayout(null);
        Color green = new Color(123, 171, 29);
        panel.setBackground(green);

        title_label = new JLabel("Login Page: ");
        title_label.setBounds(10,20,350,25);
        title_label.setFont(new Font("Serif", Font.BOLD, 13));

        panel.add(title_label);

        username_label = new JLabel("Username:");
        username_label.setBounds(10,40,80,25);
        panel.add(username_label);

        username_text = new JTextField(10);
        username_text.setBounds(100,40,165, 25);
        panel.add(username_text);

        password_label = new JLabel("Password:");
        password_label.setBounds(10,80,80,25);
        panel.add(password_label);

        Password_text = new JPasswordField(10);
        Password_text.setBounds(100,80, 165, 25);
        panel.add(Password_text);

        button = new JButton("login");
        button.setBounds(100,120,80,25);
        panel.add(button);

        success = new JLabel("");
        success.setBounds(10,150,300,25);
        panel.add(success);


        frame.setVisible(true);

        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String su_user = Signup.su_username_text.getText();
                String su_Password = Signup.su_Password_text.getText();

                String user = username_text.getText();
                String Password = Password_text.getText();

                if(user.equals(su_user) && Password.equals(su_Password)){
                    success.setText("Login success!");
                    new Home();
                    setVisible(false);
                    frame.dispose();
                }else{
                    success.setText("Login not successfull");
                }
         }
        });
    }
}