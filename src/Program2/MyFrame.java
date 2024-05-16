package Program2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyFrame extends JFrame {
    public MyFrame(String titolo, ArrayList brani) {
        setTitle(titolo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(400, 750);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
