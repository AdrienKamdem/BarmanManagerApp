import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.*;




public class Patron implements Serializable {
	
	
	private static Map<String,Barman> barman;
	
	
	public Patron() {

	
	barman = new HashMap<String,Barman>();
	
	
	}	
	


	public static Map<String, Barman> getBarman() {
		return barman;
	}


	public static boolean ajouterBarman(Barman bar) {
		
		boolean bool = true;
		
		if (barman.containsKey(bar.getNomBarman())) {
				bool = false;
			}
		else {
			barman.put(bar.getNomBarman(),bar);
			return bool;
		}
		return bool;
	}
		
	public static boolean ajouterBarman(String id, String mdp) {
		Barman bar = new Barman(id,mdp);
		return ajouterBarman(bar);
	}
	
	
	public boolean supprimerBarman (Barman bar) {
		
		if(barman.containsKey(bar.getNomBarman())) {

			barman.remove(bar.getNomBarman());
			return true;
		}
		
		return false;
	}
	public boolean supprimerBarman(String nom) {
		
		if(barman.containsKey(nom)) {

			barman.remove(nom);
			return true;
		}
		
		return false;
	}
	
		
	public void afficherBarman() {
		
		
		Set<Map.Entry<String, Barman>> couples = barman.entrySet();
        Iterator<Map.Entry<String, Barman>> itCouples = couples.iterator();
        System.out.println("                   Voici votre équipe                ");
        System.out.println(" ______________________________________________________");
        System.out.println("|                                                      |");
        while (itCouples.hasNext()) {
            Map.Entry<String, Barman> couple = itCouples.next();
            System.out.println("   - [Barman] ----> " + couple.getKey() + " a pour mot de passe " + couple.getValue().getMdp());
           
        }
        
        System.out.println("|______________________________________________________|");
        System.out.println("");
		
	}
	
	public static String lireInfo(String messageInfo) {
		String infoLue;
		System.out.print(messageInfo + " : ");
		 Scanner s = new Scanner(System.in);
		 infoLue = s.nextLine();
		return infoLue;
	}
	
	public void ModifId(Patron pat) {
		
		String idModif=lireInfo("Indiquer l'identifiant du Barman dont vous souhaitez modifier l'identifiant");
		if(barman.containsKey(idModif)) {
			String id3 = lireInfo("Indiquer le nouveau identifiant");
			if(barman.containsKey(id3)) {
				System.out.println("");
				System.out.println("L'identifiant que vous souhaitez entrer est déjà pris, prenez-en un autre !");
				System.out.println("");
			}
			else {
				Barman bar = barman.get(idModif);
				barman.remove(idModif);
				barman.put(id3, bar);
				barman.get(id3).setNomBarman(id3);
				System.out.println("");	
				System.out.println("La modification de l'identifiant est maintenant sauvegardée :)");
				System.out.println("");	
			}	
		}
		else {
			System.out.println("");
			System.out.println("L'identifiant que vous venez d'entrer est inconnu de nos services");
			System.out.println("");
		}
	}
	
	public void ModifMdp(Patron pat) {
		
		String idModif=lireInfo("Indiquez l'identifiant du Barman dont vous souhaitez modifier l'identifiant");
		
		if(barman.containsKey(idModif)) {
			String mdp1 = lireInfo("Indiquez le nouveau mot de passe du Barman");
			Barman bar = barman.get(idModif);
			barman.remove(idModif);
			barman.put(idModif, bar);
			barman.get(idModif).setMdp(mdp1);
			System.out.println("");
			System.out.println("La modification du mot de passe est maintenant sauvegardée :)");
			System.out.println("");
		}
		else {
			System.out.println("");
			System.out.println("L'identifiant que vous venez d'entrer est inconnu de nos services");
			System.out.println("");
		}
	}

	
		
	
	
  	
   public static void sauvegarderMap(String nomFichier){
		
	    Map<String,Barman> barman = new HashMap<String,Barman>();
    	barman = getBarman();
    	int BUFSIZE=256;
    	 try {
    	       FileOutputStream fileOut = new FileOutputStream(nomFichier);
    	       ObjectOutputStream out = new ObjectOutputStream(fileOut);
    	       out.writeObject(barman);
    	       out.close();
      	       fileOut.close();
    	     
    	       
	           String inputFile = nomFichier;
	           FileInputStream in = new FileInputStream(inputFile);
	           FileChannel ch = in.getChannel();
	           ByteBuffer buf = ByteBuffer.allocateDirect(BUFSIZE);  // BUFSIZE = 256

	           Charset cs = Charset.forName("ASCII"); // Or whatever encoding you want

	           // read the file into a buffer, 256 bytes at a time 
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

	
  	public static void chargerMap(String nomFichier) {
  		
		
  		Map<String,Barman> barman = new HashMap<String,Barman>();
    	 try {
    	       FileInputStream fileIn = new FileInputStream(nomFichier);
    	       ObjectInputStream in = new ObjectInputStream(fileIn);
    	       barman = (Map<String, Barman>) in.readObject();
    	       for (Map.Entry m : barman.entrySet()) {
    	    	   ajouterBarman(m.getKey().toString(), m.getValue().toString());
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
	             return;
	         }
    	 
	}
  	
  	
}
