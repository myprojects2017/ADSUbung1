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
	double[] varstringarray_csv= new double[31]; //.csv --> array --> für ausgabe (plot = zeichnen/graph)

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
        int varint_count=0;
        try {          	
        	var_br = new BufferedReader(new InputStreamReader(
                    this.getClass().getResourceAsStream("/resources/"+varstring_acronym+".csv"))); 
            try {
				while ((line = var_br.readLine()) != null) { 
				    // use comma as separator
				    String[] varstring_temp = line.split(",");  
				    
				    if(varint_count>0)  //überspringen das erste weill im ersten durchlauf "High" drinnen steht
				    	varstringarray_csv[varint_count-1]=Double.parseDouble(varstring_temp[2]); //laut .csv ist der 2 eintrag der Tageshöchstwert
					
				    varint_count++; 
 			   
				  //  Ausgabe als List (für Testzwecke)
//				    System.out.println(varstring_temp[0]+" | "+varstring_temp[1]+" | "+varstring_temp[2]+" | "+
//				    		varstring_temp[3]+" | "+varstring_temp[4]+" | "+varstring_temp[5]+" | "+varstring_temp[6]);
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

	public int plot(String varstring_acronym) 
	{
			//ruft import auf, könnte sein das im array alte Daten stehen => UPDATE
			if(import_file(varstring_acronym)==0){
	    		System.out.println("** Fehler: Grafik nicht darstellbar ! **");
				return 0;
			}	
			else
			{  
				//Höchstwert bekommen == ArrayHöche;
				double vardouble_high=0;
				for(int i=0;i<30;i++)
				{  
					if(varstringarray_csv[i]>vardouble_high)
						vardouble_high=varstringarray_csv[i];	
//					System.out.println(vardouble_high+"|"+varstringarray_csv[i]);
//					System.out.println(vardouble_high);
				}
				
//				
				//AUSGABE
				String[][] vardoublearray_draw = new String[1000][31];
				
				for(int j=0;j<30;j++){
					int varint_temp =(int)(varstringarray_csv[j]);
					vardoublearray_draw[varint_temp][j]="*";
				}
				
				int x=1;
				for(double j=vardouble_high;j>0;j--){
					System.out.print(j+" | ");
					for(int i=x;i<30;i++){
						if(vardoublearray_draw[(int)j][i]!=null)
							System.out.print("*");
						
					} 
					x++;
					System.out.println("");
				} 
								
				/*
				 * *************************************
				 * hier die darstellung !!!!
				 * 
				 * 
				 * 
				 */
			
			}		
		
		return 1;
	}

}