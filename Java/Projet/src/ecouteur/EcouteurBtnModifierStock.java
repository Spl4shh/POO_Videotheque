package ecouteur;

import graphic.Frame;
import main.Main;
import produit.CD;
import produit.DVD;
import produit.Dictionnaire;
import produit.Livre;
import tools.Langue;
import tools.Type;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurBtnModifierStock implements ActionListener
{
    Frame frame;

    public EcouteurBtnModifierStock(Frame f)
    {
        this.frame = f;

        for (JButton bouton : frame.panelPrincipal.panelStock.panelModifierStock.listeBouton)
        {
            bouton.addActionListener(this);
        }

        frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.btnValiderProduit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (frame.panelPrincipal.panelStock.panelModifierStock.gridBouton.isVisible())
        {
            int j = frame.panelPrincipal.panelStock.panelModifierStock.listeBouton.indexOf(e.getSource());
            Type typeProduit = Main.listProduit.get(j).getType();
            frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.comboTypeProduit.setSelectedItem(typeProduit);

            frame.panelPrincipal.panelStock.panelModifierStock.preparationAffichageProduit();
            frame.panelPrincipal.panelStock.panelModifierStock.transfertInfoProduit(Main.listProduit.get(j));

            frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.setVisible(true);
            frame.panelPrincipal.panelStock.panelModifierStock.gridBouton.setVisible(false);
        }

        if (frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.btnValiderProduit == e.getSource())
        {
            try
            {
                for (int i = 0; i < Main.listProduit.size(); i++)
                {
                    if (Main.listProduit.get(i).getIdentifiant().equals(frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.identifiantProduit.getText()))
                    {
                        if (!(frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.nomProduit.getText().trim().isEmpty()) &&
                                (Integer.parseInt(frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.nombreStock.getText().trim()) >= 0) &&
                                !(frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.tarifJournalier.getText().trim().isEmpty()))
                        {
                            String identifiant = frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.identifiantProduit.getText().trim();
                            String nomProduit = frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.nomProduit.getText().trim();
                            int nombreStock = Integer.parseInt(frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.nombreStock.getText().trim());
                            double tarifJournalier = Double.parseDouble(frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.tarifJournalier.getText().trim());
                            Type type = (Type) frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.comboTypeProduit.getSelectedItem();

                            switch (frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.comboTypeProduit.getSelectedIndex())
                            {
                                case 0, 1, 2:
                                {
                                    if (!frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.auteurLivre.getText().trim().isEmpty())
                                    {
                                        String auteur = frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.auteurLivre.getText().trim();

                                        Livre replace = new Livre(identifiant, nomProduit, nombreStock, type, tarifJournalier, auteur);
                                        Main.listProduit.set(i, replace);

                                        frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.reset();
                                    }
                                    break;
                                }

                                case 3:
                                {
                                    Langue langueDictionnaire = (Langue) frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.comboLangueDictionnaire.getSelectedItem();

                                    Dictionnaire replace = new Dictionnaire(identifiant, nomProduit, nombreStock, type, tarifJournalier, langueDictionnaire);
                                    Main.listProduit.set(i, replace);

                                    frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.reset();
                                    break;
                                }

                                case 4:
                                {
                                    if (!frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.anneeCD.getText().trim().isEmpty())
                                    {
                                        int anneeCD = Integer.parseInt(frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.anneeCD.getText().trim());

                                        CD replace = new CD(identifiant, nomProduit, nombreStock, type, tarifJournalier, anneeCD);
                                        Main.listProduit.set(i, replace);

                                        frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.reset();
                                    }
                                    break;
                                }

                                case 5:
                                {
                                    if (!frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.realisateur.getText().trim().isEmpty())
                                    {
                                        String realisateur = frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.realisateur.getText().trim();

                                        DVD replace = new DVD(identifiant, nomProduit, nombreStock, type, tarifJournalier, realisateur);
                                        Main.listProduit.set(i, replace);

                                        frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.reset();
                                    }
                                    break;
                                }

                                default:
                                    break;
                            }
                            frame.panelPrincipal.panelStock.panelModifierStock.btnInit();
                            for (JButton bouton : frame.panelPrincipal.panelStock.panelModifierStock.listeBouton)
                            {
                                bouton.addActionListener(this);
                            }

                            frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.labelErreur.setVisible(false);
                            frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.setVisible(false);
                            frame.panelPrincipal.panelStock.panelModifierStock.gridBouton.setVisible(true);
                        }
                        else
                        {
                            frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.labelErreur.setVisible(true);
                        }
                    }
                }
            }
            catch (NumberFormatException ignored) {
                frame.panelPrincipal.panelStock.panelAjouterStock.labelErreur.setVisible(true);
            }
        }
    }
}