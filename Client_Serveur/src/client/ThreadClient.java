package client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ThreadClient extends Thread{

	private Socket socketClient;
	private BufferedReader receptionMsg;

	public ThreadClient(Socket socketClient) {
		this.socketClient = socketClient;
	}

	@Override
	public void run() {


		try {
			receptionMsg = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

			while (true) {
				String message = receptionMsg.readLine();
				System.out.println(message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				receptionMsg.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
