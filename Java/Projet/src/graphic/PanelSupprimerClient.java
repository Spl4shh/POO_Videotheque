package graphic;


import client.Client;
import ecouteur.EcouteurSupprimerClient;
import main.Main;

import javax.swing.*;
import java.awt.*;

public class PanelSupprimerClient extends JPanel
{
    public JComboBox comboClient;
    public JButton btnSupprimer;

    public PanelSupprimerClient()
    {

        comboClient = new JComboBox();
        this.add(comboClient);
        comboClient.setPreferredSize(new Dimension(400, 25));
        comboClient.addActionListener(new EcouteurSupprimerClient(this));

        btnSupprimer = new JButton("Supprimer");
        this.add(btnSupprimer);
        btnSupprimer.addActionListener(new EcouteurSupprimerClient(this));

    }

    /**
     * Cette methode permet d'initialiser la comboBox.
     *
     * Rend le bouton supprimer visible si la comboBox n'est pas vide.
     */
    public void comboInit()
    {
        comboClient.removeAllItems();

        for (Client client : Main.videotheque.getListClient())
        {
            comboClient.addItem(client.getClass().getSimpleName() + " | " + client.getNom() + " " + client.getPrenom() + " | " + client.getIdentifiant());
        }

        if (comboClient .getItemCount() == 0)
        {
            btnSupprimer.setVisible(false);
        }
    }
}
