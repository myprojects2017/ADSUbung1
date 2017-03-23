 import java.util.Scanner;

/*
 * Algorithmen und Datenstrukturen - Übung 1
 * Autoren: Namen vor der Abgabe einfügen**********************************
 * Datum: 23.03.2017
 * Version: 1
 * */

public class MainClass {
 
	Scanner read = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		new MainClass();
	}
	
	public MainClass()
	{
		
		/*- init der Variable "varint_befehl" welche den Benutzerbefehl im Menue übergeben bekommt.
		 *- je nach Rückgabewert wird in der switch-case-Anweisung die Funktion für die Abarbeitung aufgerufen*/
		int varint_befehl=0;
		do{
			varint_befehl=showMenue();
			switch(varint_befehl)
			{
				case 1: new Manipulation().add(); break;
				case 2: new Manipulation().delete(); break; 
				case 3:	callclass(varint_befehl);break;
				case 4: new HashClass().search(); break;
				case 5: callclass(varint_befehl);break;
				case 6: new FileManipulationClass().save_file(); break;
				case 7: new FileManipulationClass().load_file(); break;
			}
		}while(varint_befehl!=8);

		System.out.println("** Programm wurde beendet! **");
	}
	
	//Ausgabe der Menueanzeige
	private int showMenue()
	{
		System.out.println(
			"\n____________\n"
			+ "|ADD    (1)|\n"
			+ "|DEL    (2)|\n"
			+ "|IMPORT (3)|\n"
			+ "|SEARCH (4)|\n"
			+ "|PLOT   (5)|\n"
			+ "|SAVE   (6)|\n"
			+ "|LOAD   (7)|\n"
			+ "|QUIT   (8)|\n"
			+ "¯¯¯¯¯¯¯¯¯¯¯¯");
		
		int varint_eingabe=0;
		do{
			System.out.print("Eingabe: ");
			/*Regx für Eingabe, überprüft ob eingabe Zahl ist. z.B. wenn ein Buchstabe eingegeben wird*/
			String varstring_regx="[1-8]";
			String varstring_input = read.next();
			if(varstring_input.matches(varstring_regx))
				varint_eingabe=Integer.parseInt(varstring_input);
			else
				System.out.println("** Ungültige Eingabe! **");
		}while(varint_eingabe<1 || varint_eingabe>9);
		
		return varint_eingabe;
		
	}

	
	/*diese Funktion dient dazu, dass für PLOT & IMPORT nicht 2mal diese Abfrage oben im Code steht
	   --> unterscheindung anhand der if-Abfrage
	*/
	private void callclass(int varint_i)
	{
		int varint_temp =0;				 				
		do{
			System.out.println("Bitte Kürzel/Namen der Aktien  eingeben: ");
			if(varint_i==3){
				varint_temp = new FileManipulationClass().import_file(read.next());	
				if(varint_temp==1)
			        System.out.println("** Die Datensätze wurden imporitert! **");
			}
			else if(varint_i==5)
				varint_temp = new FileManipulationClass().plot(read.next());	
		}while(varint_temp!=1);
	}



}

