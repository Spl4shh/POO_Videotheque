package client;

import commande.Commande;
import commande.Emprunt;

import java.util.ArrayList;

public abstract class Client {

	private String identifiant;
	private String nom;
	private String prenom;
	private ArrayList<Commande> listeCommande;

//Constructeur----------------------------------------
	/**
	 * Ce constructeur permet de creer un nouveau client sans liste au préalable
	 */
	public Client(String identifiant, String nom, String prenom)
	{
		this.identifiant = identifiant;
		this.setNom(nom);
		this.prenom = prenom;
		this.listeCommande = new ArrayList<Commande>();
	}

	/**
	 * Ce constructeur permet de creer un nouveau client avec une liste deja existante
	 */
	public Client(String identifiant, String nom, String prenom, ArrayList<Commande> listeCommande)
	{
		this.identifiant = identifiant;
		this.setNom(nom);
		this.prenom = prenom;
		this.listeCommande = listeCommande;
	}

//Getters----------------------------------------
	public String getIdentifiant()
	{
		return identifiant;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public String getNom()
	{
		return nom;
	}


//Setters----------------------------------------
	public void setNom(String nom)
	{
		if (!nom.isEmpty())
		{
			this.nom = nom;
		}
		else
		{
			System.out.println("Client.setNom(String) : Erreur nom vide");
		}
	}

	public void setIdentifiant(String id)
	{
		this.identifiant = id;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	public ArrayList<Commande> getListeCommande()
	{
		return listeCommande;
	}

//Methode particuliere----------------------------------------
	public String toString()
	{
		return "Client : identifiant = " + identifiant + ", nom= " + nom + ", prenom= " + prenom + ", listeCommande= " + listeCommande ;
	}

	/**
	 * Cette methode permet de retirer une commande
	 * à un adherent deja existant
	 *
	 * @param commande La commande a ajouter au client
	 */
	public void addCommande(Commande commande)
	{
		this.listeCommande.add(commande);
	}

	/**
	 * Cette methode permet de retirer une commande
	 * à un adherent deja existant
	 *
	 * @param commande La commande a supprimer
	 */
	public void removeCommande(Commande commande)
	{
		for (Emprunt emprunt : commande.getListeEmprunt())
		{
			emprunt.removeProduitEmprunt();
		}
		this.listeCommande.remove(commande);
	}

}