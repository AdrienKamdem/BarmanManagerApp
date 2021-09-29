import java.io.Serializable;

public class BoissonMere implements Serializable {

		
		protected String Nom;
		protected float Contenance;
		protected float Prix;
		
		
		public BoissonMere(String nom, float contenance, float prix) {
			super();
			Nom = nom;
			Contenance = contenance;
			Prix = prix;
		}


		public BoissonMere() {
			// TODO Auto-generated constructor stub
		}


		public String getNom() {
			return Nom;
		}


		public float getContenance() {
			return Contenance;
		}


		public float getPrix() {
			return Prix;
		}


		public void setContenanceAjout(float contenance) {
			Contenance = contenance+Contenance;
		}
		
		public boolean setContenanceAjuster(float contenance) {
			boolean bool;
			if(Contenance-contenance>=0) {
				Contenance = Contenance-contenance;
				bool=true;
			}
			else {
				System.out.println("");
				System.out.println("Le stock n'est pas suffisant");
				
				bool=false;
			}
			return bool;
		}
		
		
		@Override
		public String toString() {
			return " ---> Pour [" + Nom + "] il nous reste " + Contenance + " dose(s) de 5 cl à un prix de " + Prix + " € l'unité";
		}
		
		public String toStringC() {
			return " ---> Pour [" + Nom + "] il a une contenance de " + Contenance + " dose(s), une dose correspond à 5 cl et il a un prix de " + Prix + " € l'unité";
		}
		public String toStringDispo() {
			return " ---> Pour [" + Nom + "] le prix est de " + Prix + " € pour une dose de 5 cl";
		}
	
		
}
