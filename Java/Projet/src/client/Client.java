package client;

import java.util.ArrayList;

import commande.*;

public abstract class Client {

	private String identifiant;
	private String nom;
	private String prenom;
	private ArrayList<Commande> listeCommande;

	
	public void addCommande(int Commande) 
	{
		throw new UnsupportedOperationException();
	}


	public void suppCommande(int Commande) 
	{
		throw new UnsupportedOperationException();
	}

	public void setNom() 
	{
		throw new UnsupportedOperationException();
	}

	public void getNom() 
	{
		throw new UnsupportedOperationException();
	}

}