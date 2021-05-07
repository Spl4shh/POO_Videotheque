package graphic;

import main.Main;
import produit.*;
import tools.Langue;
import tools.Type;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelModifierStock extends JPanel
{
    public ArrayList<JButton> listeBouton;

    public JScrollBar verticalScrollBar;
    public JScrollPane scrollPanel;
    public JPanel gridBouton = new JPanel();

    public PanelAjouterStock panelModifierProduitSelect;


    public PanelModifierStock()
    {
        this.setLayout(new GridLayout(0, 2));  //Une fois que les deux panel seront créé essayer avec 1 colonne et le setVisible

    //Pour la modif, c'est le meme que ajouter produit mais sans le choix du type, et avec les cchamps deja rempli

        panelModifierProduitSelect = new PanelAjouterStock();
        panelModifierProduitSelect.btnValiderProduit.setText("Valider la modification");
        panelModifierProduitSelect.comboTypeProduit.setEnabled(false);
        panelModifierProduitSelect.setVisible(false);
        panelModifierProduitSelect.identifiantProduit.setEnabled(false);
        panelModifierProduitSelect.labelErreur.setText("Veuillez verifier les informations saisie");


        this.add(panelModifierProduitSelect);




    //Partie pour afficcher les boutons----------------------------
        verticalScrollBar = new JScrollBar();
        verticalScrollBar.setUnitIncrement(16);

        scrollPanel = new JScrollPane(gridBouton);

        scrollPanel.setVerticalScrollBar(verticalScrollBar);
        scrollPanel.setPreferredSize(new Dimension(500, 300));

        listeBouton = new ArrayList<JButton>();

        gridBouton.setLayout(new GridLayout(0, 1));
        gridBouton.setSize(400, 500);

        scrollPanel = new JScrollPane(gridBouton);
        scrollPanel.setVerticalScrollBar(verticalScrollBar);
        scrollPanel.setPreferredSize(new Dimension(500, 300));

        this.add(scrollPanel);
    //------------------------------------------------------------------
    }

    public void clear()
    {
        for (JButton bouton : this.listeBouton)
        {
            this.gridBouton.remove(bouton);
        }
        this.listeBouton.clear();
    }

    public void btnInit()
    {
        this.clear();

        for (int i = 0; i < Main.listProduit.size(); i++)
        {
            this.listeBouton.add(new JButton(Main.listProduit.get(i).getType() + " / "
                    + Main.listProduit.get(i).getTitre() + " / "
                    + Main.listProduit.get(i).getIdentifiant()));
        }

        for (JButton bouton : listeBouton)
        {
            this.gridBouton.add(bouton);
        }
    }

    public void preparationAffichageProduit()
    {
        this.panelModifierProduitSelect.cacherSpec();

        switch (this.panelModifierProduitSelect.comboTypeProduit.getSelectedIndex())
        {
            case 0,1,2 :
                this.panelModifierProduitSelect.auteurLivre.setVisible(true);
                this.panelModifierProduitSelect.labelAuteurLivre.setVisible(true);
                break;

            case 3 :
                this.panelModifierProduitSelect.comboLangueDictionnaire.setVisible(true);
                this.panelModifierProduitSelect.labelLangueDictionnaire.setVisible(true);
                break;

            case 4 :
                this.panelModifierProduitSelect.anneeCD.setVisible(true);
                this.panelModifierProduitSelect.labelAnneeCD.setVisible(true);
                break;

            case 5 :
                this.panelModifierProduitSelect.realisateur.setVisible(true);
                this.panelModifierProduitSelect.labelRealisateur.setVisible(true);
                break;

            default:
                break;
        }
    }


    /*public void panelModificationInit()
    {
        this.affichageModifProduit();

        try
        {
            if (!(this.panelModifierProduitSelect.nomProduit.getText().trim().isEmpty()) &&
                    !(this.panelModifierProduitSelect.identifiantProduit.getText().trim().isEmpty()) &&
                    !(this.panelModifierProduitSelect.nombreStock.getText().trim().isEmpty()) &&
                    !(this.panelModifierProduitSelect.tarifJournalier.getText().trim().isEmpty()))
            {
                String identifiant = this.panelModifierProduitSelect.identifiantProduit.getText().trim();
                String nomProduit = this.panelModifierProduitSelect.nomProduit.getText().trim();
                int nombreStock = Integer.parseInt(this.panelModifierProduitSelect.nombreStock.getText().trim());
                double tarifJournalier = Double.parseDouble(this.panelModifierProduitSelect.tarifJournalier.getText().trim());
                Type type = (Type) this.panelModifierProduitSelect.comboTypeProduit.getSelectedItem();

                switch (this.panelModifierProduitSelect.comboTypeProduit.getSelectedIndex())
                {
                    case 0,1,2 :
                        if (!this.panelModifierProduitSelect.auteurLivre.getText().trim().isEmpty())
                        {
                            String auteur = this.panelModifierProduitSelect.auteurLivre.getText().trim();
                            Main.listProduit.add(new Livre(identifiant, nomProduit, nombreStock, type, tarifJournalier, auteur));
                            this.panelModifierProduitSelect.reset();
                        }
                        break;

                    case 3 :
                        Langue langueDictionnaire = (Langue) this.panelModifierProduitSelect.comboLangueDictionnaire.getSelectedItem();
                        Main.listProduit.add(new Dictionnaire(identifiant, nomProduit, nombreStock, type, tarifJournalier, langueDictionnaire));
                        this.panelModifierProduitSelect.reset();
                        break;

                    case 4 :
                        if (!this.panelModifierProduitSelect.anneeCD.getText().trim().isEmpty())
                        {
                            int anneeCD = Integer.parseInt(this.panelModifierProduitSelect.anneeCD.getText().trim());
                            Main.listProduit.add(new CD(identifiant, nomProduit, nombreStock, type, tarifJournalier, anneeCD));
                            this.panelModifierProduitSelect.reset();
                        }
                        break;

                    case 5 :
                        if (!this.panelModifierProduitSelect.realisateur.getText().trim().isEmpty())
                        {
                            String realisateur = this.panelModifierProduitSelect.realisateur.getText().trim();
                            Main.listProduit.add(new DVD(identifiant, nomProduit, nombreStock, type, tarifJournalier, realisateur));
                            this.panelModifierProduitSelect.reset();
                        }
                        break;

                    default:
                        break;
                }
            }
            else
            {
                this.panelModifierProduitSelect.labelErreur.setText("Veuille completer tout les champs de saisie");
                this.panelModifierProduitSelect.labelErreur.setVisible(true);
            }
        }
        catch (NumberFormatException ignored)
        {
            this.panelModifierProduitSelect.labelErreur.setText("Veuillez verifier les informations saisie");
            this.panelModifierProduitSelect.labelErreur.setVisible(true);
        }
    }*/

    public void transfertInfoProduit(Produit produit)
    {
        switch (produit.getType())
        {
            case BD, Roman, Manuel_Scolaire:
            {
                Livre livre = (Livre)produit;

                this.panelModifierProduitSelect.nomProduit.setText(livre.getTitre());
                this.panelModifierProduitSelect.identifiantProduit.setText(livre.getIdentifiant());
                this.panelModifierProduitSelect.nombreStock.setText(String.valueOf(livre.getNombreStock()));
                this.panelModifierProduitSelect.tarifJournalier.setText(String.valueOf(livre.getTarifJournalier()));
                this.panelModifierProduitSelect.auteurLivre.setText(livre.getAuteur());

                break;
            }

            case Dictionnaire :
            {
                Dictionnaire dictionnaire = (Dictionnaire) produit;

                this.panelModifierProduitSelect.nomProduit.setText(dictionnaire.getTitre());
                this.panelModifierProduitSelect.identifiantProduit.setText(dictionnaire.getIdentifiant());
                this.panelModifierProduitSelect.nombreStock.setText(String.valueOf(dictionnaire.getNombreStock()));
                this.panelModifierProduitSelect.tarifJournalier.setText(String.valueOf(dictionnaire.getTarifJournalier()));
                this.panelModifierProduitSelect.comboLangueDictionnaire.setSelectedItem(dictionnaire.getLangue());

                break;
            }

            case CD :
            {
                CD cd = (CD)produit;

                this.panelModifierProduitSelect.nomProduit.setText(cd.getTitre());
                this.panelModifierProduitSelect.identifiantProduit.setText(cd.getIdentifiant());
                this.panelModifierProduitSelect.nombreStock.setText(String.valueOf(cd.getNombreStock()));
                this.panelModifierProduitSelect.tarifJournalier.setText(String.valueOf(cd.getTarifJournalier()));
                this.panelModifierProduitSelect.anneeCD.setText(String.valueOf(cd.getAnneeSortie()));

                break;
            }

            case DVD :
            {
                DVD dvd = (DVD)produit;

                this.panelModifierProduitSelect.nomProduit.setText(dvd.getTitre());
                this.panelModifierProduitSelect.identifiantProduit.setText(dvd.getIdentifiant());
                this.panelModifierProduitSelect.nombreStock.setText(String.valueOf(dvd.getNombreStock()));
                this.panelModifierProduitSelect.tarifJournalier.setText(String.valueOf(dvd.getTarifJournalier()));
                this.panelModifierProduitSelect.realisateur.setText(dvd.getRealisateur());

                break;
            }
        }
    }
}
