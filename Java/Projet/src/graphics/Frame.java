package graphics;


import java.awt.*;

import javax.swing.*;

public class Frame extends JFrame
{
	public JPanel panelPlaceHolder;
	JFrame frame;
	public PanelPrincipal panelPrincipal;
	public PanelChoix panelChoix;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	public Frame()
	{
		frame = new JFrame("Gestion d'une bibliotheque");
		frame.setVisible(true);
		frame.setSize(800, 400);
		frame.setLocation((int)screenSize.getWidth()/2 - frame.getWidth()/2, (int)screenSize.getHeight()/2 - frame.getHeight()/2);

		frame.add(panelPrincipal = new PanelPrincipal());

		frame.setResizable(false);

	}
}
