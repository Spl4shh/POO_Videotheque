package ecouteur;

import graphic.Frame;
import main.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurBtnSupprimerClient implements ActionListener
{
    Frame frame;

    public EcouteurBtnSupprimerClient(Frame f)
    {
        frame = f;

        for (int i = 0; i < frame.panelPrincipal.panelClient.panelSupprimerClient.listeBouton.size(); i++)
        {
            frame.panelPrincipal.panelClient.panelSupprimerClient.listeBouton.get(i).addActionListener(this);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        int i = frame.panelPrincipal.panelClient.panelSupprimerClient.listeBouton.indexOf(e.getSource());

        //Main.listClient.remove(i);
        frame.panelPrincipal.panelClient.panelSupprimerClient.listeBouton.remove(i);
        frame.panelPrincipal.panelClient.panelSupprimerClient.gridBouton.remove(i);

        //supprimer le client du fichier texte et supprimer les commandes et les emprunts

        frame.panelPrincipal.panelClient.panelSupprimerClient.setVisible(false);
        frame.panelPrincipal.panelClient.panelSupprimerClient.setVisible(true);
    }
}
