import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;


public class SaveLoad {
	private static final String CSV_SEPARATOR = ",";
	
	public void save(String name_csv, Hashtable hashtable_name, Hashtable hashtable_acronym)
	{	
		// für Kürzel + Name Hashtabelle
		for(int j = 0; j < 2; j++)
		{
			try
		    {
				BufferedWriter bw;
				
				// Auswahl ob nach Kürzel oder Namen gesucht wird
				if(j==0)
				{
					bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/hashtable/"+name_csv+"_name.csv"), "UTF-8"));
				}
				else
				{
					bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/hashtable/"+name_csv+"_kuerzel.csv"), "UTF-8"));	
				}
				
		        // Alle 1019 Einträge durchgehen
				for (int i =0; i < 1019; i++)
		        {
		            StringBuffer oneLine = new StringBuffer();
		            Aktie entry = new Aktie();
		            
		            // Auswahl ob in Namen oder Kürzel Hashtabelle gesucht wird
		            if(j==0) entry = hashtable_name.getEntry(i);
		            else entry = hashtable_acronym.getEntry(i);
		            
		            // Falls Eintrag ungleich null, wird Name, Kürzel, WKN und Import (true,false) hineingeschrieben
		            if(entry != null)
		            {	            
		            oneLine.append(entry.getName().trim().length() == 0? "" : entry.getName());
		            oneLine.append(CSV_SEPARATOR);
		            oneLine.append(entry.getWKN().trim().length() == 0? "" : entry.getWKN());
		            oneLine.append(CSV_SEPARATOR);
		            oneLine.append(entry.getKuerzel().trim().length() == 0? "" : entry.getKuerzel());
		            oneLine.append(CSV_SEPARATOR);
		            
		            oneLine.append(entry.getImp() ? "true" : "false");
		            bw.write(oneLine.toString());
		            bw.newLine();
		            }
		            // Falls nichts in der Hashtabelle gespeichert ist, werden Leerzeichen ausgegeben
		            else 
		            {
		            	oneLine.append(" ");
		            	oneLine.append(CSV_SEPARATOR);
		            	oneLine.append(" ");
		            	oneLine.append(CSV_SEPARATOR);
		            	oneLine.append(" ");
		            	oneLine.append(CSV_SEPARATOR);
		            	oneLine.append(" ");
		            	bw.write(oneLine.toString());
			            bw.newLine();
		            }
		        }
		        bw.flush();
		        bw.close();
		    }
		    catch (UnsupportedEncodingException e) {}
		    catch (FileNotFoundException e){}
		    catch (IOException e){}
		}
		
	}
	
	public void load(String name_csv, Hashtable hashtable_name, Hashtable hashtable_acronym)
	{	
        for(int j = 0 ; j < 2; j++)
        {
		BufferedReader var_br = null;
        String line = "";
        int varint_count=0;
        

	        try
	        {
	        	if(j==0)
	        	{
	        		var_br = new BufferedReader(new InputStreamReader(
	                    this.getClass().getResourceAsStream("/hashtable/"+name_csv+"_name.csv")));
	        	}
	        	else 
	        	{
	        		var_br = new BufferedReader(new InputStreamReader(
		                    this.getClass().getResourceAsStream("/hashtable/"+name_csv+"_kuerzel.csv")));
	        	}
	        	try
	        	{
	        		while ((line = var_br.readLine()) != null) { 
					    // use comma as separator
					    String[] varstring_temp = line.split(CSV_SEPARATOR);  
					    
					    // Falls Läneg des ersten Eintrag größer 1 (also kein Leerzeichen), werden die 
					    // Einträge als Aktien Objekt gespeichert und in die Hashtabelle geschrieben
					    if(varstring_temp[0].length() > 1)
					    {
					    	Aktie entry = new Aktie();
					    	entry.setName(varstring_temp[0]);
					    	entry.setWKN(varstring_temp[1]);
					    	entry.setKuerzel(varstring_temp[2]);
					    	
					    	// falls letzter Eintrag true, werden zusätzlich die Kursdaten importiert
					    	if(varstring_temp[3].length() == 4)
					    	{
					    		entry.setImp();
					    		Import import_entry = new Import();
					    		import_entry.import_file(entry);
					    	}
					    	
					    	if(j==0)
					    	{
					    		hashtable_name.setEntry(varint_count, entry);
					    	}
					    	else
					    	{
					    		hashtable_acronym.setEntry(varint_count, entry);
					    	}
					    }
					    	
					    // Sonst wird der jeweilige Index der Hashtabelle null gesetzt
					    else
					    {
					    	if(j==0)
					    	{
					    		hashtable_name.setNull(varint_count);
					    	}
					    	else
					    	{
					    		hashtable_acronym.setNull(varint_count);
					    	}
					    }
	
					    varint_count++;  		 	   
					}
	
	        		
	        	}
	        	catch (IOException e) 
	        	{
					System.out.println("** Fehler ! (FC_ioexc) **"); //EXCEPTION: FileClass() =FC, ioexc = IOEXCEPTION
				}
	        	
	        }     
	        catch(NullPointerException e)
	        {
	        	System.out.println("** Fehler: Datei wurde nicht gefunden ! **");
	        }
        }
    }
}
