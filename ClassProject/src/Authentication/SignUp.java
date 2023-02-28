package Authentication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// we extend the JFrame so that we can use the JFrame properties like setSize, setText and others.....
public class SignUp extends JFrame{
    private JLabel JLFirstName;
    private JTextField TFFirstName;
    private JLabel JLLastName;
    private JTextField TFLastName;
    private JLabel JLSchoolName;
    private JButton JBSignUp;
    private JButton JBLogin;
    private JTextField TFRegistration;
    private JTextField TFPassword;
    private JLabel JLRegistration;
    private JLabel JLPassword;
    private JPanel JPSignUp;
    private JLabel JLCheck;
    private JTextField TFCheck;

    public SignUp(){
        // this will allow us to use the components inside the Icon.png form.
        // without it the form will not have any component we kept in the form.
        setContentPane(JPSignUp);

        // this will set the title of the GUI.
        setTitle("Sign Up");

        // this will set the size of the GUI.
        setSize(450, 300);

        // this will stop the program when the GUI is closed.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // this makes the current component visible.
        setVisible(true);

        // go to the button and press addActionListener. this will generate this code here.
        JBSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // this will get the text from the text field
                String FirstName = TFFirstName.getText();
                String LastName = TFLastName.getText();
                String Registration = TFRegistration.getText();
                String Password = TFPassword.getText();

                // this will change the text inside the component selected.
                JLCheck.setText("Welcome " + FirstName + " " + LastName);
            }
        });
        JBLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Login login = new Login();
                login.setVisible(true);
                setVisible(false);
                dispose();
            }
        });
    }
}
