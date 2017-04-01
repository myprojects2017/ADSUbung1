import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 

// Import-Funktion der Kursdaten der letzen 30 Tage

public class Import {
   
	// Funktion um csv-Daten zu importieren
	
	public void import_file(Aktie aktie)
	{	
		BufferedReader var_br = null;
        String line = "";
        int varint_count=0;
        Boolean status=false;
        try {          	
        	var_br = new BufferedReader(new InputStreamReader(
                    this.getClass().getResourceAsStream("/resources/"+aktie.getKuerzel()+".csv"))); 
            try {
				while ((line = var_br.readLine()) != null) { 
					
				    // Beistrich als Seperator
				    String[] varstring_temp = line.split(",");  
				    
				    // Überspringen der ersten Teile, da in dieser Text steht
				    if(varint_count > 0 && varint_count < 31) 
				    	{
				    	aktie.setDate(varint_count-1,varstring_temp[0]);

				    	for(int i = 0; i< 6; i++)
					    	{
					    	aktie.setDaten(i,varint_count-1,Double.parseDouble(varstring_temp[i+1]));
					    	}
				    	}
				    varint_count++;  		 	   
				}
				status=true;
			} catch (IOException e) {
				System.out.println("** Fehler ! (FC_ioexc) **"); //EXCEPTION: FileClass() =FC, ioexc = IOEXCEPTION
			}

        } catch (NullPointerException e) {
        	System.out.println("** Fehler: Datei wurde nicht gefunden ! **");
        	status=false;
        } finally {
            if (var_br != null) {
                try {
                	var_br.close();
                } catch (Exception e) {
                	System.out.println("** Fehler ! (FC_br_close) **");
                }
            }
        }
		 
		if(status==true)
		{
			 System.out.println("** Die Datensätze wurden importiert! **");		
			 aktie.setImp();
		}
	}	

	
}