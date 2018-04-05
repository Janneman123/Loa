package Client_move_1;

import Functions.Networking;

public class Client_move_1{
	public static String Client_move_1(String hostip){

	 int SERVER_MODE = 0;
	 int CLIENT_MODE = 1;
	 int ERROR = -1;

	 String client_move="Temp";

	Functions.Networking Networking=new Functions.Networking();

	int c = Networking.connect(hostip);
		if (c == SERVER_MODE) {
			System.out.println("(Server mode)");
			System.out.println("Waiting for greeting...");
			client_move = Networking.read();
			System.out.println("Received greeting: \"" + client_move + "\"");
			System.out.println("Sending OK");
			Networking.write("OK");
			System.out.println("Closing connection");
			Networking.close();
		} else if (c == CLIENT_MODE) {
			System.out.println("(Client mode)");
			System.out.println("Sending greeting...");
			Networking.write("Hello, world!");
			System.out.println("Waiting for OK...");
			String OK = Networking.read();
			assert OK.equals("OK");
			System.out.println("Closing connection");
			Networking.close();
		} else {
			System.out.println("Connection error");
		}

	return(client_move);

	}
}