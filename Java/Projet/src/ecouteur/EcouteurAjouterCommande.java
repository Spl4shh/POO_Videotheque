package ecouteur;

import client.Client;
import client.Fidele;
import client.Occasionnel;
import commande.Commande;
import commande.Emprunt;
import graphic.PanelAjouterCommande;
import main.Main;
import produit.Produit;
import tools.Date;
import videotheque.Videotheque;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class EcouteurAjouterCommande implements ActionListener
{
    public PanelAjouterCommande panelAjouterCommande;
    public ArrayList<Emprunt> empruntAAssigner = new ArrayList<Emprunt>();
    Client clientEnCours;
    double sommeCommande;

    public EcouteurAjouterCommande(PanelAjouterCommande panelAjouterCommande)
    {
        this.panelAjouterCommande = panelAjouterCommande;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (panelAjouterCommande.btnValiderClient == e.getSource())
        {
            if (empruntAAssigner.size() > 0)
            {
                empruntAAssigner.clear();
            }

            panelAjouterCommande.deuxiemePhase();
            clientEnCours = Main.videotheque.getListClient().get(panelAjouterCommande.comboClient.getSelectedIndex());
            sommeCommande = 0;
        }


        if (panelAjouterCommande.comboProduit == e.getSource() &&
                !panelAjouterCommande.btnValiderClient.isVisible())
        {
            panelAjouterCommande.majStock();
        }

        if (panelAjouterCommande.btnValiderEmprunt == e.getSource())
        {
            try
            {
                int jour, mois,annee;
                jour  = Integer.parseInt(panelAjouterCommande.panelAjoutDate.jour.getText().trim());
                mois = Integer.parseInt(panelAjouterCommande.panelAjoutDate.mois.getText().trim());
                annee = Integer.parseInt(panelAjouterCommande.panelAjoutDate.annee.getText().trim());

                if (Date.verif(jour, mois, annee))
                {
                    java.time.LocalDate dateCourante = java.time.LocalDate.now();

                    Date dateDebut = new Date(dateCourante.getDayOfMonth(), dateCourante.getMonthValue(), dateCourante.getYear());
                    Date dateFin = new Date(jour, mois, annee);

                    Produit produitSelect;

                    DecimalFormat format2Decimal = new DecimalFormat();
                    format2Decimal.setMaximumFractionDigits(2);

                    produitSelect = Main.videotheque.getStock().get(panelAjouterCommande.comboProduit.getSelectedIndex());

                    if (produitSelect.estDispo() &&((dateFin.nbJours() - dateDebut.nbJours()) > 0))
                    {
                        int nbJour = (dateFin.nbJours() - dateDebut.nbJours());
                        this.sommeCommande += (produitSelect.getTarifJournalier()*nbJour);

                        panelAjouterCommande.panelListeEmprunt.liste.setText(panelAjouterCommande.panelListeEmprunt.liste.getText() +
                                "\"" + produitSelect.getTitre()
                                + "\"" + " du " + dateDebut + " jusqu'au " + dateFin + " pendant "
                                + nbJour + "jour(s)\n");


                        empruntAAssigner.add(new Emprunt(dateDebut, dateFin, produitSelect));
                        produitSelect.reduireStock();



                        panelAjouterCommande.total.setText("Total de la commande (sans réduction) : "
                                + format2Decimal.format(sommeCommande) +  "€");

                        panelAjouterCommande.panelListeEmprunt.setVisible(true);
                        panelAjouterCommande.deuxiemePhase();
                        panelAjouterCommande.btnValiderCommande.setVisible(true);
                    }
                    else
                    {
                        panelAjouterCommande.messageErreur.setVisible(true);
                    }
                }
            }
            catch (NumberFormatException ignored)
            {

            }
        }

        if (panelAjouterCommande.btnValiderCommande == e.getSource())
        {
            java.time.LocalDate dateCourante = java.time.LocalDate.now();

            Date dateDebut = new Date(dateCourante.getDayOfMonth(), dateCourante.getMonthValue(), dateCourante.getYear());
            String id = String.valueOf(Videotheque.plusGrandIdCommande() + 1);

            if (clientEnCours instanceof Fidele)
            {
                clientEnCours.getListeCommande().add(new Commande(id, dateDebut, ((Fidele) clientEnCours).getReduction()));
                for (Emprunt emprunt : empruntAAssigner)
                {
                    clientEnCours.getListeCommande().get(clientEnCours.getListeCommande().size()-1).ajouterEmprunt(emprunt);
                }
            }
            else if (clientEnCours instanceof Occasionnel)
            {
                clientEnCours.getListeCommande().add(new Commande(id, dateDebut, ((Occasionnel) clientEnCours).getReduction()));
                for (Emprunt emprunt : empruntAAssigner)
                {
                    clientEnCours.getListeCommande().get(clientEnCours.getListeCommande().size()-1).ajouterEmprunt(emprunt);
                }
            }
            panelAjouterCommande.panelListeEmprunt.clear();
            panelAjouterCommande.panelListeEmprunt.setVisible(false);
            panelAjouterCommande.premierePhase();
            empruntAAssigner.clear();
            sommeCommande = 0;

            JOptionPane.showMessageDialog(null,"Commande n° " + id + " bien ajouté au client " + clientEnCours.getNom() + " " + clientEnCours.getPrenom());
        }
    }
}
