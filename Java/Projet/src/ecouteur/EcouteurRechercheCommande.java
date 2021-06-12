package ecouteur;

import graphic.Frame;
import graphic.PanelRechercherCommande;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurRechercheCommande implements ActionListener
{
    PanelRechercherCommande panelCourant;

    public EcouteurRechercheCommande(PanelRechercherCommande panelRechercherCommande)
    {
        this.panelCourant = panelRechercherCommande;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        panelCourant.clear();


        if (panelCourant.comboClient == e.getSource() )
        {
            panelCourant.genererListeCommande();
        }

        if (panelCourant.comboCommande == e.getSource() &&
                panelCourant.comboCommande.getItemCount() != 0)
        {
            panelCourant.afficherCommande();
        }
    }
}
