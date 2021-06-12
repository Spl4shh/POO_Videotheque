package client;

import commande.Commande;

import java.util.ArrayList;

public class Occasionnel extends Client {

	public final double reduction = 0.00;

//Constructeur----------------------------
	public Occasionnel(String identifiant, String nom, String prenom)
	{
		super(identifiant, nom, prenom);
	}

	public Occasionnel(String identifiant, String nom, String prenom, ArrayList<Commande> listeCommande)
	{
		super(identifiant, nom, prenom, listeCommande);
	}

//Getters----------------------------
	public double getReduction()
	{
		return reduction;
	}

}