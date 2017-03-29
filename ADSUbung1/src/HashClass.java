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
	
	public void setNull(int entry)
	{
		hashtable[entry] = null;
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
						System.out.println("Aktie wurde bereits hinzugefügt");
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
		

	
	/*Übernahme des Namens oder Kürzels aus dem Menue
	von hier an search_name oder search_acronym übergen*/
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
	
	public void delete(String name, Boolean kuerzel)
	{
		int sondierung = 0;

		int index_entry = hashFunction(name);
		int index_entry_neu = index_entry;
		int index_entry_vergleich = index_entry;
		
		int sondierung_delete = 0;
		
		while((getEntry(index_entry_neu) != null) && (index_entry_vergleich == index_entry) )
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
			
				// Wenn type = false -> nach Namen vergleichen
				if(kuerzel == false)
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
			
			
				if(name.equals(entry_name))
				{
					sondierung_delete = sondierung;
					System.out.println("Aktie "+entry_name+" wurde im Index "+index_entry_neu+" gefunden");
					
				}
				sondierung = sondierung + 1;
			}

		}
		
		for(int i = sondierung_delete; i<(sondierung-1); i++)
		{
			int index_nachher = (int) (index_entry+(Math.pow((i+1),2)));
			
			int index_vorher = (int) (index_entry+(Math.pow((i),2)));
			
			Aktie tmp = getEntry(index_nachher);
			
			setEntry(index_vorher,tmp);
			
			System.out.println("Überschreiben von Eintrag" + index_vorher + "mit" + index_nachher);
		}
		setNull(index_entry + sondierung_delete);
		System.out.println("Null-Setzen von " + (index_entry + sondierung_delete));

	}
	

}
