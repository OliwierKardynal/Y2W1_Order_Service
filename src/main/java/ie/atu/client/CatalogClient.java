
package ie.atu.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ie.atu.client.dto.ProductResponse;

@FeignClient(
        name = "catalog-service",
        url = "http://localhost:8081"
)
public interface CatalogClient {

    @GetMapping("/products/{id}")
    ProductResponse getProductById(@PathVariable("id") Long id);


}