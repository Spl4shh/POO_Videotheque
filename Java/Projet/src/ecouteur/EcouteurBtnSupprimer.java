package ecouteur;

import graphic.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurBtnSupprimer implements ActionListener
{
    Frame frame;

    public EcouteurBtnSupprimer(Frame f)
    {
        frame = f;
        frame.panelPrincipal.panelClient.panelEntete.panelBtnASV.btnSupp.addActionListener(this);
        frame.panelPrincipal.panelCommande.panelEntete.panelBtnASV.btnSupp.addActionListener(this);
        frame.panelPrincipal.panelStock.panelEntete.panelBtnASV.btnSupp.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //Client--------------------------------------------------------------------------------------
        if (frame.panelPrincipal.panelClient.panelEntete.panelBtnASV.btnSupp == e.getSource())
        {
            frame.panelPrincipal.panelClient.panelSupprimerClient.setVisible(true);
            frame.panelPrincipal.panelClient.panelAjouterClient.setVisible(false);
            frame.panelPrincipal.panelClient.panelGestion.panelListe.setVisible(false);
        }
        
        
        //Commande-------------------------------------------------------------------------------------
        if (frame.panelPrincipal.panelCommande.panelEntete.panelBtnASV.btnSupp == e.getSource())
        {
            frame.panelPrincipal.panelCommande.panelSupprimerCommande.setVisible(true);
            frame.panelPrincipal.panelCommande.panelAjouterCommande.setVisible(false);
            frame.panelPrincipal.panelCommande.panelGestion.panelListe.setVisible(false);
        }

        //Stock--------------------------------------------------------------------------------------
        if (frame.panelPrincipal.panelStock.panelEntete.panelBtnASV.btnSupp == e.getSource())
        {
            //frame.panelPrincipal.panelStock.panelSupprimerClient.setVisible(true);
            //frame.panelPrincipal.panelStock.panelAjouterClient.setVisible(false);
            frame.panelPrincipal.panelStock.panelGestion.panelListe.setVisible(false);
        }
    }
}
