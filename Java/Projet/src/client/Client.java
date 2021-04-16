package client;

import java.util.ArrayList;

import commande.*;

public abstract class Client {

	private String identifiant;
	private String nom;
	private String prenom;
	private ArrayList<Commande> listeCommande;

//Constructeur----------------------------------------
	public Client(String identifiant, String nom, String prenom)
	{
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.listeCommande = new ArrayList<Commande>();
	}

//Getters----------------------------------------
	public String getId()
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

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

//Setters----------------------------------------
	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public void setId(String id)
	{
		this.identifiant = id;
	}

	public ArrayList<Commande> getListeCommande()
	{
		return listeCommande;
	}

//Methode particuliere----------------------------------------
	public String toString()
	{
		return "Client [identifiant=" + identifiant + ", nom=" + nom + ", prenom=" + prenom + ", listeCommande=" + listeCommande + "]";
	}

	public void ajouterCommande(Commande Commande)
	{
		this.listeCommande.add(Commande);
	}

	public void supprimerCommande(Commande Commande)
	{
		this.listeCommande.remove(Commande);
	}

}