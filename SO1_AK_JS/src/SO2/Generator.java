/*
 *Zadanie drugie kursu Systemy Operacyjne, 2014 PWr
 * Aleksander Kolbuszewski, Janek Szynal  
 */

package SO2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Janek
 */
public class Generator {
    ArrayList<Integer> odwolania = new ArrayList<>();
    
    /*metoda wczytuje plik o nazwie przekazanej parametrem
    i interpretuje kolejne linijki, 
    wywoĹ‚ujac odpowiednio metody dodajProces lub generujProcesy*/
    void wczytajZPliku(String nazwa) throws FileNotFoundException{
        System.out.println("wczytywanie z "+nazwa);
        Scanner odczyt = new Scanner(new File(nazwa));
        while(odczyt.hasNextLine()){
            odwolania.add(Integer.parseInt(odczyt.nextLine()));
        }
    }//wczytajZPliku
    /*SIDENOTE: CLEAN ODWOLANIA B4 ADDING*/
    void generujLosowo(int liczbaOdwolan) {//czy powinny byc inne parametry?
        for (int i = 0; i<liczbaOdwolan; i++){
            Random rand = new Random(); 
            odwolania.add(rand.nextInt(100));
        }
     
    }
}//generator
    