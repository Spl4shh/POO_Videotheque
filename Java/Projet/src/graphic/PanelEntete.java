package graphic;

import graphic.PanelBtnASV;

import javax.swing.*;

public class PanelEntete extends JPanel
{
    public JLabel titre;
    public JButton btnAccueil;
    public PanelBtnASV panelBtnASV;

    public PanelEntete()
    {
        titre = new JLabel();
        this.add(titre);

        btnAccueil = new JButton("Accueil");
        this.add(btnAccueil);

        panelBtnASV = new PanelBtnASV();
        this.add(panelBtnASV);
        this.setVisible(true);
    }
}
