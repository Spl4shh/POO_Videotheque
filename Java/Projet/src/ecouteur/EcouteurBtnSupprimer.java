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
            frame.panelPrincipal.panelClient.panelSupprimerClient.btnInit();

            EcouteurBtnSupprimerClient ecouteurBtnSupprimerClient = new EcouteurBtnSupprimerClient(frame);

            frame.panelPrincipal.panelClient.panelSupprimerClient.setVisible(true);
            frame.panelPrincipal.panelClient.panelAjouterClient.setVisible(false);
            frame.panelPrincipal.panelClient.panelGestion.panelListe.setVisible(false);
        }
        
        
        //Commande-------------------------------------------------------------------------------------
        if (frame.panelPrincipal.panelCommande.panelEntete.panelBtnASV.btnSupp == e.getSource())
        {
            frame.panelPrincipal.panelCommande.panelSupprimerCommande.btnInit();

            EcouteurBtnSupprimerCommande ecouteurBtnSupprimerCommande = new EcouteurBtnSupprimerCommande(frame);

            frame.panelPrincipal.panelCommande.panelAjouterCommande.setVisible(false);
            frame.panelPrincipal.panelCommande.panelGestion.panelListe.setVisible(false);
            frame.panelPrincipal.panelCommande.panelListeEmprunt.setVisible(false);
            frame.panelPrincipal.panelCommande.panelModifierCommande.setVisible(false);
            frame.panelPrincipal.panelCommande.panelSupprimerCommande.setVisible(true);
        }

        //Stock--------------------------------------------------------------------------------------
        if (frame.panelPrincipal.panelStock.panelEntete.panelBtnASV.btnSupp == e.getSource())
        {
            frame.panelPrincipal.panelStock.panelSupprimerStock.btnInit();

            EcouteurBtnSupprimerStock ecouteurBtnSupprimerStock = new EcouteurBtnSupprimerStock(frame);

            frame.panelPrincipal.panelStock.panelSupprimerStock.setVisible(true);
            frame.panelPrincipal.panelStock.panelAjouterStock.setVisible(false);
            frame.panelPrincipal.panelStock.panelGestion.panelListe.setVisible(false);
            frame.panelPrincipal.panelStock.panelModifierStock.setVisible(false);


        }
    }
}
