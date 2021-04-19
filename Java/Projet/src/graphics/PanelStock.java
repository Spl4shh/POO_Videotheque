package graphics;

import javax.swing.*;
import java.awt.*;

public class PanelStock extends JPanel
{
    JLabel titre;
    JButton btnAddStock, btnSuppStock, btnVoirStock;


    public PanelStock()
    {
        this.setBackground(Color.GREEN);

        titre = new JLabel("Ceci est le stock");
        this.add(titre);

        btnAddStock = new JButton("Ajouter");
        this.add(btnAddStock);

        btnSuppStock = new JButton("Supprimer");
        this.add(btnSuppStock);

        btnVoirStock = new JButton("Voir la liste");
        this.add(btnVoirStock);
    }
}
