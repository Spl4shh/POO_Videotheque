package graphic;

import client.Client;
import commande.Emprunt;
import ecouteur.EcouteurAjouterCommande;
import main.Main;
import produit.Produit;

import javax.swing.*;
import java.awt.*;

public class PanelAjouterCommande extends JPanel
{
    public JComboBox comboProduit, comboClient;
    public JButton btnValiderClient, btnValiderEmprunt, btnValiderCommande;
    public JLabel stockDispo, labelEmprunt, labelClient, labelDate1, labelDate2, messageErreur, total;
    public PanelAjoutDate panelAjoutDate;
    public double totalCommande;
    public JPanel panelCaracteristique;
    EcouteurAjouterCommande ecouteurAjouterCommande = new EcouteurAjouterCommande(this);

    public PanelListe panelListeEmprunt;


    public PanelAjouterCommande()
    {
        panelCaracteristique = new JPanel();
        this.panelCaracteristique.setLayout(new GridLayout(0, 2));
        this.add(panelCaracteristique);
        panelCaracteristique.setVisible(false);

        comboClient = new JComboBox();
        this.panelCaracteristique.add(comboClient);

        btnValiderClient = new JButton("Valider");
        this.panelCaracteristique.add(btnValiderClient);
        btnValiderClient.addActionListener(ecouteurAjouterCommande);

        this.panelCaracteristique.add(labelEmprunt  = new JLabel("Emprunt :"));

        this.panelCaracteristique.add(labelClient = new JLabel());

        comboProduit = new JComboBox();
        this.panelCaracteristique.add(comboProduit);
        comboProduit.addActionListener(ecouteurAjouterCommande);

        stockDispo = new JLabel("     stock actuel : " +  Main.videotheque.getStock().get(0).getNombreStock());
        this.panelCaracteristique.add(stockDispo);

        this.panelCaracteristique.add(new JLabel());
        this.panelCaracteristique.add(new JLabel());

        labelDate1 = new JLabel("Veuillez saisir la date de fin ");
        this.panelCaracteristique.add(labelDate1);

        panelAjoutDate = new PanelAjoutDate();
        this.panelCaracteristique.add(panelAjoutDate);

        labelDate2 = new JLabel("d'emprunt au format jj/mm/yyyy");
        this.panelCaracteristique.add(labelDate2);

        this.panelCaracteristique.add(new JLabel());this.add(new JLabel());
        this.panelCaracteristique.add(messageErreur = new JLabel("Veuillez verifier la date et/ou la disponibilité"));
        messageErreur.setForeground(Color.RED);

        this.panelCaracteristique.add(new JLabel());this.panelCaracteristique.add(new JLabel());

        btnValiderEmprunt = new JButton("Valider cet emprunt");
        this.panelCaracteristique.add(btnValiderEmprunt);
        btnValiderEmprunt.addActionListener(ecouteurAjouterCommande);

        this.panelCaracteristique.add(new JLabel());this.panelCaracteristique.add(new JLabel());

        btnValiderCommande = new JButton("Valider la Commande");
        this.panelCaracteristique.add(btnValiderCommande);
        btnValiderCommande.addActionListener(ecouteurAjouterCommande);

        panelListeEmprunt = new PanelListe();
        this.add(panelListeEmprunt);
        panelListeEmprunt.liste.setText("");
        panelListeEmprunt.liste.setColumns(40);
        panelListeEmprunt.liste.setRows(10);
        panelListeEmprunt.setVisible(true);

        total = new JLabel();
        this.panelListeEmprunt.add(total);
        total.setVisible(true);
    }

    /**
     * Cette methode permet de configurer le panel pour le choix d'un client
     *
     * On laissera visible uniquement la comoBox de choix client
     * et le bouton pour valider le client si la comboBox n'est pas vide
     *
     * On rendra tout le reste invisible
     */
    public void premierePhase()
    {
        comboClient.setVisible(true);
        if ( Main.videotheque.getListClient().size() > 0)
        {
            btnValiderClient.setVisible(true);
        }
        else
        {
            btnValiderClient.setVisible(false);
        }

        totalCommande = 0;
        labelClient.setVisible(false);
        labelEmprunt.setVisible(false);
        comboProduit.setVisible(false);
        stockDispo.setVisible(false);
        labelDate1.setVisible(false);
        panelAjoutDate.setVisible(false);
            panelAjoutDate.clear();
        labelDate2.setVisible(false);
        messageErreur.setVisible(false);
        btnValiderEmprunt.setVisible(false);
        btnValiderCommande.setVisible(false);

        panelCaracteristique.setVisible(true);
        panelListeEmprunt.setVisible(false);

        total.setText("Total de la commande (sans réduction) : ");

        this.genererListeClient();
        if ( Main.videotheque.getListClient().size() > 0)
        {
            this.genererListeProduit();
        }
    }

    /**
     * Cette methode permet de configurer le panel pour l'ajout des emprunts
     *
     * On cache le choix du client et on affiche son nom
     * on laisse la partie pour choisir un produit et la date visible
     * On affiche egalement la liste de la commande en cours et son montant
     */
    public void deuxiemePhase()
    {
        comboClient.setVisible(false);
        btnValiderClient.setVisible(false);

        labelClient.setVisible(true);
        labelClient.setText("     " +  Main.videotheque.getListClient().get(comboClient.getSelectedIndex()).getNom()
                + " " +  Main.videotheque.getListClient().get(comboClient.getSelectedIndex()).getPrenom());

        labelEmprunt.setVisible(true);
        comboProduit.setVisible(true);
            comboProduit.setSelectedIndex(0);
        stockDispo.setVisible(true);
        labelDate1.setVisible(true);
        panelAjoutDate.setVisible(true);
            panelAjoutDate.clear();
        labelDate2.setVisible(true);
        messageErreur.setVisible(false);
        btnValiderEmprunt.setVisible(true);

        panelListeEmprunt.setVisible(true);
    }

    /**
     * Cette methode permet de generer la liste des produit dans la comboBox
     *
     * On cherche tout les produits existants dans le stock
     */
    public void genererListeProduit()
    {
        comboProduit.removeAllItems();

        for (Produit produit: Main.videotheque.getStock())
        {
            comboProduit.addItem( produit.getTitre() + " | " +  produit.getIdentifiant());
        }
    }

    /**
     * Cette methode permet de generer la liste des client dans la comboBox.
     *
     * On cherche tout les clients existants dans la liste
     */
    public void genererListeClient()
    {
        comboClient.removeAllItems();

        for (Client client : Main.videotheque.getListClient())
        {
            comboClient.addItem( client.getNom() + " " +  client.getPrenom() + " | " +  client.getIdentifiant());
        }
    }

    /**
     * Cette methode permet de mettre a jour le stock affiché.
     *
     * On recupere juste le stock actuel que l'on affiche
     */
    public void majStock()
    {
        int indexProduit = comboProduit.getSelectedIndex();
        if(panelCaracteristique.isVisible() && indexProduit > -1)
        {
            stockDispo.setText("     stock actuel : " +  Main.videotheque.getStock().get(indexProduit).getNombreStock());
        }
    }

    /**
     * Cette methode permet de vider la liste des emprunt en cours
     *
     * Lorsque l'on ajoute une commande les emprunts en cours sont stocké dans une liste.
     * Si l'on quitte le menu d'ajout de commande, il faut alors vider la liste des emprunts en cours.
     * On vide egalement la liste des emprunts dans la commande.
     * On re augmentera le stock de chaque produit dans les emprunts.
     */
    public void clearListeEmpruntEnCours()
    {
        for (Emprunt emprunt : this.ecouteurAjouterCommande.empruntAAssigner)
        {
            emprunt.removeProduitEmprunt();
        }
        this.ecouteurAjouterCommande.empruntAAssigner.clear();
        this.ecouteurAjouterCommande.panelAjouterCommande.panelListeEmprunt.liste.setText("");
    }
}
