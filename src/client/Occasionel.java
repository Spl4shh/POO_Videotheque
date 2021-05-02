package client;

import commande.Commande;

import java.util.ArrayList;

public class Occasionel extends Client {

	public final double reduction = 0.00;

//Constructeur----------------------------
	public Occasionel(String identifiant, String nom, String prenom)
	{
		super(identifiant, nom, prenom);
	}

//Getters----------------------------
	public double getReduction()
	{
		return reduction;
	}

}