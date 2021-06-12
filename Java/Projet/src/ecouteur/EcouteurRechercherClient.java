package ecouteur;

import graphic.PanelRechercherClient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurRechercherClient implements ActionListener
{
    PanelRechercherClient panelRechercherClient;

    public EcouteurRechercherClient(PanelRechercherClient panelRechercherClient)
    {
        this.panelRechercherClient = panelRechercherClient;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(panelRechercherClient.textFieldNom == e.getSource() || panelRechercherClient.btnRechercher == e.getSource())
        {
            panelRechercherClient.textFieldNom.setText(panelRechercherClient.textFieldNom.getText().trim());
            panelRechercherClient.initListeClient(panelRechercherClient.textFieldNom.getText());

            JOptionPane.showMessageDialog(null,"Recherche effectuée");
        }
    }
}
