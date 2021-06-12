package ecouteur;

import graphic.PanelAjouterStock;
import main.Main;
import produit.*;
import tools.Langue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurAjouterStock implements ActionListener
{
    PanelAjouterStock panelAjouterStock;

    public EcouteurAjouterStock(PanelAjouterStock panelAjouterStock)
    {
        this.panelAjouterStock = panelAjouterStock;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (panelAjouterStock.comboTypeProduit == e.getSource())
        {
            panelAjouterStock.cacherSpec();

            switch (panelAjouterStock.comboTypeProduit.getSelectedIndex())
            {
                case 0,1,2 :
                {
                    panelAjouterStock.auteurLivre.setVisible(true);
                    panelAjouterStock.labelAuteurLivre.setVisible(true);
                    break;
                }

                case 3 :
                {
                    panelAjouterStock.comboLangueDictionnaire.setVisible(true);
                    panelAjouterStock.labelLangueDictionnaire.setVisible(true);
                    break;
                }

                case 4 :
                {
                    panelAjouterStock.anneeCD.setVisible(true);
                    panelAjouterStock.labelAnneeCD.setVisible(true);
                    break;
                }

                case 5 :
                {
                    panelAjouterStock.realisateur.setVisible(true);
                    panelAjouterStock.labelRealisateur.setVisible(true);
                    break;
                }

                default:
                {
                    System.out.println("EcouteurBtnAjouter.comboTypeProduit.switch : Erreur");
                }
            }
        }

        if(panelAjouterStock.btnValiderProduit == e.getSource())
        {
            try
            {
                if (!(panelAjouterStock.nomProduit.getText().trim().isEmpty()) &&
                        !(panelAjouterStock.identifiantProduit.getText().trim().isEmpty()) &&
                        (Integer.parseInt(panelAjouterStock.nombreStock.getText().trim()) >= 0) &&
                        !(panelAjouterStock.tarifJournalier.getText().trim().isEmpty()))
                {
                    String identifiant = panelAjouterStock.identifiantProduit.getText().trim();
                    String nomProduit = panelAjouterStock.nomProduit.getText().trim();
                    int nombreStock = Integer.parseInt(panelAjouterStock.nombreStock.getText().trim());
                    double tarifJournalier = Double.parseDouble(panelAjouterStock.tarifJournalier.getText().trim());

                    switch (panelAjouterStock.comboTypeProduit.getSelectedIndex())
                    {
                        case 0 :
                            if (!panelAjouterStock.auteurLivre.getText().trim().isEmpty())
                            {
                                String auteur = panelAjouterStock.auteurLivre.getText().trim();
                                Main.videotheque.ajouterStock(new BD(identifiant, nomProduit, nombreStock, tarifJournalier, auteur));
                                panelAjouterStock.clear();
                            }
                            break;

                        case 1 :
                            if (!panelAjouterStock.auteurLivre.getText().trim().isEmpty())
                            {
                                String auteur = panelAjouterStock.auteurLivre.getText().trim();
                                Main.videotheque.ajouterStock(new Roman(identifiant, nomProduit, nombreStock, tarifJournalier, auteur));
                                panelAjouterStock.clear();
                            }
                            break;

                        case 2 :
                            if (!panelAjouterStock.auteurLivre.getText().trim().isEmpty())
                            {
                                String auteur = panelAjouterStock.auteurLivre.getText().trim();
                                Main.videotheque.ajouterStock(new ManuelScolaire(identifiant, nomProduit, nombreStock, tarifJournalier, auteur));
                                panelAjouterStock.clear();
                            }
                            break;

                        case 3 :
                            Langue langueDictionnaire = (Langue) panelAjouterStock.comboLangueDictionnaire.getSelectedItem();
                            Main.videotheque.ajouterStock(new Dictionnaire(identifiant, nomProduit, nombreStock, tarifJournalier, langueDictionnaire));
                            panelAjouterStock.clear();
                            break;

                        case 4 :
                            if (!panelAjouterStock.anneeCD.getText().trim().isEmpty())
                            {
                                int anneeCD = Integer.parseInt(panelAjouterStock.anneeCD.getText().trim());
                                Main.videotheque.ajouterStock(new CD(identifiant, nomProduit, nombreStock, tarifJournalier, anneeCD));
                                panelAjouterStock.clear();
                            }
                            break;

                        case 5 :
                            if (!panelAjouterStock.realisateur.getText().trim().isEmpty())
                            {
                                String realisateur = panelAjouterStock.realisateur.getText().trim();
                                Main.videotheque.ajouterStock(new DVD(identifiant, nomProduit, nombreStock, tarifJournalier, realisateur));
                                panelAjouterStock.clear();
                            }
                            break;

                        default:
                            break;
                    }

                    JOptionPane.showMessageDialog(null,"Le produit " + nomProduit + " a bien été ajouté au stock");
                }
            }
            catch (NumberFormatException ignored)
            {
                panelAjouterStock.labelErreur.setVisible(true);
            }
        }
    }
}
