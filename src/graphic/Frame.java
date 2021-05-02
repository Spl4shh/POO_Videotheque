package graphic;


import java.awt.*;

import javax.swing.*;

public class Frame extends JFrame
{
	JFrame frame;
	public PanelPrincipal panelPrincipal;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	public Frame()
	{
		frame = new JFrame();
		frame.setTitle("Gestion d'une Videotheque");
		frame.setSize(1000, 700);
		frame.setLocation((int)screenSize.getWidth()/2 - frame.getWidth()/2, (int)screenSize.getHeight()/2 - frame.getHeight()/2);
		frame.setLayout(new BorderLayout());

		panelPrincipal = new PanelPrincipal();
		frame.add(panelPrincipal, "Center");

		frame.setVisible(true);
	}
}
