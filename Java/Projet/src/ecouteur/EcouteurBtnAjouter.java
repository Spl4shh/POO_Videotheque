package ecouteur;

import client.Client;
import client.Fidele;
import client.Occasionel;
import commande.Commande;
import commande.Emprunt;
import graphic.Frame;
import main.Main;
import produit.*;
import tools.Date;
import tools.Langue;
import tools.Type;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class EcouteurBtnAjouter implements ActionListener
{
    Frame frame;

    ArrayList <Emprunt> empruntAAssigner = new ArrayList<Emprunt>();
    Client clientEnCours;

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
        frame.panelPrincipal.panelCommande.panelAjouterCommande.btnValiderCommande.addActionListener(this);

    //Stock ActionListener
        frame.panelPrincipal.panelStock.panelAjouterStock.comboTypeProduit.addActionListener(this);
        frame.panelPrincipal.panelStock.panelAjouterStock.btnValiderProduit.addActionListener(this);
        frame.panelPrincipal.panelStock.panelAjouterStock.btnValiderProduit.addActionListener(this);

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
            frame.panelPrincipal.panelClient.panelAjouterClient.clear();
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
                frame.panelPrincipal.panelClient.panelAjouterClient.lblErreur.setVisible(true);

                String nom = frame.panelPrincipal.panelClient.panelAjouterClient.textFieldNom.getText().trim();
                String prenom = frame.panelPrincipal.panelClient.panelAjouterClient.textFieldPrenom.getText().trim();
                String identifiant = frame.panelPrincipal.panelClient.panelAjouterClient.textFieldId.getText().trim();
                boolean fidele = frame.panelPrincipal.panelClient.panelAjouterClient.checkFidele.isSelected();

                if (fidele)
                {
                    Main.listClient.add(new Fidele(identifiant, nom, prenom));
                }
                else
                {
                    Main.listClient.add(new Occasionel(identifiant, nom, prenom));
                }

                frame.panelPrincipal.panelClient.panelAjouterClient.setVisible(false);
                frame.panelPrincipal.panelClient.panelAjouterClient.lblErreur.setVisible(false);

                frame.panelPrincipal.panelClient.panelAjouterClient.clear();
            }
            else
            {
                frame.panelPrincipal.panelClient.panelAjouterClient.lblErreur.setVisible(true);
            }
        }


//Commande-------------------------------------------------------------
        if (frame.panelPrincipal.panelCommande.panelEntete.panelBtnASV.btnAdd == e.getSource())
        {

            if (empruntAAssigner.size() > 0)
            {
                empruntAAssigner.clear();
            }

            frame.panelPrincipal.panelCommande.panelAjouterCommande.setVisible(true);
            frame.panelPrincipal.panelCommande.panelGestion.panelListe.setVisible(false);
            frame.panelPrincipal.panelCommande.panelListeEmprunt.setVisible(false);
            frame.panelPrincipal.panelCommande.panelSupprimerCommande.setVisible(false);
            frame.panelPrincipal.panelStock.panelModifierStock.setVisible(false);

            frame.panelPrincipal.panelCommande.panelAjouterCommande.premierePhase();

        }

        if (frame.panelPrincipal.panelCommande.panelAjouterCommande.btnValiderClient == e.getSource())
        {
            frame.panelPrincipal.panelCommande.panelAjouterCommande.deuxiemePhase();

            clientEnCours = Main.listClient.get(frame.panelPrincipal.panelCommande.panelAjouterCommande.comboClient.getSelectedIndex());
        }

        if (frame.panelPrincipal.panelCommande.panelAjouterCommande.comboProduit == e.getSource() &&
            !frame.panelPrincipal.panelCommande.panelAjouterCommande.btnValiderClient.isVisible())
        {
            frame.panelPrincipal.panelCommande.panelAjouterCommande.totalCommande = 0;
            Produit produitSelect;

            produitSelect = Main.listProduit.get(frame.panelPrincipal.panelCommande.panelAjouterCommande.comboProduit.getSelectedIndex());

            frame.panelPrincipal.panelCommande.panelAjouterCommande.stockDispo.setText("     stock actuel : " + produitSelect.getNombreStock());
        }

        if (frame.panelPrincipal.panelCommande.panelAjouterCommande.btnValiderEmprunt == e.getSource())
        {
            try
            {
                int jour, mois,annee;
                jour  = Integer.parseInt(frame.panelPrincipal.panelCommande.panelAjouterCommande.panelAjoutDate.jour.getText().trim());
                mois = Integer.parseInt(frame.panelPrincipal.panelCommande.panelAjouterCommande.panelAjoutDate.mois.getText().trim());
                annee = Integer.parseInt(frame.panelPrincipal.panelCommande.panelAjouterCommande.panelAjoutDate.annee.getText().trim());

                if (Date.verif(jour, mois, annee))
                {
                    java.time.LocalDate dateCourante = java.time.LocalDate.now();

                    Date dateDebut = new Date(dateCourante.getDayOfMonth(), dateCourante.getMonthValue(), dateCourante.getYear());
                    Date dateFin = new Date(jour, mois, annee);
                    Produit produitSelect;

                    DecimalFormat format2Decimal = new DecimalFormat();
                    format2Decimal.setMaximumFractionDigits(2);

                    produitSelect = Main.listProduit.get(frame.panelPrincipal.panelCommande.panelAjouterCommande.comboProduit.getSelectedIndex());

                    if (produitSelect.estDispo() &&((dateFin.nbJours() - dateDebut.nbJours()) > 0))
                    {
                        int nbJour = (dateFin.nbJours() - dateDebut.nbJours());
                        double totalCommande = frame.panelPrincipal.panelCommande.panelAjouterCommande.totalCommande + (produitSelect.getTarifJournalier()*nbJour);

                        frame.panelPrincipal.panelCommande.panelListeEmprunt.liste.setText(frame.panelPrincipal.panelCommande.panelListeEmprunt.liste.getText() +
                                "\"" + produitSelect.getTitre()
                                + "\"" + " du " + dateDebut + " jusqu'au " + dateFin + " pendant "
                                + nbJour + "jour(s)\n");


                        empruntAAssigner.add(new Emprunt(dateDebut, dateFin, produitSelect));

                        produitSelect.reduireStock();

                        frame.panelPrincipal.panelCommande.total.setText("Total de la commande (sans réduction) : "
                                + format2Decimal.format(totalCommande) +  "€");

                        frame.panelPrincipal.panelCommande.panelListeEmprunt.setVisible(true);
                        frame.panelPrincipal.panelCommande.panelAjouterCommande.deuxiemePhase();
                        frame.panelPrincipal.panelCommande.panelAjouterCommande.btnValiderCommande.setVisible(true);
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

        if (frame.panelPrincipal.panelCommande.panelAjouterCommande.btnValiderCommande == e.getSource())
        {
            java.time.LocalDate dateCourante = java.time.LocalDate.now();

            Date dateDebut = new Date(dateCourante.getDayOfMonth(), dateCourante.getMonthValue(), dateCourante.getYear());
            String id = String.valueOf(Main.grandIdCommandeActuel() + 1);

            if (clientEnCours instanceof Fidele)
            {
                clientEnCours.getListeCommande().add(new Commande(id, dateDebut, ((Fidele) clientEnCours).getReduction()));
                for (Emprunt emprunt : empruntAAssigner)
                {
                    clientEnCours.getListeCommande().get(clientEnCours.getListeCommande().size()-1).ajouterEmprunt(emprunt);
                }
            }
            else if (clientEnCours instanceof Occasionel)
            {
                clientEnCours.getListeCommande().add(new Commande(id, dateDebut, ((Occasionel) clientEnCours).getReduction()));
                for (Emprunt emprunt : empruntAAssigner)
                {
                    clientEnCours.getListeCommande().get(clientEnCours.getListeCommande().size()-1).ajouterEmprunt(emprunt);
                }
            }

            frame.panelPrincipal.panelCommande.panelListeEmprunt.clear();
            frame.panelPrincipal.panelCommande.panelListeEmprunt.setVisible(false);
            frame.panelPrincipal.panelCommande.panelAjouterCommande.premierePhase();
            empruntAAssigner.clear();
        }



//Stock-------------------------------------------------------------
        if (frame.panelPrincipal.panelStock.panelEntete.panelBtnASV.btnAdd == e.getSource())
        {
            frame.panelPrincipal.panelStock.panelAjouterStock.reset();
            frame.panelPrincipal.panelStock.panelAjouterStock.setVisible(true);
            frame.panelPrincipal.panelStock.panelGestion.panelListe.setVisible(false);
            frame.panelPrincipal.panelStock.panelSupprimerStock.setVisible(false);
            frame.panelPrincipal.panelStock.panelModifierStock.setVisible(false);
        }

        if (frame.panelPrincipal.panelStock.panelAjouterStock.comboTypeProduit == e.getSource())
        {
            frame.panelPrincipal.panelStock.panelAjouterStock.cacherSpec();

            switch (frame.panelPrincipal.panelStock.panelAjouterStock.comboTypeProduit.getSelectedIndex())
            {
                case 0,1,2 :
                {
                    frame.panelPrincipal.panelStock.panelAjouterStock.auteurLivre.setVisible(true);
                    frame.panelPrincipal.panelStock.panelAjouterStock.labelAuteurLivre.setVisible(true);
                    break;
                }


                case 3 :
                {
                    frame.panelPrincipal.panelStock.panelAjouterStock.comboLangueDictionnaire.setVisible(true);
                    frame.panelPrincipal.panelStock.panelAjouterStock.labelLangueDictionnaire.setVisible(true);
                    break;
                }


                case 4 :
                {
                    frame.panelPrincipal.panelStock.panelAjouterStock.anneeCD.setVisible(true);
                    frame.panelPrincipal.panelStock.panelAjouterStock.labelAnneeCD.setVisible(true);
                    break;
                }


                case 5 :
                {
                    frame.panelPrincipal.panelStock.panelAjouterStock.realisateur.setVisible(true);
                    frame.panelPrincipal.panelStock.panelAjouterStock.labelRealisateur.setVisible(true);
                    break;
                }
            }
        }

        if(frame.panelPrincipal.panelStock.panelAjouterStock.btnValiderProduit == e.getSource())
        {
            try
            {
                if (!(frame.panelPrincipal.panelStock.panelAjouterStock.nomProduit.getText().trim().isEmpty()) &&
                        !(frame.panelPrincipal.panelStock.panelAjouterStock.identifiantProduit.getText().trim().isEmpty()) &&
                        (Integer.parseInt(frame.panelPrincipal.panelStock.panelAjouterStock.nombreStock.getText().trim()) >= 0) &&
                        !(frame.panelPrincipal.panelStock.panelAjouterStock.tarifJournalier.getText().trim().isEmpty()) &&
                        !(Main.verifIdProduitExistant(frame.panelPrincipal.panelStock.panelAjouterStock.identifiantProduit.getText().trim())))
                {
                    String identifiant = frame.panelPrincipal.panelStock.panelAjouterStock.identifiantProduit.getText().trim();
                    String nomProduit = frame.panelPrincipal.panelStock.panelAjouterStock.nomProduit.getText().trim();
                    int nombreStock = Integer.parseInt(frame.panelPrincipal.panelStock.panelAjouterStock.nombreStock.getText().trim());
                    double tarifJournalier = Double.parseDouble(frame.panelPrincipal.panelStock.panelAjouterStock.tarifJournalier.getText().trim());
                    Type type = (Type) frame.panelPrincipal.panelStock.panelAjouterStock.comboTypeProduit.getSelectedItem();

                    switch (frame.panelPrincipal.panelStock.panelAjouterStock.comboTypeProduit.getSelectedIndex())
                    {
                        case 0,1,2 :
                            if (!frame.panelPrincipal.panelStock.panelAjouterStock.auteurLivre.getText().trim().isEmpty())
                            {
                                String auteur = frame.panelPrincipal.panelStock.panelAjouterStock.auteurLivre.getText().trim();
                                Main.listProduit.add(new Livre(identifiant, nomProduit, nombreStock, type, tarifJournalier, auteur));
                                frame.panelPrincipal.panelStock.panelAjouterStock.reset();
                            }
                            break;

                        case 3 :
                            Langue langueDictionnaire = (Langue) frame.panelPrincipal.panelStock.panelAjouterStock.comboLangueDictionnaire.getSelectedItem();
                            Main.listProduit.add(new Dictionnaire(identifiant, nomProduit, nombreStock, type, tarifJournalier, langueDictionnaire));
                            frame.panelPrincipal.panelStock.panelAjouterStock.reset();
                            break;

                        case 4 :
                            if (!frame.panelPrincipal.panelStock.panelAjouterStock.anneeCD.getText().trim().isEmpty())
                            {
                                int anneeCD = Integer.parseInt(frame.panelPrincipal.panelStock.panelAjouterStock.anneeCD.getText().trim());
                                Main.listProduit.add(new CD(identifiant, nomProduit, nombreStock, type, tarifJournalier, anneeCD));
                                frame.panelPrincipal.panelStock.panelAjouterStock.reset();
                            }
                            break;

                        case 5 :
                            if (!frame.panelPrincipal.panelStock.panelAjouterStock.realisateur.getText().trim().isEmpty())
                            {
                                String realisateur = frame.panelPrincipal.panelStock.panelAjouterStock.realisateur.getText().trim();
                                Main.listProduit.add(new DVD(identifiant, nomProduit, nombreStock, type, tarifJournalier, realisateur));
                                frame.panelPrincipal.panelStock.panelAjouterStock.reset();
                            }
                            break;

                        default:
                            break;
                    }
                }
                if (Main.verifIdProduitExistant(frame.panelPrincipal.panelStock.panelAjouterStock.identifiantProduit.getText().trim()))
                {
                    frame.panelPrincipal.panelStock.panelAjouterStock.identifiantProduit.setBackground(Color.red);
                }
            }
            catch (NumberFormatException ignored)
            {
                frame.panelPrincipal.panelStock.panelAjouterStock.labelErreur.setVisible(true);
            }
        }
    }
}
