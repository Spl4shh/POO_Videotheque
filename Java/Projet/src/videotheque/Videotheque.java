package videotheque;

import client.Client;
import client.Fidele;
import client.Occasionnel;
import commande.Commande;
import commande.Emprunt;
import main.Main;
import produit.*;
import tools.Date;
import tools.Langue;

import java.util.ArrayList;

public class Videotheque
{
    private ArrayList<Client> listClient;
    private ArrayList<Produit> stock;

//Constructeur---------------------------------------------------
    public Videotheque()
    {
        this.listClient = new ArrayList<Client>();
        this.stock = new ArrayList<Produit>();

    //Generer le jeu d'essai
        this.setupEssai();
    }
//getters et Setters---------------------------------------------------
    public ArrayList<Client> getListClient()
    {
        return listClient;
    }

    public ArrayList<Produit> getStock()
    {
        return stock;
    }

    public void setListClient(ArrayList<Client> listClient)
    {
        this.listClient = listClient;
    }

    public void setStock(ArrayList<Produit> stock)
    {
        this.stock = stock;
    }

//Methode particuliere---------------------------------------------------

    /**
     * Cette methode permet d'appliquer le jeu d'essai
     *
     * On appelle les differentes methode de creation
     */
    public void setupEssai()
    {
        setupListeProduit();
        setupListeClient();
        setupEmpruntCommande();
    }

    /**
     * Cette methode permet d'ajouter des produits a la listes
     */
    public void setupListeProduit()
    {
        this.stock.add(new BD("1", "L'histoire de Tintin", 12,0.5,"Romain NATANELIC"));
        this.stock.add(new Roman("2", "Un si grand soleil", 7, 0.3, "Jeanne Alyze"));
        this.stock.add(new Dictionnaire("3", "Dictionnaire le Blond", 2, 0.2, Langue.Francais));
        this.stock.add(new CD("4", "Des chansons qui font pleuvoir", 5, 0.1, 2015));
        this.stock.add(new ManuelScolaire("5", "Les maths pour les enfants", 3, 0.25, "Les editions Djeun's"));
        this.stock.add(new DVD("6", "Le Roi Lion", 0, 0.28, "André Alisateur"));
        this.stock.add(new Roman("7", "Le debut, puis la fin", 1, 0.28, "Jay Malodo"));
    }

    /**
     * Cette methode permet de creer des clients.
     */
    public void setupListeClient()
    {
        this.listClient.add(new Fidele("1", "Dujardin", "Jean"));
        this.listClient.add(new Occasionnel("2", "Dutronc", "Marc"));
        this.listClient.add(new Fidele("3", "Delire", "Hugo"));
        this.listClient.add(new Occasionnel("4", "Schumi", "Mickael"));
    }

    /**
     * Cette methode permet de creer des emprunts et des commandes et de les appliquers aux clients.
     */
    public void setupEmpruntCommande()
    {
    //------------------------------------------------Premiere Commande------------------------------------------------------------
        this.listClient.get(0).addCommande(new Commande("1", new Date(23, 4, 2021), ((Fidele)listClient.get(0)).getReduction()));

        this.listClient.get(0).getListeCommande().get(0).ajouterEmprunt(new Emprunt(new Date(23,4, 2021),
                new Date(23,8, 2021), this.stock.get(0)));
        this.listClient.get(0).getListeCommande().get(0).ajouterEmprunt(new Emprunt(new Date(23,4, 2021),
                new Date(2,9, 2021), this.stock.get(3)));

    //------------------------------------------------Deuxieme Commande------------------------------------------------------------
        this.listClient.get(0).addCommande(new Commande("4", new Date(3, 3, 2021), ((Fidele)listClient.get(0)).getReduction()));

        this.listClient.get(0).getListeCommande().get(1).ajouterEmprunt(new Emprunt(new Date(3,3, 2021),
                new Date(24,7, 2021), this.stock.get(4)));

    //------------------------------------------------Troisieme Commande------------------------------------------------------------
        listClient.get(1).addCommande(new Commande("2", new Date(1,5, 2021), ((Occasionnel)listClient.get(1)).getReduction()));

        this.listClient.get(1).getListeCommande().get(0).ajouterEmprunt(new Emprunt(new Date(1,5, 2021),
                new Date(1,5, 2022), this.stock.get(1)));

        this.listClient.get(1).getListeCommande().get(0).ajouterEmprunt(new Emprunt(new Date(1,5, 2021),
                new Date(10,9, 2021), this.stock.get(2)));

    //------------------------------------------------Quatrieme Commande-----------------------------------------------------------
        listClient.get(2).addCommande(new Commande("3", new Date(2,1, 2021), ((Fidele)listClient.get(2)).getReduction()));

        this.listClient.get(2).getListeCommande().get(0).ajouterEmprunt(new Emprunt(new Date(2,1, 2021),
                new Date(10,8, 2021), this.stock.get(5)));
    }

    /**
     * Cette methode permet d'avoir le nombre d'emprunt d'un produit.
     *
     * On verifie dans tout les emprunts de toutes les commandes de tout les clients,
     * s'il existe un emprunt avec ce produit
     *
     * @param produit Le proudit dont on doit verifier les emprunts
     * @return Le nombre d'emprunt
     */
    public int nombreEmprunt(Produit produit)
    {
        String idProduit = produit.getIdentifiant();
        int nombreEmprunt = 0;

        for (Client client : this.getListClient())
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

    /**
     * Cette methode permet de retourner la plus grande valeur d'ID de Commande.
     *
     * On va parcourir toutes les commandes de tout les clients pour trouver l'ID le plus grand.
     *
     * @return La plus grand valeur de l'ID sous la forme d'un entier
     */
    public static int plusGrandIdCommande()
    {
        int compteur = -1;
        for (Client client : Main.videotheque.getListClient())
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

    /**
     * Cette methode permet de retourner la plus grande valeur d'ID de Client
     *
     * On va parcourir tout les clients pour trouver l'ID le plus grand
     *
     * @return La plus grand valeur de l'ID sous la forme d'un entier
     */
    public static int plusGrandIdClient()
    {
        int compteur = 0;
        for (Client client : Main.videotheque.getListClient())
        {
            if (Integer.parseInt(client.getIdentifiant()) > compteur)
            {
                compteur = Integer.parseInt(client.getIdentifiant());
            }
        }
        return compteur;
    }


    /**
     * Cette methode permet de retourner la plus grande valeur d'ID de Produit.
     *
     * On va parcourir tout les produits pour trouver l'ID le plus grand.
     *
     * @return La plus grand valeur de l'ID sous la forme d'un entier
     */
    public static int plusGrandIdProduit()
    {
        int compteur = 0;
        for (Produit produit : Main.videotheque.getStock())
        {
            if (Integer.parseInt(produit.getIdentifiant()) > compteur)
            {
                compteur = Integer.parseInt(produit.getIdentifiant());
            }
        }
        return compteur;
    }

    /**
     * Cette methode permet d'ajouter un client a la liste des clients.
     *
     * On suppose que le clients est valide et que les verifications ont été faites en amont.
     *
     * @param client Client a ajouter a la liste
     */
    public void ajouterClient (Client client)
    {
        this.getListClient().add(client);
    }

    /**
     * Cette methode permet de supprimer un client dans la liste.
     *
     * @param indexSuppression Index du client a supprimer
     */
    public void supprimerClient (int indexSuppression)
    {
        Client aSupprimer = this.getListClient().get(indexSuppression);

        for (Commande commande : aSupprimer.getListeCommande())
        {
            for (Emprunt emprunt : commande.getListeEmprunt())
            {
                emprunt.removeProduitEmprunt();
            }
        }
        this.getListClient().remove(indexSuppression);
    }

    /**
     * Cette methode permet d'ajouter un produit au stock.
     *
     * @param produit Produit à ajouter
     */
    public void ajouterStock (Produit produit)
    {
        this.getStock().add(produit);
    }

    /**
     * Cette methode permet de supprimer un produit du stock.
     *
     * @param indexSuppression Index du produit a supprimer
     */
    public void supprimerStock (int indexSuppression)
    {
        this.getStock().remove(indexSuppression);
    }
}
