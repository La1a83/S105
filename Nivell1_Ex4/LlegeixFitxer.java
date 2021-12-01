
package Nivell1_Ex4;

import java.io.*;
import java.util.Scanner;
public class LlegeixFitxer {

    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String nomFitxer;
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriu el nom complert del fitxer que vols llegir: ");
        nomFitxer = sc.nextLine();
        if (nomFitxer.isEmpty()) {
            System.out.println("error, no has escrit cap nom");
        }
        
        try {
            BufferedReader f = new BufferedReader( new FileReader(nomFitxer));
            int c = f.read();
            while (c !=-1) {
                System.out.print((char)c);
                c = f.read();
            }
            f.close();
        }catch (EOFException eof) {
            System.out.println("Aquest fitxer no s'ha pogut obrir");
        }
           
        
        
        
        
        
    }
    
}
