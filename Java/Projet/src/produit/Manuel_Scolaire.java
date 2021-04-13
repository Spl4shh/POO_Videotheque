package produit;

public class Manuel_Scolaire extends Livre 
{
	private double tarifJournalier;

//Constructeur-------------------------------------------		
	public Manuel_Scolaire(String identifiant, String titre, int nombreStock, String auteur, double tarifJournalier) 
	{
		super(identifiant, titre, nombreStock, auteur);
		this.tarifJournalier = tarifJournalier;
	}

//Getters-------------------------------------------		
	public double getTarifJournalier() 
	{
		return tarifJournalier;
	}

//Setters-------------------------------------------		
	public void setTarifJournalier(double tarifJournalier) 
	{
		this.tarifJournalier = tarifJournalier;
	}
	
}