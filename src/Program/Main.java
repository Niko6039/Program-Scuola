package Program;

import java.io.FileReader;
import java.util.Scanner;

public class Main {
    final static String path = "Risorse/";
    public static void main(String[] args) {
        //leggi file a assegna a una array le infomazioni
        try {
            FileReader lettStud = new FileReader(Main.path + "pagina1.txt");
            Scanner scanFile = new Scanner(lettStud);
            while (scanFile.hasNextLine()) {

            }
            lettStud.close();
        }catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}