package ventaproductos;

import java.util.List;
import javax.jws.WebService;

@WebService(endpointInterface = "ventaproductos.SOAPI")
public class SOAPImpl implements SOAPI {
    
    @Override
    public List<Product> getProducts() {
        return Product.getProducts();
    }
    
    @Override
    public void addProduct(Product product) {
        Product.getProducts().add(product);
    }
}
