package Program;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final String path = "src/Risorse/";
    public static void main(String[] args) {
        ArrayList<Brano> brani = new ArrayList<>();

        try {
            FileReader lettBraniSave = new FileReader(path + "braniSave");
            Scanner scanFile = new Scanner(lettBraniSave);
            String nomeCanzone, artista, genere;
            String line = "";
            while (scanFile.hasNextLine()) {
                Brano canzone = new Brano();
                line = scanFile.nextLine();

                nomeCanzone = line.split(":")[0];
                nomeCanzone = nomeCanzone.substring(nomeCanzone.indexOf("Nome del brano; ") + 16, nomeCanzone.indexOf("*"));

                System.out.println(nomeCanzone);
                canzone.setNomeBrano(nomeCanzone);

                artista = line.split(":")[1];
                artista = artista.substring(artista.indexOf("Artista; ") + 9, artista.indexOf("*"));
                System.out.println(artista);
                canzone.setArtista(artista);

                genere = line.split(":")[2];
                genere = genere.substring(genere.indexOf("Genere; ") + 8, genere.indexOf("*"));
                System.out.println(genere);
                canzone.setGenere(genere);

                System.out.println(canzone);
                brani.add(canzone);
            }
            lettBraniSave.close();
        }catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        System.out.println(brani);
        MyFrame frame = new MyFrame("Spotify", brani);

    }
}
