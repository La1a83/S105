package Nivell1_Ex1;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LListaDirectori{

    // Es crea un objecte de la Classe LlistaDirectori per sortir del static:
    public static void main(String[] args) {
        LListaDirectori programa = new LListaDirectori();
        programa.inici();
        
    }
    
    public void inici() {
        //S'obre l'Scanner:
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriu la ruta del directori: ");
        String ruta = sc.nextLine();//Aquí s'introduiria la ruta del directori.
        //Es crea objecta File:
        File directori = new File(ruta);
        //Si no es un directori o no existeix surt missatge error.
        if (directori.exists()&&directori.isDirectory()) {
            System.out.println("Contingut del directori "+directori.getName()+":");
            LlistaContingut(directori);//Si existeix es llista el contingut ordenat.
        } else {
            System.out.println("Aquest directori no existeix.");
        }
    }
    
    //Mètode que endreça i imprimeix el resultat:
    public void LlistaContingut(File directori) {
        
        //Es fa servir el mètode list() per passar la info a un array.
        String [] llista = directori.list();
        //Desprès es passen les dades a ArrayList:
        List <String> arraylist = new ArrayList();
        arraylist.addAll(Arrays.asList(llista));
        //So'ordenen alfabètocament amb el mètode sort() de Collections
        Collections.sort(arraylist);
        /*Finalment s'imprimeix el resultat amb un bucle for perquè 
        surti en forma de llistat */
        for (int i=0;i<arraylist.size();i++) {
            System.out.println(arraylist.get(i));
        }
           
    }
     
}
            
            
            