import java.util.Scanner;

/*
 * In dieser Klasse werden die Eingaben (Name,Kürzel) gehasht und in das dazu gehörige Array gespeichert
 * */
public class HashClass {
	
	Scanner read = new Scanner(System.in);
	Aktie[] hashtable = null;
	int fuellgrad = 0;
	int anzahl = 0;
	
	// Konstruktor
	public HashClass()
	{
		hashtable = new Aktie[1019];
	}
	
	// Eintrag auslesen (ist ein Objekt der Klasse Aktie)
	public Aktie getEntry(int entry)
	{
		return hashtable[entry];
	}
	
	public void setEntry(int entry, Aktie aktie)
	{
		hashtable[entry] = aktie;
		System.out.println("Die Aktie " + aktie.getname() + " wurde unter " + entry + " hinzugefügt");
	}
	
	
	public int hashFunction(String aktie)
	{
		int index = 0;
		index = aktie.hashCode() % 1019;
		return index;
	}
	

	public void add(String name, Aktie aktie)
	{
		fuellgrad = (anzahl/1019)*100;
		int sondierung = 0;
		
		if(fuellgrad < 100)
		{
			int index_entry = hashFunction(name);
			
				while(getEntry(index_entry) != null)
				{
					index_entry = index_entry + (sondierung*sondierung);
					Aktie entry = getEntry(index_entry);
					String entry_name = entry.getname();
				
					if(entry_name == name)
					{
						System.out.println("Aktie wurde bereits hinzugefügt");
						return;
					}
					else
					{
						sondierung = sondierung + 1;
					}
				}
				
				setEntry(index_entry, aktie);
				anzahl = anzahl + 1;
		}
		
		else
		{
			System.out.println("Hashtabelle ist voll.");
		}
	}
		

	
	/*Übernahme des Namens oder Kürzels aus dem Menue
	von hier an search_name oder search_acronym übergen*/
	public int search()
	{
		int varint_eingabe=0;
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
		 	 case 0:return 0;
			 case 1://weiter Funktion
				 ;break;
			 case 2://weitere Funktion
				 ;break;
			 default:System.out.println("** Ungültige Eingabe! **\n");break;
		 } 			 
		}while(varint_eingabe<0||varint_eingabe>2);
		return 0;
			
	}
	//Suche nach Namen
	private void search_name(String varstring_name)
	{
		
	}
	
	//Suche nach Kürzel
	private void search_acronym(String varstring_acronym)
	{
		
	}

}
