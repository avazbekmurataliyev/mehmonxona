package hotel.uz.mehmonxona.service;

import hotel.uz.mehmonxona.entity.Hotel;
import hotel.uz.mehmonxona.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository ;

    public List<Hotel> getAll(){
        return hotelRepository.findAll();
    }

    public Hotel getOne( Integer id){
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        if (optionalHotel.isPresent()){
            return optionalHotel.get();
        }
        return new Hotel();
    }

    public String delete( Integer id){
        try{
            Optional<Hotel> optionalHotel = hotelRepository.findById(id);
            if (optionalHotel.isPresent())
            {
                hotelRepository.deleteById(id);
                return "Delete success";
            }
        return " This hotel Not found error ";

        }catch (Exception e){
            return "Error deleted request ";
        }
    }


    public String save( Hotel hotel){

        try{
            if (!hotel.getName().isEmpty()){
            hotelRepository.save(hotel);
            return "Saved ";}
            return "Hotel name is empty";
        }catch (Exception e){
            return "Error save ";
        }
    }

    public String update( Integer id , Hotel hotel){

        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        if (optionalHotel.isPresent()){
            Hotel hotel1 = optionalHotel.get();
            if (hotel.getName().isEmpty()){
                return "This hotel name is empty ";
            }
            hotel1.setName(hotel.getName());
            hotelRepository.save(hotel1);
            return "Hotel name is updated ";
        }
        return "Hotel not found";
    }

}
