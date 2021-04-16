package graphics;


import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Frame extends JFrame
{
	JFrame frame;
	public PanelPrincipal panelPrincipal;
	public PanelChoix panelChoix;
	
	public Frame()
	{
		frame = new JFrame("Gestion d'une bibliotheque");
		frame.setVisible(true);
		frame.setSize(400, 200);
		frame.setLocation(200, 200);

		frame.add(panelPrincipal = new PanelPrincipal());
	}
}
