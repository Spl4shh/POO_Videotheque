package ecouteur;

import graphic.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurBtnListe implements ActionListener
{
    Frame frame;

    public EcouteurBtnListe(Frame f)
    {
        this.frame = f;
        this.frame.panelPrincipal.panelCommande.panelEntete.panelBtnASV.btnVoir.addActionListener(this);
        this.frame.panelPrincipal.panelClient.panelEntete.panelBtnASV.btnVoir.addActionListener(this);
        this.frame.panelPrincipal.panelStock.panelEntete.panelBtnASV.btnVoir.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        //Client-------------------------------------------------------------
        if (frame.panelPrincipal.panelClient.panelEntete.panelBtnASV.btnVoir == e.getSource())
        {
            frame.panelPrincipal.panelClient.panelGestion.panelListe.initListeClient();

            frame.panelPrincipal.panelClient.panelGestion.panelListe.setVisible(true);
            frame.panelPrincipal.panelClient.panelAjouterClient.setVisible(false);
            frame.panelPrincipal.panelClient.panelSupprimerClient.setVisible(false);

        }

        //Commande-------------------------------------------------------------
        if (frame.panelPrincipal.panelCommande.panelEntete.panelBtnASV.btnVoir == e.getSource())
        {
            frame.panelPrincipal.panelCommande.panelGestion.panelListe.initListeCommande();

            frame.panelPrincipal.panelCommande.panelAjouterCommande.setVisible(false);
            frame.panelPrincipal.panelCommande.panelGestion.panelListe.setVisible(true);
            frame.panelPrincipal.panelCommande.panelListeEmprunt.setVisible(false);
            frame.panelPrincipal.panelCommande.panelModifierCommande.setVisible(false);
            frame.panelPrincipal.panelCommande.panelSupprimerCommande.setVisible(false);
        }

        //Stock-------------------------------------------------------------
        if (frame.panelPrincipal.panelStock.panelEntete.panelBtnASV.btnVoir == e.getSource())
        {
            frame.panelPrincipal.panelStock.panelGestion.panelListe.initListeProduit();

            frame.panelPrincipal.panelStock.panelGestion.panelListe.setVisible(true);
            frame.panelPrincipal.panelStock.panelAjouterStock.setVisible(false);
            frame.panelPrincipal.panelStock.panelSupprimerStock.setVisible(false);
            frame.panelPrincipal.panelStock.panelModifierStock.setVisible(false);
        }
    }
}
