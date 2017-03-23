import java.util.Scanner;

/*
 * In dieser Klasse werden die Eingaben (Name,Kürzel) gehasht und in das dazu gehörige Array gespeichert
 * */
public class HashClass {
	
	Scanner read = new Scanner(System.in);
		
	//Hash mit Namen
	public void hash_name(String varstring_name)
	{
		
	}

	//Hash mit Kürzel
	public void hash_acronym(String varstring_acronym){
		
	}
	
	/*Übernahme des Namens oder Kürzels aus dem Menue
	von hier an search_name oder search_acronym übergen*/
	public int search()
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
		 	 case 0:return 0;
			 case 1://weiter Funktion
				 ;break;
			 case 2://weitere Funktion
				 ;break;
			 default:System.out.println("** Ungültige Eingabe! **\n");break;
		 } 			 
		}while(varint_eingabe<0||varint_eingabe>2);
		return 0;
			
	}
	//Suche nach Namen
	private void search_name(String varstring_name)
	{
		
	}
	
	//Suche nach Kürzel
	private void search_acronym(String varstring_acronym)
	{
		
	}

}
