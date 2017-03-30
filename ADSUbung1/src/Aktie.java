
public class Aktie {
	
	String name;
	String kuerzel;
	int wkn;
	double[] vararray_daten= new double[31]; 
	
	
	public void aktie_name(String eingabe)
	{
		name = eingabe;
	}
	
	public void aktie_wkn(int eingabe_wkn)
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
	
	public int getwkn()
	{
		return wkn;
	}
	
	public String getkuerzel()
	{
		return kuerzel;
	}
	
	public double[] getdaten()
	{
		return vararray_daten;
	}
	
	public void setdaten(int i,double val)
	{
		vararray_daten[i]=val;
	}
		
	public void printAktie()
	{
		if(getname() != null)
		{
		System.out.println("-----------------------");
		System.out.println("Name: " + getname());
		System.out.println("WKN: " + getwkn());
		System.out.println("Kürzel: " + getkuerzel());
		System.out.println("-----------------------");
		}
	}

}
