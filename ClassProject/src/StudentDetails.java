import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StudentDetails extends JFrame {
    Database dat = new Database();
    int StudentId;
    List<String> CourseName = new ArrayList<>();
    private JPanel JPDetails;
    private JLabel StudentName;
    private JLabel Registration;
    private JLabel EnterName;
    private JLabel EnterReg;
    private JLabel Programme;
    private JLabel EnterProg;
    private JButton libraryButton;
    private JButton resultsButton;
    private JButton notAvailable2Button;
    private JButton notAvailable3Button;
    private JButton LogOut;
    private JButton notAvailableButton;
    private JLabel Course1;
    private JLabel Course2;
    private JLabel Course3;
    private JLabel Course4;
    private JLabel Course5;

    public StudentDetails(int id){
        setTitle("Student Details");
        setSize(450, 400);
        setContentPane(JPDetails);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        StudentInfo(id);
        CourseNameInfo(id);
        LogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Login log = new Login();
                log.setVisible(true);
                setVisible(false);
            }
        });


        libraryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        resultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Results res = new Results(id);
                res.setVisible(true);
                setVisible(false);
            }
        });
        libraryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Library lib = new Library(id);
                lib.setVisible(true);
                setVisible(false);
            }
        });
    }
    public void StudentInfo(int id){
        dat.getDataById("StudentDetails", "StudentId", id);
        for(int i = 0; i < dat.ValueDatabase.size(); i += 4){
            StudentId = Integer.parseInt(dat.ValueDatabase.get(i));
            EnterName.setText(dat.ValueDatabase.get(i+1));
            EnterReg.setText(dat.ValueDatabase.get(i+2));
            EnterProg.setText(dat.ValueDatabase.get(i+3));
        }
    }

    public void CourseNameInfo(int id){
        dat.getDataById("StudentCourse", "StudentId", id);
        for(int i = 0; i < dat.ValueDatabase.size(); i += 5){
            System.out.println(dat.ValueDatabase.get(i+1));
            CourseName.add(dat.ValueDatabase.get(i+1));
        }
        CourseName.remove(0);
        for (int i = 0; i < CourseName.size(); i += 5) {
            Course1.setText(CourseName.get(i));
            Course2.setText(CourseName.get(i + 1));
            Course3.setText(CourseName.get(i + 2));
            Course4.setText(CourseName.get(i + 3));
            Course5.setText(CourseName.get(i + 4));
        }
    }
}
