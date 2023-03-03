import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import static java.lang.Integer.parseInt;

public class Login extends JFrame {
    private String Password;
    private String Registration;
    private JPanel JPLogin;
    private JTextField TFRegistration;
    private JTextField TFPassword;
    private JButton JBLogin;
    private JLabel JLPassword;
    private JLabel JLRegistration;
    private JLabel JLCheck;
    private JLabel JLSchoolName;
    private JLabel Checked;

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
                Database dat = new Database();
                dat.getData("LoginDetails");
                for(int i = 0; i < dat.ValueDatabase.size(); i += 3){
                    int id = parseInt(dat.ValueDatabase.get(i));
                    String CurrentPassword = dat.ValueDatabase.get(i+2);
                    String CurrentRegistration= dat.ValueDatabase.get(i+1);
                    if(Objects.equals(Registration, CurrentRegistration)){
                        Checked.setText("");
                        if(Objects.equals(Password, CurrentPassword)){
                            StudentDetails sd = new StudentDetails(id);
                            sd.setVisible(true);
                            setVisible(false);
                            Checked.setText("Welcome");
                        }else{
                            Checked.setText("incorrect Password");
                        }
                    }else{
                        Checked.setText("incorrect Password or Registration. ");
                    }
                }
            }
        });
    }
}
