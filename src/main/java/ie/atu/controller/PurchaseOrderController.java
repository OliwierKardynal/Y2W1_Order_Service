package ie.atu.controller;

import ie.atu.model.PurchaseOrder;
import ie.atu.service.PurchaseOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public String testCatalogConnection(@PathVariable Long productId) {
        return service.testCatalogConnection(productId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PurchaseOrder create(@RequestBody PurchaseOrder order) {
        return service.create(order);
    }
}
