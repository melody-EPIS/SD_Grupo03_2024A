package LabSD; // Define el paquete en el que se encuentra la clase.

import java.util.List; // Importa la clase List para manejar listas de objetos.
import javax.jws.WebService; // Importa la anotación WebService para marcar la clase como un servicio web.
import LabSD.User; // Importa la clase User que será utilizada en los métodos de la clase.

// Marca esta clase como una implementación de un servicio web y especifica la interfaz que implementa.
@WebService(endpointInterface = "LabSD.SOAPI") 
public class SOAPImpl implements SOAPI { // Declara la clase SOAPImpl que implementa la interfaz SOAPI.

    @Override // Sobrescribe el método getUsers de la interfaz SOAPI.
    public List<User> getUsers() { // Implementa el método para obtener una lista de usuarios.
        return User.getUsers(); // Llama al método estático getUsers de la clase User para obtener la lista de usuarios.
    }
    
    @Override // Sobrescribe el método addUser de la interfaz SOAPI.
    public void addUser(User user) { // Implementa el método para añadir un usuario.
        User.getUsers().add(user); // Añade el usuario a la lista de usuarios llamando al método estático getUsers de la clase User.
    }
}
