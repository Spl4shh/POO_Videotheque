package ecouteur;

import graphic.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurBtnRecherche implements ActionListener
{
    Frame frame;

    public EcouteurBtnRecherche(Frame f)
    {
        this.frame = f;

        frame.panelPrincipal.panelRechercher.comboClient.addActionListener(this);
        frame.panelPrincipal.panelRechercher.comboCommande.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        frame.panelPrincipal.panelRechercher.clear();

        if (frame.panelPrincipal.panelRechercher.comboClient == e.getSource() )
        {
            frame.panelPrincipal.panelRechercher.genererListeCommande();
        }

        if (frame.panelPrincipal.panelRechercher.comboCommande == e.getSource() &&
                frame.panelPrincipal.panelRechercher.comboCommande.getItemCount() != 0)
        {
            frame.panelPrincipal.panelRechercher.afficherCommande();
        }
    }
}
