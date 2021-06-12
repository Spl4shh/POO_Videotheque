package graphic;

import javax.swing.*;

public class PanelAjoutDate extends JPanel
{
    public JTextField jour, mois, annee;

    public PanelAjoutDate()
    {
        jour = new JTextField(2);
        this.add(jour);

        this.add(new JLabel("/"));

        mois = new JTextField(2);
        this.add(mois);

        this.add(new JLabel("/"));

        annee = new JTextField(4);
        this.add(annee);
    }

    /**
     * Cette methode permet de nettoyer les champs de saisie.
     *
     * On mettra simplement les champs de saisie a vide
     */
    public void clear()
    {
        this.jour.setText("");
        this.mois.setText("");
        this.annee.setText("");
    }
}
