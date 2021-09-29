public class BoissonNonAlcoolisée extends Boisson {
		
		
	private float DegSucre;

	public BoissonNonAlcoolisée(String nom, float contenance, float prix, float degSucre) {
		super(nom, contenance, prix);
		DegSucre = degSucre;
	}

	public float getDegSucre() {
		return DegSucre;
	}
	/*public void afficherStock() {
		System.out.println(this.getDegSucre());
	}*/

	@Override
	public String toString() {
		return "[BoissonNonAlcoolisée]" + super.toString() + ". Cette boisson contient " + DegSucre + " degrés de sucre.";
	}
	
	public String toStringDispo() {
		return "[BoissonNonAlcoolisée]" + super.toStringDispo() + ". Cette boisson contient " + DegSucre + " degrés de sucre.";
	}
	

}
