package ch.appaka.commerce.warehouse.data.repository;

import ch.appaka.commerce.warehouse.data.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
