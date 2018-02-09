// Auteurs : Julien Cardinal, Paul Sasu

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

// Classe Permettant de lire un fichier texte afin de remplr les différents tableau d'information.
public class LectureFichier {
	
	ArrayList<String> tabClients = new ArrayList<>();
	ArrayList<Plat> tabPlats = new ArrayList<>();
	
	public LectureFichier() {
		
		BufferedReader ficLecture = null;
		
		Path chemin = Paths.get( "commandes.txt" );
		
		try {
			
			ficLecture = Files.newBufferedReader( chemin );
			
		} catch ( IOException errIO ) {
			
			System.out.println( "\nUne erreur empèche l'ouverture du fichier en mode lecture." );
			
		}
		
		try {
			
			String ligne = "";
			
			ficLecture.readLine(); // Lecture de "Client :"
				
			while ( ( ligne = ficLecture.readLine() ) != "Plat:" ) {
				
				tabClients.add( ligne );
				
			}
			
			while ( ( ligne = ficLecture.readLine() ) != "Commandes:" ) {
				
				String[] tabTemp = ligne.split( " " );
				
				tabPlats.add( new Plat( tabTemp[0], Double.parseDouble( tabTemp[1] ) ) );
				
			}
				
			
		} catch( IOException errIO ) {
			
			System.out.println( "\nUne erreur empèche la lecture du fichier" );
			
		}
		
		try {
			
			ficLecture.close();
			
		} catch ( IOException errIO ) {
			
			System.out.println( "\nUne erreur empèche de fermer le fichier." );
			
		}
		
	}
	
}
