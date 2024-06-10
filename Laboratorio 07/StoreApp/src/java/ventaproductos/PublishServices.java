package ventaproductos;

import javax.xml.ws.Endpoint;

public class PublishServices {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:1516/WS/Products", new SOAPImpl());
        System.out.println("Service published at http://localhost:1516/WS/Products");
    }
}
