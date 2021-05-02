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

        //partie test a supprimer------------------------
        JButton btn1 = new JButton("test");
        JButton btn2 = new JButton("test2");
        JButton btn3 = new JButton("test3");
        JButton btn4 = new JButton("test4");
        JButton btn5 = new JButton("tets5");
        JButton btn6 = new JButton("test6");
        JButton btn7 = new JButton("test7");
        JButton btn8 = new JButton("test8");
        JButton btn9 = new JButton("test9");
        JButton btn10 = new JButton("test10");
        JButton btn11 = new JButton("tets11");
        JButton btn12 = new JButton("test12");

        listeBouton.add(btn1);listeBouton.add(btn2);listeBouton.add(btn3);listeBouton.add(btn4);listeBouton.add(btn5);listeBouton.add(btn6);listeBouton.add(btn7);listeBouton.add(btn8);listeBouton.add(btn9);listeBouton.add(btn10);listeBouton.add(btn11);listeBouton.add(btn12);
        //------------------------------------------------



        gridBouton.setLayout(new GridLayout(0, 1));//si jamais, mettre le column a 1
        gridBouton.setSize(400, 500);

        //Gerer l'importation de la liste des clients dans une liste

/*A activer une fois que des commande seront créé

        for (Client client : Main.listClient )
        {
            for (Commande commande : client.getListeCommande())
            {
                gridBouton.add(new JButton(commande.getIdentifiant()));
            }
        }
*/


//Possible d'implementer au dessus la partie en desous


        for (int i = 0; i < listeBouton.size(); i++)
        {
            gridBouton.add(listeBouton.get(i));
        }


        scrollPanel = new JScrollPane(gridBouton);
        scrollPanel.setVerticalScrollBar(verticalScrollBar);
        scrollPanel.setPreferredSize(new Dimension(500, 300));

        this.add(scrollPanel);
    }


}