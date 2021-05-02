package graphic;

import main.Main;

import javax.swing.*;
import java.awt.*;

public class PanelAjouterCommande extends JPanel
{
    public JComboBox comboProduit, comboClient;
    public JButton btnValiderClient, btnValiderEmprunt;
    public JTextField jour, mois, annee;
    public JLabel stockDispo, labelEmprunt, labelClient, labelDate1, labelDate2, messageErreur;
    public JPanel ajoutDate;

    public PanelAjouterCommande()
    {
        this.setLayout(new GridLayout(0, 2));


        comboClient = new JComboBox();

        for (int i = 0; i < Main.listClient.size(); i++)
        {
            comboClient.addItem(Main.listClient.get(i).getNom() + "_" + Main.listClient.get(i).getPrenom());
        }
        this.add(comboClient);

        btnValiderClient = new JButton("Valider");
        this.add(btnValiderClient);

        this.add(labelEmprunt  = new JLabel("Emprunt :"));

        this.add(labelClient = new JLabel());


        comboProduit = new JComboBox();

        for (int i = 0; i < Main.listProduit.size(); i++)
        {
            comboProduit.addItem(Main.listProduit.get(i).getTitre());
        }
        this.add(comboProduit);

        stockDispo = new JLabel("     stock actuel : " + Main.listProduit.get(0).getNombreStock());
        this.add(stockDispo);

        this.add(new JLabel());
        this.add(new JLabel());

        labelDate1 = new JLabel("Veuillez saisir la date de fin ");
        this.add(labelDate1);

        ajoutDate = new JPanel();
            jour = new JTextField(2);
            ajoutDate.add(jour);
            ajoutDate.add(new JLabel("/"));
            mois = new JTextField(2);
            ajoutDate.add(mois);
            ajoutDate.add(new JLabel("/"));
            annee = new JTextField(4);
            ajoutDate.add(annee);
        this.add(ajoutDate);

        labelDate2 = new JLabel("d'emprunt au format jj/mm/yyyy");
        this.add(labelDate2);

        this.add(new JLabel());this.add(new JLabel());
        this.add(messageErreur = new JLabel("Veuillez verifier la date et la disponibilitée"));
        messageErreur.setForeground(Color.RED);

        btnValiderEmprunt = new JButton("Valider cet emprunt");
        this.add(btnValiderEmprunt);
    }

    public void premierePhase()
    {
        comboClient.setVisible(true);
        btnValiderClient.setVisible(true);

        labelClient.setVisible(false);
        labelEmprunt.setVisible(false);
        comboProduit.setVisible(false);
        stockDispo.setVisible(false);
        labelDate1.setVisible(false);
        ajoutDate.setVisible(false);
        labelDate2.setVisible(false);
        messageErreur.setVisible(false);
        btnValiderEmprunt.setVisible(false);
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
        ajoutDate.setVisible(true);
            jour.setText("");
            mois.setText("");
            annee.setText("");
        labelDate2.setVisible(true);
        messageErreur.setVisible(false);
        btnValiderEmprunt.setVisible(true);
    }
}
