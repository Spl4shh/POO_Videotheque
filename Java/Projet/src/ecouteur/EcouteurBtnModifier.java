package ecouteur;

import graphic.Frame;
import main.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurBtnModifier implements ActionListener
{
    Frame frame;

    public EcouteurBtnModifier(Frame f)
    {
        this.frame = f;

        frame.panelPrincipal.panelStock.btnModifier.addActionListener(this);
        frame.panelPrincipal.panelCommande.btnModifier.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (frame.panelPrincipal.panelStock.btnModifier == e.getSource())
        {
            frame.panelPrincipal.panelStock.panelAjouterStock.setVisible(false);
            frame.panelPrincipal.panelStock.panelGestion.panelListe.setVisible(false);
            frame.panelPrincipal.panelStock.panelSupprimerStock.setVisible(false);

            frame.panelPrincipal.panelStock.panelModifierStock.gridBouton.setVisible(true);
            frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.setVisible(false);

            frame.panelPrincipal.panelStock.panelModifierStock.btnInit();

            EcouteurBtnModifierStock ecouteurBtnModifierStock = new EcouteurBtnModifierStock(frame);

            Main.recharger(frame.panelPrincipal.panelStock.panelModifierStock);
        }

        if (frame.panelPrincipal.panelCommande.btnModifier == e.getSource())
        {
            frame.panelPrincipal.panelCommande.panelAjouterCommande.setVisible(false);
            frame.panelPrincipal.panelCommande.panelGestion.panelListe.setVisible(false);
            frame.panelPrincipal.panelCommande.panelSupprimerCommande.setVisible(false);

            frame.panelPrincipal.panelCommande.panelModifierCommande.setVisible(true);
            frame.panelPrincipal.panelCommande.panelModifierCommande.init();

        }
    }
}
