 import java.util.Scanner;

/*
 * Algorithmen und Datenstrukturen - Übung 1
 * Autoren: Ulrich Gram, Mihael
 * Datum: 31.03.2017
 * */

public class MainClass {
 
	Scanner read = new Scanner(System.in);
	
	Hashtable hashtable_name = new Hashtable();
	Hashtable hashtable_acronym = new Hashtable();
	Hashtable_Manipulation manipulation = new Hashtable_Manipulation();
	SaveLoad saveload = new SaveLoad();
	
	public static void main(String[] args) {
		new MainClass();
	}
	
	public MainClass()
	{
		
		// Initialisierung der Variable "varint_befehl", welche den Benutzerbefehl im Menue übergeben bekommt.
		// Je nach Rückgabewert wird in der switch-case-Anweisung die Funktion für die Abarbeitung aufgerufen
		int eingabe=0;
		do{
			// Aufruf der Funktion showMenue
			eingabe=showMenue();
			switch(eingabe)
			{
				case 1: manipulation.add(hashtable_name, hashtable_acronym); break;
				case 2: manipulation.delete(hashtable_name, hashtable_acronym); break; 
				case 3:	callClass(eingabe);break;
				case 4: {
							Aktie searchentry = manipulation.search(hashtable_name, hashtable_acronym);
							if(searchentry!=null)
								searchentry.printAktie();
							break;
						}
				case 5: callClass(eingabe);break;
				case 6: {
							System.out.println("Name der CSV-Datei: ");
							String name_csv = read.next(); 
							saveload.save(name_csv, hashtable_name, hashtable_acronym);					
							break;
						}
				case 7: {
							System.out.println("Name der CSV-Datei: ");
							String name_csv = read.next(); 
							saveload.load(name_csv, hashtable_name, hashtable_acronym);					
							break;
						}
			}      
		}while(eingabe!=8);

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
			+ "¯¯¯¯¯¯¯¯¯¯¯¯");
		
		int eingabe=0;
		do{
			System.out.print("Eingabe: ");
			//Regx für Eingabe, überprüft ob eingabe Zahl ist. z.B. wenn ein Buchstabe eingegeben wird*/
			String varstring_regx="[1-8]";
			String varstring_input = read.next();
			if(varstring_input.matches(varstring_regx))
				eingabe=Integer.parseInt(varstring_input);
			else
				System.out.println("** Ungültige Eingabe! **");
		}while(eingabe<1 || eingabe>9);
		
		return eingabe;
		
	}

	
	//diese Funktion dient dazu, dass für PLOT & IMPORT nicht 2mal diese Abfrage oben im Code steht
	//  --> unterscheindung anhand der if-Abfrage

	private void callClass(int varint_i)
	{ 
			Aktie searchentry = manipulation.search(hashtable_name, hashtable_acronym);
			if(varint_i==3)
				new Import().import_file(searchentry);			
			else if(varint_i==5)
				 new DrawClass().plot(searchentry);	
		 
	}

	



}

