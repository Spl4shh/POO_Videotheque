package commande;

import tools.*;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Commande 
{

	private String identifiant;
	private Date dateCreation;
	private double reduction;
	private ArrayList<Emprunt> listeEmprunt;

	
//Constructeur---------------------------------------
	public Commande(String identifiant, Date dateCreation, double reduction, ArrayList<Emprunt> listeEmprunt) 
	{
		this.identifiant = identifiant;
		this.dateCreation = dateCreation;
		this.reduction = reduction;
		this.listeEmprunt = listeEmprunt;
	}

	public Commande(String identifiant, Date dateCreation, double reduction)
	{
		this.identifiant = identifiant;
		this.dateCreation = dateCreation;
		this.reduction = reduction;
		this.listeEmprunt = new ArrayList<Emprunt>();
	}
	
//Getters---------------------------------------	
	public String getIdentifiant() 
	{
		return identifiant;
	}

	public Date getDateCreation() 
	{
		return dateCreation;
	}

	public double getReduction() 
	{
		return reduction;
	}

	public ArrayList<Emprunt> getListeEmprunt() 
	{
		return listeEmprunt;
	}
	
//Setters---------------------------------------
	public void setIdentifiant(String identifiant) 
	{
		this.identifiant = identifiant;
	}

	public void setDateCreation(Date dateCreation) 
	{
		this.dateCreation = dateCreation;
	}

	public void setReduction(double reduction) 
	{
		this.reduction = reduction;
	}


	public void setListeEmprunt(ArrayList<Emprunt> listeEmprunt) 
	{
		this.listeEmprunt = listeEmprunt;
	}

//Methode Particuliere---------------------------------------
	public void ajouterEmprunt(Emprunt emprunt)
	{
		this.listeEmprunt.add(emprunt);
	}

	public void supprimerEmprunt(Emprunt Emprunt) 
	{
		for(int i = 0; i < this.listeEmprunt.size(); i++)
		{
			if(this.listeEmprunt.get(i) == Emprunt)
			{
				this.listeEmprunt.remove(i);
			}
		}		
	}

	public String montantCommande()
	{
		double total = 0;

		DecimalFormat format2Decimal = new DecimalFormat();
		format2Decimal.setMaximumFractionDigits(2);

		for (Emprunt emprunt : this.listeEmprunt)
		{
			int dureeJours = (emprunt.getDateFin().nbJours() - emprunt.getDateDebut().nbJours());
			total = total + (double)dureeJours * emprunt.getProduitConcerne().getTarifJournalier();
		}

		return format2Decimal.format(total);
	}
}