package produit;

public class DVD extends Produit 
{
	private String realisateur;
	private double tarifJournalier;
	
	
//Constructeur-------------------------------------------		
	public DVD(String identifiant, String titre, int nombreStock, String type, String realisateur,double tarifJournalier) 
	{
		super(identifiant, titre, nombreStock, "Support Numerique");
		this.realisateur = realisateur;
		this.tarifJournalier = tarifJournalier;
	}

//Getters-------------------------------------------		
	public String getRealisateur() 
	{
		return realisateur;
	}

	public double getTarifJournalier() 
	{
		return tarifJournalier;
	}

//Setters-------------------------------------------		
	public void setRealisateur(String realisateur) 
	{
		this.realisateur = realisateur;
	}

	public void setTarifJournalier(double tarifJournalier) 
	{
		this.tarifJournalier = tarifJournalier;
	}
	
}