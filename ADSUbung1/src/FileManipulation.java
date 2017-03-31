import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 

/*
 * In dieser Klasse erfoleng die Funktionen "load,save,import"
 * */
public class FileManipulation {
   
	//Daten aus der KÜRZEL.csv laden
	public void import_file(Aktie aktie)
	{	
		BufferedReader var_br = null;
        String line = "";
        int varint_count=0;
        int status=0;
        try {          	
        	var_br = new BufferedReader(new InputStreamReader(
                    this.getClass().getResourceAsStream("/resources/"+aktie.getkuerzel()+".csv"))); 
            try {
				while ((line = var_br.readLine()) != null) { 
				    // use comma as separator
				    String[] varstring_temp = line.split(",");  
				    
				    if(varint_count>0) //überspringen das erste weill im ersten durchlauf "High" drinnen steht
				    	{
				    	aktie.setdate(varint_count-1,varstring_temp[0]);

				    	for(int i = 0; i< 6; i++)
					    	{
					    	aktie.setdaten(i,varint_count-1,Double.parseDouble(varstring_temp[i+1]));
					    	}
				    	}
				    varint_count++;  		 	   
				}
				status=1;
			} catch (IOException e) {
				System.out.println("** Fehler ! (FC_ioexc) **"); //EXCEPTION: FileClass() =FC, ioexc = IOEXCEPTION
			}

        } catch (NullPointerException e) {
        	System.out.println("** Fehler: Datei wurde nicht gefunden ! **");
        	status=0;
        } finally {
            if (var_br != null) {
                try {
                	var_br.close();
                } catch (Exception e) {
                	System.out.println("** Fehler ! (FC_br_close) **");
                }
            }
        }
		 
		if(status==1)
		{
			 System.out.println("** Die Datensätze wurden importiert! **");		
			 aktie.setimp();
		}
	}	

	
}