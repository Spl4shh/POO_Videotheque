package produit;

import tools.Type;

public class CD extends Produit
{
	private int anneeSortie;

	
//Constructereurs------------------------------------------
	public CD(String identifiant, String titre, int nombreStock, Type type , double tarifJournalier, int anneeSortie)
	{
		super(identifiant, titre, nombreStock, type, tarifJournalier);
		this.anneeSortie = anneeSortie;
	}

//Getters------------------------------------------

	public int getAnneeSortie() 
	{
		return anneeSortie;
	}

//Setters------------------------------------------

	public void setAnneeSortie(int anneeSortie) 
	{
		this.anneeSortie = anneeSortie;
	}


	
}