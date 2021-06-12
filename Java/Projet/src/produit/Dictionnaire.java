package produit;

import tools.*;

public class Dictionnaire extends Document
{
	private Langue Langue;
	
//Constructeur-------------------------------------------		
	public Dictionnaire(String identifiant, String titre, int nombreStock, double tarifJournalier, Langue langue)
	{
		super(identifiant, titre, nombreStock, tarifJournalier);
		Langue = langue;
	}

//Getters-------------------------------------------			

	public Langue getLangue() 
	{
		return Langue;
	}
	
//Setters-------------------------------------------		

	public void setLangue(Langue langue) 
	{
		Langue = langue;
	}

}