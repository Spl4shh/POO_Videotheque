package produit;

public class CD extends SupportNumerique
{
	private int anneeSortie;

	
//Constructereurs------------------------------------------
	public CD(String identifiant, String titre, int nombreStock, double tarifJournalier, int anneeSortie)
	{
		super(identifiant, titre, nombreStock, tarifJournalier);
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