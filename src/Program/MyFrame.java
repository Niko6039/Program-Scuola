package Program;

import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame(String titolo) {
        setTitle(titolo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
