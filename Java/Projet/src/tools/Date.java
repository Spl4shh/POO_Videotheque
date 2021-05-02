package tools;

public class Date 
{
	private int jour;
	private int mois;
	private int annee;

//Constructeur, getters et setters
	
		public Date(int jour, int mois, int annee) 
		{
			if(verif(jour, mois, annee))
			{
				this.jour = jour;
				this.mois = mois;
				this.annee = annee;	
			}
			else
			{
				System.out.println("Il y a une erreur");
			}
		}

		public int getJour() 
		{
			return jour;
		}

		public void setJour(int jour) 
		{
			this.jour = jour;
		}

		public int getMois() 
		{
			return mois;
		}

		public void setMois(int mois) 
		{
			this.mois = mois;
		}

		public int getAnnee() 
		{
			return annee;
		}

		public void setAnnee(int annee) 
		{
			this.annee = annee;
		}


//--------------------------------Fonction particuliere
		
		public String toString() 
		{
			return (this.jour + "/" + this.mois + "/" + this.annee);
		}

		public boolean equals(Object obj) 
		{
			boolean res = false;
			if (obj instanceof Date)
			{
				Date other = (Date) obj;
				if ((this.annee == other.annee) && (this.jour == other.jour) && (this.mois == other.mois))
				{
					res = true;
				}
			}
			return res;			
		}
		
		
		public int nbJours()	//Fonction qui renvoi un nombre de jours pour la date
		{
			return (int)((1461 * (this.annee + 4800 + (this.mois - 14) / 12)) / 4 + 
					(367 * (this.mois - 2 - 12 * ((this.mois - 14) / 12))) / 12 - 
					(3 * ((this.annee + 4900 + (this.mois - 14) / 12) / 100)) / 4 + this.jour - 32075);
		}
		
		public static boolean verif(int jour, int mois, int annee)
		{
			boolean res = false;
			if(jour >= 1 && jour <= 31)
				if(mois >= 1 && mois <= 12)
					if(annee >= 0)
					{
						switch(mois)
						{
						case 1, 3, 5, 7, 8, 10, 12 : 
							res = true;
						
						case 4, 6, 9, 11 : 
							if(jour >= 1 && jour <= 30)
							{
								res = true;
							}
						
						case 2 :
							if(((annee % 4 == 0) && (annee % 100 != 0)) || (annee % 400 == 0))
							{
								if(jour >= 1 && jour <= 28)
								{
									res = true;
								}
							}
							else
							{
								if(jour >= 1 && jour <= 27)
								{
									res = true;
								}
							}
						}
						
					}
			return res;
		}
}