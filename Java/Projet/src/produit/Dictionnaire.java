package produit;

import tools.*;

public class Dictionnaire extends Produit 
{
	private Langue Langue;
	
//Constructeur-------------------------------------------		
	public Dictionnaire(String identifiant, String titre, int nombreStock, Type type, double tarifJournalier, Langue langue)
	{
		super(identifiant, titre, nombreStock, type, tarifJournalier);
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