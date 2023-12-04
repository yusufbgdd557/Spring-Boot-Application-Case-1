package Kodlama.io.Devs.case4.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSubTechnologyRequest {

    private String subTechnologyName;

    private String programmingLanguageName;
}