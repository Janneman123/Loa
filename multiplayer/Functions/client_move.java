//package client_move;

import Functions.Networking;

public class client_move{
	public static String client_move(String clientmove,String hostip){

	Functions.Networking Networking=Functions.Networking();

	int c = Networking.connect(hostip);
		if (c == SERVER_MODE) {
			System.out.println("(Server mode)");
			System.out.println("Waiting for greeting...");
			String client_move = Networking.read();
			System.out.println("Received greeting: \"" + greeting + "\"");
			System.out.println("Sending OK");
			write("OK");
			System.out.println("Closing connection");
			close();
		} else if (c == CLIENT_MODE) {
			System.out.println("(Client mode)");
			System.out.println("Sending greeting...");
			write("Hello, world!");
			System.out.println("Waiting for OK...");
			String OK = Networking.read();
			assert OK.equals("OK");
			System.out.println("Closing connection");
			close();
		} else {
			System.out.println("Connection error");
		}

	}
}