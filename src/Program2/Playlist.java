package Program2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Queue;

public class Playlist extends JDialog {
    JButton Aventi,Cancel;
    JLabel testo, logoLabel;
    JPanel imagePanel;
    ImageIcon image;
    public Playlist(Queue coda) {
        setTitle("Playlist");
        setModal(true);
        setLocationRelativeTo(null);
        setSize(350,200);
        setBackground(new Color(16, 188, 76));

        imagePanel = new JPanel();
        imagePanel.setBackground(new Color(16, 188, 76));
        logoLabel = new JLabel();
        image = new ImageIcon(Main.path + "img2.png");
        logoLabel.setIcon(image);
        add(logoLabel, BorderLayout.WEST);

        testo = new JLabel();
        if(coda.isEmpty()!=true){
            testo.setText(coda.poll().toString());
        }

        Aventi = new JButton("Aventi");
        JPanel panel = new JPanel();
        panel.add(Aventi);
        panel.setBackground(new Color(16, 188, 76));
        add(panel, BorderLayout.SOUTH);

        Aventi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (coda.isEmpty()!=true){
                    System.out.println(coda.peek().toString());
                    testo.setText(coda.poll().toString());
                }else{
                    testo.setText("");
                    add(logoLabel, BorderLayout.CENTER);

                }
            }
        });
        add(testo, BorderLayout.CENTER);
        setVisible(true);
    }
}
