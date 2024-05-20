package Program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.ArrayList;

public class myDialogAggiungiFile extends JDialog {
    JPanel barraBottoni, panelDati;
    JLabel nome, artista, genere;
    JTextField txtNome, txtArtista, txtGenere;

    JPanel imagePanel;
    JLabel image;
    ImageIcon imageIcon;

    JButton btnAggiungi, btnCancelar;
    public myDialogAggiungiFile(ArrayList brani,DefaultComboBoxModel nuovoBrano, JComboBox comboBox) {
        setTitle("Aggiungi File");
        setSize(350, 375);
        setModal(true);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setBackground(new Color(16, 188, 76));

        //set image
        imagePanel = new JPanel();
        image = new JLabel();
        imageIcon = new ImageIcon(Main.path + "img3.png");
        image.setIcon(imageIcon);
        image.setHorizontalAlignment(SwingConstants.CENTER);
        imagePanel.add(image);
        imagePanel.setBackground(new Color(16, 188, 76));
        add(imagePanel, BorderLayout.NORTH);


        //Set pannello che contine in nome, artista e genere
        panelDati = new JPanel();
        panelDati.setBackground(new Color(16, 188, 76));
        panelDati.setLayout(new GridLayout(3, 21));
        add(panelDati, BorderLayout.CENTER);

        //add Nome
        nome = new JLabel("Nome brano", JLabel.CENTER);
        txtNome = new JTextField();
        txtNome.setBackground(new Color(16, 188, 76));
        txtNome.setHorizontalAlignment(SwingConstants.CENTER);

        //add Artista
        artista = new JLabel("Artista", JLabel.CENTER);
        txtArtista = new JTextField();
        txtArtista.setBackground(new Color(16, 188, 76));
        txtArtista.setHorizontalAlignment(SwingConstants.CENTER);

        //add genere
        genere = new JLabel("Genere", JLabel.CENTER);
        txtGenere = new JTextField();
        txtGenere.setBackground(new Color(16, 188, 76));
        txtGenere.setHorizontalAlignment(SwingConstants.CENTER);

        //Set layout
        panelDati.add(nome);
        panelDati.add(txtNome);
        panelDati.add(artista);
        panelDati.add(txtArtista);
        panelDati.add(genere);
        panelDati.add(txtGenere);

        //Barra bottoni sotto
        barraBottoni = new JPanel();
        barraBottoni.setLayout(new FlowLayout());
        add(barraBottoni, BorderLayout.SOUTH);
        btnAggiungi = new JButton("Aggiungi");
        btnAggiungi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter fw = new FileWriter(Main.path + "braniSave",true);
                    fw.write("Nome del brano; "+txtNome.getText()+ "* :Artista; " + txtArtista.getText() +"* :Genere; "+ txtGenere.getText() +"*:\n");
                    MyFrame.setComboBox(txtNome.getText(), comboBox, nuovoBrano);
                    Brano br = new Brano();
                    br.setNomeBrano(txtNome.getText());
                    br.setArtista(txtArtista.getText());
                    br.setGenere(txtGenere.getText());
                    brani.add(br);
                    fw.close();
                    setVisible(false);
                }catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        barraBottoni.add(btnAggiungi);

        btnCancelar = new JButton("Cancella");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        barraBottoni.add(btnCancelar);

        setVisible(true);
    }
}