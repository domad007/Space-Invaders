package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Serveur {

	public static void main(String[] args) {
		/*
		 * Création du serveur
		 */
		ServerSocket serversocket = null;
		try {
			serversocket = new ServerSocket(11111);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		try {
			Socket client = serversocket.accept();
			System.out.println("Un client s'est connecté");
			
			/*
			 * Création des objets permettant de communiquer avec le client
			 */
			BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintStream output = new PrintStream(client.getOutputStream());
			
			/*
			 * Note : On peut utiliser l'objet scanner au lieu du BufferedReader
			 */
			Scanner inputScanner = new Scanner(client.getInputStream());
			
			/*
			 * La communication se fera dans cette boucle
			 */
			
			/*
			 * La communication se fera dans cette boucle
			 */
			while (true) {
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
