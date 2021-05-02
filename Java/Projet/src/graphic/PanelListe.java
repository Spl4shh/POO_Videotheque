package graphic;

import client.Client;
import commande.Commande;
import main.Main;

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


        liste = new JTextArea( 4, 80);
        liste.setText("Hello \n there \n you\n read \n my \n messagen  funny\n right\n \n not \n for \n me");
        liste.setLineWrap(true);
        liste.setText("My brain\n is giant\n" + liste.getText());
        liste.setEditable(false);

        scrollListe = new JScrollPane(liste);

        verticalScrollBar = new JScrollBar();
        verticalScrollBar.setUnitIncrement(16);

        scrollListe.setVerticalScrollBar(verticalScrollBar);

        this.add(scrollListe);
    }

    public void clear()
    {
        this.liste.setText("");
    }

    public void initListeEmprunt(Commande commande, Client client)
    {
        for (int i = 0; i < Main.listClient.size(); i++)
        {
            if(Main.listClient.get(i).equals(client))
            {
                for (int j = 0; j < client.getListeCommande().size(); j++)
                {
                    if (client.getListeCommande().get(j).equals(commande))
                    {
                        for (int k = 0; k < commande.getListeEmprunt().size(); k++)
                        {
                            this.liste.setText(this.liste.getText() + "Emprunt de " + commande.getListeEmprunt().get(k).getProduitConcerne().getTitre()
                                    + " du " + commande.getListeEmprunt().get(k).getDateDebut().toString()
                                    + " jusqu'au " + commande.getListeEmprunt().get(k).getDateFin().toString() + "\n");
                        }
                    }
                }
            }
        }
    }
}
