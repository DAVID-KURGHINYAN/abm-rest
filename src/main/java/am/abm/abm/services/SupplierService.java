package am.abm.abm.services;

import am.abm.abm.models.dtos.supplier.SupplierCreateDTO;
import am.abm.abm.models.dtos.supplier.SupplierDetailsDTO;
import am.abm.abm.models.enities.Supplier;
import am.abm.abm.repositories.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public SupplierDetailsDTO getSupplierDetails(Long id) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (optionalSupplier.isPresent()) {
            Supplier supplier = optionalSupplier.get();
            return new SupplierDetailsDTO(supplier);
        }
        return null;
    }

    public List<Supplier> getAll() {
        return null;
    }

    public Supplier saveSupplier(SupplierCreateDTO supplierCreateDTO) {
        Supplier supplier = new Supplier();
        supplier.setSupplierName(supplierCreateDTO.getSupplierName());
        supplier.setContactName(supplierCreateDTO.getContactName());
        supplier.setAddress(supplierCreateDTO.getAddress());
        supplier.setCity(supplierCreateDTO.getCity());
        supplier.setPostalCode(supplierCreateDTO.getPostalCode());
        supplier.setCountry(supplierCreateDTO.getCountry());
        supplier.setPhone(supplierCreateDTO.getPhone());
        return supplierRepository.save(supplier);
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    public boolean editSupplier(SupplierCreateDTO supplier, Long id) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (optionalSupplier.isPresent()) {
            Supplier oldSupplier = optionalSupplier.get();
            oldSupplier.setSupplierName(supplier.getSupplierName());
            oldSupplier.setContactName(supplier.getContactName());
            oldSupplier.setAddress(supplier.getAddress());
            oldSupplier.setCity(supplier.getCity());
            oldSupplier.setPostalCode(supplier.getPostalCode());
            oldSupplier.setCountry(supplier.getCountry());
            oldSupplier.setPhone(supplier.getPhone());
            supplierRepository.save(oldSupplier);
            return true;
        }
        return false;
    }

}
