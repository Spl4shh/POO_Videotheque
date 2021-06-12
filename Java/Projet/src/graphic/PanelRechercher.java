package graphic;

import javax.swing.*;
import java.awt.*;

public class PanelRechercher extends JPanel
{
    public PanelEntete panelEntete;
    public PanelRechercherCommande panelRechercherCommande;
    public PanelRechercherClient panelRechercherClient;
    public JPanel panelGestion;
    public PanelRechercherStock panelRechercherStock;

    public PanelRechercher()
    {
        this.setLayout(new BorderLayout());

        panelEntete = new PanelEntete();
        this.add(panelEntete, "North");
        this.panelEntete.titre.setText("Rechercher");

        panelGestion = new JPanel();
        this.add(panelGestion, "Center");

        panelRechercherCommande = new PanelRechercherCommande();
        this.panelGestion.add(panelRechercherCommande);
        panelRechercherCommande.setVisible(true);

        panelRechercherClient = new PanelRechercherClient();
        this.panelGestion.add(panelRechercherClient);
        panelRechercherClient.setVisible(false);

        panelRechercherStock = new PanelRechercherStock();
        this.panelGestion.add(panelRechercherStock);
        panelRechercherStock.setVisible(false);
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
        //Client
        this.panelRechercherClient.setBackground(couleurPanelValeur);
        this.panelRechercherClient.panelSelection.setBackground(couleurPanelValeur);
        this.panelRechercherClient.panelNom.setBackground(couleurPanelValeur);
        this.panelRechercherClient.panelBtn.setBackground(couleurPanelValeur);
        this.panelRechercherClient.labelNomClient.setForeground(couleurTexte);
        //Commande
        this.panelRechercherCommande.setBackground(couleurPanelValeur);
        this.panelRechercherCommande.panelSelection.setBackground(couleurPanelValeur);
        //Stock
        this.panelRechercherStock.setBackground(couleurPanelValeur);
        this.panelRechercherStock.panelSelection.setBackground(couleurPanelValeur);
        this.panelRechercherStock.panelNom.setBackground(couleurPanelValeur);
        this.panelRechercherStock.panelBtn.setBackground(couleurPanelValeur);
        this.panelRechercherStock.labelTitreStock.setForeground(couleurTexte);
        //Contour
        this.panelGestion.setBackground(couleurPanelValeur);
    }
}
