import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class ClockCliente {
	private String serverName;
	private int serverPort;
	private static int count;
	private Timer timer;
	private PrintWriter pr;
	private long t0;
	private long t3;
	
	public ClockCliente(String serverName, int serverPort) {
		this.serverName = serverName;
		this.serverPort = serverPort;
		ClockCliente.count = 0;
		this.timer = new Timer();
		try {
			this.pr = new PrintWriter("C:\\Users\\User\\Clientes.txt", "UTF-8");
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	class Conversation extends TimerTask {
		@Override
		public void run() {
			if(count<10) {
				try {
					System.out.println("Conectando a:" + serverName + "en el puerto" + serverPort);
					Socket client = new Socket(serverName, serverPort);
					System.out.println("Conectado a :" + client.getRemoteSocketAddress());
					OutputStream outToServer = client.getOutputStream();
					DataOutputStream out = new DataOutputStream(outToServer);
					t0 = System.currentTimeMillis();
					out.writeUTF("Ola de " + client.getLocalSocketAddress());
					
					InputStream inFromServer = client.getInputStream();
					DataInputStream in = new DataInputStream(inFromServer);
					long t1 = in.readLong();
					long t2 = in.readLong();
					t3 = System.currentTimeMillis();
					
					client.close();
					count ++;
					
					t1 += 100;
					t2 += 150;
					t3 +=250;
					
					long rtt = (t3 - t0) - (t2 - t1);
					pr.println("_____________________________");
					pr.println("Tiempo Cliente envío " + t0);
					pr.println("Tiempo del servidor receptor: " + t1);
					pr.println("Tiempo del servidor de envío: " + t2);
					pr.println("Tiempo del cliente receptando: "+ t3);
					
					pr.println("      RTTT    ");
					pr.println("a -> (t3 - t0) = " + (t3 - t0));
					pr.println("b -> (t2 - t1) = " + (t2 - t1));
					
					pr.println("       RTT dividido por 2         ");
					pr.println("(a - b)/2 = " + rtt/2);
					
					long theta = (t1 - t0) + (t2 - t3) / 2;
					pr.println("        RTT Offset       ");
					pr.println("Theta -> (t1 - t0) + (t2 - t3) / 2 = " + theta);
					
					long acerTime = t2 + (rtt/2);
					long acerTimeComOffset = t2 + (theta);
					pr.println("Horario acer");
					pr.println("Horario acer -> t2 + (rtt/2) " + acerTime);
					pr.println("Horario acer -> t2 + (rtt_offset): " + acerTimeComOffset);
 				}catch(IOException e) {
 					e.printStackTrace();
 				}
			}
			else {
				pr.close();
				timer.cancel();
				timer.purge();
			}
		}
	}
	
	public static void main(String [] args) {
		String serverName = "localhost";
		int serverPort = 9092;
		ClockCliente client = new ClockCliente(serverName, serverPort);
		long period = 6000;
		ClockCliente.Conversation conversation = client.new Conversation();
		client.timer.schedule(conversation,0, period);
	}

}
