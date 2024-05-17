package Program2;

import javax.swing.*;
import javax.swing.text.Element;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MyFrame extends JFrame {
  //       1(null)      sud(flow)       central(griglia)
    JPanel imagePanel, barraBottoniPanel, centralPanel, CBeBT, cbPpanel, butPanel;
    JComboBox cbBrani;
    JLabel logoLabel;
    ImageIcon image;
    JButton pushButton, aggiungiBrano, visualizzaBrano;
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
        DefaultComboBoxModel allBrani = new DefaultComboBoxModel();
        for (int i = 0; i < brani.size(); i++) {//devo usare una array invece di una stringa
            nome = brani.get(i).toString().split(", ")[0];
            nomeBrano = nome.substring(nome.indexOf("Nome del brano; ") + 16, nome.length()-1);
            allBrani.addElement(nomeBrano);
        }
        cbBrani.setModel(allBrani);
        cbPpanel.add(cbBrani);
        CBeBT.add(cbPpanel);

        //Pannello per il pulsate push della coda
        butPanel = new JPanel();
        butPanel.setBackground(new Color(184, 138, 25));
        butPanel.setLayout(new FlowLayout());

        //Creazione della coda
        Queue queue = new LinkedList<>();

        //Set Bottone Push
        pushButton = new JButton("Push");
        pushButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {// trovo nella arraylist in nome
                queue.add(allBrani.getSelectedItem());
                System.out.println(queue.toString());
            }
        });
        CBeBT.add(butPanel);
        butPanel.add(pushButton);

        //----------------------------------------------------------------------
        //Barra Bottoni qui verrano inseriti i vari bottoni
        barraBottoniPanel = new JPanel();
        barraBottoniPanel.setLayout(new FlowLayout());
        barraBottoniPanel.setBackground(new Color(200, 100, 132));

        aggiungiBrano = new JButton("Aggiungi");
        //Aggiungi un brano a mano
        aggiungiBrano.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myDialogAggiungiFile dialog1 = new myDialogAggiungiFile(brani,allBrani);

            }
        });
        barraBottoniPanel.add(aggiungiBrano);

        //Visualizza i Brani (Con un dialog)
        visualizzaBrano = new JButton("Visualizza");
        visualizzaBrano.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Playlist playlist = new Playlist(queue);
            }
        });
        barraBottoniPanel.add(visualizzaBrano);
        add(barraBottoniPanel, BorderLayout.SOUTH);
        setVisible(true);
    }
}
