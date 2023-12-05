package Kodlama.io.Devs.case4.business.abstracts;

import Kodlama.io.Devs.case4.dtos.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.case4.dtos.requests.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.case4.dtos.responses.GetAllProgrammingLanguagesResponse;
import Kodlama.io.Devs.case4.dtos.responses.GetByIdProgrammingLanguageResponse;
import Kodlama.io.Devs.case4.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {
    List<GetAllProgrammingLanguagesResponse> getAll();
    GetByIdProgrammingLanguageResponse getById(int id) throws Exception;
    void deleteById(int id) throws Exception;
    void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;
    void update(UpdateProgrammingLanguageRequest updateProgrammingLanguage) throws Exception;
    void deleteByName(String name) throws Exception;
}
