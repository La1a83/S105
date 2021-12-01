/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivell1_Ex5;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Animal implements Serializable {
    
    private String tipus;
    private int edad; 
    private String color;
    
    public Animal(String tipus,int edad,String color) {
        this.tipus = tipus;
        this.edad = edad;
        this.color = color;
    }

    public String getTipus() {
        return tipus;
    }

    public int getEdad() {
        return edad;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Animal{" + "tipus=" + tipus + ", edad=" + edad + ", color=" + color + '}';
    }
    
    public String emiteSonido () {
        return "Grrrr...";
    }
    
    public static void main (String [] args) throws IOException {
        
        //Instanciació d'un objecte de la classe Animal:
        Animal animal1 = new Animal("Gat",3,"Blanc");
        
        //bloc de codi per serialitzar l'objecte i guardar-lo al fichero.ser:
        try {
            FileOutputStream fos = new FileOutputStream("./fichero.ser");
            ObjectOutputStream sos = new ObjectOutputStream(fos);
            sos.writeObject(animal1.toString());
            sos.writeObject(animal1.emiteSonido());
            sos.close();
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        
        //Intruccions per deserialitzar l'objecte i imprimir-lo per pantalla:
        try {
            FileInputStream fis = new FileInputStream("fichero.ser");
            ObjectInputStream sis = new ObjectInputStream(fis);
            System.out.println((String)sis.readObject());
            System.out.println((animal1.emiteSonido()));
            Object readObject = sis.readObject();
            sis.close();
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
}
    