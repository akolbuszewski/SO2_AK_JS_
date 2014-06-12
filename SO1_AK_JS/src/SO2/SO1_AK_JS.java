/*
 *Zadanie drugie kursu Systemy Operacyjne, 2014 PWr
 * Aleksander Kolbuszewski, Janek Szynal  
 */

package so1_ak_js;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Janek
 */
public class SO2_AK_JS {
    
    
    
    
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Zasob zas = new Zasob();
        startMenu(zas.stworzListe());
       
    }
    
    private static void startMenu(ArrayList<Integer> odwolania) throws FileNotFoundException{
            System.out.println("\n* * *");
            System.out.println("Wybierz naciskajac klawisz cyfry, a nastepnie potwierdź enterem:");
            System.out.println("1 - Wyświetl listę odwołań"); //OK
            System.out.println("2 - Stwórz nową listę odwołań"); //test GEN
            System.out.println("3 - Przedstaw statystyki"); 
            System.out.println("4 - Zakończ"); //OK

            //MENU
            Scanner scn = new Scanner(System.in);

            switch (scn.nextInt()) {
            case 1: 
                    System.out.println("Lista odwołań:");
                    for (Integer i : odwolania){
                        System.out.print(i+" ");
                    }
                    startMenu(odwolania);
                    break;
            case 2: //stworzliste
                    Zasob zas = new Zasob();
                    startMenu(zas.stworzListe());
                    break;
            case 3: //stats
                    Zasob zas2 = new Zasob();
                    System.out.println("FCFS: "+zas2.FCFS(odwolania));
                    System.out.println("SSTF: "+zas2.SSTF(odwolania));
                    System.out.println("SCAN: "+zas2.SCAN(odwolania));
                    System.out.println("C-SCAN: "+zas2.CSCAN(odwolania));
                    startMenu(odwolania);
                    break;
            
            case 4:
                    break;
            }

        }

    
}
