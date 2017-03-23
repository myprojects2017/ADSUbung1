import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader; 

/*
 * In dieser Klasse erfoleng die Funktionen "load,save,import"
 * */
public class FileManipulationClass {
	
	/*Die Abfrage nach dem namen erfolgt in den Funktionen
	 * (call by name)*/
	
	//Aktien aus .csv/txt/... laden
	public void load_file()
	{
		
	}
	
	//Aktien in .csv/txt/... speichern
	public void save_file()
	{
		
	}	

	//Daten aus der KÜRZEL.csv laden
	public int import_file(String varstring_acronym)
	{		
		BufferedReader var_br = null;
        String line = "";
        try {          	
        	var_br = new BufferedReader(new InputStreamReader(
                    this.getClass().getResourceAsStream("/resources/"+varstring_acronym+".csv"))); 
            try {
				while ((line = var_br.readLine()) != null) { 
				    // use comma as separator
				    String[] varstring_temp = line.split(",");  
				    
				    System.out.println(varstring_temp[0]+" | "+varstring_temp[1]+" | "+varstring_temp[2]+" | "+
				    		varstring_temp[3]+" | "+varstring_temp[4]+" | "+varstring_temp[5]+" | "+varstring_temp[6]);
				    
				}
			} catch (IOException e) {
				System.out.println("** Fehler ! (FC_ioexc) **"); //EXCEPTION: FileClass() =FC, ioexc = IOEXCEPTION
			}

        } catch (NullPointerException e) {
    		System.out.println("** Fehler: Datei wurde nicht gefunden ! **");
    		return 0; //Datei existiert nicht
        } finally {
            if (var_br != null) {
                try {
                	var_br.close();
                } catch (Exception e) {
                	System.out.println("** Fehler ! (FC_br_close) **");
                }
            }
        }
		 
		return 1;
	}	
}