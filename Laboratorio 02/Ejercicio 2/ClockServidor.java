import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
public class ClockServidor extends Thread {
	private final ServerSocket ServidorSocket;
	private long timeRecb;
	private long timeSend;
	
	public ClockServidor(int port) throws IOException{
		
		ServidorSocket = new ServerSocket(port);
	}
	@Override
	public void run() {
		while(true) {
			try {
				String localHostName = java.net.InetAddress.getLocalHost().getHostName();
				System.out .println("Nombre servidor :" + localHostName);
				System.out.println("Esperando cliente en el puerto " + ServidorSocket.getLocalPort()+ "...");
				Socket server = ServidorSocket.accept();
				System.out.println("Conectando en"+ server.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(server.getInputStream());
				timeRecb = System.currentTimeMillis();
				System.out.println(in.readUTF());
				DataOutputStream out = new DataOutputStream(server.getOutputStream());
				long time_on_Server = System.currentTimeMillis();
				timeSend = System.currentTimeMillis();
				out.writeLong(time_on_Server);
				out.writeLong(timeSend);
				server.close();
				
			}catch (SocketTimeoutException s){
				System.out.println("Tiempo de espera agotado del servidor");
				break;
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String [] args) {
		int port = 9092;
		try {
			Thread t = new ClockServidor(port);
			t.start();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
