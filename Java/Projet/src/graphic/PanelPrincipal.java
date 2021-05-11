package graphic;

import java.awt.*;

import javax.swing.*;

public class PanelPrincipal extends JPanel
{
	public JButton boutonAcces, boutonRechercher;
	public PanelClient panelClient;
	public PanelChoix panelChoix;
	public PanelStock panelStock;
	public PanelCommande panelCommande;
	public PanelRechercher panelRechercher;

	public PanelPrincipal()
	{
		this.setBackground(Color.blue);

		boutonAcces = new JButton("Bienvenue");
		this.add(boutonAcces);

//CHOIX
		panelChoix = new PanelChoix();
		this.add(panelChoix);
		this.panelChoix.setVisible(false);

//RECHERCHER
		boutonRechercher = new JButton("Rechercher");
		this.panelChoix.add(boutonRechercher);

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
}
