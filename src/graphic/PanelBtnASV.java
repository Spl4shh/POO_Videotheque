package graphic;


import javax.swing.*;

//Correspond au panel pour stocker les boutons Add Sub Voir
public class PanelBtnASV extends JPanel
{

    public JButton btnAdd, btnSupp, btnVoir;

    public PanelBtnASV()
    {
        btnAdd = new JButton("Ajouter");
        this.add(btnAdd);

        btnSupp = new JButton("Supprimer");
        this.add(btnSupp);

        btnVoir = new JButton("Voir la liste");
        this.add(btnVoir);
    }
}
