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
	
	public void save(String name_csv, HashClass hashtable_name, HashClass hashtable_acronym)
	{	
		for(int j = 0; j < 2; j++)
		{
			try
		    {
				BufferedWriter bw;
				if(j==0)
				{
					bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/hashtable/"+name_csv+"_name.csv"), "UTF-8"));
				}
				else
				{
					bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/hashtable/"+name_csv+"_kuerzel.csv"), "UTF-8"));	
				}
				
		        
				for (int i =0; i < 1019; i++)
		        {
		            StringBuffer oneLine = new StringBuffer();
		            Aktie entry = new Aktie();
		            
		            if(j==0) entry = hashtable_name.getEntry(i);
		            else entry = hashtable_acronym.getEntry(i);
		            
		            if(entry != null)
		            {	            
		            oneLine.append(entry.getname().trim().length() == 0? "" : entry.getname());
		            oneLine.append(CSV_SEPARATOR);
		            oneLine.append(entry.getwkn().trim().length() == 0? "" : entry.getwkn());
		            oneLine.append(CSV_SEPARATOR);
		            oneLine.append(entry.getkuerzel().trim().length() == 0? "" : entry.getkuerzel());
		            oneLine.append(CSV_SEPARATOR);
		            
		            oneLine.append(entry.getimp() ? "true" : "false");
		            bw.write(oneLine.toString());
		            bw.newLine();
		            }
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
	
	public void load(String name_csv, HashClass hashtable_name, HashClass hashtable_acronym)
	{	
		BufferedReader var_br = null;
        String line = "";
        int varint_count=0;
        int status=0;
        try
        {
        	var_br = new BufferedReader(new InputStreamReader(
                    this.getClass().getResourceAsStream("/hashtable/"+name_csv+"_name.csv")));
        	try
        	{
        		while ((line = var_br.readLine()) != null) { 
				    // use comma as separator
				    String[] varstring_temp = line.split(",");  
				    
				    //if(varstring_temp[0] != " ")
				    //{
				    System.out.println(varint_count + " , " + varstring_temp[0]);
				   // }


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
