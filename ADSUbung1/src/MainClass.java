 import java.util.Scanner;

/*
 * Algorithmen und Datenstrukturen - �bung 1
 * Autoren: Namen vor der Abgabe einf�gen**********************************
 * Datum: 23.03.2017
 * Version: 1
 * */

public class MainClass {
 
	Scanner read = new Scanner(System.in);
	
	HashClass hashtable_name = new HashClass();
	HashClass hashtable_acronym = new HashClass();
	Manipulation manipulation = new Manipulation();
	
	public static void main(String[] args) {
		new MainClass();
	}
	
	public MainClass()
	{
		
		/*- init der Variable "varint_befehl" welche den Benutzerbefehl im Menue �bergeben bekommt.
		 *- je nach R�ckgabewert wird in der switch-case-Anweisung die Funktion f�r die Abarbeitung aufgerufen*/
		int varint_befehl=0;
		do{
			varint_befehl=showMenue();
			switch(varint_befehl)
			{
				case 1: manipulation.add(hashtable_name, hashtable_acronym); break;
				case 2: new Manipulation().delete(hashtable_name, hashtable_acronym); break; 
				case 3:	callclass(varint_befehl);break;
				case 4: {
							Aktie searchentry = manipulation.search(hashtable_name, hashtable_acronym);
							if(searchentry!=null)
								searchentry.printAktie();
							break;
						}
				case 5: callclass(varint_befehl);break;
				case 6: //new DrawClass().save_file(); break;
				case 7: //new DrawClass().load_file(); break;
			}      
		}while(varint_befehl!=8);

		System.out.println("** Programm wurde beendet! **");
	}	
	
	//Funktionen der MainClass
	
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
			+ "������������");
		
		int varint_eingabe=0;
		do{
			System.out.print("Eingabe: ");
			/*Regx f�r Eingabe, �berpr�ft ob eingabe Zahl ist. z.B. wenn ein Buchstabe eingegeben wird*/
			String varstring_regx="[1-8]";
			String varstring_input = read.next();
			if(varstring_input.matches(varstring_regx))
				varint_eingabe=Integer.parseInt(varstring_input);
			else
				System.out.println("** Ung�ltige Eingabe! **");
		}while(varint_eingabe<1 || varint_eingabe>9);
		
		return varint_eingabe;
		
	}

	
	/*diese Funktion dient dazu, dass f�r PLOT & IMPORT nicht 2mal diese Abfrage oben im Code steht
	   --> unterscheindung anhand der if-Abfrage
	*/
	private void callclass(int varint_i)
	{ 
			Aktie searchentry = manipulation.search(hashtable_name, hashtable_acronym);
			if(varint_i==3)
				new FileManipulation().import_file(searchentry);			
			else if(varint_i==5)
				 new DrawClass().plot(searchentry);	
		 
	}

	



}

