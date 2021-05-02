package client;

import commande.Commande;

import java.util.ArrayList;

public class Fidele extends Client {

	public final double reduction = 0.10;

//Constructeur----------------------------
	public Fidele(String identifiant, String nom, String prenom)
	{
		super(identifiant, nom, prenom);
	}

//Getters----------------------------
	public double getReduction()
	{
		return reduction;
	}

}