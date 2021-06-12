package graphic;

import javax.swing.*;
import java.awt.*;

public class PanelStock extends JPanel
{
    public JButton btnModifier;
    public PanelGestion panelGestion;
    public PanelEntete panelEntete;
    public PanelAjouterStock panelAjouterStock;
    public PanelSupprimerStock panelSupprimerStock;
    public PanelModifierStock panelModifierStock;

    public PanelStock()
    {
        this.setBackground(Color.GREEN);
        this.setLayout(new BorderLayout());

        panelEntete = new PanelEntete();
        this.add(panelEntete, "North");
        this.panelEntete.titre.setText("Stock");

        panelGestion = new PanelGestion();
        this.add(panelGestion);

        panelAjouterStock = new PanelAjouterStock();
        this.panelGestion.add(panelAjouterStock);
        this.panelAjouterStock.setVisible(false);

        panelSupprimerStock = new PanelSupprimerStock();
        this.panelGestion.add(panelSupprimerStock);
        this.panelSupprimerStock.setVisible(false);

        panelModifierStock = new PanelModifierStock();
        this.panelGestion.add(panelModifierStock);
        this.panelModifierStock.setVisible(false);
    }

    /**
     * Cette methode permet de changer de couleur le panel.
     *
     * On applique au differentes zones les couleurs en parametre.
     *
     * @param couleurFondPanel couleur qui sera appliqué en fond
     * @param couleurTexte couleur qui sera appliqué au texte
     * @param couleurPanelValeur couleur qui sera appliqué au panel au premier plan
     */
    public void modifierCouleur(Color couleurTexte, Color couleurFondPanel, Color couleurPanelValeur)
    {
        this.setBackground(couleurFondPanel);
        this.panelEntete.setBackground(couleurPanelValeur);
        this.panelEntete.titre.setForeground(couleurTexte);
        //Ajouter
        this.panelAjouterStock.setBackground(couleurPanelValeur);
        this.panelAjouterStock.labelNomProduit.setForeground(couleurTexte);
        this.panelAjouterStock.labelIdentifiantProduit.setForeground(couleurTexte);
        this.panelAjouterStock.labelNombreStock.setForeground(couleurTexte);
        this.panelAjouterStock.labelTarifJournalier.setForeground(couleurTexte);
        this.panelAjouterStock.labelAuteurLivre.setForeground(couleurTexte);
        this.panelAjouterStock.labelLangueDictionnaire.setForeground(couleurTexte);
        this.panelAjouterStock.labelAnneeCD.setForeground(couleurTexte);
        this.panelAjouterStock.labelRealisateur.setForeground(couleurTexte);
        //Supprimer
        this.panelSupprimerStock.setBackground(couleurPanelValeur);
        //Modifier
        this.panelModifierStock.setBackground(couleurPanelValeur);
        this.panelModifierStock.panelSelection.setBackground(couleurPanelValeur);
        this.panelModifierStock.panelModifierProduitSelect.setBackground(couleurPanelValeur);
        this.panelModifierStock.panelModifierProduitSelect.setBackground(couleurPanelValeur);
        this.panelModifierStock.panelModifierProduitSelect.labelNomProduit.setForeground(couleurTexte);
        this.panelModifierStock.panelModifierProduitSelect.labelIdentifiantProduit.setForeground(couleurTexte);
        this.panelModifierStock.panelModifierProduitSelect.labelNombreStock.setForeground(couleurTexte);
        this.panelModifierStock.panelModifierProduitSelect.labelTarifJournalier.setForeground(couleurTexte);
        this.panelModifierStock.panelModifierProduitSelect.labelAuteurLivre.setForeground(couleurTexte);
        this.panelModifierStock.panelModifierProduitSelect.labelLangueDictionnaire.setForeground(couleurTexte);
        this.panelModifierStock.panelModifierProduitSelect.labelAnneeCD.setForeground(couleurTexte);
        this.panelModifierStock.panelModifierProduitSelect.labelRealisateur.setForeground(couleurTexte);
        //Contour
        this.panelGestion.setBackground(couleurPanelValeur);
    }
}
