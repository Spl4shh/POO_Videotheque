package graphic;

import main.Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelSupprimerStock extends JPanel
{
    public JScrollBar verticalScrollBar;
    public ArrayList<JButton> listeBouton;

    public JScrollPane scrollPanel;
    public JPanel gridBouton = new JPanel();

    public PanelSupprimerStock()
    {
        verticalScrollBar = new JScrollBar();
        verticalScrollBar.setUnitIncrement(16);

        scrollPanel = new JScrollPane(gridBouton);

        scrollPanel.setVerticalScrollBar(verticalScrollBar);
        scrollPanel.setPreferredSize(new Dimension(500, 300));



        listeBouton = new ArrayList<JButton>();



        gridBouton.setLayout(new GridLayout(0, 1));
        gridBouton.setSize(400, 500);


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

        for (int i = 0; i < Main.listProduit.size(); i++)
        {
            this.listeBouton.add(new JButton(Main.listProduit.get(i).getType() + " / "
                    + Main.listProduit.get(i).getTitre() + " / "
                    + Main.listProduit.get(i).getIdentifiant()));
        }

        for (JButton bouton : listeBouton)
        {
            this.gridBouton.add(bouton);
        }
    }
}
