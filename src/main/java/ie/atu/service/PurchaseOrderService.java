package ie.atu.service;

import ie.atu.client.CatalogClient;
import ie.atu.model.PurchaseOrder;
import ie.atu.repository.PurchaseOrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import ie.atu.client.dto.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PurchaseOrderService {
    private final PurchaseOrderRepository repository;
    private final CatalogClient catalogClient;

    public PurchaseOrderService(PurchaseOrderRepository repository, CatalogClient catalogClient) {
        this.repository = repository;
        this.catalogClient = catalogClient;
    }

    public List<PurchaseOrder> getAll() {
        return repository.findAll();
    }

    public PurchaseOrder create(PurchaseOrder order) {
        order.setId(null);
        return repository.save(order);
    }

    public ProductResponse testCatalogConnection(Long productId) {
        return catalogClient.getProductById(productId);
    }
    public ProductResponse getProductForOrder(Long orderId) {
        PurchaseOrder order = repository.findById(orderId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));

        return catalogClient.getProductById(order.getProductId());
    }
}