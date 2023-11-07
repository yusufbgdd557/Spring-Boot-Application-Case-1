package Kodlama.io.Devs.case4.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllProgrammingLanguagesResponse {

    private int id;
    private String name;
    //Burada ise son kullanıcı bir veri isterse ona veriyi döneceğiz.
}
