// Auteurs : Julien Cardinal, Paul Sasu

public class Commande {
	private String nom;
	private Plat plat;
	private int quant;

	public Commande( String nom, Plat plat, int quant ) {
		this.nom = nom;
		this.plat = plat;
		this.quant = quant;
	}

	public String getNom() {
		return nom;
	}

	public int getQuant() {
		return quant;
	}

	public Plat getPlat() {
		return plat;
	}

}
