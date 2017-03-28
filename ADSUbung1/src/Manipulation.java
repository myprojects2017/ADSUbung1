import java.util.Scanner;

/*
 * Diese Klasse enthält die Funktion "ADD und DELETE"
 * */
public class Manipulation {
	Scanner read = new Scanner(System.in);

	//Aktie hinzufügen
	public void add(HashClass hashtable_name, HashClass hashtable_kuerzel, Aktie aktie)
	{
		Boolean kuerzel;
		
		// In die Namens-Hashtabelle adden
		kuerzel = false;
		hashtable_name.add(aktie.getname(), aktie, kuerzel);
		
		// In die Kürzel-Hashtabelle adden
		kuerzel = true;
		hashtable_name.add(aktie.getkuerzel(), aktie, kuerzel);
	}
	
	public void search(HashClass hashtable_name, HashClass hashtable_kuerzel, String search)
	{
		int varint_eingabe=0;
		do{
		System.out.print(
				  "\n_______________________"
				+ "\n|Abbruch           (0)|"
				+ "\n|Suche nach Namen  (1)|"
				+ "\n|Suche nach Kürzel (2)|"
				+ "\n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯"
				+ "\nEingabe:");
		 
		//wie im Hauptmenü = Regx überprüfung
		 String varstring_regx="[0-2]";
			String varstring_input = read.next();
			if(varstring_input.matches(varstring_regx))
				varint_eingabe=Integer.parseInt(varstring_input);
			else
				varint_eingabe = 3;
		 
		 //Handeln je nach Benutzereingabe
		 switch(varint_eingabe)
		 {
		 	 case 0: return;
			 case 1:
			 {
				 hashtable_name.search(search);
				 
			 }
				 ;break;
			 case 2:
			 {
				 hashtable_kuerzel.search(search);
			 }
				 ;break;
			 default:System.out.println("** Ungültige Eingabe! **\n");break;
		 } 			 
		}while(varint_eingabe<0||varint_eingabe>2);
	}
	
	//Aktie löschen
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
