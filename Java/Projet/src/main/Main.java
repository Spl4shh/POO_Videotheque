package main;

import java.util.ArrayList;

import client.*;
import produit.*;
import tools.*;
import commande.*;
import graphics.*;
import ecouteur.*;


public class Main
{
    static ArrayList<Client> listClient = new ArrayList<Client>();
    static ArrayList<Produit> listProduit = new ArrayList<Produit>();
    
    public static void main(String[] args)
    {
        creationProduit();
        Frame affichage = new Frame();
        EcouteurBoutonAcces ecouteurBoutonAcces = new EcouteurBoutonAcces(affichage);
        EcouteurBtnChoix ecouteurBtnChoix = new EcouteurBtnChoix(affichage);
    }

    public static void creationProduit()
    {
        listProduit.add(new BD("0001A", "L'histoire de Tintin", 12, "Romain NATANELIC", 0.5));
        listProduit.add(new Roman("0002A", "Un si grand soleil", 7, "Jeanne Alyse", 0.3));
        listProduit.add(new Dictionnaire("0003A", "Dictionnaire le Blond", 2, 0.2, Langue.Francais));
        listProduit.add(new CD("0004B", "Des chansons qui font pleuvoir", 5, 0.1, 2015));
        listProduit.add(new ManuelScolaire("0005A", "Les maths pour les enfants", 3, "Les editions Djeun's", 0.25));
        listProduit.add(new DVD("0006A", "Le Roi Lion", 7, "André Alisateur", 0.28));
        listProduit.add(new Roman("0007A", "Le debut, puis la fin", 1, "Jay Malodo", 0.28));
    }

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