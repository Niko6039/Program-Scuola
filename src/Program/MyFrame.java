package Program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyFrame extends JFrame {
    JPanel panel1, barraBut, panelSupp, panelImage;
    JButton addStd, addPila;
    JComboBox comboBoxStd;
    JLabel logoLabel;
    ImageIcon image;
    public MyFrame(String titolo, ArrayList std) {

        setTitle(titolo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(400, 750);
        setLocationRelativeTo(null);

        //Set il pannello dove stara' la combox, immagine e lo spazio decorativo
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1, 3));
        panel1.setBackground(new Color(40, 154, 215));

        //Set il pannello della barra di sotto con i pulsanti
        barraBut = new JPanel();
        barraBut.setBackground(new java.awt.Color(40, 154, 215));
        barraBut.setLayout(new FlowLayout());

        //set Combo Box dei studenti file
        comboBoxStd = new JComboBox<>();
        DefaultComboBoxModel ComBstd = new DefaultComboBoxModel();
        String nome , nCompleto;

        for (int i = 0; i < std.size(); i++) {
            System.out.println(std.get(i).toString());
            nome = std.get(i).toString().split(", ")[0];
            nCompleto = nome.substring(nome.indexOf("Nome: ")+5, nome.length());
            ComBstd.addElement(nCompleto);
            System.out.println(std.get(i).toString().split(", ")[0]);
        }
        comboBoxStd.setModel(ComBstd);


        //Set pulsante New Studente
        addStd = new JButton("Aggiungi uno studente");
        addStd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        //Set la visualizzazione della pila
        addPila = new JButton("Aggiungi uno pila");
        addPila.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        //Set pannello per l'immagine
        panelImage = new JPanel();

        //set immagine
        logoLabel = new JLabel();
        image = new ImageIcon(Main.path + "Img.png");
        logoLabel.setIcon(image);

        //Mettiamo al panelImage l'immagine
        panelImage.add(logoLabel);
        add(panelImage, BorderLayout.NORTH);

        //Set della comboBox al centro
        add(panel1, BorderLayout.CENTER);
        panel1.add(comboBoxStd);

        //Visualizzazione della barra di sotto con i pulsanti
        add(barraBut, BorderLayout.SOUTH);
        barraBut.add(addStd);
        barraBut.add(addPila);
        setVisible(true);
    }
}
