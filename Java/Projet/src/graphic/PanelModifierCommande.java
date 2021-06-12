package graphic;

import client.Client;
import commande.Commande;
import commande.Emprunt;
import ecouteur.EcouteurAjouterCommande;
import ecouteur.EcouteurModifierCommande;
import main.Main;

import javax.swing.*;
import java.awt.*;

public class PanelModifierCommande extends JPanel
{
    public JComboBox comboClient, comboCommande, comboEmprunt;
    public JPanel panelSelectionEmprunt;

    public JButton btnSupprimer, btnAjouter, btnModifier;
    public PanelAjouterCommande panelModificationCommande;
    EcouteurModifierCommande ecouteurModifierCommande = new EcouteurModifierCommande(this);

    public PanelModifierCommande()
    {
        panelModificationCommande = new PanelAjouterCommande();

        panelModificationCommande.btnValiderClient.setVisible(false);
        panelModificationCommande.btnValiderClient.removeActionListener(new EcouteurAjouterCommande(panelModificationCommande));
        panelModificationCommande.comboClient.removeActionListener(new EcouteurAjouterCommande(panelModificationCommande));
        panelModificationCommande.comboClient.setVisible(false);
        panelModificationCommande.btnValiderCommande.removeActionListener(new EcouteurAjouterCommande(panelModificationCommande));
        panelModificationCommande.btnValiderCommande.setVisible(false);

        panelModificationCommande.btnValiderEmprunt.setText("Valider les modifications");
        panelModificationCommande.panelCaracteristique.setVisible(true);
        panelModificationCommande.panelListeEmprunt.setVisible(false);

        this.add(panelModificationCommande);
        panelModificationCommande.btnValiderEmprunt.addActionListener(ecouteurModifierCommande);
        panelModificationCommande.comboProduit.addActionListener(ecouteurModifierCommande);


        panelSelectionEmprunt = new JPanel();
        panelSelectionEmprunt.setLayout(new GridLayout(0, 2));

        panelSelectionEmprunt.add(new JLabel(""));
        comboClient = new JComboBox();
        panelSelectionEmprunt.add(comboClient);
        comboClient.addActionListener(ecouteurModifierCommande);


        panelSelectionEmprunt.add(new JLabel(""));panelSelectionEmprunt.add(new JLabel(""));panelSelectionEmprunt.add(new JLabel(""));panelSelectionEmprunt.add(new JLabel(""));panelSelectionEmprunt.add(new JLabel(""));
        comboCommande = new JComboBox();
        panelSelectionEmprunt.add(comboCommande);
        comboCommande.addActionListener(ecouteurModifierCommande);

        panelSelectionEmprunt.add(new JLabel(""));panelSelectionEmprunt.add(new JLabel(""));panelSelectionEmprunt.add(new JLabel(""));panelSelectionEmprunt.add(new JLabel(""));panelSelectionEmprunt.add(new JLabel(""));
        comboEmprunt = new JComboBox();
        comboEmprunt.setPreferredSize(new Dimension(300,40));
        panelSelectionEmprunt.add(comboEmprunt);
        comboEmprunt.addActionListener(ecouteurModifierCommande);

        btnSupprimer = new JButton("Supprimer emprunt");
        panelSelectionEmprunt.add(btnSupprimer);
        this.btnSupprimer.setVisible(false);
        btnSupprimer.addActionListener(ecouteurModifierCommande);

        panelSelectionEmprunt.add(new JLabel(""));

        btnAjouter = new JButton("Ajouter emprunt");
        panelSelectionEmprunt.add(btnAjouter);
        this.btnAjouter.setVisible(false);
        btnAjouter.addActionListener(ecouteurModifierCommande);

        btnModifier = new JButton("Modifier emprunt");
        panelSelectionEmprunt.add(btnModifier);
        this.btnModifier.setVisible(false);
        btnModifier.addActionListener(ecouteurModifierCommande);

        this.add(panelSelectionEmprunt);
    }

    /**
     * Cette methode permet de reinitialiser tout les champs de saisie.
     *
     * On met tout les champs a vide
     */
    public void resetChamp()
    {
        this.panelModificationCommande.panelAjoutDate.jour.setText("");
        this.panelModificationCommande.panelAjoutDate.mois.setText("");
        this.panelModificationCommande.panelAjoutDate.annee.setText("");

        this.panelModificationCommande.messageErreur.setVisible(false);
    }

    /**
     * Cette methode permet d'initialiser la comboBox Produit.
     *
     * On recupere tout les produits existant dans le stock qu'on mettra dans
     * la comboBox
     */
    public void initComboProduit()
    {
        panelModificationCommande.comboProduit.removeAllItems();

        for (int i = 0; i <  Main.videotheque.getStock().size(); i++)
        {
            panelModificationCommande.comboProduit.addItem( Main.videotheque.getStock().get(i).getTitre()
                    + " | " +  Main.videotheque.getStock().get(i).getIdentifiant());
        }
    }

    /**
     * Cette methode permet d'initialiser tout le panel.
     *
     * On laisse visible uniquement le choix de l'emmprunt
     * et on initialise toutes les comboBox
     */
    public void init()
    {
        this.panelModificationCommande.setVisible(false);
        this.panelSelectionEmprunt.setVisible(true);
        this.btnAjouter.setVisible(false);
        this.btnModifier.setVisible(false);
        this.btnSupprimer.setVisible(false);
        this.initComboClient();
        this.initComboProduit();
    }

    /**
     * Cette methode permet d'initialiser la comboBox Client.
     *
     * On recupere tout les clients qui existe dans la liste et qu'on ajoute
     * dans la comboBox.
     * Si la comboBox n'est pas vide, on initialise la comboBox des commandes
     */
    public void initComboClient()
    {
        comboClient.removeAllItems();

        for (Client client :  Main.videotheque.getListClient())
        {
            comboClient.addItem(client.getNom() + " " + client.getPrenom());
        }
        if( Main.videotheque.getListClient().size() > 0)
        {
            this.initComboCommande();
        }
    }

    /**
     * Cette methode permet d'initialiser la comboBox Commande.
     *
     * On recupere toutes les commande qui existe dans la liste et qu'on ajoute
     * dans la comboBox.
     * Si la comboBox n'est pas vide, on initialise la comboBox des emprunts
     */
    public void initComboCommande()
    {
        comboCommande.removeAllItems();

        Client clientEnCours =  Main.videotheque.getListClient().get(comboClient.getSelectedIndex());

        for (Commande commande : clientEnCours.getListeCommande())
        {
            comboCommande.addItem("Commande " + commande.getIdentifiant());
        }

        if(clientEnCours.getListeCommande().size() > 0)
        {
            this.initComboEmprunt();
        }
    }

    /**
     * Cette methode permet d'initialiser la comboBox Emprunts.
     *
     * On recupere tout les emprunts qui existe dans la liste et qu'on ajoute
     * dans la comboBox
     */
    public void initComboEmprunt()
    {
        comboEmprunt.removeAllItems();

        Client clientEnCours =  Main.videotheque.getListClient().get(comboClient.getSelectedIndex());
        Commande commandeEnCours = clientEnCours.getListeCommande().get(comboCommande.getSelectedIndex());

        for (Emprunt emprunt : commandeEnCours.getListeEmprunt())
        {
            comboEmprunt.addItem(emprunt.getProduitConcerne().getTitre() + " | " + emprunt.getProduitConcerne().getIdentifiant());
        }
    }
}
