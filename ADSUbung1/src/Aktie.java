
public class Aktie {
	
	// Variablen der Klasse Aktie
	private String name;
	private String kuerzel;
	private String wkn;
	private Boolean imp = false;
	
	// Kursdaten der letzen 30 Tage
	private String[] date = new String[30];
	
	// Float-Daten werden mittels zweidimensionalen Array gespeichert
	// 0 - 5 Index zu Beginn gibt an, um welchen Kurswert es sich handelt.
	// 0: Open
	// 1: High
	// 2: Low
	// 3: Close
	// 4: Volume
	// 5: Adj Close
	private double[][] vararray_daten= new double[6][30]; 
	
	
	// Speichern der Daten
	public void setName(String eingabe)
	{
		name = eingabe;
	}
	
	public void setWKN(String eingabe_wkn)
	{
		wkn = eingabe_wkn;
	}
	
	public void setKuerzel(String eingabe)
	{
		kuerzel = eingabe;
	}
	
	public void setDaten(int a, int i, double val) {
		
		vararray_daten[a][i]=val;
	}
	
	public void setDate(int i, String a)
	{
		date[i] = a;
	}
	
	// Wird auf true gesetzt, wenn Daten importiert werden
	public void setImp()
	{
		imp = true;
	}
	
	// Rückgabe der Daten
	public String getName()
	{
		return name;
	}
	
	public String getWKN()
	{
		return wkn;
	}
	
	public String getKuerzel()
	{
		return kuerzel;
	}
	
	public Boolean getImp()
	{
		return imp;
	}
	
	public double[][] getDaten()
	{
		//Mittelwert berechnen, da array mit 0.0 steht, und es sonst an plot() übergibt
		double vardouble_avg=0;
		for(int i=0;i<30;i++)
		{	
			vardouble_avg+=vararray_daten[1][i];
		}
		
		// Wenn Mittelwert ungleich 0: Rückgabe des zweidimensionalen Array -> sonst null
		if((vardouble_avg/31)!=0)
			return vararray_daten;
		else
			return null;
	}
	
	// Bestimmten Eintrag im zweidimensionalen Array zurückgeben
	public double getDataEntry(int a, int i)
	{
		return vararray_daten[a][i];
	}
	
	// Datum zurückgeben
	public String getDate(int i)
	{
		return date[i];
	}

	
	// Ausgabe aller Members der Klasse Aktie im Terminal
	public void printAktie()
	{
		if(getName() != null)
		{
		System.out.println("-----------------------");
		System.out.println("Name: " + getName());
		System.out.println("WKN: " + getWKN());
		System.out.println("Kürzel: " + getKuerzel());
		if(imp == true)
		{
			System.out.println("");
			System.out.println("Aktueller Kurseintrag:");
			System.out.println("");
			System.out.println("Date: " + getDate(0));
			System.out.println("Open: " + getDataEntry(0,0));
			System.out.println("High: " + getDataEntry(1,0));
			System.out.println("Low: " + getDataEntry(2,0));
			System.out.println("Close: " + getDataEntry(3,0));
			System.out.println("Volume: " + getDataEntry(2,0));
			System.out.println("Adj-Close: " + getDataEntry(3,0));
		}
		System.out.println("-----------------------");
		}
	}




}
