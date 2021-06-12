package ecouteur;

import graphic.PanelSupprimerClient;
import main.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurSupprimerClient implements ActionListener
{
    PanelSupprimerClient panelSupprimerClient;

    public EcouteurSupprimerClient(PanelSupprimerClient panelSupprimerClient)
    {
        this.panelSupprimerClient = panelSupprimerClient;
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == panelSupprimerClient.btnSupprimer)
        {
            int res = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment supprimer "
                    + panelSupprimerClient.comboClient.getItemAt(panelSupprimerClient.comboClient.getSelectedIndex())
                    + " ?", "Supprimer un client", JOptionPane.YES_NO_OPTION);

            if(res == 0)
            {
                int numClient = panelSupprimerClient.comboClient.getSelectedIndex();

                Main.videotheque.supprimerClient(numClient);
                panelSupprimerClient.comboInit();

                JOptionPane.showMessageDialog(null,"Suppression du client effectuée");
            }
        }

        if (e.getSource() == panelSupprimerClient.comboClient)
        {
            if (panelSupprimerClient.comboClient.getItemCount() == 0)
            {
                panelSupprimerClient.btnSupprimer.setVisible(false);
            }
            else
            {
                panelSupprimerClient.btnSupprimer.setVisible(true);
            }
        }
    }
}
