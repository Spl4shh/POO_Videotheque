package graphic;

import client.Client;
import client.Fidele;
import ecouteur.EcouteurRechercherClient;
import main.Main;

import javax.swing.*;
import java.awt.*;

public class PanelRechercherClient extends JPanel
{
    public JPanel panelSelection, panelNom, panelBtn;
    public JTextArea liste;
    public JScrollPane scrollListe;
    public JScrollBar verticalScrollBar;
    public JLabel labelNomClient;
    public JTextField textFieldNom;
    public JButton btnRechercher;

    public PanelRechercherClient()
    {
        this.setLayout(new BorderLayout());

        panelSelection = new JPanel();
        panelSelection.setLayout(new GridLayout(0, 1));

        panelNom = new JPanel();

        labelNomClient = new JLabel("Nom ou prenom du Client :");
        this.panelNom.add(labelNomClient);

        textFieldNom = new JTextField(16);
        this.panelNom.add(textFieldNom);
        textFieldNom.addActionListener(new EcouteurRechercherClient(this));

        this.panelSelection.add(panelNom);

        panelBtn = new JPanel();

        btnRechercher = new JButton("Rechercher");
        this.panelBtn.add(btnRechercher);
        btnRechercher.addActionListener(new EcouteurRechercherClient(this));

        this.panelSelection.add(panelBtn);

        this.add(panelSelection, BorderLayout.WEST);

        //Creation de la liste pour afficher les differents textes
        liste = new JTextArea( 20, 50);
        liste.setEditable(false);

        scrollListe = new JScrollPane(liste);

        verticalScrollBar = new JScrollBar();
        verticalScrollBar.setUnitIncrement(16);

        scrollListe.setVerticalScrollBar(verticalScrollBar);
        this.add(scrollListe, BorderLayout.EAST);
    }

    /**
     * Cette methode permet d'initialiser la liste des clients en fonction d'un nom ou prenom
     *
     * @param nom Le nom ou le prenom a chercher
     */
    public void initListeClient(String nom)
    {
        this.clear();
        for (Client client :  Main.videotheque.getListClient() )
        {
            if (client.getNom().contains(nom) || client.getPrenom().contains(nom))
            {
                String indicationFidelite = "Occasionnel";
                if (client instanceof Fidele)
                {
                    indicationFidelite = "Fidele";
                }

                String textPrec = this.liste.getText();
                this.liste.setText(textPrec + "Client n° " + client.getIdentifiant() + " : " + client.getNom() + " " + client.getPrenom()
                        + " | client " + indicationFidelite + " | " + client.getListeCommande().size() + " commande(s) effectuée(s) \n");
            }

        }
    }

    /**
     * Cette methode permet de nettoyer la liste
     */
    public void clear()
    {
        this.liste.setText("");
    }
}
