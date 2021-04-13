package produit;

public class ManuelScolaire extends Livre 
{
	private double tarifJournalier;

//Constructeur-------------------------------------------		
	public ManuelScolaire(String identifiant, String titre, int nombreStock, String auteur, double tarifJournalier) 
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