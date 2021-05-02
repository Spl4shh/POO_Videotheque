package ecouteur;

import graphic.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurBtnChoix implements ActionListener
{
    Frame frame;

    public EcouteurBtnChoix(Frame f)
    {
        frame = f;
        frame.panelPrincipal.panelChoix.btnClient.addActionListener(this);
        frame.panelPrincipal.panelChoix.btnCommande.addActionListener(this);
        frame.panelPrincipal.panelChoix.btnStock.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //Client-------------------------------------------------------------
        if(frame.panelPrincipal.panelChoix.btnClient == e.getSource())
        {
            frame.panelPrincipal.panelClient.setVisible(true);
            frame.panelPrincipal.panelChoix.setVisible(false);
            frame.panelPrincipal.setBackground(frame.panelPrincipal.panelClient.getBackground());
        }

        //Commande-------------------------------------------------------------
        if(frame.panelPrincipal.panelChoix.btnCommande == e.getSource())
        {
            frame.panelPrincipal.panelCommande.setVisible(true);
            frame.panelPrincipal.panelChoix.setVisible(false);
            frame.panelPrincipal.setBackground(frame.panelPrincipal.panelCommande.getBackground());
        }

        //Stock-------------------------------------------------------------
        if(frame.panelPrincipal.panelChoix.btnStock == e.getSource())
        {
            frame.panelPrincipal.panelStock.setVisible(true);
            frame.panelPrincipal.panelChoix.setVisible(false);
            frame.panelPrincipal.setBackground(frame.panelPrincipal.panelStock.getBackground());
        }
    }
}
