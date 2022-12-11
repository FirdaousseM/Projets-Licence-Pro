package serveur;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Serveur {

	public static void main (String[] args) {

		int port = Integer.parseInt(args[0]);

		ArrayList<Socket> listeClients = new ArrayList<>();
		
		try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Serveur lancé sur le port : " + port + "\n");
			while(true) {
				Socket socketClient = serverSocket.accept();
				listeClients.add(socketClient);
				ThreadServeur threadServeur = new ThreadServeur(socketClient, listeClients);
				threadServeur.start();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
