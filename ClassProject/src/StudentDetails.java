import javax.swing.*;

public class StudentDetails extends JFrame {
    private JPanel JPDetails;
    public StudentDetails(){
        setTitle("Student Details");
        setSize(450, 320);
        setContentPane(JPDetails);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        WriteStudentDetails();
    }

    public void WriteStudentDetails(){
        String[] ColumnName = {"StudentName", "StudentReg", "StudentCourse"};
        Object[] values = {"Mark Vivian", "8765", "Computer Science"};
        Database Data = new Database("StudentDetails", ColumnName, values);
    }
}
