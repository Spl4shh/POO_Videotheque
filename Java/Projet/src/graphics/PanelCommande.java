package graphics;

import javax.swing.*;
import java.awt.*;

public class PanelCommande extends JPanel
{
    JLabel titre;

    public PanelCommande()
    {
        this.setBackground(Color.BLUE);

        titre = new JLabel("Ceci est une commande");
        this.add(titre);
    }
}
