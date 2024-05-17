package Program2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class myDialogAggiungiFile extends JDialog {
    JPanel barraBottoni, panelDati;
    JLabel nome, artista, genere;
    JTextField txtNome, txtArtista, txtGenere;
    public myDialogAggiungiFile(ArrayList brani,DefaultComboBoxModel nuovoBrano) {
        setTitle("Aggiungi File");
        setSize(300, 300);
        setModal(true);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        panelDati = new JPanel();
        panelDati.setLayout(new GridLayout(3, 21));
        add(panelDati, BorderLayout.CENTER);
        panelDati.setBackground(new Color(29, 218, 99));
        //add Nome
        nome = new JLabel("Nome brano", JLabel.CENTER);
        txtNome = new JTextField();
        txtNome.setBackground(new Color(29, 218, 99));

        //add Artista
        artista = new JLabel("Artista", JLabel.CENTER);
        txtArtista = new JTextField();
        txtArtista.setBackground(new Color(29, 218, 99));
        //add genere
        genere = new JLabel("Genere", JLabel.CENTER);
        txtGenere = new JTextField();
        txtGenere.setLayout(new FlowLayout());
        txtGenere.setBackground(new Color(29, 218, 99));

        panelDati.add(nome);
        panelDati.add(txtNome);
        panelDati.add(artista);
        panelDati.add(txtArtista);
        panelDati.add(genere);
        panelDati.add(txtGenere);

        //Barra bottoni sotto
        barraBottoni = new JPanel();
        barraBottoni.setLayout(new BorderLayout());
        add(barraBottoni, BorderLayout.SOUTH);


        setVisible(true);
    }
}