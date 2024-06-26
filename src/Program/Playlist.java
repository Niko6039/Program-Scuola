package Program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.Queue;

public class Playlist extends JDialog {
    JButton aventi,Cancel;
    JLabel logoLabel, txtNome, txtArtista, txtGenre,nomePanel, artistaPanel, generePanel;
    JPanel imagePanel, testoPanel;
    ImageIcon image;
    public Playlist(Queue coda) {
        setTitle("Playlist");
        setModal(true);
        setSize(350,200);
        setLocationRelativeTo(null);
        setBackground(new Color(16, 188, 76));

        imagePanel = new JPanel();
        imagePanel.setBackground(new Color(16, 188, 76));
        logoLabel = new JLabel();
        image = new ImageIcon(Main.path + "img2.png");
        logoLabel.setIcon(image);
        imagePanel.add(logoLabel);
        add(imagePanel, BorderLayout.WEST);

        testoPanel = new JPanel();
        testoPanel.setLayout(new GridLayout(6,1));
        txtNome = new JLabel();
        txtArtista = new JLabel();
        txtGenre = new JLabel();

        nomePanel = new JLabel();
        nomePanel.setText("Nome");
        nomePanel.setHorizontalAlignment(SwingConstants.CENTER);

        artistaPanel = new JLabel();
        artistaPanel.setText("Artista");
        artistaPanel.setHorizontalAlignment(SwingConstants.CENTER);

        generePanel = new JLabel();
        generePanel.setText("Genere");
        generePanel.setHorizontalAlignment(SwingConstants.CENTER);

        testoPanel.add(nomePanel);
        testoPanel.add(txtNome);

        testoPanel.add(artistaPanel);
        testoPanel.add(txtArtista);

        testoPanel.add(generePanel);
        testoPanel.add(txtGenre);

        String nome, artista, genere,text = "";
        final Boolean[] var = {true};// set del valore di chiusura del programma, si usa l'array perche una variab bool non puo essere modificata in questo caso

        aventi = new JButton("Aventi");

        if(!coda.isEmpty()){
            text = coda.poll().toString();
            nome = text.toString().split(":")[0];
            nome = nome.substring(nome.indexOf("Nome del brano; ") + 16, nome.indexOf("*"));
            txtNome.setText(nome + "\n");
            txtNome.setHorizontalAlignment(SwingConstants.CENTER);

            artista = text.split(":")[1];
            artista = artista.substring(artista.indexOf("Artista; ") +9 , artista.indexOf("*"));
            txtArtista.setText(artista + "\n");
            txtArtista.setHorizontalAlignment(SwingConstants.CENTER);

            genere = text.split(":")[2];
            genere = genere.substring(genere.indexOf("Artista; ") +8 , genere.indexOf("*"));
            txtGenre.setText(genere + "\n");
            txtGenre.setHorizontalAlignment(SwingConstants.CENTER);

        }else{
            txtNome.setText("");
            nomePanel.setText("");
            txtArtista.setText("");
            artistaPanel.setText("");
            txtGenre.setText("");
            generePanel.setText("");
            testoPanel.setLayout(new BorderLayout());
            testoPanel.add(imagePanel, BorderLayout.CENTER);
            setSize(350,200);
            setLocationRelativeTo(null);
            aventi = new JButton("Chiudi");

        }

        JPanel panel = new JPanel();
        panel.add(aventi);
        panel.setBackground(new Color(16, 188, 76));
        add(panel, BorderLayout.SOUTH);

        aventi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!coda.isEmpty()){
                    System.out.println(coda.peek().toString());
                    String text = coda.poll().toString();

                    String nome = text.toString().split(":")[0];
                    nome = nome.substring(nome.indexOf("Nome del brano; ") + 16, nome.indexOf("*"));
                    txtNome.setText(nome + "\n");

                    String artista = text.split(":")[1];
                    artista = artista.substring(artista.indexOf("Artista; ") +9 , artista.indexOf("*"));
                    txtArtista.setText(artista + "\n");

                    String genere = text.split(":")[2];
                    genere = genere.substring(genere.indexOf("Artista; ") +8 , genere.indexOf("*"));
                    txtGenre.setText(genere + "\n");

                }else if (var[0]){

                    txtNome.setText("");
                    nomePanel.setText("");
                    txtArtista.setText("");
                    artistaPanel.setText("");
                    txtGenre.setText("");
                    generePanel.setText("");
                    testoPanel.setLayout(new BorderLayout());
                    testoPanel.add(imagePanel, BorderLayout.CENTER);
                    setSize(350,200);
                    aventi.setText("Chiudi");
                    var[0] = false;
                }else {//Chiusura
                    setVisible(false);
                }
            }
        });
        add(aventi, BorderLayout.SOUTH);

        add(testoPanel, BorderLayout.CENTER);
        testoPanel.setBackground(new Color(16, 188, 76));



        setVisible(true);
    }
}
