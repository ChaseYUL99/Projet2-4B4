// Auteurs : Julien Cardinal, Paul Sasu

public class Plat {

	private String nom;
	private double prix;

	public Plat( String nom ) {

		this( nom, -1 );

	}

	public Plat( String nom, double prix ) {

		this.setNom( nom );

		this.setPrix( prix );

	}

	public String getNom() {

		return this.nom;

	}

	public double getPrix() {

		return this.prix;

	}

	public void setNom( String nom ) {

		this.nom = nom;

	}

	public void setPrix( double prix ) {

		this.prix = prix;

	}

	@Override
	public boolean equals( Object autreObjet ) {

		boolean egalite = false;

		if ( this == autreObjet ) {

			egalite = true;

		} else if ( autreObjet != null ) {

			if ( autreObjet instanceof Plat ) {

				Plat autrePlat = (Plat) autreObjet;

				if ( this.getNom().equalsIgnoreCase( autrePlat.getNom() ) ) {

					egalite = true;

				}

			}

		}

		return egalite;

	}

}
