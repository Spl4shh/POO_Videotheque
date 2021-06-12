package graphic;

import client.Client;
import commande.Commande;
import ecouteur.EcouteurSupprimerCommande;
import main.Main;

import javax.swing.*;
import java.awt.*;

public class PanelSupprimerCommande extends JPanel
{
    public JComboBox comboCommande;
    public JButton btnSupprimer;

    public PanelSupprimerCommande()
    {
        comboCommande = new JComboBox();
        this.add(comboCommande);
        comboCommande.setPreferredSize(new Dimension(400, 25));

        btnSupprimer = new JButton("Supprimer");
        this.add(btnSupprimer);
        btnSupprimer.addActionListener(new EcouteurSupprimerCommande(this));

    }

    /**
     * Cette methode permet d'initialiser la comboBox.
     *
     * Rend le bouton supprimer visible si la comboBox n'est pas vide.
     */
    public void comboInit()
    {
        comboCommande.removeAllItems();

        for (Client client : Main.videotheque.getListClient())
        {
            for (Commande commande : client.getListeCommande())
            {
                comboCommande.addItem("Commande " + commande.getIdentifiant() + " | " + commande.getListeEmprunt().size() + " emprunt | "
                        + client.getNom() + " " + client.getPrenom());
            }
        }

        if (comboCommande .getItemCount() == 0)
        {
            btnSupprimer.setVisible(false);
        }
    }
}
