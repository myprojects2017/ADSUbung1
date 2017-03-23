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
	public void search()
	{
		int varint_eingabe=0;
		do{
		System.out.print("Wollen Sie nach dem Namen(1) oder dem Kürzel(2) suchen?\nEingabe 1 oder 2 gültig): ");
		 varint_eingabe=read.nextInt();	
		 
		 switch(varint_eingabe)
		 {
			 case 1:break;
			 case 2:break;
			 default:System.out.println("** Ungültige Eingabe! **\n");break;
		 } 			 
		}while(varint_eingabe<1||varint_eingabe>2);
			
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
