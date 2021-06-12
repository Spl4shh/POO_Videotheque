package graphic;

import ecouteur.EcouteurAjouterClient;
import videotheque.Videotheque;

import javax.swing.*;
import java.awt.*;



public class PanelAjouterClient extends JPanel
{
    public JTextField textFieldNom, textFieldPrenom, textFieldId;
    public JLabel lblErreur, labelNom, labelPrenom, labelFidele, labelId;
    public JCheckBox checkFidele, checkOccasionnel;
    public JButton valider;


    public PanelAjouterClient()
    {
        this.setLayout(new GridLayout(0,2));

        labelNom = new JLabel("Veuillez saisir le nom :");
        this.add(labelNom);

        textFieldNom = new JTextField(20);
        this.add(textFieldNom);


        labelPrenom = new JLabel("Veuillez saisir le prenom :");
        this.add(labelPrenom);

        textFieldPrenom = new JTextField(20);
        this.add(textFieldPrenom);

        labelId = new JLabel("(auto) Identifiant :");
        this.add(labelId);

        textFieldId = new JTextField(20);
        textFieldId.setEnabled(false);
        this.add(textFieldId);


        this.add(new JLabel(""));
        this.add(new JLabel(""));


        labelFidele = new JLabel("Veuillez saisir le type d'utilisateur");
        this.add(labelFidele);


        checkFidele = new JCheckBox("Fidele");
        this.add(checkFidele);
        checkFidele.setSelected(true);
        checkFidele.addActionListener(new EcouteurAjouterClient(this));


        this.add(new JLabel(""));

        checkOccasionnel = new JCheckBox("Occasionnel");
        this.add(checkOccasionnel);
        checkOccasionnel.addActionListener(new EcouteurAjouterClient(this));

        this.add(new JLabel(""));
        this.add(new JLabel(""));

        valider = new JButton("Valider");
        this.add(valider);
        valider.addActionListener(new EcouteurAjouterClient(this));


        lblErreur = new JLabel("Veuillez verifier les informations saisies");
        lblErreur.setVisible(false);
        lblErreur.setForeground(Color.RED);
        this.add(lblErreur);
    }

    /**
     * Cette methode permet de nettoyer le panel.
     *
     * On vide les champs de saisie,
     * on rentreras l'ID juste au dessus de l'ID le plus haut enregistré,
     * on cachera le label d'erreur
     * et on initialiseras les checkBox sur Occasionnel
     */
    public void clear()
    {
        this.textFieldNom.setText("");
        this.textFieldPrenom.setText("");
        this.textFieldId.setText(String.valueOf(Videotheque.plusGrandIdClient()+1));
        this.checkFidele.setSelected(false);
        this.checkOccasionnel.setSelected(true);
        this.lblErreur.setVisible(false);
    }
}
