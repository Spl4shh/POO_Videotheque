package graphic;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel
{
	public PanelClient panelClient;
	public PanelStock panelStock;
	public PanelCommande panelCommande;
	public PanelRechercher panelRechercher;
	public PanelAccueil panelAccueil;

	public PanelPrincipal()
	{
//ACCUEIL
		panelAccueil = new PanelAccueil();
		this.add(panelAccueil);


//RECHERCHER
		panelRechercher = new PanelRechercher();
		this.add(panelRechercher);
		this.panelRechercher.setVisible(false);


//CLIENT
		panelClient = new PanelClient();
		this.add(panelClient);
		this.panelClient.setVisible(false);


//COMMANDE
		panelCommande = new PanelCommande();
		this.add(panelCommande);
		this.panelCommande.setVisible(false);


//STOCK
		panelStock = new PanelStock();
		this.add(panelStock);
		this.panelStock.setVisible(false);

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
		this.panelAccueil.titrePage.setForeground(couleurTexte);
		this.panelAccueil.setBackground(couleurFondPanel);
	}
}

