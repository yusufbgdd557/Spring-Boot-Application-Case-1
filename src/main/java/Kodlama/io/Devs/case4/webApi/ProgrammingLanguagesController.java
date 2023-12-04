package Kodlama.io.Devs.case4.webApi;

import Kodlama.io.Devs.case4.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.case4.dtos.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.case4.dtos.responses.GetAllProgrammingLanguagesResponse;
import Kodlama.io.Devs.case4.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguagesController {

    private ProgrammingLanguageService programmingLanguageService;

    @Autowired
    public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping("/getAll")
    List<GetAllProgrammingLanguagesResponse> getAll(){
        return programmingLanguageService.getAll();
    }

    @GetMapping("/getById/{id}")
    ProgrammingLanguage getById(@PathVariable int id) throws Exception {
        return programmingLanguageService.getById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable int id) throws Exception {
         this.programmingLanguageService.deleteById(id);
    }

    @DeleteMapping("/deletebyname/{name}")
    public void deleteByName(@PathVariable String name) throws Exception {
        this.programmingLanguageService.deleteByName(name);
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
         programmingLanguageService.add(createProgrammingLanguageRequest);
    }

    @PutMapping("/update")
    public void updateById(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
        this.programmingLanguageService.update(programmingLanguage);
    }

}
