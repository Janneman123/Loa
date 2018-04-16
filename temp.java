import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

	// Internal network variables
	private static ServerSocket serverSocket = null;
	private static Socket clientSocket = null;
	private static BufferedReader fromPartner;
	private static DataOutputStream toPartner;
        	

public class temp {
public static void main(){
    

//try {
String myHost = InetAddress.getLocalHost().getHostAddress();

//} catch  (myHost) { myHost;
    
//}
System.out.println(myHost);		
	
}
}