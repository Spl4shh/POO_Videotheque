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
