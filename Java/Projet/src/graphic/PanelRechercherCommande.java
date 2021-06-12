package graphic;

import client.Client;
import commande.Commande;
import commande.Emprunt;
import ecouteur.EcouteurRechercheCommande;
import main.Main;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class PanelRechercherCommande extends JPanel
{
    public JPanel panelSelection;
    public JTextArea liste;
    public JScrollPane scrollListe;
    public JScrollBar verticalScrollBar;
    public JComboBox comboClient, comboCommande;

    public PanelRechercherCommande()
    {
        this.setLayout(new BorderLayout());

        panelSelection = new JPanel();
        this.add(panelSelection, BorderLayout.WEST);

        comboClient = new JComboBox();
        this.panelSelection.add(comboClient);
        comboClient.addActionListener(new EcouteurRechercheCommande(this));

        comboCommande = new JComboBox();
        this.panelSelection.add(comboCommande);
        this.genererListeCommande();
        comboCommande.addActionListener(new EcouteurRechercheCommande(this));

        liste = new JTextArea( 20, 60);
        liste.setEditable(false);

        scrollListe = new JScrollPane(liste);

        verticalScrollBar = new JScrollBar();
        verticalScrollBar.setUnitIncrement(16);

        scrollListe.setVerticalScrollBar(verticalScrollBar);

        this.add(scrollListe, BorderLayout.EAST);
    }

    /**
     * Cette methode permet de generer la comboBox client.
     *
     * On ajoute tout les clients de la liste clients.
     */
    public void genererListeClient()
    {
        this.comboClient.removeAllItems();

        for (int i = 0; i <  Main.videotheque.getListClient().size(); i++)
        {
            this.comboClient.addItem( Main.videotheque.getListClient().get(i).getNom() + " " +  Main.videotheque.getListClient().get(i).getPrenom());
        }
    }

    /**
     * Cette methode permet de generer la comboBox Commande.
     *
     * On ajoute toutes les commandes de tout clients de la liste clients.
     */
    public void genererListeCommande()
    {
        this.comboCommande.removeAllItems();

        if (comboClient.getItemCount() > 0)
        {
            Client clientEnCours =  Main.videotheque.getListClient().get(comboClient.getSelectedIndex());

            for (int i = 0; i < clientEnCours.getListeCommande().size(); i++)
            {
                this.comboCommande.addItem("Commande n° " + clientEnCours.getListeCommande().get(i).getIdentifiant());
            }
        }
    }

    /**
     * Cette methode permet d'afficher une commande.
     *
     * On recupere la commande et le client dans les comboBox et ensuite on affiche la commande correpondante.
     */
    public void afficherCommande()
    {
        Client clientEnCours =  Main.videotheque.getListClient().get(comboClient.getSelectedIndex());

        Commande commandeEnCours = clientEnCours.getListeCommande().get(comboCommande.getSelectedIndex());

        DecimalFormat format2Decimal = new DecimalFormat();
        format2Decimal.setMaximumFractionDigits(2);

        this.liste.setText("Mr/Mme " + clientEnCours.getNom() + " " + clientEnCours.getPrenom() + "\n\n"  +
                "Commande n° " + commandeEnCours.getIdentifiant() + " effectuée le " + commandeEnCours.getDateCreation().toString());

        for (Emprunt emprunt : commandeEnCours.getListeEmprunt())
        {
            String textePrec  = this.liste.getText();
            this.liste.setText(textePrec + "\n\n        " + "Emprunt de : " + emprunt.getProduitConcerne().getTitre() + " | "
                    + emprunt.getProduitConcerne().getClass().getSimpleName() + "    jusqu'au : " + emprunt.getDateFin().toString()
                    + "    tarif : " + emprunt.montantEmpruntString() + "€");
        }

        this.liste.setText(this.liste.getText() + "\n\n\n" + "              " + " Total commande sans réduction :   "
                + commandeEnCours.montantCommandeString() + "€\n" + "              " + " Montant réduction :                           - "
                + format2Decimal.format(commandeEnCours.montantCommandeDouble() * commandeEnCours.getReduction())
                + "€\n" + "              " + " Total commande avec reduction : "
                + format2Decimal.format(commandeEnCours.montantCommandeDouble() - (commandeEnCours.montantCommandeDouble() * commandeEnCours.getReduction()))
                + "€");
    }

    /**
     * Cette methode permet de nettoyer la liste
     */
    public void clear()
    {
        this.liste.setText("Pas de commande enregistrée");
    }
}

