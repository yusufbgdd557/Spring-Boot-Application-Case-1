package Kodlama.io.Devs.case4.business.abstracts;

import Kodlama.io.Devs.case4.business.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.case4.business.responses.GetAllProgrammingLanguagesResponse;
import Kodlama.io.Devs.case4.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {
    List<GetAllProgrammingLanguagesResponse> getAll();
    ProgrammingLanguage getById(int id) throws Exception;
    void deleteById(int id) throws Exception;
    void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;
    void update(ProgrammingLanguage programmingLanguage) throws Exception;
    void deleteByName(String name) throws Exception;
}
