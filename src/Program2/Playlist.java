package Program2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Queue;

public class Playlist extends JDialog {
    JButton Aventi;
    JLabel testo;
    public Playlist(Queue coda) {
        setTitle("Playlist");
        testo = new JLabel();
        setLocationRelativeTo(null);
        setSize(300,200);
        if(coda.isEmpty()!=true){
            testo.setText(coda.poll().toString());
        }


        JPanel panel = new JPanel();
        Aventi = new JButton("Aventi");
        panel.add(Aventi);
        Aventi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (coda.isEmpty()!=true){
                    System.out.println(coda.peek().toString());
                    testo.setText(coda.poll().toString());
                }else{
                    testo.setText("");
                }
            }
        });
        add(testo, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        setVisible(true);
    }
}
