package Functions;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * This class implements some *VERY* elementary networking capability. There are
 * two important routines:
 * 
 * - int connect(String host): Connect to the machine with the given IP address.
 * (See the main() function for an example.)
 * 
 * - void close(): Close the current connection.
 * 
 * The connect() function will return either ERROR (in case something went
 * wrong), SERVER_MODE (in case this machine is the "leading" partner), or
 * CLIENT_MODE (in case this machine is the "following" partner). Once a
 * connection has been established, there are two more routines to read and
 * write from the partnered machine:
 * 
 * - void write(String message)
 * 
 * - String read()
 * 
 */
public class Networking {

	// Secret internal port -- DO NOT CHANGE
	private static final int PORT = 7114;

	// Return codes for connect()
	public static final int SERVER_MODE = 0;
	public static final int CLIENT_MODE = 1;
	public static final int ERROR = -1;
	
	// Internal network variables
	private static ServerSocket serverSocket = null;
	private static Socket clientSocket = null;
	private static BufferedReader fromPartner;
	private static DataOutputStream toPartner;

	/*
	 * Connect to the machine with the given address.
	 */
	public static int connect(String host) {
		try {
			String myHost = InetAddress.getLocalHost().getHostAddress();
			if (myHost.compareTo(host) < 0) {
				return serverMode(PORT);
			} else {
				return clientMode(host, PORT);
			}
		} catch (UnknownHostException x) {
			x.printStackTrace();
		} catch (IOException x) {
			x.printStackTrace();
		}
		return ERROR;
	}

	/*
	 * Close the connection (if any).
	 */
	public static void close() {
		try {
			if (serverSocket != null) {
				serverSocket.close();
				serverSocket = null;
			}
			if (clientSocket != null) {
				clientSocket.close();
				clientSocket = null;
			}
		} catch (IOException x) {
			x.printStackTrace();
		}
	}

	/*
	 * Send a message to the partnered machine.
	 */
	public static void write(String message) {
		try {
			toPartner.writeBytes(message + "\n");
		} catch (IOException x) {
			x.printStackTrace();
		}
	}

	/*
	 * Wait for a message from the partnered machine.
	 */
	public static String read() {
		try {
			return fromPartner.readLine();
		} catch (IOException x) {
			x.printStackTrace();
		}
		return "";
	}
	
	/*
	 * Internal routine for connecting as the "leading" partner.
	 */
	private static int serverMode(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		Socket socket = serverSocket.accept();
		fromPartner = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		toPartner = new DataOutputStream(socket.getOutputStream()); 
		return SERVER_MODE;
	}

	/*
	 * Internal routine for connecting as the "following" partner.
	 */
	private static int clientMode(String host, int port) throws UnknownHostException, IOException {
		clientSocket = new Socket(host, port);
		fromPartner = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		toPartner = new DataOutputStream(clientSocket.getOutputStream());
		return CLIENT_MODE;
	}

	/*
	 * Main routine for testing this module.
	 */
	public static void main(String[] args) {
		String host = "192.168.1.101";
		if (args.length > 0) {
			host = args[0];
		}
		int c = connect(host);
		if (c == SERVER_MODE) {
			System.out.println("(Server mode)");
			System.out.println("Waiting for greeting...");
			String greeting = read();
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
			String OK = read();
			assert OK.equals("OK");
			System.out.println("Closing connection");
			close();
		} else {
			System.out.println("Connection error");
		}
	}

}