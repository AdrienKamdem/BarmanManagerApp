import java.io.IOError;
import java.util.*;

public class Baman_manager {
	
	static Barman barm = new Barman();
	static Patron pat = new Patron();
	static Commande cmd = new Commande();
	static float tot=0;
	public static void main(String[] args) {
	
		int choix=-1; 
		pat.chargerMap("Info.txt");
		barm.chargerBoissonMere("BoissonMere.txt");
		barm.chargerCommande("Commandes.txt");
		try {
		while (choix!=0) {
			afficherMenu();
			choix = saisieChoix(0,3);	
			switch (choix){
				case 1 :   
					MenuClient();
					break;
				case 2 :
					MenuBarman();
					break;
				case 3 :
					MenuPatron();
					break;
				case 0:
					System.out.println("En espérant vous revoir très vite :) !");
					break;
			}
		}
		} catch (IOError e) {
			System.err.println("Erreur grave d'entrée/sortie, fin de l'application");
		} 
	}
	
	private static void afficherMenu() {
		
		System.out.println(" *************************************************");
		System.out.println("|           Bienvenue dans notre Bar              |");
		System.out.println(" *************************************************");
		System.out.println("| (1) Accéder à l'espace client :)                |");
		System.out.println("| (2) Connectez-vous à l'espace Barman            |");
		System.out.println("| (3) Connectez-vous à l'espace Patron            |");
		System.out.println("| (0) Souhaitez-vous déjà nous quitter ? :/       |");
		System.out.println(" *************************************************");
	}
	private static void afficherMenuClient() {
		
		System.out.println(" ************************************************************************");
		System.out.println("|                    Bienvenue dans l'espace Client                      |");
		System.out.println(" ************************************************************************");
		System.out.println("| (1) Venez voir ce que nous proposons comme rafraichissement            |");
		System.out.println("| (2) Laisser votre créativité nous surprendre                           |");
		System.out.println("| (3) Espace Commande(s)                                                 |");
		System.out.println("| (0) Souhaitez-vous revenir au menu précédent ?                         |");
		System.out.println(" ************************************************************************");
	}
	
	private static void afficherMenuBarman() {
		
		System.out.println(" ************************************************************************");
		System.out.println("|                     Bienvenue votre espace Barman                      |");
		System.out.println(" ************************************************************************");
		System.out.println("| (1) Accéder au stock disponible                                        |");
		System.out.println("| (2) Espace commande(s)                                                 |");
		System.out.println("| (3) Ajout/Suppression et création                                                  |");
		System.out.println("| (0) Souhaitez-vous revenir au menu précédent ?                         |");
		System.out.println(" ************************************************************************");
	}
	
	private static void afficherMenuPatron() {
		
		System.out.println(" ************************************************************************");
		System.out.println("|                    Bienvenue votre espace Patron                       |");
		System.out.println(" ************************************************************************");
		System.out.println("| (1) Gestion de votre équipe                                            |");
		System.out.println("| (2) Modification des identifiants et des mots de passe                 |");
		System.out.println("| (3) Afficher la rémunération de la journée                             |");
		System.out.println("| (0) Souhaitez-vous revenir au menu précédent ?                         |");
		System.out.println(" ************************************************************************");
	}
	
	
	public static void MenuPatron() {
		
		if(verifpat()) {
			int choix=-1; 
		    
			try {
			while (choix!=0) {
				afficherMenuPatron();
				choix = saisieChoix(0,3);	
				switch (choix){
					case 1 :   
						MenuPatronGestion();
						break;
					case 2 :
						MenuPatronModif();
						break;
					case 3 :
						System.out.println("La recette journalière est de : " + tot + "€");
						System.out.println("");
						break;
					case 0:
						System.out.println("Vous revoilà au menu précédent !");
						System.out.println("");
						break;
				}
			}
			} catch (IOError e) {
				System.err.println("Erreur grave d'entrée/sortie, fin de l'application");
			} 
		}
		}
		
	
	public static void MenuPatronGestion() {
		
		int choix=-1; 
	    
		try {
		while (choix!=0) {
			afficherMenuPatronGestion();
			choix = saisieChoix(0,3);	
			switch (choix){
				case 1 :   
					ajouterBarman(pat);
					pat.sauvegarderMap("Info.txt");
					break;
				case 2 :
					supprimerBarman(pat);
					pat.sauvegarderMap("Info.txt");
					break;
				case 3 :
					pat.afficherBarman();
					break;
				case 0:
					System.out.println("Vous revoilà au menu précédent !");
					System.out.println("");
					break;
			}
		}
		} catch (IOError e) {
			System.err.println("Erreur grave d'entrée/sortie, fin de l'application");
		} 
	}
	public static void MenuPatronModif() {
		
		int choix=-1; 
	    
		try {
		while (choix!=0) {
			afficherMenuPatronModif();
			choix = saisieChoix(0,2);	
			switch (choix){
				case 1 :   
					pat.ModifId(pat);
					pat.sauvegarderMap("Info.txt");
					break;
				case 2 :
					pat.ModifMdp(pat);
					pat.sauvegarderMap("Info.txt");
					break;
				case 0:
					System.out.println("Vous revoilà au menu précédent !");
					System.out.println("");
					break;
			}
		}
		} catch (IOError e) {
			System.err.println("Erreur grave d'entrée/sortie, fin de l'application");
		} 
	}
	private static void afficherMenuPatronModif() {
		
		System.out.println(" ************************************************************************");
		System.out.println("|                    Bienvenue votre espace Patron                       |");
		System.out.println(" ************************************************************************");
		System.out.println("| (1) Modifier l'identifiant d'un Barman                                 |");
		System.out.println("| (2) Modifier le mot de passe d'un Barman ?                             |");
		System.out.println("| (0) Souhaitez-vous revenir au menu précédent ?                         |");
		System.out.println(" ************************************************************************");
	}
	private static void afficherMenuPatronGestion() {
		
		System.out.println(" ************************************************************************");
		System.out.println("|                     Espace Gestion des Barmans                         |");
		System.out.println(" ************************************************************************");
		System.out.println("| (1) Embaucher un nouveau barman                                           |");
		System.out.println("| (2) Renvoyer un barman                                                 |");
		System.out.println("| (3) Afficher votre équipe                                              |");
		System.out.println("| (0) Souhaitez-vous revenir au menu précédent ?                         |");
		System.out.println(" ************************************************************************");
	}
	public static void MenuClient() {
		
		int choix=-1; 
	    
		try {
		while (choix!=0) {
			afficherMenuClient();
			choix = saisieChoix(0,3);	
			switch (choix){
				case 1 :   
					MenuClientAffichage();
					break;
				case 2 :
					MenuClientCreation();
					break;
				case 3 :
					MenuClientCommande();
					break;
				case 0:
					System.out.println("Vous revoilà au menu précédent !");
					System.out.println("");
					break;
			}
		}
		} catch (IOError e) {
			System.err.println("Erreur grave d'entrée/sortie, fin de l'application");
		} 
	}
	
	private static void afficherMenuClientAffichage() {
		
		System.out.println(" ************************************************************************");
		System.out.println("|                      Voici nos différentes cartes                      |");
		System.out.println(" ************************************************************************");
		System.out.println("| (1) Afficher les boissons alcoolisées actuellement disponibles         |");
		System.out.println("| (2) Afficher les boissons non alcoolisées actuellement disponibles     |");
		System.out.println("| (3) Afficher les cocktails actuellement disponibles                    |");
		System.out.println("| (0) Souhaitez-vous revenir au menu précédent ?                         |");
		System.out.println(" ************************************************************************");
	}
	private static void afficherMenuClientCreation() {
		
		System.out.println(" ************************************************************************");
		System.out.println("|                 Vous voilà dans la nouveauté du moment :               |");
		System.out.println(" ************************************************************************");
		System.out.println("| (1) Créer votre propre cocktail avec le nom que vous souhaitez         |");
		System.out.println("| (2) Besoin d'un conseil ? Nous sommes là ne vous en faites pas         |");
		System.out.println("| (3) Voir le top 3 des cocktails les plus vendus                        |");
		System.out.println("| (0) Souhaitez-vous revenir au menu précédent ?                         |");
		System.out.println(" ************************************************************************");
	}
	
	private static void afficherMenuClientCommande() {
		
		System.out.println(" ************************************************************************");
		System.out.println("|                 Vous voilà dans le menu des commandes                  |");
		System.out.println(" ************************************************************************");
		System.out.println("| (1) Voir le nombre de commande en attente                              |");
		System.out.println("| (2) Passer une comande                                                 |");
		System.out.println("| (0) Souhaitez-vous revenir au menu précédent ?                         |");
		System.out.println(" ************************************************************************");
	}
	public static void MenuClientAffichage() {
		
		int choix=-1; 
	   
		try {
		while (choix!=0) {
			afficherMenuClientAffichage();
			choix = saisieChoix(0,3);	
			switch (choix){
				case 1 :   
					barm.afficherStockAlcooliséeDispo();
					break;
				case 2 :
					barm.afficherStockNonAlcooliséeDispo();
					break;
				case 3 :
					barm.afficherStockCocktailDispo();
					break;
				case 0:
					System.out.println("Vous revoilà au menu précédent !");
					System.out.println("");
					break;
			}
		}
		} catch (IOError e) {
			System.err.println("Erreur grave d'entrée/sortie, fin de l'application");
		} 
	}
	
	public static void MenuClientCreation() {
		
		int choix=-1; 
	    
		try {
		while (choix!=0) {
			afficherMenuClientCreation();
			choix = saisieChoix(0,3);	
			switch (choix){
				case 1 :   
					creerCocktail(barm);
					barm.sauvegarderBoissonMere("BoissonMere.txt");
					break;
				case 2 :
					barm.afficherConseil();
					break;
				case 3 :
					barm.afficherCocktVendus();
					break;
				case 0:
					System.out.println("Vous revoilà au menu précédent !");
					System.out.println("");
					break;
			}
		}
		} catch (IOError e) {
			System.err.println("Erreur grave d'entrée/sortie, fin de l'application");
		} 
	}
	
	public static void MenuClientCommande() {
		
		int choix=-1; 
	   
		try {
		while (choix!=0) {
			afficherMenuClientCommande();
			choix = saisieChoix(0,2);	
			switch (choix){
				case 1 :   
					System.out.println("Le nombre de commande en attente actuellement est de : " + barm.getCommande().size());
					System.out.println("Le temps d'attente est estimé à : " +barm.getCommande().size()*10 + " minute(s)");
					System.out.println("N'hésitez pas à consulter notre espace création :)");
					System.out.println("");
					break;
				case 2 :
					ajouterCommande(barm);
					barm.sauvegarderCommande("Commandes.txt");
					break;
				case 0:
					System.out.println("Vous revoilà au menu précédent !");
					System.out.println("");
					break;
			}
		}
		} catch (IOError e) {
			System.err.println("Erreur grave d'entrée/sortie, fin de l'application");
		} 
	}

	public static void MenuBarman() {
		if(verif()) {
			int choix=-1; 
		    
			try {
			while (choix!=0) {
				afficherMenuBarman();
				choix = saisieChoix(0,3);	
				switch (choix){
					case 1 :   
						MenuBarmanStock();
						break;
					case 2 :
						MenuBarmanCommande();
						break;
					case 3 :
						MenuBarmanCreation();
						break;
					case 0:
						System.out.println("Vous revoilà au menu précédent !");
						System.out.println("");
						break;
				}
			}
			} catch (IOError e) {
				System.err.println("Erreur grave d'entrée/sortie, fin de l'application");
			} 
		}
	}
		
	
	public static void MenuBarmanStock() {
		
		int choix=-1; 
	   
		try {
		while (choix!=0) {
			afficherMenuBarmanStock();
			choix = saisieChoix(0,3);	
			switch (choix){
				case 1 :   
					barm.afficherStockAlcoolisée();
					break;
				case 2 :
					barm.afficherStockNonAlcoolisée();
					break;
				case 3 :
					barm.afficherStockCocktail();
					break;
				case 0:
					System.out.println("Vous revoilà au menu précédent !");
					System.out.println("");
					break;
			}
		}
		} catch (IOError e) {
			System.err.println("Erreur grave d'entrée/sortie, fin de l'application");
		} 
	}
	
	public static void MenuBarmanCommande() {
		
		int choix=-1; 
		
		try {
		while (choix!=0) {
			afficherMenuBarmanCommande();
			choix = saisieChoix(0,3);	
			switch (choix){
				case 1 :   
					barm.afficherCommande();
					break;
				case 2 :
					barm.afficherCommande();
					int j=saisieNumeroCommandeF();
					tot+=barm.facturation(j);
					barm.supprimerCommande(j);
					barm.sauvegarderCommande("Commandes.txt");
					break;
				case 3 :
					int i = saisieNumeroCommandeAnnulation();
					barm.supprimerCommande(i);
					barm.sauvegarderCommande("Commandes.txt");
					break;
				case 0:
					System.out.println("Vous revoilà au menu précédent !");
					System.out.println("");
					break;
			}
		}
		} catch (IOError e) {
			System.err.println("Erreur grave d'entrée/sortie, fin de l'application");
		} 
	}
	
	public static void MenuBarmanCreation() {
		
		int choix=-1; 
	   
		try {
		while (choix!=0) {
			afficherMenuBarmanCreation();
			choix = saisieChoix(0,4);	
			switch (choix){
				case 1 :   
					creerCocktailB(barm);
					barm.sauvegarderBoissonMere("BoissonMere.txt");
					break;
				case 2 :
					MenuBarmanCreation2();
					break;
				case 3 :
					barm.ajouterStockBoisson();
					barm.sauvegarderBoissonMere("BoissonMere.txt");
					break;
				case 4 :
					barm.afficherStock();
					System.out.println("");
					String nom = lireInfo("Indiquer la boisson ou le cocktail que vous souhaitez supprimer");
					barm.supprimerBoissonMere(nom);
					barm.sauvegarderBoissonMere("BoissonMere.txt");
					break;
				case 0:
					System.out.println("Vous revoilà au menu précédent !");
					System.out.println("");
					break;
			}
		}
		} catch (IOError e) {
			System.err.println("Erreur grave d'entrée/sortie, fin de l'application");
		} 
	}
	
	public static void MenuBarmanCreation2() {
		
		int choix=-1; 
	   
		try {
		while (choix!=0) {
			afficherMenuBarmanCreation2();
			choix = saisieChoix(0,2);	
			switch (choix){
				case 1 :   
					ajouterBoissonAlcoolisée(barm);
					barm.sauvegarderBoissonMere("BoissonMere.txt");
					break;
				case 2 :
					ajouterBoissonNonAlcoolisée(barm);
					barm.sauvegarderBoissonMere("BoissonMere.txt");
					break;
				case 0:
					System.out.println("Vous revoilà au menu précédent !");
					System.out.println("");
					break;
			}
		}
		} catch (IOError e) {
			System.err.println("Erreur grave d'entrée/sortie, fin de l'application");
		} 
	}
	
	private static void afficherMenuBarmanStock() {
		
		System.out.println(" ************************************************************************");
		System.out.println("|                      Voici nos différentes cartes                      |");
		System.out.println(" ************************************************************************");
		System.out.println("| (1) Afficher les boissons alcoolisées                                  |");
		System.out.println("| (2) Afficher les boissons non alcoolisées                              |");
		System.out.println("| (3) Afficher les cocktails                                             |");
		System.out.println("| (0) Souhaitez-vous revenir au menu précédent ?                         |");
		System.out.println(" ************************************************************************");
	}
	private static void afficherMenuBarmanCommande() {
		
		System.out.println(" ************************************************************************");
		System.out.println("|                   Vous voilà dans l'espace commande                    |");
		System.out.println(" ************************************************************************");
		System.out.println("| (1) Afficher les commandes en attente                                  |");
		System.out.println("| (2) Facturer une commande                                              |");
		System.out.println("| (3) Annuler une commande                                               |");
		System.out.println("| (0) Souhaitez-vous revenir au menu précédent ?                         |");
		System.out.println(" ************************************************************************");
	}
	
	private static void afficherMenuBarmanCreation2() {
		
		System.out.println(" ************************************************************************");
		System.out.println("|                         Ajout des boissons                             |");
		System.out.println(" ************************************************************************");
		System.out.println("| (1) Ajouter une nouvelle Boisson Alcoolisée                            |");
		System.out.println("| (2) Ajouter une nouvelle Boisson non Alcoolisée                        |");
		System.out.println("| (0) Souhaitez-vous revenir au menu précédent ?                         |");
		System.out.println(" ************************************************************************");
	}
	///////////////////////////////////
	// Ajout d'une boisson  alcoolisée ( CF BARMAN )
	////////////////////////////////////
	// ( vient du menu )
	private static void ajouterBoissonAlcoolisée(Barman barman) {
		
		String Nom;
		float Contenance;
		float Prix;
		int degAlcool;
		boolean operationOK;
		
		Nom=lireInfo("Veuillez saisir le nom de la boisson alcoolisée que vous souhaitez ajouter");
		System.out.println("");
		Contenance=saisieContenanceAl();
		Prix=saisiePrix();
		degAlcool=saisieDegAlcool();
		operationOK= barman.ajouterBoissonAlcoolisée(Nom,Contenance,Prix,degAlcool);
		if (operationOK) {
			System.out.println("");
			System.out.println("L'ajout de la nouvelle boisson alcoolisée s'est déroulé avec succès ! ");
			System.out.println("");
		}
		else {
			System.out.println("");
			System.out.println("L'ajout de la nouvelle boisson alcoolisée n'a pas pu aboutir ! ");
			System.out.println("");
		}
	}
	private static void afficherMenuBarmanCreation() {
		
		System.out.println(" ************************************************************************");
		System.out.println("|              Vous voilà dans le menu création et gestion               |");
		System.out.println(" ************************************************************************");
		System.out.println("| (1) Créer un nouveau cocktail                                          |");
		System.out.println("| (2) Ajouter une nouvelle Boisson                                       |");
		System.out.println("| (3) Ajouter du stock                                                   |");
		System.out.println("| (4) Supprimer une boisson                                              |");
		System.out.println("| (0) Souhaitez-vous revenir au menu précédent ?                         |");
		System.out.println(" ************************************************************************");
	}

	///////////////////////////////////
	// Ajout d'une boisson  NON alcoolisée ( CF BARMAN )
	////////////////////////////////////
	// ( vient du menu )
	private static void ajouterBoissonNonAlcoolisée(Barman barman) {
		String Nom;
		int Contenance;
		float Prix;
		int degSucre;
		boolean operationOK;
		
		Nom=lireInfo("Veuillez saisir le nom de la boisson non alcoolisée que vous souhaitez ajouter");
		System.out.println("");
		Contenance=saisieContenanceNonAl();
		Prix=saisiePrix();
		degSucre=saisieDegSucre();
		operationOK= barman.ajouterBoissonNonAlcoolisée(Nom,Contenance,Prix,degSucre);
		if (operationOK) {
			System.out.println("");
			System.out.println("L'ajout de la nouvelle boisson non alcoolisée s'est déroulé avec succès ! ");
			System.out.println("");
		}
		else {
			System.out.println("");
			System.out.println("L'ajout de la nouvelle boisson non alcoolisée n'a pas pu aboutir ! ");
			System.out.println("");
		}
	}
	
	private static void ajouterBarman(Patron pat) {
		String Nom;
		String Mdp;
		boolean operationOK;
		
		Nom=lireInfo("Veuillez saisir l'identifiant du barman que vous souhaitez embaucher");
		Mdp=lireInfo("Veuillez saisir le mot de passe du barman que vous souhaitez embaucher");
		operationOK= pat.ajouterBarman(Nom,Mdp);
		if (operationOK) {
			System.out.println("");
			System.out.println("L'ajout du nouveau barman s'est déroulé avec succès ! ");
			System.out.println("");
		}
		else {
			System.out.println("");
			System.out.println("L'ajout du nouveau barman n'a pas pu aboutir ! ");
			System.out.println("");
		}
	}
	
	private static void supprimerBarman(Patron pat) {
		String Nom;
		boolean operationOK;
		Nom=lireInfo("Veuillez saisir l'identifiant du barman que vous souhaitez renvoyer");
		operationOK = pat.supprimerBarman(Nom);
		if(operationOK) {
			System.out.println("");
			System.out.println("C'était une bonne décision, il était mauvais de toute façon");
			System.out.println("");
		}
		else {
			System.out.println("");
			System.out.println("Il y a eu un problème lors du renvoi...");
			System.out.println("");
		}
		
	}

	
	/////////////////////////////////////
	// LIRE INFO vient de menu
	////////////////////////////////////
	
	public static String lireInfo(String messageInfo) {
		String infoLue;
		System.out.print(messageInfo + " : ");
		 Scanner s = new Scanner(System.in);
		 infoLue = s.nextLine();
		return infoLue;
	}
	/////////////////////////////////////
	// saisieContenance vient de menu
	////////////////////////////////////
	public static float saisieContenanceAl() {
		
		float contenance = 0;
		boolean erreur;
		String lecture; 

		do {
			try {
				erreur = false;
				lecture = lireInfo("Indiquer le nombre de dose(s) que vous souhaitez ajouter (une dose correspond à 5 cl)");
				contenance = Integer.parseInt(lecture);
			} catch (NumberFormatException e) {
				
				erreur = true;
			}
		} while (erreur || contenance<0 );
		return contenance;
	}
	public static int saisieContenanceNonAl() {
		
		int contenance = 0;
		boolean erreur;
		String lecture; 

		do {
			try {
				erreur = false;
				lecture = lireInfo("Indiquer le nombre de dose(s) que vous souhaitez ajouter (une dose correspond à 5 cl)");
				contenance = Integer.parseInt(lecture);
			} catch (NumberFormatException e) {
				
				erreur = true;
			}
		} while (erreur || contenance<0 );
		return contenance;
	}
	
	public static int saisieContenance() {
		
		int contenance = 0;
		boolean erreur;
		String lecture; 

		do {
			try {
				erreur = false;
				lecture = lireInfo("Indiquer le nombre de dose(s) que vous souhaitez ajouter (une dose correspond à 5 cl)");
				contenance = Integer.parseInt(lecture);
			} catch (NumberFormatException e) {
				
				erreur = true;
			}
		} while (erreur || contenance<0 );
		return contenance;
	}
	/////////////////////////////////////
	// saisiePrix vient de menu
	////////////////////////////////////
	private static float saisiePrix() {
		
		float prix = 0;
		boolean erreur;
		String lecture; 

		do {
			try {
				erreur = false;
				lecture = lireInfo("Indiquer le prix pour une dose de la nouvelle boisson");
				prix = Float.parseFloat(lecture);
			} catch (NumberFormatException e) {
				
				erreur = true;
			}
		} while (erreur || prix<0 );
		return prix;
	}
	/////////////////////////////////////
	// saisieDegAlcool vient de menu
	////////////////////////////////////
	private static int saisieDegAlcool() {
		
		int degAlcool = 0;
		boolean erreur;
		String lecture; 

		do {
			try {
				erreur = false;
				lecture = lireInfo("Indiquer le degré d'alcool par litre de la nouvelle boisson");
				degAlcool = Integer.parseInt(lecture);
			} catch (NumberFormatException e) {
				
				erreur = true;
			}
		} while (erreur || degAlcool<0 );
		return degAlcool;
	}
	
	private static int saisieChoix(int borneMin, int borneMax) {
		int choix = -1;
		boolean erreur;
		String lecture; 

		do {
			try {
				erreur = false;
				System.out.println("");
				lecture = lireInfo("Votre choix");
				System.out.println("");
				choix = Integer.parseInt(lecture);
			} catch (NumberFormatException e) {
				erreur = true;
			}
		} while (erreur || choix<borneMin || choix>borneMax);
		return choix;
	}
	/////////////////////////////////////
	//saisieDegSucre vient de menu
	////////////////////////////////////
	private static int saisieDegSucre() {
		
		int degSucre = 0;
		boolean erreur;
		String lecture; 

		do {
			try {
				erreur = false;
				lecture = lireInfo("Indiquer le degré de sucre par litre de la nouvelle boisson");
				degSucre = Integer.parseInt(lecture);
			} catch (NumberFormatException e) {
				erreur = true;
			}
		} while (erreur || degSucre<0 );
		return degSucre;
	}
	///////////////////////////////////
	// création d'un cocktail 
	////////////////////////////////////
	private static void creerCocktail(Barman barman) {
		String Nom;
		int Contenance=0;
		float Prix=0;
		String str="";
		boolean bool=true;
		List<Float> cont = new ArrayList<Float>();
		List<Boisson> Boissons = new ArrayList<Boisson>();
		boolean operationOK;
		
		Nom=lireInfo("Donner un nom amusant à votre cocktail :)");
		System.out.println("");
		System.out.println("Voici notre carte des Boissons");
		System.out.println("");
		barm.afficherStockDispo();
		System.out.println("");
		do
		{
			Boisson boi= rechercheBoisson(barman);
			if(boi.getNom().equals("")){
				bool=false;
				System.out.println("");
				System.out.println("Nous ne connaissons pas ce produit...");

			}
			else {
				Boissons.add(boi);
				float j =saisieContenance();
				cont.add(j);
				Contenance+=j;
				Prix+=boi.getPrix()*j;
				System.out.println("");
				str=lireInfo("Entrez (fin) si vous avez fini l'ajout de boisson, pour continuer appuyez sur entrée");
				
			}
			
		}while(!str.equals("fin")&& bool);
		
		Prix=(float) (Prix*1.1);
		if (bool){
			operationOK= barman.ajouterCocktail(Nom,Contenance,Prix,Boissons,cont);
			if (operationOK) {
				System.out.println("");
				System.out.println("L'ajout du cocktail s'est déroulé avec succès ! ");
				System.out.println("");
			}
			else {
				System.out.println("");
				System.out.println("L'ajout du cocktail n'a pas pu aboutir ! ");
				System.out.println("");
			}
		}
		else {
			System.out.println("");
			System.out.println("Impossible de créer le cocktail ! ");
			System.out.println("");
		}
	}
	
	private static void creerCocktailB(Barman barman) {
		String Nom;
		int Contenance=0;
		float Prix=0;
		
		boolean bool=true;
		String str="";
		List<Float> cont = new ArrayList<Float>();
		List<Boisson> Boissons = new ArrayList<Boisson>();
		boolean operationOK;
		
		Nom=lireInfo("Donner un nom amusant à votre cocktail :)");
		System.out.println("");
		System.out.println("Voici notre carte des Boissons : ");
		System.out.println("");
		barm.afficherStockB();
		
		do
		{
			Boisson boi= rechercheBoisson(barman);
			
			if(boi.getNom().equals("")){
				bool=false;
				System.out.println("");
				System.out.println("Nous ne connaissons pas ce produit...");

			}
			else {
				Boissons.add(boi);
				float j =saisieContenance();
				cont.add(j);
				Contenance+=j;
				Prix+=boi.getPrix()*j;
				System.out.println("");
				str=lireInfo("Entrez (fin) si vous avez fini l'ajout de boisson, pour continuer appuyez sur entrée");
			
			}
			
			
		} while(!str.equals("fin") && bool);
			
		
		Prix=(float) (Prix*1.1);
		if (bool){
			operationOK= barman.ajouterCocktail(Nom,Contenance,Prix,Boissons,cont);
			if (operationOK) {
				System.out.println("");
				System.out.println("L'ajout du cocktail s'est déroulé avec succès ! ");
				System.out.println("");
			}
			else {
				System.out.println("");
				System.out.println("L'ajout du cocktail n'a pas pu aboutir ! ");
				System.out.println("");
			}
		}
		else {
			System.out.println("");
			System.out.println("Impossible de créer le cocktail ! ");
			System.out.println("");
		}
	}
	///////////////////////////////////
	// PARTIE RECHERCHE BOISSON / COCKTAIL
	////////////////////////////////////
	
	///////////////////////////////////
	// RECHERCHE BOISSON 
	////////////////////////////////////
	public static Boisson rechercheBoisson(Barman barman) {
		String Nom=lireInfo("Indiquer le nom de la boisson que vous souhaitez ajouter");
		Boisson boisson = new Boisson("",0,0);
		if(barman.BoissonMere.contains(Nom)) {
			System.out.println("");
			System.out.println("Ce produit est inconnu de nos services...");
			System.out.println("");
		}
		else {
			for(BoissonMere boi : barman.BoissonMere) {
				if(Nom.equals(boi.getNom())) {
					boisson=(Boisson)boi;
				}
			}
		}
		return boisson;
	}
	///////////////////////////////////
	// RECHERCHE COCKTAIL
	////////////////////////////////////
	public static Cocktail rechercheCocktail(Barman barman) {
		String Nom=lireInfo("Indiquer le nom du cocktail de votre choix");
		ArrayList<Boisson> Boisson = new ArrayList<Boisson>();
		List<Float> cont = new ArrayList<Float>();
		Cocktail cocktail = new Cocktail("",0,0,Boisson,cont);
		if(barman.BoissonMere.contains(Nom)) {
			System.out.println("Ce produit est inconnu de nos services...");
		}
		else {
			for(BoissonMere boi : barman.BoissonMere) {
				if(Nom.equals(boi.getNom())) {
					cocktail=(Cocktail)boi;
				}
			}
		}
		
		return cocktail;
	}
	private static int saisieNumeroCommande() {
		
		int num = -1;
		boolean erreur;
		String lecture; 

		do {
			try {
				erreur = false;
				lecture = lireInfo("Donner nous le numéro de commande que vous souhaitez, votre chiffre porte bohneur par exemple :)");
				num = Integer.parseInt(lecture);
			} catch (NumberFormatException e) {
				erreur = true;
			}
		} while (erreur || num<0 );
		return num;
	}
	
	private static int saisieNumeroCommandeF() {
		
		int num = -1;
		boolean erreur;
		String lecture; 

		do {
			try {
				erreur = false;
				lecture = lireInfo("Donnez nous le numéro de commande que vous souhaitez facturer");
				num = Integer.parseInt(lecture);
			} catch (NumberFormatException e) {
				erreur = true;
			}
		} while (erreur || num<0 );
		return num;
	}
	
	private static int saisieNumeroCommandeAnnulation() {
		
		int num = -1;
		boolean erreur;
		String lecture; 

		do {
			try {
				erreur = false;
				lecture = lireInfo("Entrez le numéro de commande que vous souhaitez annuler");
				num = Integer.parseInt(lecture);
			} catch (NumberFormatException e) {
				erreur = true;
			}
		} while (erreur || num<0 );
		return num;
	}
	private static void ajouterCommande(Barman barman) {
		int NumeroCommande;
		boolean operationOK;
		String str1 = "";
		String str2 = "";
		boolean boo=true;
		List<Boisson> boi = new ArrayList<Boisson>();
		List<Float> contb = new ArrayList<Float>();
		List<Cocktail> cockt = new ArrayList<Cocktail>();
		List<Float> contc = new ArrayList<Float>();
		String choix = lireInfo("Voulez vous commander des boissons (oui/non)");
		if(choix.equals("oui")) {
			do {
				System.out.println("");
				barman.afficherStockDispo();
				System.out.println("");
				Boisson b = rechercheBoisson(barman);
				if(b.getNom().equals("")){
					System.out.println("");
					System.out.println("Nous ne connaissons pas ce produit...");

				}
				else {
					float j = barman.ajusterStockBoisson(b);
					if(j>=0) {
						boi.add(b);
						contb.add(j);
						str1=lireInfo("Entrez (fin) si vous avez fini l'ajout de boisson");
					}
					
				}
				
			} while (!str1.equals("fin"));
		}
		String choix1 = lireInfo("Voulez vous commander des cocktails (oui/non)");
		if(choix1.equals("oui")) {
			do {
				System.out.println("");
				boo=barman.afficherStockCocktailDispo();
				System.out.println("");
				
				if(boo) {
					Cocktail c = rechercheCocktail(barman);
					if(c.getNom().equals("")){
						System.out.println("");
						System.out.println("Nous ne connaissons pas ce produit...");
					}
					else {
						float j = barman.ajusterStockCocktail(c);
						if(j>=0) {
							cockt.add(c);
							contc.add(j);
							str2=lireInfo("Entrez (fin) si vous avez fini l'ajout de cocktail");
						}
					}
				
					
				}
				else {
					System.out.println("Désolé nous n'avons plus de cocktail à disposition");
					str2="fin";
				}
				
			} while (!str2.equals("fin"));
		}
		
		NumeroCommande=barm.getCommande().size();
		System.out.println("");
		if(boi.isEmpty()&&cockt.isEmpty()) {
			System.out.println("");
			System.out.println("Une erreur s'est produite. Veuillez repasser votre commande svp !");
			System.out.println("");
		}
		else {
			operationOK= barman.ajouterCommande(NumeroCommande,boi,cockt,contb,contc);
			if (operationOK) {
				System.out.println("");
				System.out.println("Votre commande a été prise en compte ! ");
				System.out.println("");
			}
			else {
				System.out.println("");
				System.out.println("Une erreur c'est produite. Veuillez repasser votre commande svp !");
				System.out.println("");
			}
		}
		
	}
	
	public static boolean verif() {
		
		String id;
		String mdp;
		int s=0;
		boolean boo=false;
		Map<String, Barman> barman = pat.getBarman();
		Set<String> cles = pat.getBarman().keySet();
		Collection<Barman> values = pat.getBarman().values();
	   
		
		System.out.println("Bienvenue dans l'espace dédié aux barmans ! ");
		System.out.println("");
		id=lireInfo("Veuillez entrer votre identifiant");
		System.out.println("");
		if (cles.contains(id)) {
			System.out.println("L'identifiant que vous avez saisi est correct :) ");
			System.out.println("");
			boo=true;
			mdp=lireInfo("Veuillez entrer votre mot de passe");
			System.out.println("");
			Barman bar = barman.get(id);
			if (mdp.equals(bar.getMdp())) {
				System.out.println("Le mot de passe que vous avez saisi est correct :) ");
				System.out.println("");
			}
			else {
				System.out.println("Le mot de passe que vous avez saisi est incorrect veuillez réessayer :/ ");
				System.out.println("");
				boo=false;
				
			}
		}
		else {
			System.out.println("L'identifiant que vous avez saisi est inconnu de nos services :/ ");
			System.out.println("");
		}
		return boo;
	}
	public static boolean verifpat() {
		
		String id;
		String mdp;
		boolean boo=false;
		System.out.println("Bienvenue dans l'espace dédié au patron : ");
		System.out.println("");
		id=lireInfo("Veuillez entrer votre identifiant (NathanW)");
		if (id.equals("NathanW")) {
			System.out.println("L'identifiant que vous avez saisi est correct :) ");
			System.out.println("");
			boo=true;
		}
		else {
			System.out.println("L'identifiant que vous avez saisi est inconnu de nos services :/ ");
			System.out.println("");
		}
		mdp=lireInfo("Veuillez entrer votre mot de passe (Nathan)");
			if (mdp.equals("Nathan")) {
				System.out.println("Le mot de passe que vous avez saisi est correct :) ");
				System.out.println("");
			}
			else {
				System.out.println("Le mot de passe que vous avez saisi est incorrect veuillez réessayer :/ ");
				System.out.println("");
				boo=false;
			}
		return boo;
		}
}
