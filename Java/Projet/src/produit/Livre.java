package produit;

public abstract class Livre extends Produit 
{
	private String auteur;
	
//Construccteurs------------------------------------------	
	public Livre(String identifiant, String titre, int nombreStock, String auteur) 
	{
		super(identifiant, titre, nombreStock, "Document");
		this.auteur = auteur;
	}

//Getters------------------------------------------
	public String getAuteur() 
	{
		return auteur;
	}

//Setters------------------------------------------
	public void setAuteur(String auteur) 
	{
		this.auteur = auteur;
	}
	
}