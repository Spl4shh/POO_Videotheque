package graphics;

import javax.swing.*;
import java.awt.*;

public class PanelStock extends JPanel
{
    JLabel titre;


    public PanelStock()
    {
        this.setBackground(Color.GREEN);

        titre = new JLabel("Ceci est le stock");
        this.add(titre);
    }
}
