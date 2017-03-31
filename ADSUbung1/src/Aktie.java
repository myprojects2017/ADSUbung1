
public class Aktie {
	
	String name;
	String kuerzel;
	String wkn;
	Boolean imp = false;
	String[] date = new String[30];
	double[][] vararray_daten= new double[6][30]; 
	
	
	public void aktie_name(String eingabe)
	{
		name = eingabe;
	}
	
	public void aktie_wkn(String eingabe_wkn)
	{
		wkn = eingabe_wkn;
	}
	
	public void aktie_kuerzel(String eingabe)
	{
		kuerzel = eingabe;
	}
	
	public String getname()
	{
		return name;
	}
	
	public String getwkn()
	{
		return wkn;
	}
	
	public String getkuerzel()
	{
		return kuerzel;
	}
	
	public double[][] getdaten()
	{
		/*AVG berechnen, da array mit 0.0 steht, und es sonst an plot() übergibt
		 * */
		double vardouble_avg=0;
		for(int i=0;i<30;i++)
		{	
			vardouble_avg+=vararray_daten[1][i];
		}
		
		if((vardouble_avg/31)!=0) //AVG des Arrays!=0
			return vararray_daten;
		else
			return null;
	}
	
	public void setdaten(int a, int i, double val) {
		
		vararray_daten[a][i]=val;
	}
	
	public double getdataentry(int a, int i)
	{
		return vararray_daten[a][i];
	}
	
	public void setdate(int i, String a)
	{
		date[i] = a;
	}
	
	public String getdate(int i)
	{
		return date[i];
	}
	
	public void setimp()
	{
		imp = true;
	}

		
	public void printAktie()
	{
		if(getname() != null)
		{
		System.out.println("-----------------------");
		System.out.println("Name: " + getname());
		System.out.println("WKN: " + getwkn());
		System.out.println("Kürzel: " + getkuerzel());
		if(imp == true)
		{
			System.out.println("");
			System.out.println("Aktueller Kurseintrag:");
			System.out.println("");
			System.out.println("Date: " + getdate(0));
			System.out.println("Open: " + getdataentry(0,0));
			System.out.println("High: " + getdataentry(1,0));
			System.out.println("Low: " + getdataentry(2,0));
			System.out.println("Close: " + getdataentry(3,0));
			System.out.println("Volume: " + getdataentry(2,0));
			System.out.println("Adj-Close: " + getdataentry(3,0));
		}
		System.out.println("-----------------------");
		}
	}



}
