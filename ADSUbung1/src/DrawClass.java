
public class DrawClass {
	public void plot(Aktie aktie) 
	{		
		double vardouble_max=0;
		double vardouble_min=0; 
		String[][] matrix = new String[13][30];
		for(int i = 0; i < 13; i++)
		{
			for(int k = 0; k< 30; k++)
			{
				if(i==0)
				{
					matrix[i][k] = "-";	
				}
				else matrix[i][k] = " ";
			}
		}
		
		if(aktie!=null && aktie.getDaten()!=null){
			
			double[][] vararray_temp=aktie.getDaten();
			vardouble_min = vararray_temp[3][10];
			
			for(int i=0;i<30;i++)
			{
				if(vararray_temp[3][i]>vardouble_max){
					vardouble_max=vararray_temp[3][i];
				}
				if(vararray_temp[3][i]<vardouble_min)
				{
					vardouble_min=vararray_temp[3][i];
				}
			}
			
			System.out.println("");
			
			double vardouble_diff=vardouble_max-vardouble_min;
			
			for(int i = 0; i < 30; i++)
			{
				double y_kaestchen = (((vararray_temp[3][i] - vardouble_min)*12)/vardouble_diff); 
				int y = (int) y_kaestchen;
				matrix[y][i] = "*";
			}
			
			String zeile ="";
			
			for(int i = 12; i >= 0; i--)
			{
				for( int j = 0; j < 30; j ++)
				{
					zeile = zeile + matrix[i][j];
				}
				if (i==12) System.out.println("|" + zeile + "    " + vardouble_max);
				else if (i==0) System.out.println("|" + zeile + "    " + vardouble_min);
				else System.out.println("|" + zeile);
				zeile = "";
			}
			System.out.println("");
			System.out.println("Alle Kursdaten der letzten 30 Tage:"); 
			System.out.println("");
			
			for(int j=0;j<30;j++)
			{	
				System.out.println((j+1)+": "+ aktie.getDate(j) + " , " + vararray_temp[0][j] + " , " + vararray_temp[1][j] + " , " + vararray_temp[2][j] + " , " + vararray_temp[3][j] + " , " + vararray_temp[4][j] + " , " + vararray_temp[5][j]);
			} 
			
		}
		else 
			System.out.println("** Grafik wurde nicht gezeichnet ! **");		
	}
}