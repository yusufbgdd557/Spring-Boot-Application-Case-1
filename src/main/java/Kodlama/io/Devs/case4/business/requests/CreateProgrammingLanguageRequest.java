package Kodlama.io.Devs.case4.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProgrammingLanguageRequest {

    private String name;
    //Burada son kullanıcıdan bir veri alacağız ve veritabanına ekleyeceğiz.
}
