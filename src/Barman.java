import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.*;

public class Barman implements Serializable {
	
	private String NomBarman;
	private String Mdp;
	private static List<Commande> Commande= new ArrayList<Commande>();
	protected List<BoissonMere> BoissonMere= new ArrayList<BoissonMere>();
	
	
	public Barman() {
		Commande= new ArrayList<Commande>();
		BoissonMere= new ArrayList<BoissonMere>();
	}
		
	public Barman(String nomBarman, List<Commande> commande, List<BoissonMere> boissonMere) {
		super();
		NomBarman = nomBarman;
		Commande = commande;
		BoissonMere = boissonMere;
	}
	
	
	
	public Barman(String nomBarman, String mdp) {
		super();
		NomBarman = nomBarman;
		Mdp = mdp;
	}
	
	

	public void setNomBarman(String nomBarman) {
		NomBarman = nomBarman;
	}

	public void setMdp(String mdp) {
		Mdp = mdp;
	}

	public String getMdp() {
		return Mdp;
	}

	public String getNomBarman() {
		return NomBarman;
	}


	public List<Commande> getCommande() {
		return Commande;
	}

	public List<BoissonMere> getBoissonMere() {
		return BoissonMere;
	}
	
	public boolean ajouterBoissonMere(BoissonMere boiM) {
		
		boolean bool = true;
		if (BoissonMere.contains(boiM.getNom())) {
			bool = false;
		}
		else {
			bool=BoissonMere.add(boiM);
			
		}
		return bool;
	}
	
	public void sauvegarderBoissonMere(String nomFichier){
		
	    List<BoissonMere> str = new ArrayList<BoissonMere>(); 
    	str = getBoissonMere();
    	int BUFSIZE=256;
    	 try {
    	       FileOutputStream fileOut = new FileOutputStream(nomFichier);
    	       ObjectOutputStream out = new ObjectOutputStream(fileOut);
    	       out.writeObject(str);
    	       out.close();
      	       fileOut.close();
    	     
    	       
	           String inputFile = nomFichier;
	           FileInputStream in = new FileInputStream(inputFile);
	           FileChannel ch = in.getChannel();
	           ByteBuffer buf = ByteBuffer.allocateDirect(BUFSIZE);

	           Charset cs = Charset.forName("ASCII"); 

	           int rd;
	           while ( (rd = ch.read( buf )) != -1 ) {
	               buf.rewind();
	               CharBuffer chbuf = cs.decode(buf);
	               buf.clear();
	           }
	     
    	       
    	 }
    	      catch (IOException e) {
    	       e.printStackTrace();
    	     }
    	  }
	
	public ArrayList<BoissonMere> chargerBoissonMere(String nomFichier) {
  		
		
  		ArrayList<BoissonMere> str = new ArrayList<BoissonMere>(); 
    	 try {
    	       FileInputStream fileIn = new FileInputStream(nomFichier);
    	       ObjectInputStream in = new ObjectInputStream(fileIn);
    	       str = (ArrayList) in.readObject();
    	       for (BoissonMere s : str) {
    	    	   BoissonMere.add(s);
   			   }	
    	       in.close();
    	       fileIn.close();
    	 
    	     } catch (IOException e) {
    	       e.printStackTrace();
    	     }
	    	 catch (ClassNotFoundException c) 
	         {
	             System.out.println("Erreur de chargement :/ ");
	             c.printStackTrace();
	         }
    	 return str;
	}

	
	public void sauvegarderCommande(String nomFichier){
		
		List<Commande> str = new ArrayList<Commande>(); 
    	str = getCommande();
    	int BUFSIZE=256;
    	 try {
    	       FileOutputStream fileOut = new FileOutputStream(nomFichier);
    	       ObjectOutputStream out = new ObjectOutputStream(fileOut);
    	       out.writeObject(str);
    	       out.close();
      	       fileOut.close();
    	     
    	       
	           String inputFile = nomFichier;
	           FileInputStream in = new FileInputStream(inputFile);
	           FileChannel ch = in.getChannel();
	           ByteBuffer buf = ByteBuffer.allocateDirect(BUFSIZE);

	           Charset cs = Charset.forName("ASCII"); 

	           int rd;
	           while ( (rd = ch.read( buf )) != -1 ) {
	               buf.rewind();
	               CharBuffer chbuf = cs.decode(buf);
	               buf.clear();
	           }
    	       
    	 }
    	      catch (IOException e) {
    	       e.printStackTrace();
    	     }
    	  }
	
	public void chargerCommande(String nomFichier) {
  		
		
		List<Commande> str = new ArrayList<Commande>();
    	 try {
    	       FileInputStream fileIn = new FileInputStream(nomFichier);
    	       ObjectInputStream in = new ObjectInputStream(fileIn);
    	       str = (List<Commande>) in.readObject();
    	       for (Commande c : str) {
    	    	   ajouterCommande(c);
   			   }	
    	       in.close();
    	       fileIn.close();
    	 
    	     } catch (IOException e) {
    	       e.printStackTrace();
    	     }
	    	 catch (ClassNotFoundException c) 
	         {
	             System.out.println("Erreur de chargement :/ ");
	             c.printStackTrace();
	         }
	}
	/////////////////////////////////////
	//Ajout d'une boisson   alcoolisée
	////////////////////////////////////
	public boolean ajouterBoissonAlcoolisée(String nom, float contenance, float prix, float degAlcool){
		BoissonMere boiM = new BoissonAlcoolisée(nom,contenance,prix,degAlcool);
		return this.ajouterBoissonMere(boiM);
	}
	/////////////////////////////////////
	//Ajout d'une boisson  NON alcoolisée
	////////////////////////////////////
	
	public boolean ajouterBoissonNonAlcoolisée(String nom, float contenance, float prix, float degSucre){
		BoissonMere boiM = new BoissonNonAlcoolisée(nom,contenance,prix,degSucre);
		return this.ajouterBoissonMere(boiM);
	}
	/////////////////////////////////////
	//Ajout d'uncocktail
	////////////////////////////////////
	
	public boolean ajouterCocktail(String nom, float contenance, float prix,  List<Boisson> boisson,List<Float> cont){
		BoissonMere boiM = new Cocktail(nom,contenance,prix,boisson,cont);
		return this.ajouterBoissonMere(boiM);
	}

		
	public static boolean ajouterCommande(Commande com) {
		
		boolean bool = true;
		if (Commande.contains(com.getNumeroCommande())) {
			bool = false;
		}
		else {
			bool = Commande.add(com);
		}
		return bool;
	}

	public static boolean ajouterCommande(int i) {
		Commande bar = new Commande(i);
		return ajouterCommande(bar);
	}
	
	
	public boolean supprimerCommande(int i) {
		boolean bool=false;
		for(int j=0;j<Commande.size();j++) {
			if(Commande.get(j).getNumeroCommande()==i) {
				bool = Commande.remove(Commande.get(j));
				System.out.println("");
				System.out.println("La suppression s'est déroulée avec succès");
				System.out.println("");
			}
		}
		return bool;
	}
	
	public boolean ajouterCommande(Integer numeroCommande, List<Boisson> boisson, List<Cocktail> cocktail, List<Float> contb, List<Float> contc){
		Commande com = new Commande(numeroCommande,boisson,cocktail, contb, contc);
		return this.ajouterCommande(com);
	}
	
	public boolean supprimerBoissonMere(BoissonMere boiM) {
		
		boolean bool=BoissonMere.remove(boiM);
		System.out.println("");
		System.out.println("La suppression s'est déroulée avec succès");
		System.out.println("");
		return bool;
	}
	
	public boolean supprimerBoissonMere(String nom) {
		for(BoissonMere b : BoissonMere) {
			if(b.getNom().equals(nom)) {
				
				return supprimerBoissonMere(b);
			}
		}
		return false;
	}
	
	public String lireInfo(String messageInfo) {
		String infoLue;
		System.out.print(messageInfo + " : ");
		 Scanner s = new Scanner(System.in);
		 infoLue = s.nextLine();
		return infoLue;
	}
	
	public int saisieContenance() {
		
		int contenance = 0;
		boolean erreur;
		String lecture; 

		do {
			try {
				erreur = false;
				lecture = lireInfo("Indiquez le nombre de dose(s) que vous souhaitez ajouter");
				contenance = Integer.parseInt(lecture);
			} catch (NumberFormatException e) {
				
				erreur = true;
			}
		} while (erreur || contenance<0 );
		return contenance;
	}
	public int saisieContenanceSpe() {
		
		int contenance = 0;
		boolean erreur;
		String lecture; 

		do {
			try {
				erreur = false;
				lecture = lireInfo("Indiquez le nombre de cocktail(s) que vous souhaitez ajouter");
				contenance = Integer.parseInt(lecture);
			} catch (NumberFormatException e) {
				
				erreur = true;
			}
		} while (erreur || contenance<0 );
		return contenance;
	}
	
	public void ajouterStockBoisson() {
		System.out.println("Voici la liste de nos boissons et cocktails : ");
		System.out.println("");
		afficherStockB();
		String nom = lireInfo("Indiquez le nom de la boisson que vous souhaitez recharger");
		if(BoissonMere.contains(nom)) {
			System.out.println("Nous ne connaissons pas ce produit...");
		}
		else {
			for(int i=0; i<BoissonMere.size();i++) {
				BoissonMere boiM = BoissonMere.get(i);
				if(boiM.getNom().equals(nom)) {
					int c = saisieContenance();
					boiM.setContenanceAjout(c);
				}
			}
			System.out.println("");
			System.out.println("L'ajout de stock s'est correctement déroulé !");
			System.out.println("");
		}
		
	}
	
	public int ajusterStockBoisson(Boisson boi) {
		boolean bool;
		int c = saisieContenance();
		bool = boi.setContenanceAjuster(c);
		if(bool) {
			return c;
		}
		return 0;
	}
	
	public int ajusterStockCocktail(Cocktail c) {
		int cont = saisieContenanceSpe();
		boolean bool=true;
		
		for(int i=0; i<c.getBoisson().size();i++) {
			bool =c.getBoisson().get(i).setContenanceAjuster(c.getCont().get(i)*cont);
		    if(!bool) {
		    	break;
		    }
		}
	
		
		System.out.println("");
		return cont;
	}
	
	public void afficherStockAlcoolisée() {
		
		for (BoissonMere b : getBoissonMere()) {
			if(b.getClass().getSimpleName().equals("BoissonAlcoolisée")) {
				System.out.println(b.toString());
			}
			
		}
		System.out.println("");
	}
	
	public void afficherStock() {
		for (BoissonMere b : getBoissonMere()) {
			System.out.println(b.toString());
		}
		System.out.println("");
	}
	
	public void afficherStockB() {
		for (BoissonMere b : getBoissonMere()) {
			if(b.getClass().getSimpleName().equals("BoissonAlcoolisée")||b.getClass().getSimpleName().equals("BoissonNonAlcoolisée")) {
				System.out.println(b.toString());
			}
		}
		System.out.println("");
	}
	
	public void afficherStockNonAlcoolisée() {
		for (BoissonMere b : getBoissonMere()) {
			if(b.getClass().getSimpleName().equals("BoissonNonAlcoolisée")) {
				System.out.println(b.toString());
			}
			
		}
		System.out.println("");
	}
	
	public void afficherStockCocktail() {
		for (BoissonMere b : getBoissonMere()) {
			if(b.getClass().getSimpleName().equals("Cocktail")) {
				System.out.println(b.toStringC());
			}
			
		}
		System.out.println("");
	}
	
	public void afficherStockAlcooliséeDispo() {
		for (BoissonMere b : getBoissonMere()) {
			if(b.getClass().getSimpleName().equals("BoissonAlcoolisée") && b.getContenance()>0) {
				System.out.println(b.toStringDispo());
			}
		}
		System.out.println("");
	}
	
	public void afficherStockNonAlcooliséeDispo() {
		for (BoissonMere b : getBoissonMere()) {
			if(b.getClass().getSimpleName().equals("BoissonNonAlcoolisée") && b.getContenance()>0) {
				System.out.println(b.toStringDispo());
			}
		}
		System.out.println("");
	}
	
	public void afficherStockDispo() {
		for (BoissonMere b : getBoissonMere()) {
			if((b.getClass().getSimpleName().equals("BoissonNonAlcoolisée")||b.getClass().getSimpleName().equals("BoissonAlcoolisée"))  && b.getContenance()>0) {
				System.out.println(b.toStringDispo());
			}
			
		}
	}
	
	public boolean afficherStockCocktailDispo() {
		String str = "";
		Boolean boo=true;
		for (BoissonMere b : getBoissonMere()) {
			if(b.getClass().getSimpleName().equals("Cocktail")) {
				
				System.out.println(b.toStringDispo());
				str=b.toStringDispo();
			}
			
		}
		if(str.equals("")) {
			boo=false;
		}
		return boo;
	}
	
	public void afficherConseil() {
		System.out.println("Le cocktail du soir se nomme Mystère, c'est un cocktail non alcoolisée contenant une touche de gingembre et une note de griotte");
		System.out.println("Vous ne serez pas déçu, je vous l'assure !");
		System.out.println("");
	}
	
	public void afficherCocktVendus() {
		
		int cmpt=0;
		for (BoissonMere b : getBoissonMere()) {
			if(b.getClass().getSimpleName().equals("Cocktail")&&cmpt<3) {
				cmpt+=1;
					System.out.println(b.toString());
				
			}
		}
		System.out.println("");
	}
	
	public float facturation(int j) {
		float prix=0;
		for(int i=0;i<Commande.size();i++) {
			if(j == Commande.get(i).getNumeroCommande()) {
				if(!Commande.get(i).getBoisson().isEmpty()) {
					for(int z=0;z<Commande.get(i).getBoisson().size();z++) {
						prix+=Commande.get(i).getBoisson2(z).getPrix()*Commande.get(i).getContb(z);
						
					}
				}
				if(!Commande.get(i).getCocktail().isEmpty()) {
					for(int z=0;z<Commande.get(i).getCocktail().size();z++) {
						prix+=Commande.get(i).getCocktail2(z).getPrix()*Commande.get(i).getContc(z);
						
					}
				}
				
			}
		}
		System.out.println("");
		System.out.println("Le prix de la commande s'élève à : " + prix + "€");	
		return prix;
	}
	
	public void afficherCommande() {
		
		System.out.println("            Voici les commande(s) en attente           ");
        System.out.println(" ______________________________________________________");
        System.out.println("|                                                      |");
		for (Commande b : getCommande()) {
			System.out.println(b.toString());
		}
		System.out.println("|______________________________________________________|");
        System.out.println("");
	}
	
	
	@Override
	public String toString() {
		return Mdp;
	}
	public String toStringBar() {
		return "[Barman] ----> " + NomBarman + " a pour mot de passe " + Mdp;
	}
	
	
	
	
}
