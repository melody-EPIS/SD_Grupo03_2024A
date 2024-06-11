package ventaproductos;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface SOAPI {

    @WebMethod
    List<Product> getProducts();

    @WebMethod
    void addProduct(Product product);
}
