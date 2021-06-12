package ecouteur;

import client.Client;
import commande.Commande;
import commande.Emprunt;
import graphic.PanelModifierStock;
import main.Main;
import produit.*;
import tools.Langue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class EcouteurModifierStock implements ActionListener
{
    PanelModifierStock panelModifierStock;

    public EcouteurModifierStock(PanelModifierStock panelModifierStock)
    {
        this.panelModifierStock = panelModifierStock;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == panelModifierStock.btnModifier)
        {
            Produit produitAModifier = Main.videotheque.getStock().get(panelModifierStock.comboStock.getSelectedIndex());

            panelModifierStock.transfertInfoProduit(produitAModifier);
            panelModifierStock.preparationAffichageProduit();

            panelModifierStock.panelSelection.setVisible(false);
            panelModifierStock.panelModifierProduitSelect.setVisible(true);
        }

        if (panelModifierStock.panelModifierProduitSelect.btnValiderProduit == e.getSource())
        {
            try
            {
                for (int i = 0; i <  Main.videotheque.getStock().size(); i++)
                {
                    if (Main.videotheque.getStock().get(i).getIdentifiant().trim().equals(panelModifierStock.panelModifierProduitSelect.identifiantProduit.getText().trim()))
                    {
                        if (!(panelModifierStock.panelModifierProduitSelect.nomProduit.getText().trim().isEmpty()) &&
                                (Integer.parseInt(panelModifierStock.panelModifierProduitSelect.nombreStock.getText().trim()) >= 0) &&
                                !(panelModifierStock.panelModifierProduitSelect.tarifJournalier.getText().trim().isEmpty()))
                        {
                            String identifiant = panelModifierStock.panelModifierProduitSelect.identifiantProduit.getText().trim();
                            String nomProduit = panelModifierStock.panelModifierProduitSelect.nomProduit.getText().trim();
                            int nombreStock = Integer.parseInt(panelModifierStock.panelModifierProduitSelect.nombreStock.getText().trim());
                            double tarifJournalier = Double.parseDouble(panelModifierStock.panelModifierProduitSelect.tarifJournalier.getText().trim());
                            Produit remplacantEmprunt = null;

                            //Remplacer l'ancien produit par le nouveau dans la listeProduit
                            switch (panelModifierStock.panelModifierProduitSelect.comboTypeProduit.getSelectedIndex())
                            {
                                case 0:
                                {
                                    if (!panelModifierStock.panelModifierProduitSelect.auteurLivre.getText().trim().isEmpty())
                                    {
                                        String auteur = panelModifierStock.panelModifierProduitSelect.auteurLivre.getText().trim();

                                        Livre replace = new BD(identifiant, nomProduit, nombreStock, tarifJournalier, auteur);
                                        remplacantEmprunt = replace;
                                        Main.videotheque.getStock().set(i, replace);

                                        panelModifierStock.panelModifierProduitSelect.clear();
                                    }
                                    break;
                                }

                                case 1:
                                {
                                    if (!panelModifierStock.panelModifierProduitSelect.auteurLivre.getText().trim().isEmpty())
                                    {
                                        String auteur = panelModifierStock.panelModifierProduitSelect.auteurLivre.getText().trim();

                                        Livre replace = new Roman(identifiant, nomProduit, nombreStock, tarifJournalier, auteur);
                                        remplacantEmprunt = replace;
                                        Main.videotheque.getStock().set(i, replace);

                                        panelModifierStock.panelModifierProduitSelect.clear();
                                    }
                                    break;
                                }

                                case 2:
                                {
                                    if (!panelModifierStock.panelModifierProduitSelect.auteurLivre.getText().trim().isEmpty())
                                    {
                                        String auteur = panelModifierStock.panelModifierProduitSelect.auteurLivre.getText().trim();

                                        Livre replace = new ManuelScolaire(identifiant, nomProduit, nombreStock, tarifJournalier, auteur);
                                        remplacantEmprunt = replace;
                                        Main.videotheque.getStock().set(i, replace);

                                        panelModifierStock.panelModifierProduitSelect.clear();
                                    }
                                    break;
                                }

                                case 3:
                                {
                                    Langue langueDictionnaire = (Langue) panelModifierStock.panelModifierProduitSelect.comboLangueDictionnaire.getSelectedItem();

                                    Dictionnaire replace = new Dictionnaire(identifiant, nomProduit, nombreStock, tarifJournalier, langueDictionnaire);
                                    remplacantEmprunt = replace;
                                    Main.videotheque.getStock().set(i, replace);

                                    panelModifierStock.panelModifierProduitSelect.clear();
                                    break;
                                }

                                case 4:
                                {
                                    if (!panelModifierStock.panelModifierProduitSelect.anneeCD.getText().trim().isEmpty())
                                    {
                                        int anneeCD = Integer.parseInt(panelModifierStock.panelModifierProduitSelect.anneeCD.getText().trim());

                                        CD replace = new CD(identifiant, nomProduit, nombreStock, tarifJournalier, anneeCD);
                                        remplacantEmprunt = replace;
                                        Main.videotheque.getStock().set(i, replace);

                                        panelModifierStock.panelModifierProduitSelect.clear();
                                    }
                                    break;
                                }

                                case 5:
                                {
                                    if (!panelModifierStock.panelModifierProduitSelect.realisateur.getText().trim().isEmpty())
                                    {
                                        String realisateur = panelModifierStock.panelModifierProduitSelect.realisateur.getText().trim();

                                        DVD replace = new DVD(identifiant, nomProduit, nombreStock, tarifJournalier, realisateur);
                                        remplacantEmprunt = replace;
                                        Main.videotheque.getStock().set(i, replace);

                                        panelModifierStock.panelModifierProduitSelect.clear();
                                    }
                                    break;
                                }

                                default:
                                    break;
                            }

//On va remplacer dans toutes les commandes, le produit qu'on a modifié par le nouveau
                            for (Client client :  Main.videotheque.getListClient())
                            {
                                for (Commande commande : client.getListeCommande())
                                {
                                    for(Emprunt emprunt : commande.getListeEmprunt())
                                    {
                                        if (Objects.requireNonNull(remplacantEmprunt).getIdentifiant().equals(emprunt.getProduitConcerne().getIdentifiant()))
                                        {
                                            emprunt.setProduitConcerne(remplacantEmprunt);
                                        }
                                    }
                                }
                            }
                            //Regenerer la comboBox
                            panelModifierStock.initComboStock();

                            panelModifierStock.panelModifierProduitSelect.labelErreur.setVisible(false);
                            panelModifierStock.panelModifierProduitSelect.setVisible(false);
                            panelModifierStock.panelSelection.setVisible(true);

                            JOptionPane.showMessageDialog(null,"Le produit a bien été modifié dans le stock ainsi que dans les commandes");
                        }
                        else
                        {
                            panelModifierStock.panelModifierProduitSelect.labelErreur.setVisible(true);
                        }
                    }
                }
            }
            catch (NumberFormatException ignored) {
                panelModifierStock.panelModifierProduitSelect.labelErreur.setVisible(true);
            }
        }
    }
}