package produit;

public class CD extends Produit 
{
	private double tarifJournalier;
	private int anneeSortie;

	
//Constructereurs------------------------------------------
	public CD(String identifiant, String titre, int nombreStock, double tarifJournalier, int anneeSortie) 
	{
		super(identifiant, titre, nombreStock, "Support Informatique");
		this.tarifJournalier = tarifJournalier;
		this.anneeSortie = anneeSortie;
	}

//Getters------------------------------------------
	public double getTarifJournalier() 
	{
		return tarifJournalier;
	}

	public int getAnneeSortie() 
	{
		return anneeSortie;
	}

//Setters------------------------------------------
	public void setTarifJournalier(double tarifJournalier) 
	{
		this.tarifJournalier = tarifJournalier;
	}

	public void setAnneeSortie(int anneeSortie) 
	{
		this.anneeSortie = anneeSortie;
	}


	
}