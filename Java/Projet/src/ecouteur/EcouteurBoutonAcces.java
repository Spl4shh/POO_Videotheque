package ecouteur;

import graphics.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class EcouteurBoutonAcces implements ActionListener
{
	Frame frameEntree;
	
	public EcouteurBoutonAcces(Frame f)
	{
		frameEntree = f;
		frameEntree.panelPrincipal.boutonAcces.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(frameEntree.panelPrincipal.boutonAcces == e.getSource())
		{
			frameEntree.panelPrincipal.boutonAcces.setVisible(false);

			frameEntree.panelPrincipal.panelChoix.setVisible(true);
			frameEntree.panelPrincipal.panelChoix.setBackground(Color.blue);
		}
	}

}
