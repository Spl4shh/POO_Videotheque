package graphic;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PanelAccueil extends JPanel
{
    public JLabel titrePage;
    public Font fontTitre;

    public PanelAccueil()
    {
       this.setLayout(new GridLayout(0, 1));

        titrePage = new JLabel("Bienvenue  dans  l'application de gestion de vidéotheque");

        Icon icon = new ImageIcon(String.valueOf(new File(".\\.\\Image\\Animated_Book.gif")));

        JLabel gif = new JLabel(icon);

        try
        {
            fontTitre = new Font (Font.createFont(Font.TRUETYPE_FONT,
                    new File(".\\.\\police\\Hello.ttf")).getFamily(), Font.BOLD, 50);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        titrePage.setFont(fontTitre);

        this.add(titrePage);
        this.add(gif);
    }
}
