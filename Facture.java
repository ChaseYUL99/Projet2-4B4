// Auteurs : Julien Cardinal, Paul Sasu

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Facture {

	private ArrayList<String> tabClients;
	private ArrayList<Plat> tabPlats;
	private ArrayList<Commande> tabCommandes;

	public Facture() {

		LectureFichier lectureFichier = new LectureFichier();

		if ( lectureFichier.isCommandesValide() ) {

			this.tabClients = lectureFichier.getTabClient();
			this.tabPlats = lectureFichier.getTabPlats();
			this.tabCommandes = lectureFichier.getTabCommandes();

			BufferedWriter ficEcriture = null;
			boolean valide = false;

			Path chemin = Paths.get( "facture.txt" );

			if ( Files.notExists( chemin ) ) {

				System.out.println( "\nLe fichier facture.txt n'existe pas, il sera automatiquement cr\u00E9\u00E9" );

				valide = true;

			} else if ( Files.exists( chemin ) && Files.isRegularFile( chemin ) && Files.isWritable( chemin ) ) {

				System.out.println( "\nLe fichier facture.txt existe, il sera \u00E9cras\u00E9" );

				valide = true;

			} else {

				System.out.println( "\nLe fichier facture.txt n'est pas conforme au programme. "
						+ "Veuillez le supprimer, puis relancer le programme." );

			}

			if ( valide ) {

				try {

					ficEcriture = Files.newBufferedWriter( chemin, Charset.defaultCharset() );

					ficEcriture.write( "Bienvenue chez Barette!\r\n" + "Factures:\r\n" );

					for ( String client : tabClients ) {

						double montantClient = 0;

						ficEcriture.write( client + " " );

						for ( Commande commande : tabCommandes ) {

							double montantCommandes = 0;

							if ( commande.getNom().equals( client ) ) {

								for ( Plat plat : tabPlats ) {

									if ( commande.getPlat().equals( plat ) ) {

										montantCommandes += plat.getPrix() * commande.getQuant();

									}

								}

							}

							montantClient += montantCommandes;

						}

						NumberFormat formatNb = NumberFormat.getNumberInstance();

						formatNb.setMinimumIntegerDigits( 1 );
						formatNb.setMinimumFractionDigits( 2 );
						formatNb.setMaximumFractionDigits( 2 );

						ficEcriture.write( formatNb.format( montantClient ) + "$\r\n" );

					}

					ficEcriture.close();

				} catch ( IOException errIO ) {

					System.out.println( "\nUne erreur empèche l'ouverture et l'ex\u00E9cution"
							+ " du fichier en mode écriture" );

				}

			}

		} else {

			System.out.println( "\nLe fichier ne respecte pas le format demand\u00E9 !" );

		}

	}

}
