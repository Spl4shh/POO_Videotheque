package ecouteur;

import commande.Emprunt;
import graphic.Frame;
import main.Main;
import produit.Produit;
import tools.Date;
import java.time.LocalDate;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurBtnAjouter implements ActionListener
{
    Frame frame;

    public EcouteurBtnAjouter(Frame f)
    {
        frame = f;

        frame.panelPrincipal.panelClient.panelEntete.panelBtnASV.btnAdd.addActionListener(this);
        frame.panelPrincipal.panelCommande.panelEntete.panelBtnASV.btnAdd.addActionListener(this);
        frame.panelPrincipal.panelStock.panelEntete.panelBtnASV.btnAdd.addActionListener(this);

    //Client ActionListener---------------------------------------------------------------------------------------------
        frame.panelPrincipal.panelClient.panelAjouterClient.checkFidele.addActionListener(this);
        frame.panelPrincipal.panelClient.panelAjouterClient.checkOccasionnel.addActionListener(this);
        frame.panelPrincipal.panelClient.panelAjouterClient.valider.addActionListener(this);

    //Commande ActionListener-------------------------------------------------------------------------------------------
        frame.panelPrincipal.panelCommande.panelAjouterCommande.comboProduit.addActionListener(this);
        frame.panelPrincipal.panelCommande.panelAjouterCommande.btnValiderClient.addActionListener(this);
        frame.panelPrincipal.panelCommande.panelAjouterCommande.btnValiderEmprunt.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
//Client-------------------------------------------------------------
        if (frame.panelPrincipal.panelClient.panelEntete.panelBtnASV.btnAdd == e.getSource())
        {
            frame.panelPrincipal.panelClient.panelSupprimerClient.setVisible(false);
            frame.panelPrincipal.panelClient.panelAjouterClient.setVisible(true);
            frame.panelPrincipal.panelClient.panelGestion.panelListe.setVisible(false);
                //Clear des differents espaces de saisie
            frame.panelPrincipal.panelClient.panelAjouterClient.textFieldNom.setText("");
            frame.panelPrincipal.panelClient.panelAjouterClient.textFieldPrenom.setText("");
            frame.panelPrincipal.panelClient.panelAjouterClient.checkFidele.setSelected(false);
            frame.panelPrincipal.panelClient.panelAjouterClient.checkOccasionnel.setSelected(true);
        }
            //Inversion checkBox----------------------------------------------
        if (frame.panelPrincipal.panelClient.panelAjouterClient.checkFidele == e.getSource())
        {
            frame.panelPrincipal.panelClient.panelAjouterClient.checkOccasionnel.setSelected(!frame.panelPrincipal.panelClient.panelAjouterClient.checkFidele.isSelected());
        }
        if (frame.panelPrincipal.panelClient.panelAjouterClient.checkOccasionnel == e.getSource())
        {
            frame.panelPrincipal.panelClient.panelAjouterClient.checkFidele.setSelected(!frame.panelPrincipal.panelClient.panelAjouterClient.checkOccasionnel .isSelected());
        }
            //Bouton Valider---------------------------------------------------
        if (frame.panelPrincipal.panelClient.panelAjouterClient.valider == e.getSource())
        {
            if (!frame.panelPrincipal.panelClient.panelAjouterClient.textFieldNom.getText().trim().isEmpty() &&
                !frame.panelPrincipal.panelClient.panelAjouterClient.textFieldPrenom.getText().trim().isEmpty())
            {
                //Ici integrer la partie de sauvegarde du Client
                frame.panelPrincipal.panelClient.panelAjouterClient.setVisible(false);
                frame.panelPrincipal.panelClient.panelAjouterClient.lblErreur.setVisible(false);

            }
            else
            {
                frame.panelPrincipal.panelClient.panelAjouterClient.lblErreur.setVisible(true);
            }
        }


//Commande-------------------------------------------------------------
        if (frame.panelPrincipal.panelCommande.panelEntete.panelBtnASV.btnAdd == e.getSource())
        {
            frame.panelPrincipal.panelCommande.panelAjouterCommande.setVisible(true);
            frame.panelPrincipal.panelCommande.panelGestion.panelListe.setVisible(false);
            frame.panelPrincipal.panelCommande.panelListeEmprunt.setVisible(false);

            frame.panelPrincipal.panelCommande.panelAjouterCommande.premierePhase();
        }

        if (frame.panelPrincipal.panelCommande.panelAjouterCommande.comboProduit == e.getSource())
        {
            Produit produitSelect;

            produitSelect = Main.listProduit.get(frame.panelPrincipal.panelCommande.panelAjouterCommande.comboProduit.getSelectedIndex());

            frame.panelPrincipal.panelCommande.panelAjouterCommande.stockDispo.setText("     stock actuel : " + produitSelect.getNombreStock());
        }

        if (frame.panelPrincipal.panelCommande.panelAjouterCommande.btnValiderClient == e.getSource())
        {
            frame.panelPrincipal.panelCommande.panelAjouterCommande.deuxiemePhase();
        }

        if (frame.panelPrincipal.panelCommande.panelAjouterCommande.btnValiderEmprunt == e.getSource())
        {
            try
            {
                int jour, mois,annee;
                jour = Integer.parseInt(frame.panelPrincipal.panelCommande.panelAjouterCommande.jour.getText());
                mois = Integer.parseInt(frame.panelPrincipal.panelCommande.panelAjouterCommande.mois.getText());
                annee = Integer.parseInt(frame.panelPrincipal.panelCommande.panelAjouterCommande.annee.getText());

                if (Date.verif(jour, mois, annee))
                {
                    java.time.LocalDate dateCourante = java.time.LocalDate.now();

                    Date dateDebut = new Date(dateCourante.getDayOfMonth(), dateCourante.getMonthValue(), dateCourante.getYear());
                    Date dateFin = new Date(jour, mois, annee);
                    Produit produitSelect;

                    produitSelect = Main.listProduit.get(frame.panelPrincipal.panelCommande.panelAjouterCommande.comboProduit.getSelectedIndex());

                    if ((Emprunt.verifierDisponibilite(produitSelect)) &&((dateFin.nbJours() - dateDebut.nbJours()) > 0))
                    {
                        int nbJour = (dateFin.nbJours() - dateDebut.nbJours());
        //Completer avec la sauvegarde de l'emprunt'
                        frame.panelPrincipal.panelCommande.panelListeEmprunt.liste.setText(frame.panelPrincipal.panelCommande.panelListeEmprunt.liste.getText() +
                                "\"" + Main.listProduit.get(frame.panelPrincipal.panelCommande.panelAjouterCommande.comboProduit.getSelectedIndex()).getTitre()
                                + "\"" + " du " + dateDebut.toString() + " jusqu'au " + dateFin.toString() + " pendant "
                                + nbJour + "jour(s)\n");
                        Main.listProduit.get(frame.panelPrincipal.panelCommande.panelAjouterCommande.comboProduit.getSelectedIndex()).reduireStock();


        //Afficher le prix a la suite mettre le label dans Commande>Gestion>Liste et mettre Liste en GridLayout

                        frame.panelPrincipal.panelCommande.panelListeEmprunt.setVisible(true);
                        frame.panelPrincipal.panelCommande.panelAjouterCommande.deuxiemePhase();
                    }
                    else
                    {
                        frame.panelPrincipal.panelCommande.panelAjouterCommande.messageErreur.setVisible(true);
                    }
                }
            }
            catch (NumberFormatException ignored)
            {
            }
        }




//Stock-------------------------------------------------------------
        if (frame.panelPrincipal.panelStock.panelEntete.panelBtnASV.btnAdd == e.getSource())
        {
            //frame.panelPrincipal.panelStock..setVisible(true);
            frame.panelPrincipal.panelStock.panelGestion.panelListe.setVisible(false);
        }
    }
}
