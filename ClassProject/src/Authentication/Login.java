package Authentication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    public JPanel JPLogin;
    private JLabel JLSchoolName;
    private JLabel JLCheck;
    private JTextField TFRegistration;
    private JTextField TFPassword;
    private JButton JBLogin;
    private JButton JBSignUp;
    private JLabel JLRegistration;
    private JLabel JLPassword;

    public Login(){
        setContentPane(JPLogin);
        setTitle("Login");
        setSize(450, 320);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        JBLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String Registration = TFRegistration.getText();
                String Password = TFPassword.getText();

            }
        });
        JBSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }
}
