import java.util.Scanner;

/*
 * Diese Klasse enthält die Funktion "ADD und DELETE"
 * */
public class Manipulation {
	Scanner read = new Scanner(System.in);

	//Aktie hinzufügen
	public void add(HashClass hashtable_name, HashClass hashtable_kuerzel)
	{
		Aktie aktieadd = new Aktie();
		
		System.out.println("Geben Sie den Namen der Aktie ein: ");
		String eingabe_name = read.next(); 
		aktieadd.aktie_name(eingabe_name);
		
		System.out.println("Geben Sie die Wertpapier-Kennnummer (WKN) ein: ");
		String scan = read.next();
		int eingabe_wkn = Integer.parseInt(scan);
		aktieadd.aktie_wkn(eingabe_wkn);
		
		System.out.println("Geben Sie das Kürzel der Aktie ein: ");
		String eingabe_kuerzel = read.next(); 
		aktieadd.aktie_kuerzel(eingabe_kuerzel);
		
		// In die Namens-Hashtabelle adden
		hashtable_name.add(aktieadd.getname(), aktieadd, false);
		
		// In die Kürzel-Hashtabelle adden
		hashtable_kuerzel.add(aktieadd.getkuerzel(), aktieadd, true);
	}
	
	public Aktie search(HashClass hashtable_name, HashClass hashtable_kuerzel)
	{
		int varint_eingabe=0;
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
		 String varstring_regx="[0-2]";
			String varstring_input = read.next();
			if(varstring_input.matches(varstring_regx))
				varint_eingabe=Integer.parseInt(varstring_input);
			else
				varint_eingabe = 3;
		

		 
		 //Handeln je nach Benutzereingabe
		 switch(varint_eingabe)
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

		}while(varint_eingabe<0||varint_eingabe>2);
		return search_entry;
	}
	
	//Aktie löschen
	public void delete(HashClass hashtable_name, HashClass hashtable_kuerzel) {
		int varint_eingabe=0;
		
		do{
			System.out.print(
					  "\n_________________________"
					+ "\n|Abbruch             (0)|"
					+ "\n|Löschen nach Namen  (1)|"
					+ "\n|Löschen nach Kürzel (2)|"
					+ "\n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯--"
					+ "\nEingabe:");
			 
			//wie im Hauptmenü = Regx überprüfung
			 String varstring_regx="[0-2]";
				String varstring_input = read.next();
				if(varstring_input.matches(varstring_regx))
					varint_eingabe=Integer.parseInt(varstring_input);
				else
					varint_eingabe = 3;
				 
				 //Handeln je nach Benutzereingabe
				 switch(varint_eingabe)
				 {
				 	 case 0: return; 
					 case 1:
					 {
						System.out.println("Geben Sie den Löschbegriff ein: ");
						String loeschbegriff = read.next();
						String kuerzel = hashtable_name.delete(loeschbegriff, false);
						if(kuerzel == "") System.out.println("Aktie nicht gefunden");
						String name = hashtable_kuerzel.delete(kuerzel, true);
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
						kuerzel = null;
						name = null;
					 }
						 ;break;
					 default:System.out.println("** Ungültige Eingabe! **\n");break;
				 } 		

				}while(varint_eingabe<0||varint_eingabe>2);
		
		
	 	
	}
	
	public void save(HashClass name, HashClass kuerzel)
	{
		/*
		for(int i=0;i<1019;i++)
		{
		Aktie eintrag = name.getEntry(10);
			String name1 = eintrag.getname();
			String kuerz1 =	eintrag.getkuerzel();
			int wert1 =	eintrag.getwkn();
		}
		*/
		
	}
}
