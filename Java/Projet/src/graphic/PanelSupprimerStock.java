package graphic;

import ecouteur.EcouteurSupprimerStock;
import main.Main;
import produit.Produit;

import javax.swing.*;
import java.awt.*;

public class PanelSupprimerStock extends JPanel
{
    public JComboBox comboStock;
    public JButton btnSupprimer;

    public PanelSupprimerStock()
    {

        comboStock = new JComboBox();
        this.add(comboStock);
        comboStock.setPreferredSize(new Dimension(400, 25));
        comboStock.addActionListener(new EcouteurSupprimerStock(this));

        btnSupprimer = new JButton("Supprimer");
        this.add(btnSupprimer);
        btnSupprimer.addActionListener(new EcouteurSupprimerStock(this));

    }

    /**
     * Cette methode permet d'initialiser la comboBox.
     *
     * Rend le bouton supprimer visible si la comboBox n'est pas vide.
     */
    public void comboInit()
    {
        comboStock.removeAllItems();

        for (Produit produit : Main.videotheque.getStock())
        {
            comboStock.addItem(produit.getClass().getSimpleName() + " | " + produit.getTitre() + " | " + produit.getIdentifiant());
        }

        if (comboStock .getItemCount() == 0)
        {
            btnSupprimer.setVisible(false);
        }
    }
}
