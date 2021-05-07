package commande;

import tools.*;
import produit.*;

public class Emprunt 
{

	private Date dateDebut;
	private Date dateFin;
	private Produit produitConcerne;
	
//Constructeur---------------------------------------
	public Emprunt(Date dateDebut, Date dateFin, Produit produitConcerne) 
	{
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.produitConcerne = produitConcerne;

	}
	
//Getters---------------------------------------
	public Date getDateDebut() 
	{
		return dateDebut;
	}

	public Date getDateFin() 
	{
		return dateFin;
	}

	public Produit getProduitConcerne() 
	{
		return produitConcerne;
	}
	
//Setters---------------------------------------
	public void setDateDebut(Date dateDebut) 
	{
		this.dateDebut = dateDebut;
	}

	public void setDateFin(Date dateFin) 
	{
		this.dateFin = dateFin;
	}

	public void setProduitConcerne(Produit produitConcerne) 
	{
		this.produitConcerne = produitConcerne;
	}

//Methode Particuliere--------------------------
	public static boolean verifierDisponibilite(Produit produit)
	{
		if(produit.getNombreStock() > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}


}