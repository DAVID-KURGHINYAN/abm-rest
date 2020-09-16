package am.abm.abm.controllers;

import am.abm.abm.models.dtos.supplier.SupplierCreateDTO;
import am.abm.abm.models.dtos.supplier.SupplierDetailsDTO;
import am.abm.abm.models.dtos.supplier.SupplierPreviewDTO;
import am.abm.abm.models.enities.Supplier;
import am.abm.abm.services.SupplierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("supplier/")
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("list")
    public List<SupplierPreviewDTO> supplierList() {
        return supplierService.getAll();
    }

    @PostMapping("add")
    public SupplierPreviewDTO addSupplier(@RequestBody SupplierCreateDTO supplier) {
        return supplierService.saveSupplier(supplier);
    }

    @PutMapping("edit/{id}")
    public boolean editSupplier(@RequestBody SupplierCreateDTO supplier, @PathVariable Long id) {
        return supplierService.editSupplier(supplier, id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
    }

    @GetMapping("details/{id}")
    public SupplierPreviewDTO details(@PathVariable Long id) {
        return supplierService.getSupplierDetails(id);
    }

    @GetMapping("detail/{id}")
    public SupplierPreviewDTO infoSupplier(@PathVariable Long id) {return supplierService.getInfoSupplier(id);}
}

