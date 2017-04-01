import java.util.Scanner;

// Mithilfe dieser Klasse kann eine Hashtabelle erstellt werden
// Sie bietet außerdem Möglichkeiten, Bearbeitung in dieser einen Hashtabelle mittels Add, Search and Delete durchzuführen
public class Hashtable {
	
	Scanner read = new Scanner(System.in);
	private Aktie[] hashtable = null;
	private int fuellgrad = 0;
	private int anzahl = 0;
	
	// Konstruktor
	public Hashtable()
	{
		hashtable = new Aktie[1019];
	}
	
	// Eintrag auslesen (ist ein Objekt der Klasse Aktie)
	public Aktie getEntry(int entry)
	{
		return hashtable[entry];
	}
	
	// Einen Eintrag an einen bestimmten Index setzen
	public void setEntry(int entry, Aktie aktie)
	{
		hashtable[entry] = aktie;
		System.out.println("Die Aktie " + aktie.getName() + " wurde unter " + entry + " hinzugefügt");
	}
	
	// Referenz löschen
	public void setNull(int entry)
	{
		hashtable[entry] = null;
	}
	
	// Hashfunktion um aus String integer Wert zu generieren
	// Falls negativ, wird mit -1 multipliziert
	
	public int hashFunction(String aktie)
	{
		int index = 0;
		index = aktie.hashCode() % 1019;
		if(index<0) index = index*(-1);
		return index;
	}
	
	
	// Richtige Methode der Klasse Aktie aufrufen, je nachdem ob kuerzel true, false
	public String getFunction(Aktie aktie, Boolean kuerzel)
	{
		if(kuerzel == false)
		{
			return aktie.getName();
		}
		
		else 
		{
			return aktie.getKuerzel();
		}
		
	}
	
	// Eintrag hinzufügen in dieser Hashtabelle
	// type - Definieren ob nach Kürzel oder Namen geaddet wird
	// type true: Kürzel, sonst Name
	
	public void add(String name, Aktie aktie, Boolean type)
	{
		fuellgrad = (anzahl/1019)*100;
		int sondierung = 0;
		
		if(fuellgrad < 100)
		{
			int index_entry = hashFunction(name);
			int index_entry_neu = index_entry;
			
				// Solange suchen, bis Hashtabellen-Eintrag null
				while(getEntry(index_entry_neu) != null)
				{
					// Berechnung des Index
					index_entry_neu = (int) (index_entry + Math.pow(sondierung,2));
					
					// Um im Indizes von 0 - 1018 zu bleiben
					if(index_entry_neu > 1018) 
					{
						index_entry_neu = index_entry_neu % 1018;
					}

					Aktie entry = getEntry(index_entry);
					String entry_name;
					
					entry_name = getFunction(entry,type);
				
					// Wenn Name bereits vorhanden: Errormeldung und Verlassen der Funktion
					// Sonst Sondierung um 1 Erhöhen
					if(name.equals(entry_name))
					{
						System.out.println("Aktie wurde bereits hinzugefügt");
						return;
					}	
					else sondierung = sondierung + 1;
				}
				// Eintrag hineinspeichern und anzahl erhöhen
				setEntry(index_entry_neu, aktie);
				anzahl = anzahl + 1;
		}
		
		else
		{
			System.out.println("Hashtabelle ist voll.");
		}
	}
		

	
	// In dieser Hastabelle nach String suchen und Objekt zurückliefern
	// type - Definieren ob nach Kürzel oder Namen geaddet wird
	
	public Aktie search(String search, Boolean type)
	{
		int sondierung = 0;
		
		// Berechnen des Index mittels Hashfunktion
		int index_entry = hashFunction(search);
		int index_entry_neu = index_entry;
		
			while(getEntry(index_entry_neu) != null)
			{				
				
				index_entry_neu = (int) (index_entry + Math.pow(sondierung,2));
				if(index_entry_neu > 1018) 
				{
					index_entry_neu = index_entry_neu % 1018;
				}
				Aktie entry = getEntry(index_entry_neu);
				
				String entry_name;
				
				if(entry != null)
				{
				
					entry_name = getFunction(entry,type);
					
					
					if(search.equals(entry_name))
					{
						System.out.println("Aktie "+entry_name+" wurde im Index "+index_entry_neu+" gefunden");
						return entry;
					}
					
					else sondierung = sondierung + 1;
				}

			}
			System.out.println("Aktie nicht gefunden");		
			return null;
	}
	
	
	
	// In dieser Hashtabelle nach String suchen und löschen
	
	public String delete(String name, Boolean kuerzel)
	{
		int sondierung = 0;
		
		// Wenn Eintrag gefunden -> true
		Boolean found=false;

		int index_entry = hashFunction(name);
		int index_entry_neu = index_entry;
		
		// Speichern des Objekts, wenn der richtige Eintrag gefunden wurde
		Aktie rueckgabe = new Aktie();
		
		// Index, falls etwas gefunden wird
		int sondierung_delete = 0;
		
		
		// Wie Suchfunktion, nur dass Index und Objekt gespeichert werden,
		// wenn der richtige Eintrag gefunden wird
		
		while(getEntry(index_entry_neu) != null)
		{				
			
			index_entry_neu = (int) (index_entry + Math.pow(sondierung,2));
			if(index_entry_neu > 1018) 
			{
				index_entry_neu = index_entry_neu % 1018;
			}
			
			Aktie entry = getEntry(index_entry_neu);
			
			String entry_name;
			
			if(entry != null)
			{
			
				entry_name = getFunction(entry,kuerzel);
			
				if(name.equals(entry_name))
				{
					sondierung_delete = sondierung;
					System.out.println("Aktie "+entry_name+" wurde im Index "+index_entry_neu+" gefunden");
					rueckgabe = getEntry(index_entry_neu);
					found = true;
					
				}
				sondierung = sondierung + 1;
			}

		}
		
		// Wenn etwas gefunden wurde
		if(found == true)
			{
			
			int last_element = index_entry;
			// Nachrücken der Elemente, welche mit dem gefunden Eintrag im Hashwert übereinstimmen
			for(int i = sondierung_delete; i<(sondierung-1); i++)
			{
					int index_vorher = (int) (index_entry+ (Math.pow((i),2)) );
					
					Aktie vorher = getEntry(index_vorher);		
					String string_vorher = getFunction(vorher, kuerzel);		
					int hashcode_vorher = hashFunction(string_vorher);
					
					// Nur wenn Hashcode des ersten Eintrags gleich dem Hashcode des zu löschenden Elements ist
					if(hashcode_vorher == index_entry)
					{
						int a = 1;
						int index_nachher = (int) (index_entry+ (Math.pow((i+1),2)) );
						Aktie nachher = new Aktie();
						String string_nachher;
						int hashcode_nachher = 0;
						
						// Finden des nächsten Elements mit dem selben Hashcode, nach quadratischer Sondierung weiterrücken
						while((hashcode_nachher != index_entry) && (a <= (sondierung-1)))
						{
						index_nachher = (int) (index_entry+ (Math.pow((i+a),2)) );
						nachher = getEntry(index_nachher);
						string_nachher = getFunction(nachher, kuerzel);
						hashcode_nachher = hashFunction(string_nachher);
						a = a + 1;							
						}
						
						if(hashcode_nachher == index_entry)
						{			
						// Überschreiben des vorherigen Elements mit dem nächsten nachher						
						setEntry(index_vorher,nachher);
						last_element = index_nachher;
						}
						
						vorher = null;
						nachher = null;
						string_vorher = null;
						string_nachher = null;
					}
				
			}
			
			// Referenz im letzten Glied der Kette löschen und Anzahl erniedrigen
			setNull(last_element);
			anzahl = anzahl - 1;
			
			
			System.out.println("Löschen von " + (last_element));
			
			// Rückgabe des Kürzels/Namens als String
			String ausgabe;
			if(kuerzel == false)
			{
				ausgabe = rueckgabe.getKuerzel();
			}
			else 
			{
				ausgabe = rueckgabe.getName();
			}
			rueckgabe = null;
			return ausgabe;
		}
		else 
			{
			return "";
			}

	}
	

}
