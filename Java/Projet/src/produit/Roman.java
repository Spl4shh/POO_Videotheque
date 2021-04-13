package produit;

public class Roman extends Livre 
{


	private double tarifJournalier;

//Constructeur-------------------------------------------	
	public Roman(String identifiant, String titre, int nombreStock, String auteur, double tarifJournalier,double tarifJournalier2) 
	{
		super(identifiant, titre, nombreStock, auteur);
		tarifJournalier = tarifJournalier2;
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