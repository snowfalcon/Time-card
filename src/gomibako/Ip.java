package gomibako;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ip {
	public static String ip() {
		try {
			InetAddress addr = InetAddress.getLocalHost();
			String ip = "jdbc:mysql://" + addr.getHostAddress() + ":3306/kintaisys?autoReconnect=true&useSSL=false";
			//String ip = "jdbc:mysql://localhost:3306/hal_db";でok
			return ip;
		} catch (UnknownHostException e) { e.printStackTrace(); }
		return null;
	}
}
