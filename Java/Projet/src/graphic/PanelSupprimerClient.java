package graphic;

import client.Client;
import client.Fidele;
import main.Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelSupprimerClient extends JPanel
{
    public JScrollBar verticalScrollBar;
    public ArrayList<JButton> listeBouton;

    public JScrollPane scrollPanel;
    public JPanel gridBouton = new JPanel();

    public PanelSupprimerClient()
    {
        verticalScrollBar = new JScrollBar();
        verticalScrollBar.setUnitIncrement(16);

        scrollPanel = new JScrollPane(gridBouton);

        scrollPanel.setVerticalScrollBar(verticalScrollBar);
        scrollPanel.setPreferredSize(new Dimension(500, 300));



        listeBouton = new ArrayList<JButton>();




        gridBouton.setLayout(new GridLayout(0, 1));//si jamais, mettre le column a 1
        gridBouton.setSize(400, 500);

        //Gerer l'importation de la liste des clients dans une liste

        /*
        for (int i = 0; i < Main.listClient.size(); i++)
        {
            listeBouton.add(new JButton(Main.listClient.get(i).getNom() + " "
                    + Main.listClient.get(i).getPrenom()));
        }
        */


//Possible d'implementer au dessus la partie en desous


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

        for (int i = 0; i < Main.listClient.size(); i++)
        {
            this.listeBouton.add(new JButton( Main.listClient.get(i).getNom() + " "
                    + Main.listClient.get(i).getPrenom()));
        }

        for (JButton bouton : listeBouton)
        {
            this.gridBouton.add(bouton);
        }
    }
}
