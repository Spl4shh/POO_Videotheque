package graphics;

import javax.swing.*;
import java.awt.*;

public class PanelClient extends JPanel
{
    JLabel titre;
    JButton btnAddClient, btnSuppClient, btnVoirClient;

    public PanelClient()
    {
        this.setBackground(Color.yellow);

        titre = new JLabel("Ceci est un client");
        this.add(titre);

        btnAddClient = new JButton("Ajouter");
        this.add(btnAddClient);

        btnSuppClient = new JButton("Supprimer");
        this.add(btnSuppClient);

        btnVoirClient = new JButton("Voir la liste");
        this.add(btnVoirClient);
    }
}
