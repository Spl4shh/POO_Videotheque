package graphic;

import client.Client;
import commande.Commande;
import commande.Emprunt;
import main.Main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.text.DecimalFormat;

public class PanelRechercher extends JPanel
{
    public JPanel panelSelection;
    public JTextArea liste;
    public JScrollPane scrollListe;
    public JScrollBar verticalScrollBar;
    public PanelEntete panelEntete;
    public JComboBox comboClient, comboCommande;

    public PanelRechercher()
    {
        this.setLayout(new BorderLayout());

        panelEntete = new PanelEntete();
        panelEntete.remove(panelEntete.panelBtnASV);
        this.add(panelEntete, "North");
        this.panelEntete.titre.setText("Rechercher");



        panelSelection = new JPanel();
        this.add(panelSelection, BorderLayout.WEST);

        comboClient = new JComboBox();
        this.panelSelection.add(comboClient);

        comboCommande = new JComboBox();
        this.panelSelection.add(comboCommande);


        liste = new JTextArea( 20, 60);
        liste.setEditable(false);

        scrollListe = new JScrollPane(liste);

        verticalScrollBar = new JScrollBar();
        verticalScrollBar.setUnitIncrement(16);

        scrollListe.setVerticalScrollBar(verticalScrollBar);

        this.add(scrollListe, BorderLayout.EAST);
    }

    public void genererListeClient()
    {
        comboClient.removeAllItems();

        for (int i = 0; i < Main.listClient.size(); i++)
        {
            comboClient.addItem(Main.listClient.get(i).getNom() + " " + Main.listClient.get(i).getPrenom());
        }
    }

    public void genererListeCommande()
    {
        comboCommande.removeAllItems();

        if (comboClient.getItemCount() > 0)
        {
            Client clientEnCours = Main.listClient.get(comboClient.getSelectedIndex());

            for (int i = 0; i < clientEnCours.getListeCommande().size(); i++)
            {
                comboCommande.addItem("Commande numéro " + clientEnCours.getListeCommande().get(i).getIdentifiant());
            }
        }
    }

    public void afficherCommande()
    {
        Client clientEnCours = Main.listClient.get(comboClient.getSelectedIndex());

        Commande commandeEnCours = clientEnCours.getListeCommande().get(comboCommande.getSelectedIndex());

        DecimalFormat format2Decimal = new DecimalFormat();
        format2Decimal.setMaximumFractionDigits(2);

        this.liste.setText("Mr/Mme " + clientEnCours.getNom() + " " + clientEnCours.getPrenom() + "\n\n"  +
                           "Commande n° " + commandeEnCours.getIdentifiant() + " effectuée le " + commandeEnCours.getDateCreation().toString());

        for (Emprunt emprunt : commandeEnCours.getListeEmprunt())
        {
                String textePrec  = this.liste.getText();
                this.liste.setText(textePrec + "\n\n        " + "Emprunt de : " + emprunt.getProduitConcerne().getTitre() + " | "
                                   + emprunt.getProduitConcerne().getType() + "    jusqu'au : " + emprunt.getDateFin().toString()
                                   + "    tarif : " + emprunt.montantEmpruntString() + "€");
        }

        this.liste.setText(this.liste.getText() + "\n\n\n" + "              " + " Total commande sans réduction :   "
                + commandeEnCours.montantCommandeString() + "€\n" + "              " + " Montant réduction :                           - "
                + format2Decimal.format(commandeEnCours.montantCommandeDouble() * commandeEnCours.getReduction())
                + "€\n" + "              " + " Total commande avec reduction : "
                + format2Decimal.format(commandeEnCours.montantCommandeDouble() - (commandeEnCours.montantCommandeDouble() * commandeEnCours.getReduction()))
                + "€");
    }

    public void clear()
    {
        this.liste.setText("Pas de commande enregistrée");
    }
}
