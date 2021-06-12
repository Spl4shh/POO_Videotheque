package graphic;

import javax.swing.*;

public class PanelEntete extends JPanel
{
    public JLabel titre;

    public PanelEntete()
    {
        titre = new JLabel();
        this.add(titre);
    }
}
