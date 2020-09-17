package am.abm.abm.services;

import am.abm.abm.exceptions.EntityNotFoundException;
import am.abm.abm.models.dtos.shipper.ShipperCreateDTO;
import am.abm.abm.models.dtos.shipper.ShipperDetailsDTO;
import am.abm.abm.models.dtos.shipper.ShipperPreviewDTO;
import am.abm.abm.models.enities.Shipper;
import am.abm.abm.repositories.ShipperRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipperService {
    private final ShipperRepository shipperRepository;

    public ShipperService(ShipperRepository shipperRepository) {
        this.shipperRepository = shipperRepository;
    }

    public ShipperPreviewDTO getShipperDetails(Long id) throws EntityNotFoundException {
        Optional<Shipper> optionalShipper = shipperRepository.findById(id);
        if (optionalShipper.isPresent()) {
            Shipper shipper = optionalShipper.get();
            return new ShipperPreviewDTO(shipper);
        }
        else throw new EntityNotFoundException();
    }

    public List<ShipperPreviewDTO> getAll() {
        return ShipperPreviewDTO.getShipperPreviewDTOS(shipperRepository.findAll());
    }

    public ShipperPreviewDTO saveShipper(ShipperCreateDTO shipperCreateDTO) {
        Shipper shipper = new Shipper();
        shipper.setShipperName(shipperCreateDTO.getShipperName());
        shipper.setPhone(shipperCreateDTO.getPhone());
        return new ShipperPreviewDTO(shipperRepository.save(shipper));
    }

    public void deleteShipper(Long id) {
        shipperRepository.deleteById(id);
    }

    public boolean editShipper(ShipperCreateDTO shipper, Long id) {
        Optional<Shipper> optionalShipper = shipperRepository.findById(id);
        if (optionalShipper.isPresent()) {
            Shipper oldShipper = optionalShipper.get();
            oldShipper.setShipperName(shipper.getShipperName());
            oldShipper.setPhone(shipper.getPhone());
            shipperRepository.save(oldShipper);
            return true;
        }
        return false;
    }
}
