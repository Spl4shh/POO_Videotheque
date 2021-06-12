package ecouteur;

import commande.Commande;
import commande.Emprunt;
import graphic.PanelModifierCommande;
import main.Main;
import produit.Produit;
import tools.Date;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurModifierCommande implements ActionListener
{
    PanelModifierCommande panelModifierCommande;
    boolean ajouter;

    public EcouteurModifierCommande(PanelModifierCommande panelModifierCommande)
    {
        this.panelModifierCommande = panelModifierCommande;
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
//Combo Client-----------------------------------------------------------------------
        if (panelModifierCommande.comboClient == e.getSource())
        {
            if (panelModifierCommande.comboClient.getItemCount() > 0)
            {
                panelModifierCommande.initComboCommande();
            }
            else
            {
                panelModifierCommande.comboCommande.removeAllItems();
            }
        }
//Combo Commande-----------------------------------------------------------------------
        if (panelModifierCommande.comboCommande == e.getSource())
        {
            if (panelModifierCommande.comboClient.getItemCount() > 0
                    && panelModifierCommande.comboCommande.getItemCount() > 0)
            {
                panelModifierCommande.initComboEmprunt();
            }
            else
            {
                panelModifierCommande.comboEmprunt.removeAllItems();
            }
        }
//Combo Emprunt-----------------------------------------------------------------------
        if (panelModifierCommande.comboEmprunt == e.getSource())
        {
            if (panelModifierCommande.comboEmprunt.getItemCount() >0)
            {
                panelModifierCommande.btnAjouter.setVisible(true);
                panelModifierCommande.btnModifier.setVisible(true);
                panelModifierCommande.btnSupprimer.setVisible(true);
            }
            else
            {
                panelModifierCommande.btnAjouter.setVisible(false);
                panelModifierCommande.btnModifier.setVisible(false);
                panelModifierCommande.btnSupprimer.setVisible(false);
            }
            panelModifierCommande.resetChamp();
        }
//Combo Produit ---------------------------------------------------------------------------------------
        if (panelModifierCommande.panelModificationCommande.comboProduit == e.getSource())
        {
            if (panelModifierCommande.panelModificationCommande.comboProduit.getItemCount() > 0)
            {
                panelModifierCommande.panelModificationCommande.majStock();
                panelModifierCommande.panelModificationCommande.messageErreur.setVisible(false);
            }
        }
//btnAjouter-----------------------------------------------------------------------
        if (panelModifierCommande.btnAjouter == e.getSource())
        {
            panelModifierCommande.panelSelectionEmprunt.setVisible(false);
            panelModifierCommande.panelModificationCommande.setVisible(true);
            panelModifierCommande.panelModificationCommande.majStock();
            ajouter = true;
        }
//btnSupprimer-----------------------------------------------------------------------
        if (panelModifierCommande.btnSupprimer == e.getSource())
        {
            int indexClient = panelModifierCommande.comboClient.getSelectedIndex();
            int indexCommande = panelModifierCommande.comboCommande.getSelectedIndex();
            int indexEmprunt = panelModifierCommande.comboEmprunt.getSelectedIndex();

            Emprunt empruntCourant =  Main.videotheque.getListClient().get(indexClient).getListeCommande().get(indexCommande).getListeEmprunt().get(indexEmprunt);

            Main.videotheque.getStock().get(Integer.parseInt(empruntCourant.getProduitConcerne().getIdentifiant()) - 1).augmenterStock();

            if ( Main.videotheque.getListClient().get(indexClient).getListeCommande().get(indexCommande).getListeEmprunt().size() > 1)
            {
                Emprunt emprunt =  Main.videotheque.getListClient().get(indexClient).getListeCommande().get(indexCommande).getListeEmprunt().get(indexEmprunt);

                Main.videotheque.getListClient().get(indexClient).getListeCommande().get(indexCommande).supprimerEmprunt(emprunt);
               panelModifierCommande.initComboEmprunt();

                JOptionPane.showMessageDialog(null,"L'emprunt a bien été supprimé de la commande");
            }
            else if ( Main.videotheque.getListClient().get(indexClient).getListeCommande().size() > 1)
            {
                Commande commande = Main.videotheque.getListClient().get(indexClient).getListeCommande().get(indexCommande);

                Main.videotheque.getListClient().get(indexClient).removeCommande(commande);
                panelModifierCommande.initComboCommande();

                JOptionPane.showMessageDialog(null,"L'emprunt ainsi que la commande ont bien été supprimé");

            }
            else
            {
                Main.videotheque.getListClient().get(indexClient).getListeCommande().remove(indexCommande);
                panelModifierCommande.initComboClient();

                JOptionPane.showMessageDialog(null,"L'emprunt ainsi que la commande ont bien été supprimé\n"
                        + "Ce client n'a plus de commande");
            }
        }
//btnModifier-----------------------------------------------------------------------
        if (panelModifierCommande.btnModifier == e.getSource())
        {
            int indexClient = panelModifierCommande.comboClient.getSelectedIndex();
            int indexCommande = panelModifierCommande.comboCommande.getSelectedIndex();
            int indexEmprunt = panelModifierCommande.comboEmprunt.getSelectedIndex();

            Emprunt empruntCourant =  Main.videotheque.getListClient().get(indexClient).getListeCommande().get(indexCommande).getListeEmprunt().get(indexEmprunt);

            String jour = String.valueOf(empruntCourant.getDateFin().getJour());
            String mois = String.valueOf(empruntCourant.getDateFin().getMois());
            String annee = String.valueOf(empruntCourant.getDateFin().getAnnee());

            ajouter = false;

            int indexProduit = 0;
            for (int i = 0; i < Main.videotheque.getStock().size(); i++)
            {
                if(empruntCourant.getProduitConcerne().getIdentifiant().equals(Main.videotheque.getStock().get(i).getIdentifiant()))
                {
                    indexProduit = i;
                }
            }

            panelModifierCommande.panelModificationCommande.comboProduit.setSelectedIndex(indexProduit);
            panelModifierCommande.panelModificationCommande.panelAjoutDate.jour.setText(jour);
            panelModifierCommande.panelModificationCommande.panelAjoutDate.mois.setText(mois);
            panelModifierCommande.panelModificationCommande.panelAjoutDate.annee.setText(annee);

            panelModifierCommande.panelSelectionEmprunt.setVisible(false);
            panelModifierCommande.panelModificationCommande.setVisible(true);

        }
//btnValider-----------------------------------------------------------------------
        if (panelModifierCommande.panelModificationCommande.btnValiderEmprunt == e.getSource())
        {
            int indexClient = panelModifierCommande.comboClient.getSelectedIndex();
            int indexCommande = panelModifierCommande.comboCommande.getSelectedIndex();
            int indexEmprunt = panelModifierCommande.comboEmprunt.getSelectedIndex();

            Commande commande =  Main.videotheque.getListClient().get(indexClient).getListeCommande().get(indexCommande);

            try
            {
                int jour, mois,annee;
                jour  = Integer.parseInt(panelModifierCommande.panelModificationCommande.panelAjoutDate.jour.getText().trim());
                mois = Integer.parseInt(panelModifierCommande.panelModificationCommande.panelAjoutDate.mois.getText().trim());
                annee = Integer.parseInt(panelModifierCommande.panelModificationCommande.panelAjoutDate.annee.getText().trim());

                if (Date.verif(jour, mois, annee))
                {
                    Date dateDebut = commande.getDateCreation();
                    Date dateFin = new Date(jour, mois, annee);

                    Produit produitSelect;

                    produitSelect =  Main.videotheque.getStock().get(panelModifierCommande.panelModificationCommande.comboProduit.getSelectedIndex());

                    if (produitSelect.estDispo() &&((dateFin.nbJours() - dateDebut.nbJours()) > 0))
                    {
                        if (ajouter)
                        {
                            commande.ajouterEmprunt(new Emprunt(dateDebut, dateFin, produitSelect));
                            produitSelect.reduireStock();
                        }
                        else
                        {
                            commande.getListeEmprunt().set(indexEmprunt, new Emprunt(dateDebut, dateFin, produitSelect));
                        }
                        panelModifierCommande.panelModificationCommande.setVisible(false);
                        panelModifierCommande.panelSelectionEmprunt.setVisible(true);
                        panelModifierCommande.initComboEmprunt();

                        JOptionPane.showMessageDialog(null,"Modification bien prise en compte");
                    }
                    else
                    {
                        panelModifierCommande.panelModificationCommande.messageErreur.setVisible(true);
                    }
                }

            }
            catch (NumberFormatException ignored)
            {
            }
        }
    }
}
