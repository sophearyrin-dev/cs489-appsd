package cs489.srmwebapi.repository;

import cs489.srmwebapi.model.Supplier;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface SupplierRepository extends ListPagingAndSortingRepository<Supplier, Integer> {
}
