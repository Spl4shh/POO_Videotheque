package graphic;

import javax.swing.*;
import java.awt.*;

public class PanelCommande extends JPanel
{
    public PanelGestion panelGestion;
    public PanelEntete panelEntete;
    public PanelAjouterCommande panelAjouterCommande;
    public PanelSupprimerCommande panelSupprimerCommande;
    public PanelModifierCommande panelModifierCommande;

    public PanelCommande()
    {
        this.setLayout(new BorderLayout());

        panelEntete = new PanelEntete();
        this.add(panelEntete, "North");
        this.panelEntete.titre.setText("Commande");

        panelGestion = new PanelGestion();
        this.add(panelGestion, "Center");

        panelAjouterCommande = new PanelAjouterCommande();
        this.panelGestion.add(panelAjouterCommande);
        this.panelAjouterCommande.setVisible(false);

        panelSupprimerCommande = new PanelSupprimerCommande();
        this.panelGestion.add(panelSupprimerCommande);
        this.panelSupprimerCommande.setVisible(false);

        panelModifierCommande = new PanelModifierCommande();
        this.panelGestion.add(panelModifierCommande);
        this.panelModifierCommande.setVisible(false);
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
        this.panelAjouterCommande.setBackground(couleurPanelValeur);
        this.panelAjouterCommande.panelCaracteristique.setBackground(couleurPanelValeur);
        this.panelAjouterCommande.panelAjoutDate.setBackground(couleurPanelValeur);
        this.panelAjouterCommande.panelListeEmprunt.setBackground(couleurPanelValeur);
        this.panelAjouterCommande.labelClient.setForeground(couleurTexte);
        this.panelAjouterCommande.labelEmprunt.setForeground(couleurTexte);
        this.panelAjouterCommande.labelDate1.setForeground(couleurTexte);
        this.panelAjouterCommande.labelDate2.setForeground(couleurTexte);
        this.panelAjouterCommande.labelDate2.setForeground(couleurTexte);
        this.panelAjouterCommande.stockDispo.setForeground(couleurTexte);
        this.panelAjouterCommande.total.setForeground(couleurTexte);
        //Supprimer
        this.panelSupprimerCommande.setBackground(couleurPanelValeur);
        //Modifier
        this.panelModifierCommande.setBackground(couleurPanelValeur);
        this.panelModifierCommande.panelSelectionEmprunt.setBackground(couleurPanelValeur);
        this.panelModifierCommande.panelModificationCommande.setBackground(couleurPanelValeur);
        this.panelModifierCommande.panelModificationCommande.panelAjoutDate.setBackground(couleurPanelValeur);
        this.panelModifierCommande.panelModificationCommande.panelCaracteristique.setBackground(couleurPanelValeur);
        this.panelModifierCommande.panelModificationCommande.labelEmprunt.setForeground(couleurTexte);
        this.panelModifierCommande.panelModificationCommande.labelDate1.setForeground(couleurTexte);
        this.panelModifierCommande.panelModificationCommande.labelDate2.setForeground(couleurTexte);
        this.panelModifierCommande.panelModificationCommande.labelDate2.setForeground(couleurTexte);
        this.panelModifierCommande.panelModificationCommande.stockDispo.setForeground(couleurTexte);

        //Contour
        this.panelGestion.setBackground(couleurPanelValeur);
    }
}
