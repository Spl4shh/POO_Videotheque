package ecouteur;

import graphic.Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener ;

public class EcouteurBtnAccueil implements ActionListener
{
    Frame frame;

    public EcouteurBtnAccueil(Frame frame)
    {
        this.frame = frame;
        frame.panelPrincipal.panelClient.panelEntete.btnAccueil.addActionListener( this);
        frame.panelPrincipal.panelCommande.panelEntete.btnAccueil.addActionListener( this);
        frame.panelPrincipal.panelStock.panelEntete.btnAccueil.addActionListener( this);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //Client-------------------------------------------------------------
        if (frame.panelPrincipal.panelClient.panelEntete.btnAccueil == e.getSource())
        {
            frame.panelPrincipal.panelClient.setVisible(false);
            frame.panelPrincipal.panelClient.panelGestion.panelListe.setVisible(false);
            frame.panelPrincipal.panelClient.panelSupprimerClient.setVisible(false);
            frame.panelPrincipal.panelClient.panelAjouterClient.setVisible(false);
        }

        //Commande-------------------------------------------------------------
        if (frame.panelPrincipal.panelCommande.panelEntete.btnAccueil == e.getSource())
        {
            frame.panelPrincipal.panelCommande.setVisible(false);
            frame.panelPrincipal.panelCommande.panelAjouterCommande.setVisible(false);
            frame.panelPrincipal.panelCommande.panelGestion.panelListe.setVisible(false);
            frame.panelPrincipal.panelCommande.panelListeEmprunt.setVisible(false);
            frame.panelPrincipal.panelCommande.panelSupprimerCommande.setVisible(false);
        }

        //Stock-------------------------------------------------------------
        if (frame.panelPrincipal.panelStock.panelEntete.btnAccueil == e.getSource())
        {
            frame.panelPrincipal.panelStock.setVisible(false);
            frame.panelPrincipal.panelStock.panelGestion.panelListe.setVisible(false);
            frame.panelPrincipal.panelStock.panelSupprimerStock.setVisible(false);
            frame.panelPrincipal.panelStock.panelModifierStock.setVisible(false);
            frame.panelPrincipal.panelStock.panelAjouterStock.setVisible(false);
        }

        frame.panelPrincipal.panelChoix.setVisible(true);
        frame.panelPrincipal.setBackground(Color.blue);
    }
}
