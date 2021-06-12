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

	/**
	 * Permet d'ajouter un emprunt
	 * Dans cette methode, on verifie que la date
	 * de l'emprunt sois la meme que celle da la commande
	 * si ce n'est pas le cas on la modifie puis on verifie
	 * si la nouvelle date est avant la date de fin
	 * si ce n'est pas le cas on renvoi une erreur
	 *
	 * @param emprunt l'emprunt à ajouter
	 */
	public void ajouterEmprunt(Emprunt emprunt)
	{
		if (!emprunt.getDateDebut().equals(this.dateCreation))
		{
			emprunt.setDateDebut(this.getDateCreation());
			if (emprunt.getDateDebut().nbJours() - emprunt.getDateFin().nbJours() < 0)
			{
				System.out.println("Erreur date ajoutEmprunt classe : Commande");
			}
		}
		else if ((emprunt.getDateFin().nbJours() - emprunt.getDateDebut().nbJours()) > 0)
		{
			this.listeEmprunt.add(emprunt);
		}
	}

	/**
	 * Cette methode permet de supprimer un emprunt
	 * Elle recherche l'emprunt correspondant
	 * dans la liste des emprunts de la commande
	 * Une fois l'emprunt trouvé, on retire le produit et
	 * on supprime l'emprunt
	 *
	 * @param emprunt l'emprunt à supprimer
	 */
	public void supprimerEmprunt(Emprunt emprunt)
	{
		for(int i = 0; i < this.listeEmprunt.size(); i++)
		{
			if(this.listeEmprunt.get(i) == emprunt)
			{
				emprunt.removeProduitEmprunt();
				this.listeEmprunt.remove(i);
			}
		}		
	}


	/**
	 * Cette methode permet de renvoyer le montant (String) de la commande
	 * On recupera le montant de la commande sous un double
	 * On conservera juste 2 chiffres apres la virgule
	 *
	 * @return le montant de la commande sous forme d'un String
	 */
	public String montantCommandeString()
	{
		double total = 0;

		DecimalFormat format2Decimal = new DecimalFormat();
		format2Decimal.setMaximumFractionDigits(2);

		total = this.montantCommandeDouble();

		return format2Decimal.format(total);
	}

	/**
	 * Cette methode permet de renvoyer le montant (double) de la commande
	 * On recupera le montant de chaque emprunt,
	 * on en ferra ensuite la somme.
	 *
	 * @return le montant de la commande sous forme d'un double
	 */
	public double montantCommandeDouble()
	{
		double total = 0;

		for (Emprunt emprunt : this.listeEmprunt)
		{
			total = total + emprunt.montantEmpruntDouble();
		}

		return total;
	}

}