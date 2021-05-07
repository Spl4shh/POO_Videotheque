package produit;

import tools.Type;

public class DVD extends Produit
{
	private String realisateur;
	
//Constructeur-------------------------------------------		
	public DVD(String identifiant, String titre, int nombreStock, Type type, double tarifJournalier, String realisateur)
	{
		super(identifiant, titre, nombreStock, type, tarifJournalier);
		this.realisateur = realisateur;
	}

//Getters-------------------------------------------		
	public String getRealisateur() 
	{
		return realisateur;
	}


//Setters-------------------------------------------		
	public void setRealisateur(String realisateur) 
	{
		this.realisateur = realisateur;
	}

}