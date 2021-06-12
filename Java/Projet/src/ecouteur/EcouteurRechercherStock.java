package ecouteur;

import graphic.PanelRechercherStock;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurRechercherStock implements ActionListener
{
    PanelRechercherStock panelCourant;
    public EcouteurRechercherStock(PanelRechercherStock panelRechercherStock)
    {
        this.panelCourant = panelRechercherStock;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(panelCourant.textFieldTitre == e.getSource() || panelCourant.btnRechercher == e.getSource())
        {
            panelCourant.textFieldTitre.setText(panelCourant.textFieldTitre.getText().trim());
            panelCourant.initListeStock(panelCourant.textFieldTitre.getText());

            JOptionPane.showMessageDialog(null,"Recherche effectuée");

        }
    }
}
