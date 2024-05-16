import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    final static String path = "src/Risorse/";
    public static void main(String[] args) {
        //leggi file a assegna a una array le infomazioni
        ArrayList<Studente> Studenti = new ArrayList<Studente>();

        try {
            FileReader lettStud = new FileReader(path + "testo.txt");
            Scanner scanFile = new Scanner(lettStud);
            String x; //Variabile che serve per settare nome, cogn, N.Matricola, email
            while (scanFile.hasNextLine()) {
                String line = scanFile.nextLine();
                Studente std = new Studente();
                if (line.startsWith("Nome: ")) {
                    x = line.split(",")[0] + "\n";

                } else if (line.startsWith("Cognome: ")) {
                    x = line.split(",")[1] + "\n";

                } else if (line.startsWith("Matricola: ")) {
                    x = line.split(",")[2] + "\n";

                }else if (line.startsWith("Email: ")) {
                    x = line.split(",")[3] + "\n";

                }else {

                }
            }

            lettStud.close();
        }catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}