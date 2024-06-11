package LabSD; // Define el paquete en el que se encuentra la clase.

import javax.xml.ws.Endpoint; // Importa la clase Endpoint para publicar el servicio web.
import javax.xml.*; // Importa todas las clases en el paquete javax.xml.
import LabSD.SOAPImpl; // Importa la implementación del servicio web SOAP.

public class PublishServices { // Declara la clase PublishServices.
    public static void main(String[] args) { // Define el método principal, punto de entrada de la aplicación.
        Endpoint.publish("http://localhost:1516/WS/Users", new SOAPImpl()); 
        // Publica el servicio web en la URL especificada. 
        // "http://localhost:1516/WS/Users" es la dirección en la que el servicio estará disponible.
        // new SOAPImpl() es la instancia de la implementación del servicio web que se publica.
    }
}

