import javax.swing.*;

public class Library extends JFrame {
    private JPanel JPLibrary;

    public Library(){
        setTitle("Library");
        setSize(450, 320);
        setContentPane(JPLibrary);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        WriteLibrary();
    }

    public void WriteLibrary(){
        String[] ColumnName = {"StudentName"};
        Object[] values = {"Mark Vivian"};
        Database Data = new Database();
        Data.DatabaseWrite("library", ColumnName, values);
    }
}
