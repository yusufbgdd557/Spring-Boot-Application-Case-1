package Kodlama.io.Devs.case4.business.concretes;

import Kodlama.io.Devs.case4.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.case4.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.case4.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    // Business Logics and Exception Handlings are dealt in Business Layer.
    private ProgrammingLanguageRepository programmingLanguageRepository;
    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguageRepository.getAll();
    }

    @Override
    public ProgrammingLanguage getById(int id) throws Exception {
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.getById(id);
        if (programmingLanguage == null){
            throw new Exception("There is no language to be brought with this id!");
        }
        return programmingLanguageRepository.getById(id);
    }

    @Override
    public ProgrammingLanguage deleteById(int id) throws Exception {
        if(getById(id) == null){
            throw new Exception("There is no language with this id");
        }
        return programmingLanguageRepository.deleteById(id);
    }

    @Override
    public void add(ProgrammingLanguage programmingLanguage) throws Exception{
        if (programmingLanguage.getName() == null){
            throw new Exception("Programming name can not be empty!");
        }
        for (ProgrammingLanguage theLanguage : programmingLanguageRepository.getAll()) {
            if (theLanguage.getName().equalsIgnoreCase(programmingLanguage.getName())){
                throw new Exception("Programming language can not repeat!");
            }
        }
        programmingLanguageRepository.add(programmingLanguage);
    }

    @Override
    public void update(ProgrammingLanguage programmingLanguage) {
        programmingLanguageRepository.update(programmingLanguage);
    }

//    @Override
//    public void delete(ProgrammingLanguage programmingLanguage) {
//        programmingLanguageRepository.delete(programmingLanguage);
//    }
}
