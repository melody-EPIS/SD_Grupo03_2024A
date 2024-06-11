package ventaproductos; // Define el paquete donde se encuentra la clase

import javax.xml.ws.Endpoint; // Importa la clase Endpoint del paquete javax.xml.ws

public class PublishServices { // Define la clase PublishServices
    public static void main(String[] args) { // Método principal
        // Publica un servicio web en la dirección especificada con una implementación dada
        Endpoint.publish("http://localhost:1516/WS/Products", new SOAPImpl());
        System.out.println("Service published at http://localhost:1516/WS/Products"); // Imprime un mensaje de confirmación
    }
}
