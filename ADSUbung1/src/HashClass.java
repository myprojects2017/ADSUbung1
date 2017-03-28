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
		if(index<0) index = index*(-1);
		return index;
	}
	
	// type - Definieren ob nach Kürzel oder Namen geaddet wird
	public void add(String name, Aktie aktie, Boolean type)
	{
		fuellgrad = (anzahl/1019)*100;
		int sondierung = 0;
		
		if(fuellgrad < 100)
		{
			int index_entry = hashFunction(name);
			int index_entry_neu = index_entry;
			
				while(getEntry(index_entry_neu) != null)
				{
					index_entry_neu = index_entry + (sondierung*sondierung);
					sondierung = sondierung + 1;

					Aktie entry = getEntry(index_entry);
					String entry_name;
					
					// Wenn type = false -> nach Namen vergleichen
					if(type == false)
					{
					entry_name = entry.getname();
					}
					
					// Wenn type = true -> nach Kuerzel vergleichen
					else 
					{
					entry_name = entry.getkuerzel();
					}
				
					if(name.equals(entry_name))
					{
						System.out.println("Aktie wurde bereits hinzugefügt");
						return;
					}						
				}
				
				setEntry(index_entry_neu, aktie);
				anzahl = anzahl + 1;
		}
		
		else
		{
			System.out.println("Hashtabelle ist voll.");
		}
	}
		

	
	/*Übernahme des Namens oder Kürzels aus dem Menue
	von hier an search_name oder search_acronym übergen*/
	public void search(Boolean type)
	{
		int sondierung = 0;
		
		System.out.println("Geben Sie den Suchbegriff ein: ");
		String search = read.next();
		
		int index_entry = hashFunction(search);
		System.out.println(index_entry);
		int index_entry_neu = index_entry;
		
			while(getEntry(index_entry_neu) != null)
			{				
				
				index_entry_neu = index_entry + (sondierung*sondierung);
				Aktie entry = getEntry(index_entry_neu);
				
				String entry_name;
				
				// Wenn type = false -> nach Namen vergleichen
				if(type == false)
				{
				entry_name = entry.getname();
				}
				
				// Wenn type = true -> nach Kuerzel vergleichen
				else 
				{
				entry_name = entry.getkuerzel();
				}
				
				if(search.equals(entry_name))
				{
					System.out.println("Aktie "+entry_name+" wurde im Index "+index_entry_neu+" gefunden");
					return;
				}
				
				else
				{
					sondierung = sondierung + 1;
				}

			}
			System.out.println("Aktie nicht gefunden");		
	}
	

}
