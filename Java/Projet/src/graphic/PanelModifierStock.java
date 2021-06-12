package graphic;

import ecouteur.EcouteurModifierStock;
import main.Main;
import produit.*;
import tools.Type;

import javax.swing.*;
import java.awt.*;

public class PanelModifierStock extends JPanel
{
    public JPanel panelSelection = new JPanel();

    public PanelAjouterStock panelModifierProduitSelect;
    public JComboBox comboStock;
    public JButton btnModifier;

    public PanelModifierStock()
    {
    //Partie pour modifier un client----------------------------
        panelModifierProduitSelect = new PanelAjouterStock();
        panelModifierProduitSelect.btnValiderProduit.setText("Valider la modification");
        panelModifierProduitSelect.comboTypeProduit.setEnabled(false);
        panelModifierProduitSelect.setVisible(false);
        panelModifierProduitSelect.identifiantProduit.setEnabled(false);
        panelModifierProduitSelect.labelErreur.setText("Veuillez verifier les informations saisie");

        panelModifierProduitSelect.btnValiderProduit.addActionListener(new EcouteurModifierStock(this));

        this.add(panelModifierProduitSelect);
    //------------------------------------------------------------------
    //Partie pour selectionner un client----------------------------
        comboStock = new JComboBox();
        comboStock.setPreferredSize(new Dimension(400, 25));
        this.panelSelection.add(comboStock);

        btnModifier = new JButton("Modifier Stock");
        btnModifier.addActionListener(new EcouteurModifierStock(this));
        this.panelSelection.add(btnModifier);

        this.add(panelSelection);
    //------------------------------------------------------------------
    }

    /**
     * Cette methode permet d'initialiser la comboBox Stock.
     *
     * On ajoute tout les produits presents dans le stock.
     * Si la comboBox n'est pas vide, on rend le bouton de validation visible.
     */
    public void initComboStock()
    {
        comboStock.removeAllItems();
        this.btnModifier.setVisible(false);

        for (Produit produit :  Main.videotheque.getStock())
        {
            comboStock.addItem(produit.getClass().getSimpleName() + " | " + produit.getTitre() + " | " + produit.getIdentifiant());
        }
        if( Main.videotheque.getStock().size() > 0)
        {
            this.btnModifier.setVisible(true);
        }
    }

    /**
     * Cette methode permet de rendre visible les bonnes specifications en fonction de la comboBox.
     */
    public void preparationAffichageProduit()
    {
        this.panelModifierProduitSelect.cacherSpec();

        switch (this.panelModifierProduitSelect.comboTypeProduit.getSelectedIndex())
        {
            case 0,1,2 :
                this.panelModifierProduitSelect.auteurLivre.setVisible(true);
                this.panelModifierProduitSelect.labelAuteurLivre.setVisible(true);
                break;

            case 3 :
                this.panelModifierProduitSelect.comboLangueDictionnaire.setVisible(true);
                this.panelModifierProduitSelect.labelLangueDictionnaire.setVisible(true);
                break;

            case 4 :
                this.panelModifierProduitSelect.anneeCD.setVisible(true);
                this.panelModifierProduitSelect.labelAnneeCD.setVisible(true);
                break;

            case 5 :
                this.panelModifierProduitSelect.realisateur.setVisible(true);
                this.panelModifierProduitSelect.labelRealisateur.setVisible(true);
                break;

            default:
                break;
        }
    }

    /**
     * Cette methode permet de transferer les infos du prdouits dans le panel.
     *
     * @param produit Produit dont on recupere les informations
     */
    public void transfertInfoProduit(Produit produit)
    {
        Type typeProduit = Type.valueOf(produit.getClass().getSimpleName());
        this.panelModifierProduitSelect.comboTypeProduit.setSelectedItem(typeProduit);

        switch (produit.getClass().getSimpleName())
        {
            case "BD":
            {
                BD bd = (BD)produit;

                this.panelModifierProduitSelect.nomProduit.setText(bd.getTitre());
                this.panelModifierProduitSelect.identifiantProduit.setText(bd.getIdentifiant());
                this.panelModifierProduitSelect.nombreStock.setText(String.valueOf(bd.getNombreStock()));
                this.panelModifierProduitSelect.tarifJournalier.setText(String.valueOf(bd.getTarifJournalier()));
                this.panelModifierProduitSelect.auteurLivre.setText(bd.getAuteur());

                break;
            }

            case "Roman" :
            {
                Roman roman = (Roman)produit;

                this.panelModifierProduitSelect.nomProduit.setText(roman.getTitre());
                this.panelModifierProduitSelect.identifiantProduit.setText(roman.getIdentifiant());
                this.panelModifierProduitSelect.nombreStock.setText(String.valueOf(roman.getNombreStock()));
                this.panelModifierProduitSelect.tarifJournalier.setText(String.valueOf(roman.getTarifJournalier()));
                this.panelModifierProduitSelect.auteurLivre.setText(roman.getAuteur());

                break;
            }

            case "ManuelScolaire" :
            {
                ManuelScolaire manuelScolaire = (ManuelScolaire)produit;

                this.panelModifierProduitSelect.comboTypeProduit.setSelectedItem(manuelScolaire.getClass().getSimpleName());
                this.panelModifierProduitSelect.nomProduit.setText(manuelScolaire.getTitre());
                this.panelModifierProduitSelect.identifiantProduit.setText(manuelScolaire.getIdentifiant());
                this.panelModifierProduitSelect.nombreStock.setText(String.valueOf(manuelScolaire.getNombreStock()));
                this.panelModifierProduitSelect.tarifJournalier.setText(String.valueOf(manuelScolaire.getTarifJournalier()));
                this.panelModifierProduitSelect.auteurLivre.setText(manuelScolaire.getAuteur());

                break;
            }

            case "Dictionnaire" :
            {
                Dictionnaire dictionnaire = (Dictionnaire) produit;

                this.panelModifierProduitSelect.nomProduit.setText(dictionnaire.getTitre());
                this.panelModifierProduitSelect.identifiantProduit.setText(dictionnaire.getIdentifiant());
                this.panelModifierProduitSelect.nombreStock.setText(String.valueOf(dictionnaire.getNombreStock()));
                this.panelModifierProduitSelect.tarifJournalier.setText(String.valueOf(dictionnaire.getTarifJournalier()));
                this.panelModifierProduitSelect.comboLangueDictionnaire.setSelectedItem(dictionnaire.getLangue());

                break;
            }

            case "CD" :
            {
                CD cd = (CD)produit;

                this.panelModifierProduitSelect.nomProduit.setText(cd.getTitre());
                this.panelModifierProduitSelect.identifiantProduit.setText(cd.getIdentifiant());
                this.panelModifierProduitSelect.nombreStock.setText(String.valueOf(cd.getNombreStock()));
                this.panelModifierProduitSelect.tarifJournalier.setText(String.valueOf(cd.getTarifJournalier()));
                this.panelModifierProduitSelect.anneeCD.setText(String.valueOf(cd.getAnneeSortie()));

                break;
            }

            case "DVD" :
            {
                DVD dvd = (DVD)produit;

                this.panelModifierProduitSelect.nomProduit.setText(dvd.getTitre());
                this.panelModifierProduitSelect.identifiantProduit.setText(dvd.getIdentifiant());
                this.panelModifierProduitSelect.nombreStock.setText(String.valueOf(dvd.getNombreStock()));
                this.panelModifierProduitSelect.tarifJournalier.setText(String.valueOf(dvd.getTarifJournalier()));
                this.panelModifierProduitSelect.realisateur.setText(dvd.getRealisateur());

                break;
            }

            default:
                System.out.println("Erreur panel Stock modifier trasnfert info produit");
        }
    }
}
