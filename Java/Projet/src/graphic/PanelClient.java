package graphic;

import javax.swing.*;
import java.awt.*;

public class PanelClient extends JPanel
{
    public PanelGestion panelGestion;
    public PanelEntete panelEntete;
    public PanelAjouterClient panelAjouterClient;
    public PanelSupprimerClient panelSupprimerClient;

    public PanelClient()
    {
        this.setBackground(Color.yellow);
        this.setLayout(new BorderLayout());

        panelEntete = new PanelEntete();
        this.add(panelEntete, "North");
        this.panelEntete.titre.setText("Client");

        panelGestion = new PanelGestion();
        this.add(panelGestion, "South");

        panelAjouterClient = new PanelAjouterClient();
        this.panelGestion.add(panelAjouterClient);
        this.panelAjouterClient.setVisible(false);

        panelSupprimerClient = new PanelSupprimerClient();
        this.panelGestion.add(panelSupprimerClient);
        this.panelSupprimerClient.setVisible(false);
    }
}
