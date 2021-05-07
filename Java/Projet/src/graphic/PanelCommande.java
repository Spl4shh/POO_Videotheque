package graphic;

import javax.swing.*;
import java.awt.*;

public class PanelCommande extends JPanel
{
    public PanelGestion panelGestion;
    public PanelEntete panelEntete;
    public PanelAjouterCommande panelAjouterCommande;
    public PanelListe panelListeEmprunt;
    public PanelSupprimerCommande panelSupprimerCommande;
    public JLabel total;

    public PanelCommande()
    {
        this.setBackground(Color.BLUE);
        this.setLayout(new BorderLayout());

        panelEntete = new PanelEntete();
        this.add(panelEntete, "North");
        this.panelEntete.titre.setText("Commande");

        panelGestion = new PanelGestion();
        this.add(panelGestion, "Center");

        panelAjouterCommande = new PanelAjouterCommande();
        this.panelGestion.add(panelAjouterCommande);
        this.panelAjouterCommande.setVisible(false);

        panelListeEmprunt = new PanelListe();
        this.panelGestion.add(panelListeEmprunt);
        panelListeEmprunt.liste.setText("");
        panelListeEmprunt.liste.setColumns(40);
        panelListeEmprunt.liste.setRows(10);
        panelListeEmprunt.setVisible(false);

        total = new JLabel("Total : ");
        this.panelListeEmprunt.add(total);
        total.setVisible(true);

        panelSupprimerCommande = new PanelSupprimerCommande();
        this.panelGestion.add(panelSupprimerCommande);
        this.panelSupprimerCommande.setVisible(false);
    }
}
