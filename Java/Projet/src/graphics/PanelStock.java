package graphics;

import javax.swing.*;
import java.awt.*;

public class PanelStock extends JPanel
{
    JLabel titre;
    JButton btnAddStock;
    JButton btnSuppStock;
    JButton btnVoirStock;
    public JButton btnAccueil;


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

        btnAccueil = new JButton("Accueil");
        this.add(btnAccueil);
    }
}
