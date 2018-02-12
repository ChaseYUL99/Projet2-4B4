// Auteurs : Julien Cardinal, Paul Sasu

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;

// Classe Permettant de lire un fichier texte afin de remplr les différents tableau d'information.
public class LectureFichier {

	private ArrayList<String> tabClients = new ArrayList<>();
	private ArrayList<Plat> tabPlats = new ArrayList<>();
	private ArrayList<Commande> tabCommandes = new ArrayList<>();
	private boolean commandesValide = true;

	public LectureFichier() {

		Path chemin = null;
		BufferedReader ficLecture = null;

		try {

			chemin = Paths.get( "commandes.txt" );

		} catch ( InvalidPathException errNomFichier ) {

			System.out.println( "\nUne erreur au niveau du nom du fichier a été attrapé" );

		}

		try {

			ficLecture = Files.newBufferedReader( chemin, Charset.defaultCharset() );

		} catch ( IOException errIO ) {

			System.out.println( "\nUne erreur empèche l'ouverture du fichier en mode lecture." );

		}

		try {

			String ligne = "";

			ficLecture.readLine(); // Lecture de "Client :"

			while ( !( ligne = ficLecture.readLine() ).equals( "Plats :" ) ) {

				tabClients.add( ligne );

			}

			while ( !( ligne = ficLecture.readLine() ).equals( "Commandes :" ) ) {

				String[] tabTemp = ligne.split( " " );

				tabPlats.add( new Plat( tabTemp[0], Double.parseDouble( tabTemp[1] ) ) );

			}

			while ( !( ligne = ficLecture.readLine() ).equals( "Fin" ) ) {

				String[] tabTemp = ligne.split( " " );

				if ( tabTemp.length < 3 ) {

					commandesValide = false;

				} else {

					tabCommandes
							.add( new Commande( tabTemp[0], new Plat( tabTemp[1] ), Integer.parseInt( tabTemp[2] ) ) );

				}

			}

		} catch ( IOException errIO ) {

			System.out.println( "\nUne erreur empèche la lecture du fichier" );

		}
		
		for ( Commande commande : tabCommandes ) {
			
			boolean clientCorrespond = false;
			
			for ( String client : tabClients ) {
				
				if ( commande.getNom().equals( client ) ) {
					
					clientCorrespond = true;
					
					break;
					
				}
				
			}
			
			if ( !clientCorrespond ) {
				
				commandesValide = false;
				
				break;
				
			}
			
		}
		
		if ( commandesValide ) {
			
			for ( Commande commande : tabCommandes ) {
				
				boolean PlatCorrespond = false;
				
				for ( Plat plat : tabPlats ) {
					
					if ( commande.getPlat().equals( plat ) ) {
						
						PlatCorrespond = true;
						
						break;
						
					}
					
				}
				
				if ( !PlatCorrespond ) {
					
					commandesValide = false;
					
					break;
					
				}
				
			}
			
		}

		try {

			ficLecture.close();

		} catch ( IOException errIO ) {

			System.out.println( "\nUne erreur empèche de fermer le fichier." );

		}

	}
	
	public ArrayList<Commande> getTabCommandes() {
		
		return tabCommandes;
		
	}
	
	public boolean isCommandesValide() {
		
		return commandesValide;
		
	}

}
