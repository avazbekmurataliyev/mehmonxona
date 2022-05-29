package hotel.uz.mehmonxona.repository;

import hotel.uz.mehmonxona.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {
}
