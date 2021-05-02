package graphic;

import javax.swing.*;
import java.awt.*;

public class PanelGestion extends JPanel
{
    public PanelListe panelListe;

    public PanelGestion()
    {
        panelListe = new PanelListe();
        this.add(panelListe);
        this.panelListe.setVisible(false);
    }
}
