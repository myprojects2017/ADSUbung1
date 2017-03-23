import java.util.Scanner;

/*
 * Algorithmen und Datenstrukturen - Übung 1
 * Autoren: Namen vor der Abgabe einfügen**********************************
 * Datum: 23.03.2017
 * Version: 1
 * */

public class MainClass {
 
	Scanner reader = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		new MainClass();
	}
	
	public MainClass()
	{
		
		/*- init einer variable welche den Benutzerbefehl im Menue zugewiesen bekommt.
		 *- je nach Rückgabewert wird in der switch-case-Anweisung die Funktion für die Abarbeitung aufgerufen*/
		int varint_befehl=0;
		do{
			varint_befehl=Menueanzeige();
			switch(varint_befehl)
			{
				case 1: new HashClass().search(); break;
				case 2: break;
				case 3: break;
				case 4: break;
				case 5: break;
				case 6: break;
				case 7: break;
			}
		}while(varint_befehl!=8);

		System.out.println("Programm wurde beendet");
	}
	
	//Ausgabe der Menueanzeige
	private int Menueanzeige()
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
			varint_eingabe=reader.nextInt();		
		}while(varint_eingabe<1 || varint_eingabe>9);
		
		return varint_eingabe;
		
	}
}
