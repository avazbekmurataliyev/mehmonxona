package hotel.uz.mehmonxona.controller;

import hotel.uz.mehmonxona.entity.Room;
import hotel.uz.mehmonxona.payload.RoomDto;
import hotel.uz.mehmonxona.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService ;

    @GetMapping
    public List<Room> getAll(){
        return roomService.getAll();
    }

    @GetMapping("/{id}")
    public Page<Room> get(@PathVariable Integer id , @RequestParam Integer page){

        Pageable pageable = PageRequest.of(page, 10);
        return roomService.getOneHotelRooms(id, pageable);
    }

    @PostMapping
    public String save(@RequestBody RoomDto roomDto){
        return roomService.save(roomDto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        return roomService.delete(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Integer id , @RequestBody RoomDto roomDto){
        return roomService.update(id,roomDto);
    }


}
