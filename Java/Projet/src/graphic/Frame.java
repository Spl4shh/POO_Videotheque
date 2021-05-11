package graphic;


import java.awt.*;

import javax.swing.*;

public class Frame extends JFrame
{
	public PanelPrincipal panelPrincipal;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	public Frame()
	{
		this.setTitle("Gestion d'une Videotheque");
		this.setSize(1080, 700);
		this.setLocation((int)screenSize.getWidth()/2 - this.getWidth()/2, (int)screenSize.getHeight()/2 - this.getHeight()/2);
		this.setLayout(new BorderLayout());

		panelPrincipal = new PanelPrincipal();
		this.add(panelPrincipal, "Center");

		this.setVisible(true);
	}
}
