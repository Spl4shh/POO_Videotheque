package graphic;

import javax.swing.*;
import java.awt.*;

public class PanelStock extends JPanel
{
    public JButton btnModifier;
    public PanelGestion panelGestion;
    public PanelEntete panelEntete;
    public PanelAjouterStock panelAjouterStock;
    public PanelSupprimerStock panelSupprimerStock;
    public PanelModifierStock panelModifierStock;

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

        panelAjouterStock = new PanelAjouterStock();
        this.panelGestion.add(panelAjouterStock);
        this.panelAjouterStock.setVisible(false);

        panelSupprimerStock = new PanelSupprimerStock();
        this.panelGestion.add(panelSupprimerStock);
        this.panelSupprimerStock.setVisible(false);

        panelModifierStock = new PanelModifierStock();
        this.panelGestion.add(panelModifierStock);
        this.panelModifierStock.setVisible(false);
    }
}
