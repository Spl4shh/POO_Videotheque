package graphic;

import javax.swing.*;
import java.awt.*;

public class PanelListe extends JPanel
{
    public JTextArea liste;
    public JScrollPane scrollListe;
    public JScrollBar verticalScrollBar;

    public PanelListe()
    {
        this.setLayout(new GridLayout(0, 1));

        liste = new JTextArea( 20, 80);
        liste.setEditable(false);

        scrollListe = new JScrollPane(liste);

        verticalScrollBar = new JScrollBar();
        verticalScrollBar.setUnitIncrement(16);

        scrollListe.setVerticalScrollBar(verticalScrollBar);

        this.add(scrollListe);
    }

    /**
     * Cette methode permet de nettoyer la liste
     *
     * On modifie le texte de la liste a vide
     */
    public void clear()
    {
        this.liste.setText("");
    }
}
