package produit;

import tools.*;

public class Dictionnaire extends Produit 
{
	private double tarifJournalier;
	private Langue Langue;
	
//Constructeur-------------------------------------------		
	public Dictionnaire(String identifiant, String titre, int nombreStock, double tarifJournalier, tools.Langue langue)
	{
		super(identifiant, titre, nombreStock, "Support Numerique");
		this.tarifJournalier = tarifJournalier;
		Langue = langue;
	}

//Getters-------------------------------------------			
	public double getTarifJournalier() 
	{
		return tarifJournalier;
	}

	public Langue getLangue() 
	{
		return Langue;
	}
	
//Setters-------------------------------------------		
	public void setTarifJournalier(double tarifJournalier) 
	{
		this.tarifJournalier = tarifJournalier;
	}

	public void setLangue(Langue langue) 
	{
		Langue = langue;
	}

}