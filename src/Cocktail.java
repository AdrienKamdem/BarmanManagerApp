import java.util.*;

public class Cocktail extends BoissonMere {
	
	
	
	private List<Boisson> Boisson = new ArrayList<Boisson>();
	private List<Float> Cont = new ArrayList<Float>();
	
	public Cocktail() {
		super();
		Boisson = new ArrayList<Boisson>();
		Cont = new ArrayList<Float>();
	}
	
	public Cocktail(String nom, float contenance, float prix, List<Boisson> boisson, List<Float> cont) {
		super(nom, contenance, prix);
		Boisson = boisson;
		Cont = cont;
	}
	
	

	public List<Float> getCont() {
		return Cont;
	}

	public List<Boisson> getBoisson() {
		return Boisson;
	}
	
	@Override
	public String toString() {
		String str="";
		for(int i=0; i<Boisson.size();i++) {
			str=str + "\n" + "                        * " + Boisson.get(i).getNom() + " avec " + Cont.get(i)+ " dose(s) ";
		}
		return "[Cocktail]" + super.toString() + " et contient :" + str;
	}
	public String toStringC() {
		String str="";
		float degAl=0;
		float degSu=0;
		float alcool=0;
		float sucre=0;
		float cont=0;
		for(int i=0; i<Boisson.size();i++) {
			if(Boisson.get(i) instanceof BoissonAlcoolisée) {
				BoissonAlcoolisée b = (BoissonAlcoolisée) Boisson.get(i); 
				alcool+=b.getDegAlcool()*Cont.get(i)*5;
				cont+=Cont.get(i)*5;
			}
			if(Boisson.get(i) instanceof BoissonNonAlcoolisée) {
				BoissonNonAlcoolisée b = (BoissonNonAlcoolisée) Boisson.get(i); 
				sucre+=b.getDegSucre()*Cont.get(i)*5;
				cont+=Cont.get(i)*5;
			}
			str=str + "\n" + "                        * " + Boisson.get(i).getNom() + " avec " + Cont.get(i)+ " dose(s) ";
		}
		degAl=alcool/cont;
		degSu=sucre/cont;
		return "[Cocktail]" + super.toStringC() + " et contient :" + str + "\n" + "                Son degré d'alcool est de " + degAl +"° et son degré de sucre est de " +degSu+"°"+"\n";
	}
	
	public String toStringDispo() {
		String str="";
		Boolean bool=true;
		float degAl=0;
		float degSu=0;
		float alcool=0;
		float sucre=0;
		float cont=0;
		for(int i=0; i<Boisson.size();i++) {
			if(Boisson.get(i).getContenance()>=Cont.get(i)) {
				if(Boisson.get(i) instanceof BoissonAlcoolisée) {
					BoissonAlcoolisée b = (BoissonAlcoolisée) Boisson.get(i); 
					alcool+=b.getDegAlcool()*Cont.get(i)*5;
					cont+=Cont.get(i)*5;
				}
				if(Boisson.get(i) instanceof BoissonNonAlcoolisée) {
					BoissonNonAlcoolisée b = (BoissonNonAlcoolisée) Boisson.get(i); 
					sucre+=b.getDegSucre()*Cont.get(i)*5;
					cont+=Cont.get(i)*5;
				}
				str=str + "\n" + "                        * " + Boisson.get(i).getNom() + " avec " + Cont.get(i)+ " dose(s) ";
			}
			else {
				bool=false;
			}
		}
		degAl=alcool/cont;
		degSu=sucre/cont;
		if(bool) {
			return "[Cocktail]" + super.toStringC() + " et contient :" + str + "\n" + "                Son degré d'alcool est de " + degAl +"° et son degré de sucre est de " +degSu+"°"+"\n";
		}
		else {
			return "";
		}
		
		
	}
	
}
