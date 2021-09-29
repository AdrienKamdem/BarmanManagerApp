import java.io.Serializable;
import java.util.*;

public class Commande implements Serializable {
	
	private Integer NumeroCommande;
	private List<Boisson> Boisson;
	private List<Float> Contb;
	private List<Cocktail> Cocktail;
	private List<Float> Contc;
	
	
	public Commande() {
		
		Boisson = new ArrayList<Boisson>();;
		Cocktail = new ArrayList<Cocktail>();
		Contb = new ArrayList<Float>();
		Contc = new ArrayList<Float>();
	}
	public Commande(Integer numeroCommande, List<Boisson> boisson, List<Cocktail> cocktail,List<Float> contb, List<Float> contc) {
		super();
		NumeroCommande = numeroCommande;
		Boisson = boisson;
		Cocktail = cocktail;
		Contb=contb;
		Contc=contc;
	}
	
	public Commande(Integer numeroCommande) {
		super();
		NumeroCommande = numeroCommande;
	}
	
	public Integer getNumeroCommande() {
		return NumeroCommande;
	}

	public List<Boisson> getBoisson() {
		return Boisson;
	}
		
	public Float getContb(int z) {
		return Contb.get(z);
	}
	public Float getContc(int z) {
		return Contc.get(z);
	}
	public Boisson getBoisson2(int z) {
		return Boisson.get(z);
	}

	public List<Cocktail> getCocktail() {
		return Cocktail;
	}
	public Cocktail getCocktail2(int z) {
		return Cocktail.get(z);
	}
	@Override
	public String toString() {
		
		return "    - [Commande] ---> " + NumeroCommande;
	}
	
	
}
