package graphic;

import main.Main;

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
        this.checkFidele.setSelected(true);

        this.add(new JLabel(""));

        checkOccasionnel = new JCheckBox("Occasionel");
        this.add(checkOccasionnel);

        this.add(new JLabel(""));
        this.add(new JLabel(""));

        valider = new JButton("Valider");
        this.add(valider, "South");

        lblErreur = new JLabel("Veuillez verifier les informations saisie");
        lblErreur.setVisible(false);
        lblErreur.setForeground(Color.RED);
        this.add(lblErreur);
    }

    public void clear()
    {
        this.textFieldNom.setText("");
        this.textFieldPrenom.setText("");
        this.textFieldId.setText(String.valueOf(Main.grandIdClientActuel()+1));
        this.checkFidele.setSelected(false);
        this.checkOccasionnel.setSelected(true);
        this.lblErreur.setVisible(false);
    }
}
