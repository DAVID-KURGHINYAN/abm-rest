package am.abm.abm.controllers;

import am.abm.abm.exceptions.EntityNotFoundException;
import am.abm.abm.models.ResponseModel;
import am.abm.abm.models.dtos.shipper.ShipperCreateDTO;
import am.abm.abm.models.dtos.shipper.ShipperPreviewDTO;
import am.abm.abm.services.ShipperService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("shipper/")
public class ShipperController extends BaseController{

    private final ShipperService shipperService;

    public ShipperController(ShipperService shipperService) {
        this.shipperService = shipperService;
    }

    @GetMapping("list")
    public List<ShipperPreviewDTO> shipperList() {
        return shipperService.getAll();
    }

    @PostMapping("add")
    public ShipperPreviewDTO addShipper(@RequestBody ShipperCreateDTO shipper) {
        return shipperService.saveShipper(shipper);
    }

    @PutMapping("edit/{id}")
    public boolean editShipper(@RequestBody ShipperCreateDTO shipper, @PathVariable Long id) {
        return shipperService.editShipper(shipper, id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteShipper(@PathVariable Long id) {
        shipperService.deleteShipper(id);
    }

    @GetMapping("details/{id}")
    public ResponseModel details(@PathVariable Long id) {
        try {
            return createResult(shipperService.getShipperDetails(id), "Product details was retrieved successfully");
        } catch (EntityNotFoundException e) {
            return createErrorResult(e);
        }
    }
}
