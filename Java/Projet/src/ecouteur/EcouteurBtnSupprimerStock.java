package ecouteur;

import graphic.Frame;
import main.Main;
import produit.Produit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurBtnSupprimerStock implements ActionListener
{
    Frame frame;

    public EcouteurBtnSupprimerStock(Frame f)
    {
        frame = f;

        for (int i = 0; i < frame.panelPrincipal.panelStock.panelSupprimerStock.listeBouton.size(); i++)
        {
            frame.panelPrincipal.panelStock.panelSupprimerStock.listeBouton.get(i).addActionListener(this);

        }
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        int numProd = frame.panelPrincipal.panelStock.panelSupprimerStock.listeBouton.indexOf(e.getSource());
        Produit produit = Main.listProduit.get(numProd);

        if(Main.nombreEmprunt(produit) == 0)
        {
            Main.listProduit.remove(numProd);
            frame.panelPrincipal.panelStock.panelSupprimerStock.listeBouton.remove(numProd);
            frame.panelPrincipal.panelStock.panelSupprimerStock.gridBouton.remove(numProd);
        }

        Main.recharger(frame.panelPrincipal.panelStock.panelSupprimerStock);
    }
}
