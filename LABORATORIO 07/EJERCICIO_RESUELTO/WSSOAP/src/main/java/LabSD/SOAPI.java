package LabSD; // Define el paquete en el que se encuentra la interfaz.

import java.util.List; // Importa la clase List para manejar listas de objetos.
import javax.jws.WebMethod; // Importa la anotación WebMethod para marcar métodos como operaciones web.
import javax.jws.WebService; // Importa la anotación WebService para definir una interfaz como servicio web.
import LabSD.User; // Importa la clase User que será utilizada en los métodos de la interfaz.

@WebService // Marca esta interfaz como un servicio web.
public interface SOAPI { // Declara la interfaz del servicio web SOAPI.

    @WebMethod // Indica que este método es una operación web que se puede invocar.
    public List<User> getUsers(); // Define un método para obtener una lista de usuarios.
    
    @WebMethod // Indica que este método es una operación web que se puede invocar.
    public void addUser(User user); // Define un método para añadir un usuario.
    
}
