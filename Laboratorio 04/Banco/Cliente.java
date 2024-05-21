

import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente implements Runnable {
    private static final String IP = "localhost";
    private static final int PUERTO = 1100;
    private InterfaceRemoto server;
    private String name;

    protected Cliente(InterfaceRemoto chatinterface, String name) throws RemoteException {
        this.server = chatinterface;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " " + server.depositar("Cliente1", 500));
            System.out.println(name + " " + server.retirar("Cliente1", 500));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(IP, PUERTO);
        InterfaceRemoto server = (InterfaceRemoto) registry.lookup("BancoService"); // Cambiar "calculadora" a "BancoService"
        new Thread(new Cliente(server, "Julio")).start();
        new Thread(new Cliente(server, "Ricardo")).start();
    }
}
