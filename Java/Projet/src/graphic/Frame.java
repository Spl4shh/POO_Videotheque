package graphic;

import ecouteur.EcouteurMenuBarre;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame
{
	public PanelPrincipal panelPrincipal;
	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public JMenuBar barreMenu;
	public JMenu accueilMenu, clientMenu, commandeMenu, stockMenu, rechercherMenu, optionMenu;
	public JMenuItem ajouterClientItem, supprimerClientItem, modifierClientItem,
					 ajouterCommandeItem, supprimerCommandeItem, modifierCommandeItem,
					 ajouterStockItem, supprimerStockItem, modifierStockItem,
					 rechercherClientItem, rechercherCommandeItem, rechercherStockItem,
					 accueilMenuItem, optionThemeItem;

	public Frame()
	{
		this.setTitle("Gestion d'une Videotheque");
		this.setSize(1080, 600);
		//this.setResizable(false);
		this.setLocation((int)screenSize.getWidth()/2 - this.getWidth()/2, (int)screenSize.getHeight()/2 - this.getHeight()/2);

		this.setLayout(new BorderLayout());

		panelPrincipal = new PanelPrincipal();
		this.add(panelPrincipal);


		//Barre en haut de l'ecran pour naviguer
		//Sous forme de methode car trop grand a mon gout
		this.creationMenuBarre();

		this.add(barreMenu, "North");

		this.gestionTheme(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}

	public void gestionTheme(boolean themeSombre)
	{
		Color couleurBarre;
		Color couleurTexte;
		Color couleurFondPanel;
		Color couleurPanelValeur;
		String dossierTheme;

		if (themeSombre)
		{
			couleurBarre = Color.DARK_GRAY;
			couleurTexte = new Color(215,216,245);
			couleurFondPanel = Color.DARK_GRAY.darker();
			couleurPanelValeur = Color.DARK_GRAY;
			dossierTheme = "theme_sombre";
		}
		else
		{
			couleurBarre = new Color(215,216,245);
			couleurTexte = Color.BLACK;
			couleurFondPanel = new Color(229,233,250);
			couleurPanelValeur = new Color(215,216,245);
			dossierTheme = "theme_clair";
		}

		//Barre de menu
		this.barreMenu.setBackground(couleurBarre);
		for (int i = 0; i < this.barreMenu.getMenuCount(); i++)
		{
			JMenu menu = this.barreMenu.getMenu(i);
			menu.setForeground(couleurTexte);

			for (int j = 0; j < menu.getItemCount(); j++)
			{
				JMenuItem item = menu.getItem(j);

				item.setBackground(couleurBarre);
				item.setForeground(couleurTexte);

			}
		}
		//Icone
		this.accueilMenu.setIcon(new ImageIcon(".\\.\\Image\\" + dossierTheme + "\\home_small.png"));
		this.clientMenu.setIcon(new ImageIcon(".\\.\\Image\\" + dossierTheme + "\\user_small.png"));
		this.commandeMenu.setIcon(new ImageIcon(".\\.\\Image\\" + dossierTheme + "\\copy_small.png"));
		this.stockMenu.setIcon(new ImageIcon(".\\.\\Image\\" + dossierTheme + "\\increasing-stocks_small.png"));
		this.rechercherMenu.setIcon(new ImageIcon(".\\.\\Image\\" + dossierTheme + "\\search_small.png"));
		this.optionMenu.setIcon(new ImageIcon(".\\.\\Image\\" + dossierTheme + "\\settings_small.png"));


		this.setBackground(couleurFondPanel);
		this.panelPrincipal.modifierCouleur(couleurTexte, couleurFondPanel, couleurPanelValeur);

		//Page Client
		this.panelPrincipal.panelClient.modifierCouleur(couleurTexte, couleurFondPanel, couleurPanelValeur);

		//Page Commande
		this.panelPrincipal.panelCommande.modifierCouleur(couleurTexte, couleurFondPanel, couleurPanelValeur);

		//Page Stock
		this.panelPrincipal.panelStock.modifierCouleur(couleurTexte, couleurFondPanel, couleurPanelValeur);

		//Page Rechercher
		this.panelPrincipal.panelRechercher.modifierCouleur(couleurTexte, couleurFondPanel, couleurPanelValeur);
	}

	/**
	 * Cette methode permet de creer la barre de naviguation.
	 *
	 * On creer les differents items et ajoute les logos,
	 * on applique egalement un actionListener
	 */
	public void creationMenuBarre()
	{
		barreMenu = new JMenuBar();

		//Accueil
		accueilMenu = new JMenu("Accueil");
		accueilMenu.setIcon(new ImageIcon(".\\.\\Image\\theme_clair\\home_small.png"));

		accueilMenuItem = new JMenuItem("Retourner à l'accueil");

		accueilMenu.add(accueilMenuItem);

		barreMenu.add(accueilMenu);

		//Client
		clientMenu = new JMenu("Client");
		clientMenu.setIcon(new ImageIcon(".\\.\\Image\\theme_clair\\user_small.png"));

		ajouterClientItem = new JMenuItem("Ajouter");
		supprimerClientItem = new JMenuItem("Supprimer");
		modifierClientItem = new JMenuItem("Modifier");

		clientMenu.add(ajouterClientItem);
		clientMenu.add(supprimerClientItem);
		clientMenu.add(modifierClientItem);

		barreMenu.add(clientMenu);

		//Commande
		commandeMenu = new JMenu("Commande");
		commandeMenu.setIcon(new ImageIcon(".\\.\\Image\\theme_clair\\copy_small.png"));

		ajouterCommandeItem = new JMenuItem("Ajouter");
		supprimerCommandeItem = new JMenuItem("Supprimer");
		modifierCommandeItem = new JMenuItem("Modifier");

		commandeMenu.add(ajouterCommandeItem);
		commandeMenu.add(supprimerCommandeItem);
		commandeMenu.add(modifierCommandeItem);

		barreMenu.add(commandeMenu);

		//Stock
		stockMenu = new JMenu("Stock");
		stockMenu.setIcon(new ImageIcon(".\\.\\Image\\theme_clair\\increasing-stocks_small.png"));

		ajouterStockItem = new JMenuItem("Ajouter");
		supprimerStockItem = new JMenuItem("Supprimer");
		modifierStockItem = new JMenuItem("Modifier");

		stockMenu.add(ajouterStockItem);
		stockMenu.add(supprimerStockItem);
		stockMenu.add(modifierStockItem);

		barreMenu.add(stockMenu);

		//Rechercher
		rechercherMenu = new JMenu("Rechercher");
		rechercherMenu.setIcon(new ImageIcon(".\\.\\Image\\theme_clair\\search_small.png"));

		rechercherClientItem = new JMenuItem("Client");
		rechercherCommandeItem = new JMenuItem("Commande");
		rechercherStockItem = new JMenuItem("Stock");

		rechercherMenu.add(rechercherClientItem);
		rechercherMenu.add(rechercherCommandeItem);
		rechercherMenu.add(rechercherStockItem);

		barreMenu.add(rechercherMenu);

		optionMenu = new JMenu("Option");
		optionMenu.setIcon(new ImageIcon(".\\.\\Image\\theme_clair\\settings_small.png"));

		optionThemeItem = new JMenuItem("Changer thême");

		optionMenu.add(optionThemeItem);

		barreMenu.add(optionMenu);

		for (int i = 0; i < this.barreMenu.getMenuCount(); i++)
		{
			JMenu menu = this.barreMenu.getMenu(i);

			for (int j = 0; j < menu.getItemCount(); j++)
			{
				JMenuItem item = menu.getItem(j);

				item.addActionListener(new EcouteurMenuBarre(this));
			}
		}
	}
}
