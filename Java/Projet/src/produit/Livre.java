package produit;

import tools.Type;

public class Livre extends Document
{
	private String auteur;
	
//Construccteurs------------------------------------------	
	public Livre(String identifiant, String titre, int nombreStock, double tarifJournalier, String auteur)
	{
		super(identifiant, titre, nombreStock, tarifJournalier);
		this.auteur = auteur;
	}

//Getters------------------------------------------
	public String getAuteur() 
	{
		return auteur;
	}

//Setters------------------------------------------
	public void setAuteur(String auteur) 
	{
		this.auteur = auteur;
	}
	
}