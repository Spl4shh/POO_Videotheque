package ecouteur;

import graphics.*;
import graphics.Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener ;

public class EcouteurBtnAccueil implements ActionListener
{
    Frame frame;

    public EcouteurBtnAccueil(Frame frame)
    {
        this.frame = frame;
        frame.panelPrincipal.panelClient.btnAccueil.addActionListener( this);
        frame.panelPrincipal.panelCommande.btnAccueil.addActionListener( this);
        frame.panelPrincipal.panelStock.btnAccueil.addActionListener( this);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        frame.panelPrincipal.panelCommande.setVisible(false);
        frame.panelPrincipal.panelClient.setVisible(false);
        frame.panelPrincipal.panelStock.setVisible(false);

        frame.panelPrincipal.panelChoix.setVisible(true);
        frame.panelPrincipal.setBackground(Color.blue);

    }
}
