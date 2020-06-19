package ch.appaka.commerce.warehouse.data.repository;

import ch.appaka.commerce.warehouse.data.entity.Room;
import ch.appaka.commerce.warehouse.data.entity.Stock;
import ch.appaka.commerce.warehouse.data.entity.StockCompositeKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock, StockCompositeKey> {
}
