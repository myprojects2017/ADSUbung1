import java.util.Scanner;

// Diese Klasse enthält die Funktionen Add, Search and Delete, um Einträge in ZWEI Hashtabellen zu bearbeiten


public class Hashtable_Manipulation {
	Scanner read = new Scanner(System.in);

	// Aktie hinzufügen
	public void add(Hashtable hashtable_name, Hashtable hashtable_kuerzel)
	{
		Aktie aktieadd = new Aktie();
		
		System.out.println("Geben Sie den Namen der Aktie ein: ");
		String eingabe_name = read.next(); 
		aktieadd.setName(eingabe_name);
		
		System.out.println("Geben Sie die Wertpapier-Kennnummer (WKN) ein: ");
		String eingabe_wkn = read.next();
		aktieadd.setWKN(eingabe_wkn);
		
		System.out.println("Geben Sie das Kürzel der Aktie ein: ");
		String eingabe_kuerzel = read.next(); 
		aktieadd.setKuerzel(eingabe_kuerzel);
		
		// In die Namens-Hashtabelle adden
		hashtable_name.add(aktieadd.getName(), aktieadd, false);
		
		// In die Kürzel-Hashtabelle adden
		hashtable_kuerzel.add(aktieadd.getKuerzel(), aktieadd, true);
	}
	
	
	// Suchen nach bestimmten Name oder Kürzel
	// Rückgabe des dementsprechenden Aktien-Objekts
	// Im Hauptprogramm wird die Methode Aktie.print() aufgerufen und die Daten ausgegeben
	
	public Aktie search(Hashtable hashtable_name, Hashtable hashtable_kuerzel)
	{
		int eingabe=0;
		Aktie search_entry = new Aktie();
		do{
		System.out.print(
				  "\n_______________________"
				+ "\n|Abbruch           (0)|"
				+ "\n|Suche nach Namen  (1)|"
				+ "\n|Suche nach Kürzel (2)|"
				+ "\n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯"
				+ "\nEingabe:");
		 
		//wie im Hauptmenü = Regx überprüfung
		 String regx="[0-2]";
			String input = read.next();
			if(input.matches(regx))
				eingabe=Integer.parseInt(input);
			else
				eingabe = 3;
		

		 switch(eingabe)
		 {
		 	 case 0: return null;
			 case 1:
			 {
				System.out.println("Geben Sie den Suchbegriff ein: ");
				String search = read.next();
				search_entry = hashtable_name.search(search, false);
				 
			 }
				 ;break ; 
			 case 2:
			 {
				System.out.println("Geben Sie den Suchbegriff ein: ");
				String search = read.next();
				search_entry = hashtable_kuerzel.search(search, true);
			 }
				 ;break;
			 default:System.out.println("** Ungültige Eingabe! **\n");break;
		 } 		

		}while(eingabe<0||eingabe>2);
		return search_entry;
	}
	
	
	
	// Aktie löschen
	// Eingabe des Löschbegriffs und anschließendes Löschen in beiden Hashtabellen
	// Wird in der Namen-Hashtabelle gelöscht, wird das Kürzel als String ausgegeben.
	// Mit diesem String kann dann in der Kürzel-Hashtabelle gelöscht werden
	// Umgekehrt genauso.
	
	public void delete(Hashtable hashtable_name, Hashtable hashtable_kuerzel) {
		int eingabe=0;
		
		do{
			System.out.print(
					  "\n_________________________"
					+ "\n|Abbruch             (0)|"
					+ "\n|Löschen nach Namen  (1)|"
					+ "\n|Löschen nach Kürzel (2)|"
					+ "\n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯"
					+ "\nEingabe:");
			 
			 String regx="[0-2]";
				String varstring_input = read.next();
				if(varstring_input.matches(regx))
					eingabe=Integer.parseInt(varstring_input);
				else
					eingabe = 3;
				 

				 switch(eingabe)
				 {
				 	 case 0: return; 
					 case 1:
					 {
						System.out.println("Geben Sie den Löschbegriff ein: ");
						String loeschbegriff = read.next();
						String kuerzel = hashtable_name.delete(loeschbegriff, false);
						if(kuerzel == "") System.out.println("Aktie nicht gefunden");
						String name = hashtable_kuerzel.delete(kuerzel, true);
						if(name == "") System.out.println("Aktie nicht gefunden");
						kuerzel = null;
						name = null;
					 }
						 ;break ; 
					 case 2:
					 {
						System.out.println("Geben Sie den Löschbegriff ein: ");
						String loeschbegriff = read.next();
						String name = hashtable_kuerzel.delete(loeschbegriff, true);
						if(name == "") System.out.println("Aktie nicht gefunden");
						String kuerzel = hashtable_name.delete(name, false);
						if(kuerzel == "") System.out.println("Aktie nicht gefunden");
						kuerzel = null;
						name = null;
					 }
						 ;break;
					 default:System.out.println("** Ungültige Eingabe! **\n");break;
				 } 		

				}while(eingabe<0||eingabe>2);
		

	}
	
}
