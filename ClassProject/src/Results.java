import javax.swing.*;

public class Results extends JFrame {
    private JPanel JPResults;

    public Results(int id){
        setTitle("Results");
        setSize(450, 320);
        setContentPane(JPResults);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
