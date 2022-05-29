package uz.pdp.appjparelationships.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentDto {

private String firstName ;

    private String lastName;

    private Integer groupId ;

    private Integer addressId ;

    private List<Integer> subjectsId ;
}
