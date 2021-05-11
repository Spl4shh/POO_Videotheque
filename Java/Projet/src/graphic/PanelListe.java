package graphic;

import client.Client;
import client.Fidele;
import commande.Commande;
import main.Main;
import produit.Produit;

import javax.swing.*;
import java.awt.*;

public class PanelListe extends JPanel
{
    public JTextArea liste;
    public JScrollPane scrollListe;
    public JScrollBar verticalScrollBar;


    public PanelListe()
    {

        this.setLayout(new GridLayout(0, 1));


        liste = new JTextArea( 20, 80);
        liste.setEditable(false);

        scrollListe = new JScrollPane(liste);

        verticalScrollBar = new JScrollBar();
        verticalScrollBar.setUnitIncrement(16);

        scrollListe.setVerticalScrollBar(verticalScrollBar);

        this.add(scrollListe);
    }

    public void initListeClient()
    {
        this.clear();
        for (Client client : Main.listClient )
        {
            String indicationFidelite = "Occasionel";
            if (client instanceof Fidele)
            {
                indicationFidelite = "Fidele";
            }

            String textPrec = this.liste.getText();
            this.liste.setText(textPrec + "Client numéro " + client.getIdentifiant() + " : " + client.getNom() + " " + client.getPrenom()
                    + " | client " + indicationFidelite + " | " + client.getListeCommande().size() + " commande(s) éffectuée(s) \n");
        }
    }

    public void initListeCommande()
    {
        this.clear();
        for (Client client : Main.listClient )
        {
            for (Commande commande : client.getListeCommande())
            {
                String textPrec = this.liste.getText();
                this.liste.setText(textPrec + "Commande numéro " + commande.getIdentifiant() + " effetuée par le client numero "
                        + client.getIdentifiant() + " : " + client.getNom() + " " + client.getPrenom()
                        + " | nombre d'emprunt : " + commande.getListeEmprunt().size() + " | date de création : "
                         + commande.getDateCreation().toString() + " | montant total (sans reduction) : " + commande.montantCommandeString() + "€\n");
            }
        }
    }

    public void initListeProduit()
    {
        this.clear();
        for (Produit produit : Main.listProduit )
        {
            String textPrec = this.liste.getText();
            this.liste.setText(textPrec + "Produit numéro " + produit.getIdentifiant() + " : " + produit.getTitre() + " | Type : "
                    + produit.getType() + " | cout journalier : " + produit.getTarifJournalier() + "€ | nombre en stock :" + produit.getNombreStock()+ "\n");
        }
    }



    public void clear()
    {
        this.liste.setText("");
    }

}
