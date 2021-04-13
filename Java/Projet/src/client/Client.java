package client;

import java.util.ArrayList;

import commande.*;

public abstract class Client {

	private String identifiant;
	private String nom;
	private String prenom;
	private ArrayList<Commande> listeCommande;

	
	public void addCommande(int Commande) {
		// TODO - implement Client.addCommande
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Commande
	 */
	public void suppCommande(int Commande) {
		// TODO - implement Client.suppCommande
		throw new UnsupportedOperationException();
	}

	public void setNom() {
		// TODO - implement Client.setNom
		throw new UnsupportedOperationException();
	}

	public void getNom() {
		// TODO - implement Client.getNom
		throw new UnsupportedOperationException();
	}

}