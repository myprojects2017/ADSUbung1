
public class DrawClass {
	public void plot(Aktie aktie) 
	{		
		double vardouble_max=0;
		double vardouble_min=0; 
		String[][] varstringarray_feld = new String[17][31];
		
		if(aktie!=null && aktie.getdaten()!=null){
			double[] vararray_temp=aktie.getdaten();
			for(int i=0;i<30;i++)
			{
				if(vararray_temp[i]>vardouble_max){
					vardouble_min=vardouble_max;
					vardouble_max=vararray_temp[i];
				}
				else if(vararray_temp[i]<vardouble_min)
					vardouble_min=vararray_temp[i];
			}
			
			double vardouble_diff=vardouble_max-vardouble_min;
			
			//berechnen wo welches hineinkommt
			for(int k=0;k<30;k++)
			{ 
				double vardouble_temp = vardouble_max-vararray_temp[k];
				if(vardouble_temp>(vardouble_diff/2))
				{
					vardouble_temp=vardouble_temp-(vardouble_diff/2);
					vardouble_temp=vardouble_temp/(vardouble_diff/16);
				
					varstringarray_feld[(int)(8-vardouble_temp)][k]="*";
				}
				else{
					vardouble_temp=(vardouble_diff/2)-vardouble_temp;
					vardouble_temp=vardouble_temp/(vardouble_diff/16);	
					varstringarray_feld[(int)(16-vardouble_temp)][k]="*";				
				}								  
			}
			
			int[] varintarray_temp = new int[31];
			for(int i=16;i>0;i--)
			{ 
				//Aktienwert
				for(int j=0;j<30;j++)
				{			   					
					if(varstringarray_feld[i][j]!=null|| varintarray_temp[j]==1){
						System.out.print("|");
						varintarray_temp[j]=1;
					}
					else 
						System.out.print(" "); 
				} 	
				
				//Nach Aktienwert 
				if(i==1)  
					System.out.println("\n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
				else
					System.out.println("");
			}
			
			for(int j=0;j<30;j++)
			{	
				System.out.println(j+": "+vararray_temp[j]);
			} 
			
		}
		else 
			System.out.println("** Grafik wurde nicht gezeichnet ! **");		
	}
}