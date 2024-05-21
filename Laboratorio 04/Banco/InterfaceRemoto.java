
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRemoto extends Remote {
    String depositar(String cuenta, int monto) throws RemoteException;
    String retirar(String cuenta, int monto) throws RemoteException;
}
