package hotel.uz.mehmonxona.service;

import hotel.uz.mehmonxona.entity.Hotel;
import hotel.uz.mehmonxona.entity.Room;
import hotel.uz.mehmonxona.payload.RoomDto;
import hotel.uz.mehmonxona.repository.HotelRepository;
import hotel.uz.mehmonxona.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository ;

    @Autowired
    private HotelRepository hotelRepository ;

    public List<Room> getAll(){
        return roomRepository.findAll();
    }

    public Page<Room> getOneHotelRooms(Integer id , Pageable pageable){
        Page<Room> allByHotelId = roomRepository.findAllByHotelId(id, pageable);
        return allByHotelId;
    }

    public String delete( Integer id){
        try{
            Optional<Room> optionalRoom = roomRepository.findById(id);
            if (optionalRoom.isPresent())
            {
                roomRepository.deleteById(id);
                return "Delete success";
            }
            return " This Room Not found error ";

        }catch (Exception e){
            return "Error deleted request ";
        }
    }


    public String save( RoomDto roomDto){

        try{
            if (roomRepository.
                    existsByFloorAndNumberAndSizeAndHotel_Id(roomDto.getFloor(),
                            roomDto.getNumber(), roomDto.getSize(), roomDto.getHotelId()))
                return "This Room already exsist ";
            Optional<Hotel> optionalHotel = hotelRepository.findById(roomDto.getHotelId());
            if (!optionalHotel.isPresent())
                return "Hotel not found ";
            Hotel hotel = optionalHotel.get();
            Room room = new Room();
            room.setNumber(roomDto.getNumber());
            room.setFloor(roomDto.getFloor());
            room.setSize(roomDto.getSize());
            room.setHotel(hotel);
            roomRepository.save(room);
            return "Room saved ";

        }catch (Exception e){
            return "Error save ";
        }
    }

    public String update( Integer id , RoomDto roomDto){
    try{
        if (roomRepository.
                existsByFloorAndNumberAndSizeAndHotel_Id(roomDto.getFloor(),
                        roomDto.getNumber(), roomDto.getSize(), roomDto.getHotelId()))
            return "This Room already exsist ";
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if (optionalRoom.isPresent()){
            Room room = optionalRoom.get();
            Optional<Hotel> optionalHotel = hotelRepository.findById(roomDto.getHotelId());
            if (!optionalHotel.isPresent()) return "Hotel not found";
            Hotel hotel = optionalHotel.get();

            if (roomDto.getFloor() !=null ) room.setFloor(roomDto.getFloor());
            if (roomDto.getNumber() !=null ) room.setNumber(roomDto.getNumber());
            if (roomDto.getSize() !=null ) room.setSize(roomDto.getSize());
            room.setHotel(hotel);

            roomRepository.save(room);
            return "Update Rooms ";
        }
        return "Room not found";

    }catch (Exception e){
        return "Error update ";
    }
    }
}
