package client;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String address = args[0];
		int port = Integer.parseInt(args[1]);
		
		System.out.println("Entrez votre nom : ");
		String name = sc.nextLine();

		try (Socket socketClient = new Socket(address, port)) {
			PrintWriter envoiMsg = new PrintWriter(socketClient.getOutputStream(), true);

			ThreadClient threadClient = new ThreadClient(socketClient);
			threadClient.start(); 
            envoiMsg.println(name + " a rejoint le chat.");
            
			String message;
			do{
				message = sc.nextLine();
				if (message.equals("\\quit")) {
		            envoiMsg.println(name + " a quitté le chat.");
					break;
				}
				envoiMsg.println(name + " : " + message);

			} while(!message.equals("\\quit"));

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
