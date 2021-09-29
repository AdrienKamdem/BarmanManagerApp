public class BoissonAlcoolisée extends Boisson {
		
		private float DegAlcool;

		public BoissonAlcoolisée(String nom, float contenance, float prix, float degAlcool) {
			super(nom, contenance, prix);
			DegAlcool = degAlcool;
		}

		public float getDegAlcool() {
			return DegAlcool;
		}
		
		/*public void afficherStock() {
			System.out.println(this.getDegAlcool());
		}*/

		@Override
		public String toString() {
			return "[BoissonAlcoolisée]" + super.toString() + ". Cette boisson contient " + DegAlcool + " degrés d'alcool.";
		}
		public String toStringDispo() {
			return "[BoissonAlcoolisée]" + super.toStringDispo() + ". Cette boisson contient " + DegAlcool + " degrés d'alcool.";
		}
		
}
