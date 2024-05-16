package Program;

import java.io.FileReader;
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
            String nome, cognome, matricola, email; //Variabile che serve per settare nome, cogn, N.Matricola, email
            String line = "";
            while (scanFile.hasNextLine()) {
                Studente std = new Studente();
                line = scanFile.nextLine();
                nome = line.split(",")[0];
                std.setNome(nome);
                cognome = line.split(", ")[1];
                std.setCognome(cognome);
                matricola = line.split(", ")[2];
                std.setMatricula(matricola);
                email = line.split(", ")[3];
                std.setEmail(email);
                Studenti.add(std);
            }
            lettStud.close();
        }catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}