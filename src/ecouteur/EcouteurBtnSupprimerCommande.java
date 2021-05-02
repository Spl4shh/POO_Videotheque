package ecouteur;

import client.Client;
import commande.Commande;
import graphic.Frame;
import main.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurBtnSupprimerCommande implements ActionListener
{
    Frame frame;

    public EcouteurBtnSupprimerCommande(Frame f)
    {
        frame = f;

        for (int i = 0; i < frame.panelPrincipal.panelCommande.panelSupprimerCommande.listeBouton.size(); i++)
        {
            frame.panelPrincipal.panelCommande.panelSupprimerCommande.listeBouton.get(i).addActionListener(this);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        int i = frame.panelPrincipal.panelCommande.panelSupprimerCommande.listeBouton.indexOf(e.getSource());
        String id = frame.panelPrincipal.panelCommande.panelSupprimerCommande.listeBouton.get(i).getText();

/*A activer quand il y aura des commande pour les clients

        for (Client client : Main.listClient)
        {
            for (Commande commande: client.getListeCommande())
            {
                if (commande.getIdentifiant().equals(id))
                {
                    client.getListeCommande().remove(commande);
                }
            }
        }
*/
        //Main.listClient.remove(i);
        frame.panelPrincipal.panelCommande.panelSupprimerCommande.listeBouton.remove(i);
        frame.panelPrincipal.panelCommande.panelSupprimerCommande.gridBouton.remove(i);

        //supprimer le client du fichier texte et supprimer les commandes et les emprunts

        frame.panelPrincipal.panelCommande.panelSupprimerCommande.setVisible(false);
        frame.panelPrincipal.panelCommande.panelSupprimerCommande.setVisible(true);
    }
}
