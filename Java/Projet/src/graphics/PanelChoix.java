package graphics;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelChoix extends JPanel
{
	public JButton btnClient, btnStock, btnCommande;
		
	public PanelChoix()
	{
		this.setLayout(new FlowLayout());
		this.setBackground(Color.red);
		
		btnClient = new JButton("Liste Client");
		this.add(btnClient);
		
		btnCommande = new JButton("Liste Commannde");
		this.add(btnCommande);
		
		btnStock = new JButton("Stock");
		this.add(btnStock);
		
	}
}
