package ch.appaka.commerce.warehouse;

import ch.appaka.commerce.warehouse.data.entity.Guest;
import ch.appaka.commerce.warehouse.data.entity.Reservation;
import ch.appaka.commerce.warehouse.data.entity.Room;
import ch.appaka.commerce.warehouse.data.repository.GuestRepository;
import ch.appaka.commerce.warehouse.data.repository.ReservationRepository;
import ch.appaka.commerce.warehouse.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class WarehouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(WarehouseApplication.class, args);
	}

	@RestController
	@RequestMapping("/api/rooms")
	public class RoomController{
		@Autowired
		private RoomRepository roomRepository;

		@GetMapping
		public Iterable<Room> getRooms(){
			return this.roomRepository.findAll();
		}
	}

	@RestController
	@RequestMapping("/api/guests")
	public class GuestController{
		@Autowired
		private GuestRepository guestRepository;

		@GetMapping
		public Iterable<Guest> getGuests(){
			return this.guestRepository.findAll();
		}
	}

	@RestController
	@RequestMapping("/api/reservations")
	public class ReservationController{
		@Autowired
		private ReservationRepository reservationRepository;

		@GetMapping
		public Iterable<Reservation> getReservations(){
			return this.reservationRepository.findAll();
		}
	}

}
