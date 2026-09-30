package ie.atu.service;

import ie.atu.client.CatalogClient;
import ie.atu.model.PurchaseOrder;
import ie.atu.repository.PurchaseOrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

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

    public String testCatalogConnection(Long productId) {
        return catalogClient.getProductById(productId);
    }
}