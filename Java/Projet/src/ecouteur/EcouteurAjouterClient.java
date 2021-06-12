package ecouteur;

import client.Fidele;
import client.Occasionnel;
import graphic.PanelAjouterClient;
import main.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurAjouterClient implements ActionListener
{
    PanelAjouterClient panelAjouterClient;

    public EcouteurAjouterClient(PanelAjouterClient panelAjouterClient)
    {
        this.panelAjouterClient = panelAjouterClient;
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
//Client-------------------------------------------------------------
        //Inversion checkBox Ajouter----------------------------------------------
        if (panelAjouterClient.checkFidele == e.getSource())
        {
            panelAjouterClient.checkOccasionnel.setSelected(!panelAjouterClient.checkFidele.isSelected());
        }
        if (panelAjouterClient.checkOccasionnel == e.getSource())
        {
            panelAjouterClient.checkFidele.setSelected(!panelAjouterClient.checkOccasionnel .isSelected());
        }

        //Bouton Valider---------------------------------------------------
        if (panelAjouterClient.valider == e.getSource())
        {
            boolean clientExiste = false;
            for (int i = 0; i < Main.videotheque.getListClient().size(); i++)
            {
                if (Main.videotheque.getListClient().get(i).getIdentifiant().trim().equals(panelAjouterClient.textFieldId.getText().trim()))
                {
                    clientExiste = true;
                }
            }
            if (!panelAjouterClient.textFieldNom.getText().trim().isEmpty() &&
                    !panelAjouterClient.textFieldPrenom.getText().trim().isEmpty() &&
                !clientExiste)
            {
                String nom = panelAjouterClient.textFieldNom.getText().trim();
                String prenom = panelAjouterClient.textFieldPrenom.getText().trim();
                String identifiant = panelAjouterClient.textFieldId.getText().trim();
                boolean fidele = panelAjouterClient.checkFidele.isSelected();

                if (fidele)
                {
                    Main.videotheque.ajouterClient(new Fidele(identifiant, nom, prenom));
                }
                else
                {
                    Main.videotheque.ajouterClient(new Occasionnel(identifiant, nom, prenom));
                }
                panelAjouterClient.clear();
                JOptionPane.showMessageDialog(panelAjouterClient,"Client " + nom + " " + prenom + " ajouté");
            }
            else
            {
                panelAjouterClient.lblErreur.setVisible(true);
            }
        }
    }
}
