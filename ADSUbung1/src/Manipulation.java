import java.util.Scanner;

/*
 * Diese Klasse enth�lt die Funktion "ADD und DELETE"
 * */
public class Manipulation {
	Scanner read = new Scanner(System.in);

	//Aktie hinzuf�gen
	public void add(HashClass hashtable_name, HashClass hashtable_kuerzel, Aktie aktie)
	{
		Boolean kuerzel;
		
		// In die Namens-Hashtabelle adden
		kuerzel = false;
		hashtable_name.add(aktie.getname(), aktie, kuerzel);
		
		// In die K�rzel-Hashtabelle adden
		kuerzel = true;
		hashtable_kuerzel.add(aktie.getkuerzel(), aktie, kuerzel);
	}
	
	public Aktie search(HashClass hashtable_name, HashClass hashtable_kuerzel)
	{
		int varint_eingabe=0;
		Boolean kuerzel;
		Aktie search_entry = new Aktie();
		do{
		System.out.print(
				  "\n_______________________"
				+ "\n|Abbruch           (0)|"
				+ "\n|Suche nach Namen  (1)|"
				+ "\n|Suche nach K�rzel (2)|"
				+ "\n�����������������������"
				+ "\nEingabe:");
		 
		//wie im Hauptmen� = Regx �berpr�fung
		 String varstring_regx="[0-2]";
			String varstring_input = read.next();
			if(varstring_input.matches(varstring_regx))
				varint_eingabe=Integer.parseInt(varstring_input);
			else
				varint_eingabe = 3;
		

		 
		 //Handeln je nach Benutzereingabe
		 switch(varint_eingabe)
		 {
		 	 case 0: ;
			 case 1:
			 {
				 kuerzel = false;
				 search_entry = hashtable_name.search(kuerzel);
				 
			 }
				 ;break ; 
			 case 2:
			 {
				 kuerzel = true;
				 search_entry = hashtable_kuerzel.search(kuerzel);
			 }
				 ;break;
			 default:System.out.println("** Ung�ltige Eingabe! **\n");break;
		 } 		

		}while(varint_eingabe<0||varint_eingabe>2);
		return search_entry;
	}
	
	//Aktie l�schen
	public void delete() {
	 	
	}
	
	public void save(HashClass name, HashClass kuerzel)
	{
		/*
		for(int i=0;i<1019;i++)
		{
		Aktie eintrag = name.getEntry(10);
			String name1 = eintrag.getname();
			String kuerz1 =	eintrag.getkuerzel();
			int wert1 =	eintrag.getwkn();
		}
		*/
		
	}
}
