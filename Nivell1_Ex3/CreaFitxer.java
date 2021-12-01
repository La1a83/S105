package Nivell1_Ex3;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CreaFitxer{

    //Es crea objecte programa per sortir del mètode static.
    public static void main(String[] args) throws FileNotFoundException {
        CreaFitxer programa = new CreaFitxer();
        programa.inici();
    }
    
    public void inici() throws FileNotFoundException {
        
        File directori = creaFitxer();
        String espai = "  ";
        if (directori.exists()&&directori.isDirectory()) {
            PrintStream fileOut = new PrintStream("./fitxer.txt");
            System.setOut(fileOut);
            System.out.println("Contingut del directori "+directori.getName()+":");
            LlistaContingut(directori, espai);
        } else {
            System.out.println("Aquest directori no existeix.");
        }
    }
    
    //Mètode per crear l'objecte FIle:
    public File creaFitxer () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriu la ruta del directori: ");
        String ruta = sc.nextLine();//Aquí s'introduiria la ruta del directori.
        File directori = new File(ruta);
        return directori;
    }
    
    
    public void LlistaContingut(File directori, String espai) {
        
        
        String novaArrel = directori.getAbsolutePath();
        String [] llista = directori.list();
        List <String> arraylist = new ArrayList();
        arraylist.addAll(Arrays.asList(llista));
        Collections.sort(arraylist);
        
        for (int i=0;i<arraylist.size();i++) {
            
            System.out.print(espai+arraylist.get(i));
            File fitxernou = new File(novaArrel,arraylist.get(i));
            Date data = new Date(fitxernou.lastModified());
            if (fitxernou.isFile()) {
                System.out.print(" FITXER ");
                System.out.println("Última modificació: "+data);
               
            } else if (fitxernou.isDirectory()) {
                
                System.out.print(" DIRECTORI ");
                System.out.println("Última modificació: "+data);
                
                String nouespai =espai+espai;
                LlistaContingut (fitxernou,nouespai);
            } else {
                System.out.println("Fitxer no identificat");
            }
        }
    }
    }
            
            
            
    
            
            

