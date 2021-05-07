package produit;

import tools.Type;

public abstract class Produit
{
	private String identifiant;
	private String titre;
	private int nombreStock;
	private Type type;
	private double tarifJournalier;



	//Constructeurs ---------------------------------------
	public Produit(String identifiant, String titre, int nombreStock, Type type, double tarifJournalier)
	{
		this.identifiant = identifiant;
		this.titre = titre;
		this.nombreStock = nombreStock;
		this.type = type;
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

	public Type getType()
	{
		return type;
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

	public void setType(Type type)
	{
		this.type = type;
	}

	public void setTarifJournalier(double tarifJournalier)
	{
		this.tarifJournalier = tarifJournalier;
	}

//Methode Particuliere
	public void reduireStock()
	{
		if (this.getNombreStock() > 0)
		{
			this.setNombreStock(this.getNombreStock()-1);
		}
	}

	public boolean estDispo()
	{
		if (this.getNombreStock() > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}