package hotel.uz.mehmonxona.controller;

import hotel.uz.mehmonxona.entity.Hotel;
import hotel.uz.mehmonxona.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService ;

    @GetMapping
    public List<Hotel> getAll(){
        return hotelService.getAll();
    }

    @GetMapping("/{id}")
    public  Hotel get(@PathVariable Integer id){
        return hotelService.getOne(id);
    }

    @PostMapping
    public String save(@RequestBody Hotel hotel){
        return hotelService.save(hotel);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        return hotelService.delete(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Integer id , @RequestBody Hotel hotel){
        return hotelService.update(id,hotel);
    }


}
