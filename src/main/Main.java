package main;

import java.util.ArrayList;

import client.*;
import commande.Commande;
import commande.Emprunt;
import produit.*;
import tools.*;
import graphic.*;
import ecouteur.*;


public class Main
{
    public static ArrayList<Client> listClient = new ArrayList<Client>();
    public static ArrayList<Produit> listProduit = new ArrayList<Produit>();


    public static void main(String[] args)
    {
        creationProduit();
        creationClient();

        Frame affichage = new Frame();

        EcouteurBoutonAcces ecouteurBoutonAcces = new EcouteurBoutonAcces(affichage);
        EcouteurBtnChoix ecouteurBtnChoix = new EcouteurBtnChoix(affichage);
        EcouteurBtnAccueil ecouteurBtnAccueil = new EcouteurBtnAccueil(affichage);
        EcouteurBtnListe ecouteurBtnListe = new EcouteurBtnListe(affichage);
        EcouteurBtnAjouter ecouteurBtnAjouter = new EcouteurBtnAjouter(affichage);
        EcouteurBtnSupprimer ecouteurBtnSupprimer = new EcouteurBtnSupprimer(affichage);
        EcouteurBtnSupprimerClient ecouteurBtnSupprimerClient = new EcouteurBtnSupprimerClient(affichage);
        EcouteurBtnSupprimerCommande ecouteurBtnSupprimerCommande = new EcouteurBtnSupprimerCommande(affichage);

    }

//Permet de faire des test, a supprimer par la suite--------------------------------------
    public static void creationProduit()
    {
        listProduit.add(new BD("0001A", "L'histoire de Tintin", 12, "Romain NATANELIC", 0.5));
        listProduit.add(new Roman("0002A", "Un si grand soleil", 7, "Jeanne Alyse", 0.3));
        listProduit.add(new Dictionnaire("0003A", "Dictionnaire le Blond", 2, 0.2, Langue.Francais));
        listProduit.add(new CD("0004B", "Des chansons qui font pleuvoir", 5, 0.1, 2015));
        listProduit.add(new ManuelScolaire("0005A", "Les maths pour les enfants", 3, "Les editions Djeun's", 0.25));
        listProduit.add(new DVD("0006A", "Le Roi Lion", 0, "André Alisateur", 0.28));
        listProduit.add(new Roman("0007A", "Le debut, puis la fin", 1, "Jay Malodo", 0.28));
    }
    public static void creationClient()
    {
        listClient.add(new Fidele("654654", "Dujardin", "Jean"));
        listClient.add(new Occasionel("56788464", "Dutronc", "Marc"));
        listClient.add(new Fidele("654844", "Delire", "Hugo"));
        listClient.add(new Occasionel("656546454", "Schumi", "Mickael"));
    }

//------------------------------------------------------------------------------------------------------------


    public static void creerClientFidele(String identifiant, String nom, String prenom)
    {
        Fidele clientFidele = new Fidele(identifiant, nom, prenom);
        listClient.add(clientFidele);
    }

    public static void creerClientOccasionel(String identifiant, String nom, String prenom)
    {
        Occasionel clientOccasionel = new Occasionel(identifiant, nom, prenom);
        listClient.add(clientOccasionel);
    }
}