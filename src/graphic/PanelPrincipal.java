package graphic;

import java.awt.*;

import javax.swing.*;

public class PanelPrincipal extends JPanel
{
	public JButton boutonAcces;
	public JButton btnClient;
	public JButton btnStock;
	public JButton btnCommande;
	public PanelClient panelClient;
	public PanelChoix panelChoix;
	public PanelStock panelStock;
	public PanelCommande panelCommande;

	public PanelPrincipal()
	{
		this.setBackground(Color.blue);

		boutonAcces = new JButton("Bienvenue");
		this.add(boutonAcces, BorderLayout.NORTH);

//CHOIX
		panelChoix = new PanelChoix();
		this.add(panelChoix);
		this.panelChoix.setVisible(false);


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
