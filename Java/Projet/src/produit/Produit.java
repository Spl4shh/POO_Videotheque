package produit;

public abstract class Produit
{
	private String identifiant;
	private String titre;
	private int nombreStock;
	private double tarifJournalier;



	//Constructeurs ---------------------------------------
	public Produit(String identifiant, String titre, int nombreStock, double tarifJournalier)
	{
		this.identifiant = identifiant;
		this.titre = titre;
		this.nombreStock = nombreStock;
		this.tarifJournalier = tarifJournalier;
	}

//Getters ---------------------------------------	
	public String getIdentifiant() 
	{
		return identifiant;
	}

	public String getTitre() 
	{
		return titre;
	}

	public int getNombreStock() 
	{
		return nombreStock;
	}

	public double getTarifJournalier()
	{
		return tarifJournalier;
	}
	
//Setters ---------------------------------------	
	public void setIdentifiant(String identifiant) 
	{
		this.identifiant = identifiant;
	}

	public void setTitre(String titre) 
	{
		this.titre = titre;
	}

	public void setNombreStock(int nombreStock) 
	{
		this.nombreStock = nombreStock;
	}

	public void setTarifJournalier(double tarifJournalier)
	{
		this.tarifJournalier = tarifJournalier;
	}

//Methode Particuliere

	/**
	 * Cette methode permet de reduire le stock d'un produit.
	 *
	 * Si le stock du produit est positif, on le diminue de 1.
	 */
	public void reduireStock()
	{
		if (this.getNombreStock() > 0)
		{
			this.setNombreStock(this.getNombreStock()-1);
		}
	}

	/**
	 * Cette methode permet d'augmenter le stock d'un produit.
	 *
	 * On augmente le stock du produit de 1.
	 */
	public void augmenterStock()
	{
			this.setNombreStock(this.getNombreStock()+1);
	}

	/**
	 * Cette methode permet de verifier si le produit est disponible.
	 *
	 * @return Renvoi vrai si le stock du produit est positif
	 */
	public boolean estDispo()
	{
		return this.getNombreStock() > 0;
	}
}