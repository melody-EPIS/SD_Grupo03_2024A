
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor implements InterfaceRemoto {
    private static final int PUERTO = 1500; // Puerto en el que el servidor escucha
    private static Banco cuentas = new Banco();

    @Override
    public synchronized String depositar(String cuenta, int monto) throws RemoteException {
        return cuentas.depositar(cuenta, monto);
    }

    @Override
    public synchronized String retirar(String cuenta, int monto) throws RemoteException {
        return cuentas.sacar(cuenta, monto);
    }

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Servidor server = new Servidor();
        InterfaceRemoto remote = (InterfaceRemoto) UnicastRemoteObject.exportObject(server, 0);

        Registry registry = LocateRegistry.createRegistry(PUERTO);
        System.out.println("Servidor escuchando en el puerto " + PUERTO);
        cuentas.mostrarCuentas();

        registry.bind("BancoService", remote);
    }
}
