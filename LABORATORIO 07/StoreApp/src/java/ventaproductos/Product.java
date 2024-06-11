package ventaproductos; // Define el paquete donde se encuentra la clase

import java.io.Serializable; // Importa la interfaz Serializable
import java.util.ArrayList; // Importa la clase ArrayList
import java.util.Arrays; // Importa la clase Arrays
import java.util.List; // Importa la interfaz List

public class Product implements Serializable { // Define la clase Product y la hace Serializable
    private static final long serialVersionUID = 1L; // Identificador único de serialización
    public static List<Product> products = new ArrayList<>(Arrays.asList( // Lista de productos predefinidos
            new Product("Lapiceros", 0.80), // Producto: Lapiceros, Precio: 0.80
            new Product("Cuadernos", 3.40), // Producto: Cuadernos, Precio: 3.40
            new Product("Hojas Bond", 10.50))); // Producto: Hojas Bond, Precio: 10.50
    public String name; // Nombre del producto
    public double price; // Precio del producto

    public Product() { // Constructor sin argumentos
        super(); // Llama al constructor de la clase padre
    }

    public Product(String name, double precio) { // Constructor con nombre y precio como argumentos
        super(); // Llama al constructor de la clase padre
        this.name = name; // Inicializa el nombre del producto
        this.price = precio; // Inicializa el precio del producto
    }

    public void setName(String name) { // Método para establecer el nombre del producto
        this.name = name; // Asigna el nombre dado al producto
    }

    public void setPrice(double precio) { // Método para establecer el precio del producto
        this.price = precio; // Asigna el precio dado al producto
    }

    public static List<Product> getProducts() { // Método estático para obtener la lista de productos
        return products; // Devuelve la lista de productos
    }

    @Override
    public String toString() { // Método toString para representar el objeto como cadena
        return "Producto [name= " + name + ", precio= " + price + "]"; // Devuelve una representación en cadena del producto
    }
}
