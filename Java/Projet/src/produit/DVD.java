package produit;

public class DVD extends SupportNumerique
{
	private String realisateur;
	
//Constructeur-------------------------------------------		
	public DVD(String identifiant, String titre, int nombreStock, double tarifJournalier, String realisateur)
	{
		super(identifiant, titre, nombreStock, tarifJournalier);
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