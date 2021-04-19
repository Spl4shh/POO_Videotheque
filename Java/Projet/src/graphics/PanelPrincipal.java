package graphics;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;

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
		this.add(boutonAcces);
		
		panelChoix = new PanelChoix();
		this.add(panelChoix);
		this.panelChoix.setVisible(false);

		panelClient = new PanelClient();
		this.add(panelClient);
		this.panelClient.setVisible(false);

		panelCommande = new PanelCommande();
		this.add(panelCommande);
		this.panelCommande.setVisible(false);

		panelStock = new PanelStock();
		this.add(panelStock);
		this.panelStock.setVisible(false);
	}
	
}
