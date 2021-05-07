package produit;

import tools.Type;

public class Livre extends Produit
{
	private String auteur;
	
//Construccteurs------------------------------------------	
	public Livre(String identifiant, String titre, int nombreStock, Type type, double tarifJournalier, String auteur)
	{
		super(identifiant, titre, nombreStock, type, tarifJournalier);
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