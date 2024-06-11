package LabSD; // Define el paquete en el que se encuentra la clase.

import java.io.Serializable; // Importa la interfaz Serializable para permitir la serialización de objetos User.
import java.util.ArrayList; // Importa la clase ArrayList para manejar listas de usuarios.
import java.util.Arrays; // Importa la clase Arrays para inicializar la lista de usuarios.
import java.util.List; // Importa la clase List para manejar listas de objetos.
import javax.xml.bind.annotation.XmlAttribute; // Importa la anotación XmlAttribute para posibles usos futuros.
import javax.xml.bind.annotation.XmlValue; // Importa la anotación XmlValue para posibles usos futuros.

public class User implements Serializable { // Declara la clase User que implementa Serializable.
	private static final long serialVersionUID = 1L; // Define un identificador único para la serialización.
	
	// Inicializa una lista estática de usuarios con algunos usuarios predefinidos.
	public static List<User> users = new ArrayList<>(Arrays.asList(
		new User("Rosa", "Marfil"),
		new User("Pepito", "Grillo"),
		new User("Manuela", "Río")
	));
	
	public String name; // Declara el campo name para almacenar el nombre del usuario.
	public String username; // Declara el campo username para almacenar el nombre de usuario.

	public User() { // Constructor por defecto.
		super(); // Llama al constructor de la superclase.
	}
	
	// Constructor con parámetros para inicializar un nuevo usuario.
	public User(String name, String username) {
		super(); // Llama al constructor de la superclase.
		this.name = name; // Inicializa el campo name.
		this.username = username; // Inicializa el campo username.
	}
	
	// Método setter para el campo name.
	public void setName(String name) {
		this.name = name;
	}
	
	// Método setter para el campo username.
	public void setUsername(String username) {
		this.username = username;
	}
	
	// Método estático para obtener la lista de usuarios.
	public static List<User> getUsers() {
		return users; // Retorna la lista de usuarios.
	}
}
