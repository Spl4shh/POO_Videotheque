package graphic;

import client.Client;
import commande.Commande;
import main.Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelSupprimerCommande extends JPanel
{
    public JScrollBar verticalScrollBar;
    public ArrayList<JButton> listeBouton;

    public JScrollPane scrollPanel;
    public JPanel gridBouton = new JPanel();

    public PanelSupprimerCommande()
    {
        verticalScrollBar = new JScrollBar();
        verticalScrollBar.setUnitIncrement(16);

        scrollPanel = new JScrollPane(gridBouton);

        scrollPanel.setVerticalScrollBar(verticalScrollBar);
        scrollPanel.setPreferredSize(new Dimension(500, 300));



        listeBouton = new ArrayList<JButton>();


        gridBouton.setLayout(new GridLayout(0, 1));
        gridBouton.setSize(400, 500);

        
        for (JButton bouton : listeBouton)
        {
            gridBouton.add(bouton);
        }


        scrollPanel = new JScrollPane(gridBouton);
        scrollPanel.setVerticalScrollBar(verticalScrollBar);
        scrollPanel.setPreferredSize(new Dimension(500, 300));

        this.add(scrollPanel);
    }

    public void clear()
    {
        for (JButton bouton : this.listeBouton)
        {
            this.gridBouton.remove(bouton);
        }
        this.listeBouton.clear();
    }

    public void btnInit()
    {
        this.clear();

        for (Client client : Main.listClient )
        {
            for (Commande commande : client.getListeCommande())
            {
                listeBouton.add(new JButton("Commande numéro " + commande.getIdentifiant()));
            }
        }

        for (JButton bouton : listeBouton)
        {
            this.gridBouton.add(bouton);
        }
    }
}
