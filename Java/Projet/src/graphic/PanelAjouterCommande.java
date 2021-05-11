package graphic;

import main.Main;
import produit.Produit;

import javax.swing.*;
import java.awt.*;

public class PanelAjouterCommande extends JPanel
{
    public JComboBox comboProduit, comboClient;
    public JButton btnValiderClient, btnValiderEmprunt, btnValiderCommande;
    public JLabel stockDispo, labelEmprunt, labelClient, labelDate1, labelDate2, messageErreur;
    public PanelAjoutDate panelAjoutDate;
    public double totalCommande;


    public PanelAjouterCommande()
    {
        this.setLayout(new GridLayout(0, 2));


        comboClient = new JComboBox();
        this.add(comboClient);

        btnValiderClient = new JButton("Valider");
        this.add(btnValiderClient);

        this.add(labelEmprunt  = new JLabel("Emprunt :"));

        this.add(labelClient = new JLabel());


        comboProduit = new JComboBox();
        this.add(comboProduit);

        stockDispo = new JLabel("     stock actuel : " + Main.listProduit.get(0).getNombreStock());
        this.add(stockDispo);

        this.add(new JLabel());
        this.add(new JLabel());

        labelDate1 = new JLabel("Veuillez saisir la date de fin ");
        this.add(labelDate1);

        panelAjoutDate = new PanelAjoutDate();

        this.add(panelAjoutDate);

        labelDate2 = new JLabel("d'emprunt au format jj/mm/yyyy");
        this.add(labelDate2);

        this.add(new JLabel());this.add(new JLabel());
        this.add(messageErreur = new JLabel("Veuillez verifier la date et/ou la disponibilitée"));
        messageErreur.setForeground(Color.RED);

        btnValiderEmprunt = new JButton("Valider cet emprunt");
        this.add(btnValiderEmprunt);

        this.add(new JLabel());this.add(new JLabel());this.add(new JLabel());this.add(new JLabel());

        btnValiderCommande = new JButton("Valider la Commande");
        this.add(btnValiderCommande);
    }

    public void premierePhase()
    {
        comboClient.setVisible(true);
        if (Main.listClient.size() > 0)
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


        this.genererListeClient();
        if (Main.listClient.size() > 0)
        {
            this.genererListeProduit();
        }
    }

    public void deuxiemePhase()
    {
        comboClient.setVisible(false);
        btnValiderClient.setVisible(false);

        labelClient.setVisible(true);
        labelClient.setText("     " + Main.listClient.get(comboClient.getSelectedIndex()).getNom() + " " + Main.listClient.get(comboClient.getSelectedIndex()).getPrenom());

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
    }

    public void genererListeProduit()
    {
        comboProduit.removeAllItems();

        for (int i = 0; i < Main.listProduit.size(); i++)
        {
            comboProduit.addItem(Main.listProduit.get(i).getTitre() + " | " + Main.listProduit.get(i).getIdentifiant());
        }
    }

    public void genererListeClient()
    {
        comboClient.removeAllItems();

        for (int i = 0; i < Main.listClient.size(); i++)
        {
            comboClient.addItem(Main.listClient.get(i).getNom() + " " + Main.listClient.get(i).getPrenom() + " | " + Main.listClient.get(i).getIdentifiant());
        }
    }

    public void majStock()
    {
        int indexProduit = comboProduit.getSelectedIndex();
        stockDispo.setText("     stock actuel : " + Main.listProduit.get(indexProduit).getNombreStock());
    }
}
