import java.util.Scanner;

/*
 * In dieser Klasse werden die Eingaben (Name,K�rzel) gehasht und in das dazu geh�rige Array gespeichert
 * */
public class HashClass {
	
	Scanner read = new Scanner(System.in);
		
	//Hash mit Namen
	public void hash_name(String varstring_name)
	{
		
	}

	//Hash mit K�rzel
	public void hash_acronym(String varstring_acronym){
		
	}
	
	/*�bernahme des Namens oder K�rzels aus dem Menue
	von hier an search_name oder search_acronym �bergen*/
	public int search()
	{
		int varint_eingabe=0;
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
		 	 case 0:return 0;
			 case 1://weiter Funktion
				 ;break;
			 case 2://weitere Funktion
				 ;break;
			 default:System.out.println("** Ung�ltige Eingabe! **\n");break;
		 } 			 
		}while(varint_eingabe<0||varint_eingabe>2);
		return 0;
			
	}
	//Suche nach Namen
	private void search_name(String varstring_name)
	{
		
	}
	
	//Suche nach K�rzel
	private void search_acronym(String varstring_acronym)
	{
		
	}

}
