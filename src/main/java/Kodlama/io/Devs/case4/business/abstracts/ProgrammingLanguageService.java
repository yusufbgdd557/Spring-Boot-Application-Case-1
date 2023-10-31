package Kodlama.io.Devs.case4.business.abstracts;

import Kodlama.io.Devs.case4.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {
    List<ProgrammingLanguage> getAll();
    ProgrammingLanguage getById(int id) throws Exception;
    ProgrammingLanguage deleteById(int id) throws Exception;
    void add(ProgrammingLanguage programmingLanguage) throws Exception;
    void update(ProgrammingLanguage programmingLanguage);
    //void delete(ProgrammingLanguage programmingLanguage);
}
