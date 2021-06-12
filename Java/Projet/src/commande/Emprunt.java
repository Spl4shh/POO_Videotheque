package commande;

import tools.*;
import produit.*;

import java.text.DecimalFormat;

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

	/**
	 * Cette methode permet de renvoyer le montant (double) de l'emprunt
	 * On calcul le nombre de jour d'emprunt, qu'on multiplie
	 * par le tarifJournalier du produit
	 *
	 * @return le montant de l'emprunt sous forme d'un double
	 */
	public double montantEmpruntDouble()
	{
		int dureeJours = (this.getDateFin().nbJours() - this.getDateDebut().nbJours());
		double total = (double)dureeJours * this.getProduitConcerne().getTarifJournalier();

		return total;
	}

	/**
	 * Cette methode permet de renvoyer le montant (String) de l'emprunt
	 * On calcul le nombre de jour d'emprunt, qu'on multiplie
	 * par le tarifJournalier du produit
	 * Ensuite on formatera juste le resultat avec 2 chiffres
	 * apres la virgule
	 *
	 * @return le montant de l'emprunt sous forme d'un String
	 */
	public String montantEmpruntString()
	{
		DecimalFormat format2Decimal = new DecimalFormat();
		format2Decimal.setMaximumFractionDigits(2);

		int dureeJours = (this.getDateFin().nbJours() - this.getDateDebut().nbJours());
		double total = (double)dureeJours * this.getProduitConcerne().getTarifJournalier();

		return format2Decimal.format(total);
	}

	/**
	 * Cette methode permet de retirer le produit de l'emprunt
	 *
	 * On va verifier si l'emprunt est terminée ou non
	 * s'il l'est, on retir pas le produit, sinon
	 * on augmente le stock du produit
	 */
	public void removeProduitEmprunt()
		{
		java.time.LocalDate dateCourante = java.time.LocalDate.now();

		Date dateDuJour = new Date(dateCourante.getDayOfMonth(), dateCourante.getMonthValue(), dateCourante.getYear());

		if ((this.getDateFin().nbJours() - dateDuJour.nbJours()) > 0)
		{
			this.getProduitConcerne().augmenterStock();
		}
	}
}