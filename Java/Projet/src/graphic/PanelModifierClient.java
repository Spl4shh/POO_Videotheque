package graphic;

import client.Client;
import client.Fidele;
import client.Occasionnel;
import commande.Commande;
import ecouteur.EcouteurModifierClient;
import main.Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelModifierClient extends JPanel
{
    public PanelAjouterClient panelModificationClient;
    public JPanel panelSelection;
    public JComboBox comboClient;
    public JButton btnModifier;

    public PanelModifierClient()
    {
        panelModificationClient = new PanelAjouterClient();
        panelModificationClient.valider.setText("Valider les modifications");
        panelModificationClient.valider.addActionListener(new EcouteurModifierClient(this));


        this.add(panelModificationClient);
        panelModificationClient.setVisible(false);

        panelModificationClient.checkFidele.addActionListener(new EcouteurModifierClient(this));
        panelModificationClient.checkOccasionnel.addActionListener(new EcouteurModifierClient(this));


        panelSelection = new JPanel();

        comboClient = new JComboBox();
        comboClient.setPreferredSize(new Dimension(400, 25));
        panelSelection.add(comboClient);

        btnModifier = new JButton("Modifier Client");
        panelSelection.add(btnModifier);
        this.btnModifier.setVisible(false);
        btnModifier.addActionListener(new EcouteurModifierClient(this));

        this.add(panelSelection);
    }

    /**
     * Cette methode permet d'initialiser le panel.
     *
     * On initialise la comboBox.
     * On rend le panel de selection de client visible et celui
     * de modification invisible
     */
    public void init()
    {
        this.initComboClient();

        this.panelModificationClient.setVisible(false);
        this.panelSelection.setVisible(true);
    }

    /**
     * Cette methode permet d'initialiser la comboBox Client.
     *
     * On ajoute chaque client present dans la liste des clients dans la comboBox.
     * Si la comboBox n'est pas vide on rend le bouton de validation visible.
     */
    public void initComboClient()
    {
        comboClient.removeAllItems();
        this.btnModifier.setVisible(false);

        for (Client client :  Main.videotheque.getListClient())
        {
            comboClient.addItem(client.getNom() + " " + client.getPrenom());
        }
        if( Main.videotheque.getListClient().size() > 0)
        {
            this.btnModifier.setVisible(true);
        }
    }

    /**
     * Cette methode permet de transferer sur le panel les infos du client.
     *
     * On recupere les infos du client en parametre.
     *
     * @param clientCourant Client qu'on a choisi de modifier
     */
    public void transfertInfoClient(Client clientCourant)
    {
        this.panelSelection.setVisible(false);
        this.panelModificationClient.setVisible(true);

        this.panelModificationClient.textFieldId.setText(clientCourant.getIdentifiant().trim());
        this.panelModificationClient.textFieldNom.setText(clientCourant.getNom().trim());
        this.panelModificationClient.textFieldPrenom.setText(clientCourant.getPrenom().trim());

        if (clientCourant instanceof Fidele)
        {
            this.panelModificationClient.checkFidele.setSelected(true);
            this.panelModificationClient.checkOccasionnel.setSelected(false);
        }
        else
        {
            this.panelModificationClient.checkOccasionnel.setSelected(true);
            this.panelModificationClient.checkFidele.setSelected(false);
        }
    }

    /**
     * Cette methode permet de transferer les modifications dans la liste des clients.
     *
     * On verifie si les champs ne sont pas vides, on va rechercher le client dans la liste qui a le
     * meme identifiant que celui dans la fiche, une fois trouvé,
     * on lui applique les modifications et on lui transfere ses commandes.
     * Enfin on reinitialise le panel.
     */
    public void transfertModification()
    {
        if (!this.panelModificationClient.textFieldPrenom.getText().trim().isEmpty()
                && !this.panelModificationClient.textFieldNom.getText().trim().isEmpty())
        {
            String identifiant = this.panelModificationClient.textFieldId.getText();
            String prenom =  this.panelModificationClient.textFieldPrenom.getText().trim();
            String nom =  this.panelModificationClient.textFieldNom.getText().trim();
            boolean fidele = this.panelModificationClient.checkFidele.isSelected();

            for (int i = 0; i < Main.videotheque.getListClient().size(); i++)
            {
                Client client = Main.videotheque.getListClient().get(i);
                ArrayList<Commande> listeCommande = client.getListeCommande();

                if (client.getIdentifiant().equals(identifiant))
                {
                    if (fidele)
                    {
                        Main.videotheque.getListClient().set(i, new Fidele(identifiant, nom, prenom, listeCommande));
                        Fidele clientOccasionnel = (Fidele) Main.videotheque.getListClient().get(i);

                        for (Commande commande : client.getListeCommande())
                        {
                            commande.setReduction(clientOccasionnel.getReduction());
                        }
                    }
                    else
                    {
                        Main.videotheque.getListClient().set(i, new Occasionnel(identifiant, nom, prenom, listeCommande));
                        Occasionnel clientOccasionnel = (Occasionnel) Main.videotheque.getListClient().get(i);

                        for (Commande commande : client.getListeCommande())
                        {
                            commande.setReduction(clientOccasionnel.getReduction());
                        }
                    }
                    break;
                }
            }
            this.init();
        }
    }
}
