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
  
	//Aktien aus .csv/txt/... laden
	public void load_file()
	{
		
	}
	
	//Aktien in .csv/txt/... speichern
	public void save_file()
	{
		
	}	

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
				    	aktie.setdaten(varint_count,Double.parseDouble(varstring_temp[2]));
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
			 System.out.println("** Die Datensätze wurden importiert! **");		
	}	

	public void plot(Aktie aktie) 
	{
		
		if(aktie!=null){
			double[] vararray_temp=aktie.getdaten();
			for(int i=0;i<30;i++)
			{
				System.out.println(vararray_temp[i]);
			}
		}
		else
		{
			System.out.println("** Grafik wurde nicht gezeichnet ! **");
		}
		
		
		
	}
}