package ecouteur;

import client.Client;
import commande.Commande;
import graphic.PanelSupprimerCommande;
import main.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurSupprimerCommande implements ActionListener
{
    PanelSupprimerCommande panelSupprimerCommande;

    public EcouteurSupprimerCommande(PanelSupprimerCommande panelSupprimerCommande)
    {
        this.panelSupprimerCommande = panelSupprimerCommande;

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == panelSupprimerCommande.btnSupprimer)
        {
            int res = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment supprimer "
                    + panelSupprimerCommande.comboCommande.getItemAt(panelSupprimerCommande.comboCommande.getSelectedIndex())
                    + " ?", "Acces", JOptionPane.YES_NO_OPTION);

            if(res == 0)
            {
                int numCommande = panelSupprimerCommande.comboCommande.getSelectedIndex();
                int compteur = -1;

                for (Client client : Main.videotheque.getListClient())
                {
                    for (Commande commande : client.getListeCommande())
                    {
                        compteur += 1;
                        if (compteur == numCommande)
                        {


                            client.removeCommande(commande);

                            JOptionPane.showMessageDialog(null,"Suppression de la commande effectuée");

                            break;
                        }
                    }
                }

                compteur = -1;
                panelSupprimerCommande.comboInit();

                JOptionPane.showMessageDialog(panelSupprimerCommande,"Suppression effectuée");
            }
        }

        if (e.getSource() == panelSupprimerCommande.comboCommande)
        {
            if (panelSupprimerCommande.comboCommande .getItemCount() == 0)
            {
                panelSupprimerCommande.btnSupprimer.setVisible(false);
            }
            else
            {
                panelSupprimerCommande.btnSupprimer.setVisible(true);
            }
        }
    }
}
