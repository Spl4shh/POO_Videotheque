package graphic;

import javax.swing.*;
import java.awt.*;



public class PanelAjouterClient extends JPanel
{
    public JTextField textFieldNom, textFieldPrenom;
    public JLabel lblErreur, labelNom, labelPrenom, labelFidele;
    public JCheckBox checkFidele, checkOccasionnel;
    public JButton valider;

    public PanelAjouterClient()
    {
        this.setLayout(new GridLayout(0,2));

        labelNom = new JLabel("Veuillez saisir le nom");
        this.add(labelNom);

        textFieldNom = new JTextField(20);
        this.add(textFieldNom);


        labelPrenom = new JLabel("Veuillez saisir le prenom");
        this.add(labelPrenom);

        textFieldPrenom = new JTextField(20);
        this.add(textFieldPrenom);


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

        this.add(lblErreur = new JLabel("Merci de renseigner tout les champs"));
        lblErreur.setForeground(Color.RED);

    }
}
