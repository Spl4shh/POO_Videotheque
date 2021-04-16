package graphics;

import javax.swing.*;
import java.awt.*;

public class PanelClient extends JPanel
{
    JLabel titre;

    public PanelClient()
    {
        this.setBackground(Color.yellow);

        titre = new JLabel("Ceci est un client");
        this.add(titre);
    }
}
