import java.util.Scanner;

/*
 * In dieser Klasse werden die Eingaben (Name,K�rzel) gehasht und in das dazu geh�rige Array gespeichert
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
		System.out.println("Die Aktie " + aktie.getname() + " wurde unter " + entry + " hinzugef�gt");
	}
	
	
	public int hashFunction(String aktie)
	{
		int index = 0;
		index = aktie.hashCode() % 1019;
		if(index<0) index = index*(-1);
		return index;
	}
	
	// type - Definieren ob nach K�rzel oder Namen geaddet wird
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
					index_entry_neu = (int) (index_entry + Math.pow(sondierung,2));
					
					if(index_entry_neu > 1018) 
					{
						index_entry_neu = index_entry_neu % 1018;
					}

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
						System.out.println("Aktie wurde bereits hinzugef�gt");
						return;
					}	
					else sondierung = sondierung + 1;
				}
				
				setEntry(index_entry_neu, aktie);
				anzahl = anzahl + 1;
		}
		
		else
		{
			System.out.println("Hashtabelle ist voll.");
		}
	}
		

	
	/*�bernahme des Namens oder K�rzels aus dem Menue
	von hier an search_name oder search_acronym �bergen*/
	public Aktie search(String search, Boolean type)
	{
		int sondierung = 0;
		Aktie search_entry = new Aktie();
		
		
		int index_entry = hashFunction(search);
		int index_entry_neu = index_entry;
		int index_entry_vergleich = index_entry;
		
			while((getEntry(index_entry_neu) != null) && (index_entry_vergleich == index_entry) )
			{				
				
				index_entry_neu = (int) (index_entry + Math.pow(sondierung,2));
				if(index_entry_neu > 1018) 
				{
					index_entry_neu = index_entry_neu % 1018;
				}
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
				
				// Speichern des HashCodes des betrachteten Eintrags
				index_entry_vergleich = hashFunction(entry_name);
				
				if(search.equals(entry_name))
				{
					System.out.println("Aktie "+entry_name+" wurde im Index "+index_entry_neu+" gefunden");
					return entry;
				}
				
				else sondierung = sondierung + 1;

			}
			System.out.println("Aktie nicht gefunden");		
			return search_entry;
	}
	
	public void delete(Aktie aktie, Boolean kuerzel)
	{
		int sondierung = 0;

	}
	

}
