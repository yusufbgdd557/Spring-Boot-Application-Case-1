package Kodlama.io.Devs.case4.dataAccess.concretes;

import Kodlama.io.Devs.case4.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.case4.entities.concretes.ProgrammingLanguage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

    List<ProgrammingLanguage> programmingLanguages;

    public InMemoryProgrammingLanguageRepository() {
        programmingLanguages = new ArrayList<>();
        programmingLanguages.add(new ProgrammingLanguage(1,"Java"));
        programmingLanguages.add(new ProgrammingLanguage(2,"C#"));
        programmingLanguages.add(new ProgrammingLanguage(3,"Python"));
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguages;
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        for (ProgrammingLanguage theLanguage : programmingLanguages) {
            if(theLanguage.getId() == id)
                return theLanguage;
        }
        return null;
    }

    @Override
    public ProgrammingLanguage deleteById(int id) {
        for (ProgrammingLanguage theLanguage : programmingLanguages) {
            if(id == theLanguage.getId()){
                programmingLanguages.remove(theLanguage);
            }
        }
        return null;
    }

    @Override
    public void add(ProgrammingLanguage programmingLanguage)  {
        programmingLanguages.add(programmingLanguage);
    }

    @Override
    public void update(ProgrammingLanguage programmingLanguage) {
        for (ProgrammingLanguage theLanguage : programmingLanguages) {
            if(theLanguage.getId() == programmingLanguage.getId()){
                theLanguage.setName(programmingLanguage.getName());
            }
        }
    }

//    @Override
//    public void delete(ProgrammingLanguage programmingLanguage) {
//        for (ProgrammingLanguage theLanguage : programmingLanguages) {
//            if(theLanguage.getId() == programmingLanguage.getId()){
//                programmingLanguages.remove(programmingLanguage);
//            }
//        }
//    }

}
