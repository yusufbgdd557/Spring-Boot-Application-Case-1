package Kodlama.io.Devs.case4.dataAccess.abstracts;

import Kodlama.io.Devs.case4.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageRepository {

    List<ProgrammingLanguage> getAll();
    ProgrammingLanguage getById(int id);
    ProgrammingLanguage deleteById(int id);
    void add(ProgrammingLanguage programmingLanguage);
    void update(ProgrammingLanguage programmingLanguage);
    //void delete(ProgrammingLanguage programmingLanguage);
}
