package graphic;

import javax.swing.*;
import java.awt.*;

public class PanelClient extends JPanel
{
    public PanelGestion panelGestion;
    public PanelEntete panelEntete;
    public PanelAjouterClient panelAjouterClient;
    public PanelSupprimerClient panelSupprimerClient;
    public PanelModifierClient panelModifierClient;

    public PanelClient()
    {
        this.setBackground(Color.yellow);
        this.setLayout(new BorderLayout());

        panelEntete = new PanelEntete();
        this.add(panelEntete, "North");
        this.panelEntete.titre.setText("Client");

        panelGestion = new PanelGestion();
        this.add(panelGestion);

        panelAjouterClient = new PanelAjouterClient();
        this.panelGestion.add(panelAjouterClient);
        this.panelAjouterClient.setVisible(false);

        panelSupprimerClient = new PanelSupprimerClient();
        this.panelGestion.add(panelSupprimerClient);
        this.panelSupprimerClient.setVisible(false);

        panelModifierClient = new PanelModifierClient();
        this.panelGestion.add(panelModifierClient);
        this.panelModifierClient.setVisible(false);
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
        this.panelAjouterClient.setBackground(couleurPanelValeur);
        this.panelAjouterClient.checkOccasionnel.setBackground(couleurPanelValeur);
        this.panelAjouterClient.checkFidele.setBackground(couleurPanelValeur);
        this.panelAjouterClient.labelNom.setForeground(couleurTexte);
        this.panelAjouterClient.labelPrenom.setForeground(couleurTexte);
        this.panelAjouterClient.labelId.setForeground(couleurTexte);
        this.panelAjouterClient.labelFidele.setForeground(couleurTexte);
        this.panelAjouterClient.checkFidele.setForeground(couleurTexte);
        this.panelAjouterClient.checkOccasionnel.setForeground(couleurTexte);
        //Supprimer
        this.panelSupprimerClient.setBackground(couleurPanelValeur);
        //Modifier
        this.panelModifierClient.setBackground(couleurPanelValeur);
        this.panelModifierClient.panelModificationClient.setBackground(couleurPanelValeur);
        this.panelModifierClient.panelSelection.setBackground(couleurPanelValeur);
        this.panelModifierClient.panelModificationClient.checkOccasionnel.setBackground(couleurPanelValeur);
        this.panelModifierClient.panelModificationClient.checkFidele.setBackground(couleurPanelValeur);
        this.panelModifierClient.panelModificationClient.labelNom.setForeground(couleurTexte);
        this.panelModifierClient.panelModificationClient.labelPrenom.setForeground(couleurTexte);
        this.panelModifierClient.panelModificationClient.labelId.setForeground(couleurTexte);
        this.panelModifierClient.panelModificationClient.labelFidele.setForeground(couleurTexte);
        this.panelModifierClient.panelModificationClient.checkFidele.setForeground(couleurTexte);
        this.panelModifierClient.panelModificationClient.checkOccasionnel.setForeground(couleurTexte);
        //Contour
        this.panelGestion.setBackground(couleurPanelValeur);
    }
}
