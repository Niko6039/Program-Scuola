package Program2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyFrame extends JFrame {
  //       1(null)      sud(flow)       central(griglia)
    JPanel imagePanel, barraBottoniPanel, centralPanel, CBeBT, cbPpanel, butPanel;
    JComboBox cbBrani;
    JLabel logoLabel;
    ImageIcon image;
    JButton pushButton, aggiuntiBrano, visualizzaBrano;
    public MyFrame(String titolo, ArrayList brani) {
        setTitle(titolo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(400, 750);
        setLocationRelativeTo(null);

        //Pannello Centrale contiene tutti i elementi importanti
        centralPanel = new JPanel();
        centralPanel.setBackground(new Color(199, 0, 255));
        centralPanel.setLayout(new FlowLayout());
        add(centralPanel, BorderLayout.CENTER);

        //Pannello dell'immagine
        imagePanel = new JPanel();
        imagePanel.setBackground(new Color(17, 0, 255));
        logoLabel = new JLabel();
        image = new ImageIcon(Main.path + "img_1.png");
        logoLabel.setIcon(image);
        centralPanel.add(imagePanel);
        imagePanel.add(logoLabel);


        //Pannello contenitore della combo Box e del pulsante
        CBeBT = new JPanel();
        CBeBT.setLayout(new GridLayout(2,1));
        CBeBT.setBackground(new Color(255, 12, 143));
        centralPanel.add(CBeBT);

        //Pannello per la Combo Box
        cbPpanel = new JPanel();
        cbPpanel.setLayout(new FlowLayout());
        cbPpanel.setBackground(new Color(155, 23, 225));

        cbBrani = new JComboBox<>();
        String nome="", nomeBrano;
        System.out.println(nome);
        DefaultComboBoxModel allBrani = new DefaultComboBoxModel();
        for (int i = 0; i < brani.size(); i++) {
            nome = brani.get(i).toString().split(", ")[0];
            nomeBrano = nome.substring(nome.indexOf("Nome del brano; ")+15, nome.length());
            allBrani.addElement(nomeBrano);

        }
        cbBrani.setModel(allBrani);
        cbPpanel.add(cbBrani);
        CBeBT.add(cbPpanel);

        //Pannello per il pulsate push della pila
        butPanel = new JPanel();
        butPanel.setBackground(new Color(184, 138, 25));
        butPanel.setLayout(new FlowLayout());
        //Set Bottone Push
        pushButton = new JButton("Push");
        pushButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        CBeBT.add(butPanel);

        //----------------------------------------------------------------------
        //Barra Bottoni qui verrano inseriti i vari bottoni
        barraBottoniPanel = new JPanel();
        barraBottoniPanel.setLayout(new FlowLayout());
        barraBottoniPanel.setBackground(new Color(200, 100, 132));

        JButton aggiungiBrano = new JButton("Aggiungi");
        //Aggiungi un brano a mano
        aggiungiBrano.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        barraBottoniPanel.add(aggiungiBrano);

        //Visualizza i Brani (Con un dialog)
        JButton visualizzaBrano = new JButton("Visualizza");
        visualizzaBrano.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        barraBottoniPanel.add(visualizzaBrano);

        add(barraBottoniPanel, BorderLayout.SOUTH);


        setVisible(true);
    }
}
