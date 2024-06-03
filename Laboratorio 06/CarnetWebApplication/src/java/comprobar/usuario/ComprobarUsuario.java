/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package comprobar.usuario;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author mrsme
 */
@WebService(serviceName = "ComprobarUsuario")
public class ComprobarUsuario {

    @WebMethod(operationName = "Comprobar")
    public boolean Comprobar(@WebParam(name = "usuario") String user1, @WebParam(name = "contrasenia") String contra) {
        try {
            if (user1.equals("usuario") && contra.equals("contrasenia")) {
                return true;
            } else if (user1.equals("usuario") && !contra.equals("contrasenia")) {
                return false;
            } else if (!user1.equals("usuario") && !contra.equals("contrasenia")) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}