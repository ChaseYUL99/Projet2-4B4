import java.util.ArrayList;

// Auteurs : Julien Cardinal, Paul Sasu

public class Facture {
	
	ArrayList<Commande> tabCommandes;
	
	public Facture() {

		LectureFichier lectureFichier = new LectureFichier();
		
		if ( lectureFichier.isCommandesValide() ) {
			
			this.tabCommandes = lectureFichier.getTabCommandes();
			
		}

	}

}
