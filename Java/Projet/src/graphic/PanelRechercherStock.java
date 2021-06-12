package graphic;

import ecouteur.EcouteurRechercherStock;
import main.Main;
import produit.Produit;

import javax.swing.*;
import java.awt.*;

public class PanelRechercherStock extends JPanel
{
    public JPanel panelSelection;
    public JTextArea liste;
    public JScrollPane scrollListe;
    public JScrollBar verticalScrollBar;
    public JLabel labelTitreStock;
    public JTextField textFieldTitre;
    public JButton btnRechercher;
    public JPanel panelNom;
    public JPanel panelBtn;

    public PanelRechercherStock()
    {
        this.setLayout(new BorderLayout());

        panelSelection = new JPanel();
        panelSelection.setLayout(new GridLayout(0, 1));

        panelNom = new JPanel();

        labelTitreStock = new JLabel("Titre ou ID du produit :");
        this.panelNom.add(labelTitreStock);

        textFieldTitre = new JTextField(16);
        this.panelNom.add(textFieldTitre);
        textFieldTitre.addActionListener(new EcouteurRechercherStock(this));

        this.panelSelection.add(panelNom);

        panelBtn = new JPanel();

        btnRechercher = new JButton("Rechercher");
        this.panelBtn.add(btnRechercher);
        btnRechercher.addActionListener(new EcouteurRechercherStock(this));

        this.panelSelection.add(panelBtn);

        this.add(panelSelection, BorderLayout.WEST);

        //Creation de la liste pour afficher les differents textes
        liste = new JTextArea( 20, 60);
        liste.setEditable(false);

        scrollListe = new JScrollPane(liste);

        verticalScrollBar = new JScrollBar();
        verticalScrollBar.setUnitIncrement(16);

        scrollListe.setVerticalScrollBar(verticalScrollBar);
        this.add(scrollListe, BorderLayout.EAST);
    }

    /**
     * Cette methode permet d'initialiser la liste des produits en fonction d'un titre ou d'un ID
     *
     * @param titreProduit Le titre ou l'ID du produit
     */
    public void initListeStock(String titreProduit)
    {
        this.clear();
        for (Produit produit :  Main.videotheque.getStock() )
        {
            if (produit.getTitre().contains(titreProduit) || produit.getIdentifiant().contains(titreProduit))
            {
                String textPrec = this.liste.getText();
                this.liste.setText(textPrec + "Produit n° " + produit.getIdentifiant() + " : " + produit.getTitre() + " | Type : "
                        + produit.getClass().getSimpleName() + " | cout journalier : " + produit.getTarifJournalier() + "€ | nombre en stock :"
                        + produit.getNombreStock() + "\n");
            }

        }
    }

    /**
     * Cette methode permet de nettoyer la liste
     */
    public void clear()
    {
        this.liste.setText("");
    }
}

