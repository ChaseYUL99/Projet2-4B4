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
	
	@Override
	public boolean equals( Object autreObjet ) {
		
		boolean egalite = false;
		
		if ( this == autreObjet ) {
			
			egalite = true;
			
		} else if ( autreObjet != null ) {
			
			if ( autreObjet instanceof Commande ) {
				
				Commande autreCommande = (Commande) autreObjet;
				
				if ( this.getNom().equalsIgnoreCase( autreCommande.getNom() ) ) {
					
					egalite = true;
					
				}
				
			}
			
		}
		
		return egalite;
		
	}

}
