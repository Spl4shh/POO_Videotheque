package graphic;

import javax.swing.*;

public class PanelBtnListe extends JPanel
{
    public PanelListe panelListe;
    public PanelBtnASV panelBtnASV;

    public PanelBtnListe()
    {
        //this.setBackground(this.getParent().getBackground());
        panelBtnASV = new PanelBtnASV();
        this.add(panelBtnASV);
        this.setVisible(true);
        //this.panelBtnASV.setBackground(this.getParent().getBackground());


        panelListe = new PanelListe();
        this.add(panelListe);
        this.panelListe.setVisible(false);
    }
}
