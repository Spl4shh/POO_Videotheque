package graphics;

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


//a enlever, juste la methode pour afficher du contenu

		JTextArea textArea = new JTextArea( 10, 70);
		textArea.setText("Hello \n there \n you read \n my \n message \n ahah \n funny riught\n \n not \n for \n me");
		textArea.setLineWrap(true);
		textArea.setText("My brain is giant\n" + textArea.getText());

		JScrollPane jpe = new JScrollPane(textArea);
		JScrollBar verticalScrollBar;
		jpe.setVerticalScrollBar(verticalScrollBar = new JScrollBar());

		this.add(jpe);
	}
	
}
