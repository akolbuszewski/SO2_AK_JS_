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
    
    public int SSTF(ArrayList<Integer> odwolania){
        int sumaPrzemieszczen = 0;
        int indeksNajblizszego = 0;
        int przechowanyIndeks = 0;
        int najkrotszaOdleglosc = 101;
        ArrayList <Integer> odwiedzone = new ArrayList<>();
        //za każdym razem sprawdź, gdzie masz najbliżej
        //zacznasz od 50. sprawdz, gdzie masz najblizej
        for(int i=0; i<odwolania.size(); i++){
            if (abs(50-odwolania.get(i))<najkrotszaOdleglosc){
                najkrotszaOdleglosc = abs(50-odwolania.get(i));
                indeksNajblizszego = i;
            }  
        }
        
        sumaPrzemieszczen+=najkrotszaOdleglosc;
        //System.out.println("Dodano "+najkrotszaOdleglosc);
        odwiedzone.add(odwolania.get(indeksNajblizszego));
        przechowanyIndeks = indeksNajblizszego;
        najkrotszaOdleglosc = 101;
        
        while (odwiedzone.size()<odwolania.size()){
            for(int i=0; i<odwolania.size(); i++){
                if (odwiedzone.contains(odwolania.get(i))==false){ //spośród nieodwiedzonych
                    if (abs(odwolania.get(przechowanyIndeks)-odwolania.get(i))<najkrotszaOdleglosc){ //znajdz najblizszego
                        najkrotszaOdleglosc = abs(odwolania.get(przechowanyIndeks)-odwolania.get(i));
                        indeksNajblizszego = i;
                    }//if
                 }//if 
             }//for
            sumaPrzemieszczen+=najkrotszaOdleglosc;
            //System.out.println("Dodano "+najkrotszaOdleglosc);
            odwiedzone.add(odwolania.get(indeksNajblizszego));
            przechowanyIndeks = indeksNajblizszego;
            najkrotszaOdleglosc = 101;   
        }//while
        //dla kazdego: sprawdz, gdzie masz najblizej, z nieodwiedzonych

        
        return sumaPrzemieszczen;
    }

    public int SCAN(ArrayList<Integer> odwolania){
        int sumaPrzemieszczen = 0;
        ArrayList<Integer> mniejsze = new ArrayList<>();
        ArrayList<Integer> wieksze = new ArrayList<>();

        for (Integer i : odwolania){
            if (i<=50){
                mniejsze.add(i);
            } else {
                wieksze.add(i);
            }   
        }
        
        Collections.sort(mniejsze);
        Collections.sort(wieksze);
        
        sumaPrzemieszczen += 50-mniejsze.get(mniejsze.size()-1);
        
        for (int i=mniejsze.size()-1; i>0; i--){
           sumaPrzemieszczen+=mniejsze.get(i)-mniejsze.get(i-1);
        }
        
        sumaPrzemieszczen+=mniejsze.get(0)+wieksze.get(0);
        
        for (int i=1; i<wieksze.size(); i++){
           sumaPrzemieszczen+=wieksze.get(i)-wieksze.get(i-1);
        }
        
        
        return sumaPrzemieszczen;
    }
    
    public int CSCAN(ArrayList<Integer> odwolania){
        int sumaPrzemieszczen = 0;
        ArrayList<Integer> mniejsze = new ArrayList<>();
        ArrayList<Integer> wieksze = new ArrayList<>();

        for (Integer i : odwolania){
            if (i<=50){
                mniejsze.add(i);
            } else {
                wieksze.add(i);
            }   
        }
        
        Collections.sort(mniejsze);
        Collections.sort(wieksze);
        
        sumaPrzemieszczen += 50-mniejsze.get(mniejsze.size()-1);
        
        for (int i=mniejsze.size()-1; i>0; i--){
           sumaPrzemieszczen+=mniejsze.get(i)-mniejsze.get(i-1);
        }
        
        sumaPrzemieszczen+=mniejsze.get(0)+(100-wieksze.get(wieksze.size()-1));
        
        for (int i=wieksze.size()-1; i>0; i--){
           sumaPrzemieszczen+=wieksze.get(i)-wieksze.get(i-1);
        }
        
         
        return sumaPrzemieszczen;
    }