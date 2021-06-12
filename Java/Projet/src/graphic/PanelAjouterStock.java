package graphic;

import ecouteur.EcouteurAjouterStock;
import tools.Langue;
import tools.Type;
import videotheque.Videotheque;

import javax.swing.*;
import java.awt.*;

public class PanelAjouterStock extends JPanel
{
    public JComboBox comboTypeProduit, comboLangueDictionnaire;
    public JTextField nomProduit, nombreStock, tarifJournalier, identifiantProduit, auteurLivre, anneeCD, realisateur;
    public JLabel labelNomProduit, labelNombreStock, labelTarifJournalier, labelIdentifiantProduit, labelAuteurLivre, labelLangueDictionnaire, labelAnneeCD, labelRealisateur, labelErreur;
    public JButton btnValiderProduit;

    public PanelAjouterStock()
    {
        this.setLayout(new GridLayout(0, 2));

        comboTypeProduit = new JComboBox();
        for(int i = 0; i < Type.values().length ; i++)
        {
            comboTypeProduit.addItem(Type.values()[i]);
        }
        this.add(comboTypeProduit);
        comboTypeProduit.addActionListener(new EcouteurAjouterStock(this));

        this.add(new JLabel());this.add(new JLabel());this.add(new JLabel());

        labelNomProduit = new JLabel("Nom : ");
        this.add(labelNomProduit);
        nomProduit = new JTextField(20);
        this.add(nomProduit);

        this.add(new JLabel());this.add(new JLabel());

        labelIdentifiantProduit = new JLabel("(auto) Identifiant : ");
        this.add(labelIdentifiantProduit);
        identifiantProduit = new JTextField(20);
        identifiantProduit.setEnabled(false);
        this.add(identifiantProduit);

        this.add(new JLabel());this.add(new JLabel());

        labelNombreStock = new JLabel("Quantité en stock : ");
        this.add(labelNombreStock);
        nombreStock = new JTextField(20);
        this.add(nombreStock);

        this.add(new JLabel());this.add(new JLabel());

        labelTarifJournalier = new JLabel("Tarif journalier : ");
        this.add(labelTarifJournalier);
        tarifJournalier = new JTextField(20);
        this.add(tarifJournalier);

        this.add(new JLabel());this.add(new JLabel());

        labelAuteurLivre = new JLabel("Auteur : ");
        this.add(labelAuteurLivre);
        auteurLivre = new JTextField(20);
        this.add(auteurLivre);

        labelLangueDictionnaire = new JLabel("Langue : ");
        this.add(labelLangueDictionnaire);
        comboLangueDictionnaire = new JComboBox();
        for (int i = 0; i < Langue.values().length; i++)
        {
            comboLangueDictionnaire.addItem(Langue.values()[i]);
        }
        this.add(comboLangueDictionnaire);

        labelAnneeCD = new JLabel("Année de sortie : ");
        this.add(labelAnneeCD);
        anneeCD = new JTextField(20);
        this.add(anneeCD);

        labelRealisateur = new JLabel("Réalisateur : ");
        this.add(labelRealisateur);
        realisateur = new JTextField(20);
        this.add(realisateur);

        this.add(new JLabel());this.add(new JLabel());

        labelErreur = new JLabel("Veuillez verifier les informations saisie");
        labelErreur.setForeground(Color.red);
        this.add(labelErreur);

        btnValiderProduit = new JButton("Valider le produit");
        this.add(btnValiderProduit);
        btnValiderProduit.addActionListener(new EcouteurAjouterStock(this));
    }

    /**
     * Cette methode permet de cacher les spécificté des produits.
     *
     * On laisse visible uniquement visible les informations generales.
     * On rend tout le reste non visible.
     */
    public void cacherSpec()
    {
        this.auteurLivre.setVisible(false);
        this.labelAuteurLivre.setVisible(false);
        this.comboLangueDictionnaire.setVisible(false);
        this.labelLangueDictionnaire.setVisible(false);
        this.anneeCD.setVisible(false);
        this.labelAnneeCD.setVisible(false);
        this.realisateur.setVisible(false);
        this.labelRealisateur.setVisible(false);
        this.labelErreur.setVisible(false);
    }

    /**
     * Cette methode permet de nettoyer le panel
     *
     * On cache toutes spécificités, on remet l'index du type de produit à 0,
     * on nettoie tout les champs de saisie,
     * on affecte l'identifiant juste au dessus de celui le plus haut enregistré.
     */
    public void clear()
    {
        this.cacherSpec();
        this.comboTypeProduit.setSelectedIndex(0);
        this.nomProduit.setText("");
        this.identifiantProduit.setText(String.valueOf(Videotheque.plusGrandIdProduit() + 1));
        this.nombreStock.setText("");
        this.tarifJournalier.setText("");
        this.auteurLivre.setText("");
        this.comboLangueDictionnaire.setSelectedIndex(0);
        this.anneeCD.setText("");
        this.realisateur.setText("");
    }
}
