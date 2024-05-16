package Program2;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final String path = "src/Risorse/";
    public static void main(String[] args) {
        ArrayList<Brano> Brani = new ArrayList<>();

        try {
            FileReader lettBraniSave = new FileReader(path + "testo.txt");
            Scanner scanFile = new Scanner(lettBraniSave);
            String nome, artista, genere;
            String line = "";
            while (scanFile.hasNextLine()) {
                Brano canzone = new Brano();
                line = scanFile.nextLine();
                nome = line.split(", ")[0];
                canzone.setNomeBrano(nome);

                artista = line.split(", ")[1];
                canzone.setArtista(artista);

                genere = line.split(", ")[2];
                canzone.setGenere(genere);

                Brani.add(canzone);
            }
            lettBraniSave.close();
        }catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

    }
}
