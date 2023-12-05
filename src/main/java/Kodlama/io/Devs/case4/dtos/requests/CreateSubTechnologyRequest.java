package Kodlama.io.Devs.case4.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSubTechnologyRequest {

    //Bu sınıfın var olmasının sebebi. Kullanıcıya veritabanını tamamen açmamaktır.
    private String subTechnologyName;

    private String programmingLanguageName;

}
