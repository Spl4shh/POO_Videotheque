package main;

import java.awt.*;
import java.util.ArrayList;

import client.*;
import commande.Commande;
import commande.Emprunt;
import graphic.Frame;
import produit.*;
import tools.*;
import ecouteur.*;


public class Main
{
    public static ArrayList<Client> listClient = new ArrayList<Client>();
    public static ArrayList<Produit> listProduit = new ArrayList<Produit>();
    public static ArrayList<Emprunt> listEmprunt = new ArrayList<Emprunt>();

    public static void main(String[] args)
    {
        setupEssai();

        Frame affichage = new Frame();

        EcouteurBoutonAcces ecouteurBoutonAcces = new EcouteurBoutonAcces(affichage);
        EcouteurBtnChoix ecouteurBtnChoix = new EcouteurBtnChoix(affichage);
        EcouteurBtnAccueil ecouteurBtnAccueil = new EcouteurBtnAccueil(affichage);
        EcouteurBtnListe ecouteurBtnListe = new EcouteurBtnListe(affichage);
        EcouteurBtnAjouter ecouteurBtnAjouter = new EcouteurBtnAjouter(affichage);
        EcouteurBtnSupprimer ecouteurBtnSupprimer = new EcouteurBtnSupprimer(affichage);

        EcouteurBtnModifier ecouteurBtnModifier = new EcouteurBtnModifier(affichage);
        EcouteurBtnRecherche ecouteurBtnRecherche = new EcouteurBtnRecherche(affichage);
        EcouteurBtnModifierCommande ecouteurBtnModifierCommande = new EcouteurBtnModifierCommande(affichage);
    }

//Fonction setup pour creer le jeu d'essai--------------------------------------
    public static void setupEssai()
    {
        setupListeProduit();
        setupListeClient();
        setupEmprunt();
        setupCommande();
    }

    public static void setupListeProduit()
    {
        listProduit.add(new Livre("1", "L'histoire de Tintin", 12, Type.BD, 0.5,"Romain NATANELIC"));
        listProduit.add(new Livre("2", "Un si grand soleil", 7, Type.Roman, 0.3, "Jeanne Alyze"));
        listProduit.add(new Dictionnaire("3", "Dictionnaire le Blond", 2, Type.Dictionnaire, 0.2, Langue.Francais));
        listProduit.add(new CD("4", "Des chansons qui font pleuvoir", 5, Type.CD, 0.1, 2015));
        listProduit.add(new Livre("5", "Les maths pour les enfants", 3, Type.Manuel_Scolaire, 0.25, "Les editions Djeun's"));
        listProduit.add(new DVD("6", "Le Roi Lion", 0, Type.DVD, 0.28, "André Alisateur"));
        listProduit.add(new Livre("7", "Le debut, puis la fin", 1, Type.Roman, 0.28, "Jay Malodo"));
    }

    public static void setupListeClient()
    {
        listClient.add(new Fidele("1", "Dujardin", "Jean"));
        listClient.add(new Occasionel("2", "Dutronc", "Marc"));
        listClient.add(new Fidele("3", "Delire", "Hugo"));
        listClient.add(new Occasionel("4", "Schumi", "Mickael"));
    }

    public static void setupEmprunt()
    {
        listEmprunt.add(new Emprunt(new Date(23,4, 2021), new Date(23,8, 2021), listProduit.get(0)));
        listEmprunt.add(new Emprunt(new Date(23,4, 2021), new Date(2,9, 2021), listProduit.get(3)));
        listEmprunt.add(new Emprunt(new Date(1,5, 2021), new Date(1,5, 2022), listProduit.get(1)));
        listEmprunt.add(new Emprunt(new Date(2,1, 2021), new Date(10,8, 2021), listProduit.get(5)));
        listEmprunt.add(new Emprunt(new Date(14,2, 2021), new Date(10,9, 2021), listProduit.get(2)));
        listEmprunt.add(new Emprunt(new Date(3,3, 2021), new Date(24,7, 2021), listProduit.get(4)));

    }

    public static void setupCommande()
    {
        listClient.get(0).ajouterCommande(new Commande("1", new Date(23, 4, 2021), ((Fidele)listClient.get(0)).getReduction()));
        listClient.get(0).getListeCommande().get(0).ajouterEmprunt(listEmprunt.get(0));
        listClient.get(0).getListeCommande().get(0).ajouterEmprunt(listEmprunt.get(1));

        listClient.get(0).ajouterCommande(new Commande("4", new Date(3, 3, 2021), ((Fidele)listClient.get(0)).getReduction()));
        listClient.get(0).getListeCommande().get(1).ajouterEmprunt(listEmprunt.get(5));


        listClient.get(1).ajouterCommande(new Commande("2", new Date(1,5, 2021), ((Occasionel)listClient.get(1)).getReduction()));
        listClient.get(1).getListeCommande().get(0).ajouterEmprunt(listEmprunt.get(2));
        listClient.get(1).getListeCommande().get(0).ajouterEmprunt(listEmprunt.get(4));


        listClient.get(2).ajouterCommande(new Commande("3", new Date(2,1, 2021), ((Fidele)listClient.get(2)).getReduction()));
        listClient.get(2).getListeCommande().get(0).ajouterEmprunt(listEmprunt.get(3));
    }
//------------------------------------------------------------------------------------------------------------

    public static int nombreEmprunt(Produit produit)
    {
        String idProduit = produit.getIdentifiant();
        int nombreEmprunt = 0;

        for (Client client : Main.listClient)
        {
            for (Commande commande : client.getListeCommande())
            {
                for (Emprunt emprunt : commande.getListeEmprunt())
                {
                    if (emprunt.getProduitConcerne().getIdentifiant().equals(idProduit))
                    {
                        nombreEmprunt++;
                    }
                }
            }
        }
        return (nombreEmprunt);
    }

    public static void recharger(Component component)
    {
        component.setVisible(false);
        component.setVisible(true);
    }

    public static boolean verifIdProduitExistant(String identifiantVerif)
    {
        boolean existe = false;
        for (Produit produit : Main.listProduit)
        {
            if (produit.getIdentifiant().toLowerCase().equals(identifiantVerif.toLowerCase()))
            {
                existe = true;
                break;
            }
        }
        return existe;
    }

    public static int grandIdCommandeActuel()
    {
        int compteur = -1;
        for (Client client : Main.listClient)
        {
            for (Commande commande : client.getListeCommande())
            {
                if (Integer.parseInt(commande.getIdentifiant()) > compteur)
                {
                    compteur = Integer.parseInt(commande.getIdentifiant());
                }
            }
        }
        return compteur;
    }

    public static int grandIdClientActuel()
    {
        int compteur = -1;
        for (Client client : Main.listClient)
        {
            if (Integer.parseInt(client.getIdentifiant()) > compteur)
            {
                compteur = Integer.parseInt(client.getIdentifiant());
            }
        }
        return compteur;
    }

    public static int grandIdProduitActuel()
    {
        int compteur = -1;
        for (Produit produit : Main.listProduit)
        {
            if (Integer.parseInt(produit.getIdentifiant()) > compteur)
            {
                compteur = Integer.parseInt(produit.getIdentifiant());
            }
        }
        return compteur;
    }
}