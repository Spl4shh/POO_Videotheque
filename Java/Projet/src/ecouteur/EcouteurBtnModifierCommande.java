package ecouteur;

import commande.Commande;
import commande.Emprunt;
import graphic.Frame;
import main.Main;
import produit.Produit;
import tools.Date;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class EcouteurBtnModifierCommande implements ActionListener
{
    Frame frame;
    boolean ajouter;

    public EcouteurBtnModifierCommande(Frame f)
    {
        this.frame = f;
        frame.panelPrincipal.panelCommande.panelModifierCommande.comboClient.addActionListener(this);
        frame.panelPrincipal.panelCommande.panelModifierCommande.comboCommande.addActionListener(this);
        frame.panelPrincipal.panelCommande.panelModifierCommande.comboEmprunt.addActionListener(this);

        frame.panelPrincipal.panelCommande.panelModifierCommande.btnAjouter.addActionListener(this);
        frame.panelPrincipal.panelCommande.panelModifierCommande.btnModifier.addActionListener(this);
        frame.panelPrincipal.panelCommande.panelModifierCommande.btnSupprimer.addActionListener(this);

        frame.panelPrincipal.panelCommande.panelModifierCommande.panelModificationCommande.btnValiderEmprunt.addActionListener(this);

        frame.panelPrincipal.panelCommande.panelModifierCommande.panelModificationCommande.comboProduit.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
//Combo Client-----------------------------------------------------------------------
        if (frame.panelPrincipal.panelCommande.panelModifierCommande.comboClient == e.getSource())
        {
            if (frame.panelPrincipal.panelCommande.panelModifierCommande.comboClient.getItemCount() > 0)
            {
                frame.panelPrincipal.panelCommande.panelModifierCommande.initComboCommande();
            }
            else
            {
                frame.panelPrincipal.panelCommande.panelModifierCommande.comboCommande.removeAllItems();
            }
        }
//Combo Commande-----------------------------------------------------------------------
        if (frame.panelPrincipal.panelCommande.panelModifierCommande.comboCommande == e.getSource())
        {
            if (frame.panelPrincipal.panelCommande.panelModifierCommande.comboClient.getItemCount() > 0
                    && frame.panelPrincipal.panelCommande.panelModifierCommande.comboCommande.getItemCount() > 0)
            {
                frame.panelPrincipal.panelCommande.panelModifierCommande.initComboEmprunt();
            }
            else
            {
                frame.panelPrincipal.panelCommande.panelModifierCommande.comboEmprunt.removeAllItems();
            }
        }
//Combo Emprunt-----------------------------------------------------------------------
        if (frame.panelPrincipal.panelCommande.panelModifierCommande.comboEmprunt == e.getSource())
        {
            if (frame.panelPrincipal.panelCommande.panelModifierCommande.comboEmprunt.getItemCount() >0)
            {
                frame.panelPrincipal.panelCommande.panelModifierCommande.btnAjouter.setVisible(true);
                frame.panelPrincipal.panelCommande.panelModifierCommande.btnModifier.setVisible(true);
                frame.panelPrincipal.panelCommande.panelModifierCommande.btnSupprimer.setVisible(true);
            }
            else
            {
                frame.panelPrincipal.panelCommande.panelModifierCommande.btnAjouter.setVisible(false);
                frame.panelPrincipal.panelCommande.panelModifierCommande.btnModifier.setVisible(false);
                frame.panelPrincipal.panelCommande.panelModifierCommande.btnSupprimer.setVisible(false);
            }
            frame.panelPrincipal.panelCommande.panelModifierCommande.resetChamp();
        }
//Combo Produit ---------------------------------------------------------------------------------------
        if (frame.panelPrincipal.panelCommande.panelModifierCommande.panelModificationCommande.comboProduit == e.getSource())
        {
            if (frame.panelPrincipal.panelCommande.panelModifierCommande.panelModificationCommande.comboProduit.getItemCount() > 0)
            {
                frame.panelPrincipal.panelCommande.panelModifierCommande.panelModificationCommande.majStock();
                frame.panelPrincipal.panelCommande.panelModifierCommande.panelModificationCommande.messageErreur.setVisible(false);
            }
        }
//btnAjouter-----------------------------------------------------------------------
        if (frame.panelPrincipal.panelCommande.panelModifierCommande.btnAjouter == e.getSource())
        {
            frame.panelPrincipal.panelCommande.panelModifierCommande.panelSelectionEmprunt.setVisible(false);
            frame.panelPrincipal.panelCommande.panelModifierCommande.panelModificationCommande.setVisible(true);
            frame.panelPrincipal.panelCommande.panelModifierCommande.panelModificationCommande.majStock();
            ajouter = true;
        }
//btnSupprimer-----------------------------------------------------------------------
        if (frame.panelPrincipal.panelCommande.panelModifierCommande.btnSupprimer == e.getSource())
        {
            int indexClient = frame.panelPrincipal.panelCommande.panelModifierCommande.comboClient.getSelectedIndex();
            int indexCommande = frame.panelPrincipal.panelCommande.panelModifierCommande.comboCommande.getSelectedIndex();
            int indexEmprunt = frame.panelPrincipal.panelCommande.panelModifierCommande.comboEmprunt.getSelectedIndex();

            Emprunt empruntCourant = Main.listClient.get(indexClient).getListeCommande().get(indexCommande).getListeEmprunt().get(indexEmprunt);

            Main.listProduit.get(Integer.parseInt(empruntCourant.getProduitConcerne().getIdentifiant()) - 1).augmenterStock();

            if (Main.listClient.get(indexClient).getListeCommande().get(indexCommande).getListeEmprunt().size() > 1)
            {
                Emprunt emprunt = Main.listClient.get(indexClient).getListeCommande().get(indexCommande).getListeEmprunt().get(indexEmprunt);
                emprunt.removeProduitEmprunt();

                Main.listClient.get(indexClient).getListeCommande().get(indexCommande).getListeEmprunt().remove(indexEmprunt);
                frame.panelPrincipal.panelCommande.panelModifierCommande.initComboEmprunt();
            }
            else if (Main.listClient.get(indexClient).getListeCommande().size() > 1)
            {
                Main.listClient.get(indexClient).getListeCommande().remove(indexCommande);
                frame.panelPrincipal.panelCommande.panelModifierCommande.initComboCommande();
            }
            else
            {
                Main.listClient.get(indexClient).getListeCommande().remove(indexCommande);
                frame.panelPrincipal.panelCommande.panelModifierCommande.initComboClient();
            }
        }
//btnModifier-----------------------------------------------------------------------
        if (frame.panelPrincipal.panelCommande.panelModifierCommande.btnModifier == e.getSource())
        {
            int indexClient = frame.panelPrincipal.panelCommande.panelModifierCommande.comboClient.getSelectedIndex();
            int indexCommande = frame.panelPrincipal.panelCommande.panelModifierCommande.comboCommande.getSelectedIndex();
            int indexEmprunt = frame.panelPrincipal.panelCommande.panelModifierCommande.comboEmprunt.getSelectedIndex();

            Emprunt empruntCourant = Main.listClient.get(indexClient).getListeCommande().get(indexCommande).getListeEmprunt().get(indexEmprunt);

            String jour = String.valueOf(empruntCourant.getDateFin().getJour());
            String mois = String.valueOf(empruntCourant.getDateFin().getMois());
            String annee = String.valueOf(empruntCourant.getDateFin().getAnnee());

            frame.panelPrincipal.panelCommande.panelModifierCommande.panelSelectionEmprunt.setVisible(false);
            frame.panelPrincipal.panelCommande.panelModifierCommande.panelModificationCommande.setVisible(true);

            ajouter = false;

            frame.panelPrincipal.panelCommande.panelModifierCommande.panelModificationCommande.comboProduit.setSelectedIndex
                    (Integer.parseInt(empruntCourant.getProduitConcerne().getIdentifiant()) - 1);
            frame.panelPrincipal.panelCommande.panelModifierCommande.panelModificationCommande.panelAjoutDate.jour.setText(jour);
            frame.panelPrincipal.panelCommande.panelModifierCommande.panelModificationCommande.panelAjoutDate.mois.setText(mois);
            frame.panelPrincipal.panelCommande.panelModifierCommande.panelModificationCommande.panelAjoutDate.annee.setText(annee);
        }
//btnValider-----------------------------------------------------------------------
        if (frame.panelPrincipal.panelCommande.panelModifierCommande.panelModificationCommande.btnValiderEmprunt == e.getSource())
        {
            int indexClient = frame.panelPrincipal.panelCommande.panelModifierCommande.comboClient.getSelectedIndex();
            int indexCommande = frame.panelPrincipal.panelCommande.panelModifierCommande.comboCommande.getSelectedIndex();
            int indexEmprunt = frame.panelPrincipal.panelCommande.panelModifierCommande.comboEmprunt.getSelectedIndex();

            Commande commande = Main.listClient.get(indexClient).getListeCommande().get(indexCommande);

            try
            {
                int jour, mois,annee;
                jour  = Integer.parseInt(frame.panelPrincipal.panelCommande.panelModifierCommande.panelModificationCommande.panelAjoutDate.jour.getText().trim());
                mois = Integer.parseInt(frame.panelPrincipal.panelCommande.panelModifierCommande.panelModificationCommande.panelAjoutDate.mois.getText().trim());
                annee = Integer.parseInt(frame.panelPrincipal.panelCommande.panelModifierCommande.panelModificationCommande.panelAjoutDate.annee.getText().trim());

                if (Date.verif(jour, mois, annee))
                {
                    Date dateDebut = commande.getDateCreation();
                    Date dateFin = new Date(jour, mois, annee);

                    Produit produitSelect;

                    produitSelect = Main.listProduit.get(frame.panelPrincipal.panelCommande.panelModifierCommande.panelModificationCommande.comboProduit.getSelectedIndex());

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
                        frame.panelPrincipal.panelCommande.panelModifierCommande.panelModificationCommande.setVisible(false);
                        frame.panelPrincipal.panelCommande.panelModifierCommande.panelSelectionEmprunt.setVisible(true);
                        frame.panelPrincipal.panelCommande.panelModifierCommande.initComboEmprunt();
                    }
                    else
                    {
                        frame.panelPrincipal.panelCommande.panelModifierCommande.panelModificationCommande.messageErreur.setVisible(true);
                    }
                }

            }
            catch (NumberFormatException ignored)
            {
            }
        }
    }
}
