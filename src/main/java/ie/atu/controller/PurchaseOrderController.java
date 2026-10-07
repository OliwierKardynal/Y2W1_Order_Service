package ie.atu.controller;

import ie.atu.model.PurchaseOrder;
import ie.atu.service.PurchaseOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import ie.atu.client.dto.ProductResponse;

@RestController
@RequestMapping("/orders")
public class PurchaseOrderController {
    private final PurchaseOrderService service;

    public PurchaseOrderController(PurchaseOrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<PurchaseOrder> getAll() {
        return service.getAll();
    }

    @GetMapping("/test-catalog/{productId}")
    public ProductResponse testCatalogConnection(@PathVariable Long productId) {
        return service.testCatalogConnection(productId);
    }
    @GetMapping("/{id}/product")
    public ProductResponse getProductForOrder(@PathVariable Long id) {
        return service.getProductForOrder(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PurchaseOrder create(@RequestBody PurchaseOrder order) {
        return service.create(order);
    }
}
