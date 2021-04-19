package graphics;

import javax.swing.*;
import java.awt.*;

public class PanelCommande extends JPanel
{
    JLabel titre;
    JButton btnAddCommande, btnSuppCommande, btnVoirCommande;


    public PanelCommande()
    {
        this.setBackground(Color.BLUE);

        titre = new JLabel("Ceci est une commande");
        this.add(titre);

        btnAddCommande = new JButton("Ajouter");
        this.add(btnAddCommande);

        btnSuppCommande = new JButton("Supprimer");
        this.add(btnSuppCommande);

        btnVoirCommande = new JButton("Voir la liste");
        this.add(btnVoirCommande);
    }
}
