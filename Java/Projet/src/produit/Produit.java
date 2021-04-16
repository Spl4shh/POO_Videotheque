package produit;

public abstract class Produit 
{
	private String identifiant;
	private String titre;
	private int nombreStock;
	private String type;
	

//Constructeurs ---------------------------------------	
	public Produit(String identifiant, String titre, int nombreStock, String type) 
	{
		this.identifiant = identifiant;
		this.titre = titre;
		this.nombreStock = nombreStock;
		this.type = type;
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

	public String getType() 
	{
		return type;
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

	public void setType(String type) 
	{
		this.type = type;
	}


}