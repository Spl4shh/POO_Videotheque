package ecouteur;

import graphic.PanelSupprimerStock;
import main.Main;
import produit.Produit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurSupprimerStock implements ActionListener
{
    PanelSupprimerStock panelSupprimerStock;

    public EcouteurSupprimerStock(PanelSupprimerStock panelSupprimerStock)
    {
        this.panelSupprimerStock = panelSupprimerStock;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == panelSupprimerStock.btnSupprimer)
        {
            int res = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment supprimer "
                    + panelSupprimerStock.comboStock.getItemAt(panelSupprimerStock.comboStock.getSelectedIndex())
                    + " ?", "Supprimer un produit", JOptionPane.YES_NO_OPTION);

            if(res == 0)
            {
                int numProd = panelSupprimerStock.comboStock.getSelectedIndex();
                Produit produit = Main.videotheque.getStock().get(numProd);

                if(Main.videotheque.nombreEmprunt(produit) == 0)
                {
                    Main.videotheque.supprimerStock(numProd);
                    panelSupprimerStock.comboInit();
                    JOptionPane.showMessageDialog(null,"Suppression du produit effectuée");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Ce produit est toujours assigné à une commande !" + "\n" + "Impossible de le supprimer");
                }
            }
        }

        if (e.getSource() == panelSupprimerStock.comboStock)
        {
            if (panelSupprimerStock.comboStock.getItemCount() == 0)
            {
                panelSupprimerStock.btnSupprimer.setVisible(false);
            }
            else
            {
                panelSupprimerStock.btnSupprimer.setVisible(true);
            }
        }
    }
}
