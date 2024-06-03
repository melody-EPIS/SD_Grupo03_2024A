package compra.productos;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "compraproductos")
public class compraproductos {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "operation")
    public String operation(
            @WebParam(name = "CantidadPan") int CantidadPan,
            @WebParam(name = "CantidadPlatanos") int CantidadPlatanos,
            @WebParam(name = "CantidadQueso") int CantidadQueso,
            @WebParam(name = "CantidadNaranjas") int CantidadNaranjas) {
        
        String mensaje = "";
        double total = 0.0;

        if (CantidadPan < 1 || CantidadPlatanos < 1 || CantidadQueso < 1 || CantidadNaranjas < 1) {
            mensaje = "Ingreso incorrecto de las cantidades de los productos";
        } else {
            mensaje += "\n";
            total += CantidadPan * 0.5;
            mensaje += "Pan: " + CantidadPan + " unidades --> Subtotal: " + CantidadPan * 0.5 + "\n";

            total += CantidadPlatanos * 0.5;
            mensaje += "Plátanos: " + CantidadPlatanos + " unidades --> Subtotal: " + CantidadPlatanos * 0.5 + "\n";

            total += CantidadQueso * 0.5;
            mensaje += "Queso: " + CantidadQueso + " unidades --> Subtotal: " + CantidadQueso * 0.5 + "\n";

            total += CantidadNaranjas * 0.5;
            mensaje += "Naranjas: " + CantidadNaranjas + " unidades --> Subtotal: " + CantidadNaranjas * 0.5 + "\n";

            mensaje += "\nTotal: " + total;
        }

        return mensaje;
    }
}
