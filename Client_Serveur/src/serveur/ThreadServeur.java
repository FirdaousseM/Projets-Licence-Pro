package serveur;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ThreadServeur extends Thread{

	private ArrayList<Socket> listeClients;
	private Socket clientEmetteur;
	private PrintWriter envoiMsg;
	
	public ThreadServeur(Socket clientEmetteur, ArrayList<Socket> listeClients){
		this.clientEmetteur = clientEmetteur;
		this.listeClients = listeClients;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader receptionMsg = new BufferedReader(new InputStreamReader(clientEmetteur.getInputStream()));
			
			envoiMsg = new PrintWriter(clientEmetteur.getOutputStream(), true);
			//tant que le client est connecté
			while(true){
				//System.out.println("Client : " + msg);
				String message = receptionMsg.readLine();
				if (message.equals("\\quit")) {
	                break;
	            }
				diffusionAuxClients(message);
			}
			//sortir de la boucle si le client a déconecté
			System.out.println("Client déconnecté");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void diffusionAuxClients(String message) {
		for(Socket client : listeClients) {
			if (client != clientEmetteur) {
                try {
					envoiMsg = new PrintWriter(client.getOutputStream(), true);
				} catch (IOException e) {
					e.printStackTrace();
				}
				envoiMsg.println(message);
			}
		}
	}
}
