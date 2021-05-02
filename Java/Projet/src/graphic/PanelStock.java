package graphic;

import javax.swing.*;
import java.awt.*;

public class PanelStock extends JPanel
{
    public JButton btnModifier;
    public PanelGestion panelGestion;
    public PanelEntete panelEntete;


    public PanelStock()
    {
        this.setBackground(Color.GREEN);
        this.setLayout(new BorderLayout());

        panelEntete = new PanelEntete();
        this.add(panelEntete, "North");
        this.panelEntete.titre.setText("Stock");

        panelGestion = new PanelGestion();
        this.add(panelGestion, "South");

        btnModifier = new JButton("Modifier");
        this.panelEntete.add(btnModifier);
    }
}
