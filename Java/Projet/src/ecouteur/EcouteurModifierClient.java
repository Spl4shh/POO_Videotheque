package ecouteur;

import client.Client;
import graphic.PanelModifierClient;
import main.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurModifierClient implements ActionListener
{
    PanelModifierClient panelModifierClient;

    public EcouteurModifierClient(PanelModifierClient panelModifierClient)
    {
        this.panelModifierClient = panelModifierClient;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {


        if (panelModifierClient.btnModifier == e.getSource())
        {
            Client clientCourant = Main.videotheque.getListClient().get
                    (panelModifierClient.comboClient.getSelectedIndex());

            panelModifierClient.transfertInfoClient(clientCourant);
        }

        if (panelModifierClient.panelModificationClient.valider == e.getSource())
        {
            for (int i = 0; i < Main.videotheque.getListClient().size(); i++)
            {
                if (Main.videotheque.getListClient().get(i).getIdentifiant().trim().equals(panelModifierClient.panelModificationClient.textFieldId.getText().trim()))
                {
                    panelModifierClient.transfertModification();
                    JOptionPane.showMessageDialog(null,"Le client "
                            + panelModifierClient.panelModificationClient.textFieldNom.getText()
                            + " " + panelModifierClient.panelModificationClient.textFieldPrenom.getText() + " a bien été modifié");
                }
            }
        }
    }
}
