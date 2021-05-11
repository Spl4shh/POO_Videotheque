package graphic;

import client.Client;
import commande.Commande;
import commande.Emprunt;
import main.Main;

import javax.swing.*;
import java.awt.*;

public class PanelModifierCommande extends JPanel
{
    public JComboBox comboClient, comboCommande, comboEmprunt;
    public JPanel panelSelectionEmprunt = new JPanel();

    public JButton btnSupprimer, btnAjouter, btnModifier;
    public PanelAjouterCommande panelModificationCommande;


    public PanelModifierCommande()
    {
        this.setLayout(new GridLayout(0, 2));

        panelModificationCommande = new PanelAjouterCommande();
        panelModificationCommande.remove(panelModificationCommande.btnValiderClient);
        panelModificationCommande.remove(panelModificationCommande.comboClient);
        panelModificationCommande.remove(panelModificationCommande.btnValiderCommande);
        panelModificationCommande.btnValiderEmprunt.setText("Valider les modifications");

        this.add(panelModificationCommande);


        comboClient = new JComboBox();
        comboCommande = new JComboBox();
        comboEmprunt = new JComboBox();

        panelSelectionEmprunt.setLayout(new GridLayout(0, 2));

        panelSelectionEmprunt.add(new JLabel(""));
        panelSelectionEmprunt.add(comboClient);

        panelSelectionEmprunt.add(new JLabel(""));panelSelectionEmprunt.add(new JLabel(""));panelSelectionEmprunt.add(new JLabel(""));panelSelectionEmprunt.add(new JLabel(""));panelSelectionEmprunt.add(new JLabel(""));
        panelSelectionEmprunt.add(comboCommande);

        panelSelectionEmprunt.add(new JLabel(""));panelSelectionEmprunt.add(new JLabel(""));panelSelectionEmprunt.add(new JLabel(""));panelSelectionEmprunt.add(new JLabel(""));panelSelectionEmprunt.add(new JLabel(""));
        panelSelectionEmprunt.add(comboEmprunt);

        btnSupprimer = new JButton("Supprimer emprunt");
        panelSelectionEmprunt.add(btnSupprimer);
        this.btnSupprimer.setVisible(false);

        panelSelectionEmprunt.add(new JLabel(""));

        btnAjouter = new JButton("Ajouter emprunt");
        panelSelectionEmprunt.add(btnAjouter);
        this.btnAjouter.setVisible(false);

        btnModifier = new JButton("Modifier emprunt");
        panelSelectionEmprunt.add(btnModifier);
        this.btnModifier.setVisible(false);

        this.add(panelSelectionEmprunt);
    }

    public void resetChamp()
    {
        this.panelModificationCommande.panelAjoutDate.jour.setText("");
        this.panelModificationCommande.panelAjoutDate.mois.setText("");
        this.panelModificationCommande.panelAjoutDate.annee.setText("");

        //this.panelModificationCommande.comboProduit.setSelectedIndex(0);
        this.panelModificationCommande.messageErreur.setVisible(false);
    }


    public void initComboProduit()
    {
        panelModificationCommande.comboProduit.removeAllItems();

        for (int i = 0; i < Main.listProduit.size(); i++)
        {
            panelModificationCommande.comboProduit.addItem(Main.listProduit.get(i).getTitre() + " | " + Main.listProduit.get(i).getIdentifiant());
        }
    }

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

    public void initComboClient()
    {
        comboClient.removeAllItems();

        for (Client client : Main.listClient)
        {
            comboClient.addItem(client.getNom() + " " + client.getPrenom());
        }
        if(Main.listClient.size() > 0)
        {
            this.initComboCommande();
        }
    }

    public void initComboCommande()
    {
        comboCommande.removeAllItems();

        Client clientEnCours = Main.listClient.get(comboClient.getSelectedIndex());

        for (Commande commande : clientEnCours.getListeCommande())
        {
            comboCommande.addItem("Commande " + commande.getIdentifiant());
        }

        if(clientEnCours.getListeCommande().size() > 0)
        {
            this.initComboEmprunt();
        }
    }

    public void initComboEmprunt()
    {
        comboEmprunt.removeAllItems();

        Client clientEnCours = Main.listClient.get(comboClient.getSelectedIndex());
        Commande commandeEnCours = clientEnCours.getListeCommande().get(comboCommande.getSelectedIndex());

        for (Emprunt emprunt : commandeEnCours.getListeEmprunt())
        {
            comboEmprunt.addItem(emprunt.getProduitConcerne().getTitre() + " | " + emprunt.getProduitConcerne().getIdentifiant());
        }
    }
}
