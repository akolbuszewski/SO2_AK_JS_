/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package so1_ak_js;

import java.io.FileNotFoundException;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 *
 * @author Janek
 */
public class Zasob {
    Generator genr = new Generator();

    public ArrayList stworzListe() throws FileNotFoundException{
        System.out.println("1 - Wczytaj liste z pliku");
        System.out.println("2 - Wygeneruj losowo");
        Scanner scn = new Scanner(System.in);

            switch (scn.nextInt()) {
            case 1: 
                    System.out.println("Podaj nazwe pliku wraz z rozszerzeniem");
                    Scanner scn2 = new Scanner(System.in);
                    genr.wczytajZPliku(scn2.nextLine());
                    break;
            case 2: //stworzliste
                    System.out.println("Podaj liczbe odwolan do wygenerowania");
                    genr.generujLosowo(scn.nextInt());
                    break;
            }
        return genr.odwolania;    
    }
    
    public int FCFS(ArrayList<Integer> odwolania){
        int sumaPrzemieszczen = 0;
        sumaPrzemieszczen+=abs(50-odwolania.get(0));
        for (int i=1; i<odwolania.size(); i++){
            sumaPrzemieszczen+=abs(odwolania.get(i)-odwolania.get(i-1));
        }
        return sumaPrzemieszczen;
    }
    
