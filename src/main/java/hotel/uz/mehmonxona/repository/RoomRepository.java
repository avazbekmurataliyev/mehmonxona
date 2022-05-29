package hotel.uz.mehmonxona.repository;

import hotel.uz.mehmonxona.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Integer> {

     boolean existsByFloorAndNumberAndSizeAndHotel_Id(Integer floor, Integer number, Integer size, Integer hotel_id);

}
