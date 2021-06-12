package ecouteur;


import graphic.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurMenuBarre implements ActionListener
{
    Frame frame;

    boolean themeSombre = false;

    public EcouteurMenuBarre(Frame f)
    {
        frame = f;
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (frame.optionThemeItem == e.getSource())
        {
            this.themeSombre = !themeSombre;

            this.frame.gestionTheme(themeSombre);
        }
        else
        {
            this.hideAll();

            if (frame.accueilMenuItem == e.getSource())
            {
                frame.panelPrincipal.panelAccueil.setVisible(true);
            }

            if (frame.ajouterClientItem == e.getSource())
            {
                frame.panelPrincipal.panelClient.setVisible(true);
                frame.panelPrincipal.panelClient.panelAjouterClient.setVisible(true);

                frame.panelPrincipal.panelClient.panelEntete.titre.setText("Ajout Client");
                //Clear des differents espaces de saisie
                frame.panelPrincipal.panelClient.panelAjouterClient.clear();
            }

            if (frame.supprimerClientItem == e.getSource())
            {
                frame.panelPrincipal.panelClient.setVisible(true);
                frame.panelPrincipal.panelClient.panelSupprimerClient.setVisible(true);

                frame.panelPrincipal.panelClient.panelEntete.titre.setText("Suppression Client");

                //Initialisation de la comboBox
                frame.panelPrincipal.panelClient.panelSupprimerClient.comboInit();
            }

            if (frame.modifierClientItem == e.getSource())
            {
                frame.panelPrincipal.panelClient.setVisible(true);
                frame.panelPrincipal.panelClient.panelModifierClient.setVisible(true);

                frame.panelPrincipal.panelClient.panelModifierClient.init();
                frame.panelPrincipal.panelClient.panelEntete.titre.setText("Modifier Client");
            }

            if (frame.ajouterCommandeItem == e.getSource())
            {
                frame.panelPrincipal.panelCommande.setVisible(true);
                frame.panelPrincipal.panelCommande.panelAjouterCommande.setVisible(true);

                frame.panelPrincipal.panelCommande.panelEntete.titre.setText("Ajout Commande");
                //Initialiser la premiere phase de la page
                frame.panelPrincipal.panelCommande.panelAjouterCommande.premierePhase();
            }

            if (frame.supprimerCommandeItem == e.getSource())
            {
                frame.panelPrincipal.panelCommande.setVisible(true);
                frame.panelPrincipal.panelCommande.panelSupprimerCommande.setVisible(true);

                frame.panelPrincipal.panelCommande.panelEntete.titre.setText("Suppression Commande");

                //Initialiser la comboBox
                frame.panelPrincipal.panelCommande.panelSupprimerCommande.comboInit();
            }

            if (frame.modifierCommandeItem == e.getSource())
            {
                frame.panelPrincipal.panelCommande.setVisible(true);
                frame.panelPrincipal.panelCommande.panelModifierCommande.setVisible(true);
                frame.panelPrincipal.panelStock.panelModifierStock.panelModifierProduitSelect.setVisible(false);

                frame.panelPrincipal.panelCommande.panelEntete.titre.setText("Modifier Commande");

                //Initialiser la page de modifications
                frame.panelPrincipal.panelCommande.panelModifierCommande.init();
            }

            if (frame.ajouterStockItem == e.getSource())
            {
                frame.panelPrincipal.panelStock.setVisible(true);
                frame.panelPrincipal.panelStock.panelAjouterStock.setVisible(true);

                frame.panelPrincipal.panelStock.panelEntete.titre.setText("Ajout Stock");
                //Clear des differents espaces de saisie
                frame.panelPrincipal.panelStock.panelAjouterStock.clear();
            }

            if (frame.supprimerStockItem == e.getSource())
            {
                frame.panelPrincipal.panelStock.setVisible(true);
                frame.panelPrincipal.panelStock.panelSupprimerStock.setVisible(true);

                frame.panelPrincipal.panelStock.panelEntete.titre.setText("Suppression Stock");
                //Initialiser les boutons et les Action Listener
                frame.panelPrincipal.panelStock.panelSupprimerStock.comboInit();
            }

            if (frame.modifierStockItem == e.getSource())
            {
                frame.panelPrincipal.panelStock.setVisible(true);
                frame.panelPrincipal.panelStock.panelModifierStock.setVisible(true);

                frame.panelPrincipal.panelStock.panelEntete.titre.setText("Modifier Stock");

                //Initilialiser les boutons et les Action Listener
                frame.panelPrincipal.panelStock.panelModifierStock.initComboStock();
            }

            if (frame.rechercherClientItem == e.getSource())
            {
                frame.panelPrincipal.panelRechercher.setVisible(true);
                frame.panelPrincipal.panelRechercher.panelRechercherClient.setVisible(true);

                frame.panelPrincipal.panelRechercher.panelEntete.titre.setText("Recherche Client");

                frame.panelPrincipal.panelRechercher.panelRechercherClient.initListeClient("");
            }

            if (frame.rechercherCommandeItem == e.getSource())
            {
                frame.panelPrincipal.panelRechercher.setVisible(true);
                frame.panelPrincipal.panelRechercher.panelRechercherCommande.setVisible(true);

                frame.panelPrincipal.panelRechercher.panelEntete.titre.setText("Recherche Commande");

                //Generer la liste de client dans les comboBox
                frame.panelPrincipal.panelRechercher.panelRechercherCommande.genererListeClient();
            }

            if (frame.rechercherStockItem == e.getSource())
            {
                frame.panelPrincipal.panelRechercher.setVisible(true);
                frame.panelPrincipal.panelRechercher.panelRechercherStock.setVisible(true);

                frame.panelPrincipal.panelRechercher.panelEntete.titre.setText("Recherche Stock");

                frame.panelPrincipal.panelRechercher.panelRechercherStock.initListeStock("");
            }
        }


    }


    public void hideAll()
    {
        frame.panelPrincipal.panelAccueil.setVisible(false);

        frame.panelPrincipal.panelClient.setVisible(false);
        frame.panelPrincipal.panelClient.panelAjouterClient.setVisible(false);
        frame.panelPrincipal.panelClient.panelSupprimerClient.setVisible(false);
        frame.panelPrincipal.panelClient.panelGestion.panelListe.setVisible(false);
        frame.panelPrincipal.panelClient.panelModifierClient.setVisible(false);

        frame.panelPrincipal.panelCommande.setVisible(false);
        frame.panelPrincipal.panelCommande.panelAjouterCommande.setVisible(false);
        frame.panelPrincipal.panelCommande.panelAjouterCommande.clearListeEmpruntEnCours();
        frame.panelPrincipal.panelCommande.panelSupprimerCommande.setVisible(false);
        frame.panelPrincipal.panelCommande.panelGestion.panelListe.setVisible(false);
        frame.panelPrincipal.panelCommande.panelModifierCommande.setVisible(false);

        frame.panelPrincipal.panelStock.setVisible(false);
        frame.panelPrincipal.panelStock.panelAjouterStock.setVisible(false);
        frame.panelPrincipal.panelStock.panelSupprimerStock.setVisible(false);
        frame.panelPrincipal.panelStock.panelGestion.panelListe.setVisible(false);
        frame.panelPrincipal.panelStock.panelModifierStock.setVisible(false);

        frame.panelPrincipal.panelRechercher.setVisible(false);
        frame.panelPrincipal.panelRechercher.panelRechercherClient.setVisible(false);
        frame.panelPrincipal.panelRechercher.panelRechercherCommande.setVisible(false);
        frame.panelPrincipal.panelRechercher.panelRechercherStock.setVisible(false);
    }
}
