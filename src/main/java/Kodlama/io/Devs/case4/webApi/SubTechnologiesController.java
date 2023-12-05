package Kodlama.io.Devs.case4.webApi;

import Kodlama.io.Devs.case4.business.abstracts.SubTechnologyService;
import Kodlama.io.Devs.case4.dtos.requests.CreateSubTechnologyRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/subTechnologies")
public class SubTechnologiesController {

    @Autowired
    private final SubTechnologyService subTechnologyService;

    @PostMapping("/add")
    public void addSubTechnology(@RequestBody CreateSubTechnologyRequest createSubTechnologyRequest) {
        this.subTechnologyService.addSubTechnology(createSubTechnologyRequest);
    }

}
