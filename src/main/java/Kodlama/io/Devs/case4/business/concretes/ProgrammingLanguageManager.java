package Kodlama.io.Devs.case4.business.concretes;

import Kodlama.io.Devs.case4.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.case4.core.utilities.mappers.ModelMapperService;
import Kodlama.io.Devs.case4.dtos.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.case4.dtos.requests.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.case4.dtos.responses.GetAllProgrammingLanguagesResponse;
import Kodlama.io.Devs.case4.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.case4.dtos.responses.GetByIdProgrammingLanguageResponse;
import Kodlama.io.Devs.case4.entities.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    // Business Logics and Exception Handlings are dealt in Business Layer.
    @Autowired
    private ProgrammingLanguageRepository programmingLanguageRepository;
    @Autowired
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllProgrammingLanguagesResponse> getAll() {

        List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
        List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponse = programmingLanguages.stream()
                .map(programmingLanguage -> this.modelMapperService.forResponse()
                        .map(programmingLanguage, GetAllProgrammingLanguagesResponse.class)).collect(Collectors.toList());
        return programmingLanguagesResponse;
        // Manuel mapping
//        for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
//            GetAllProgrammingLanguagesResponse responseItem = new GetAllProgrammingLanguagesResponse();
//            responseItem.setId(programmingLanguage.getId());
//            responseItem.setName(programmingLanguage.getName());
//            programmingLanguagesResponse.add(responseItem);
//        }
//        //Sort sort = Sort.by(Sort.Order.asc("id"));
//        return programmingLanguagesResponse;

    }
    // This does not work and i can not get why!P
//    @Override
//    public ProgrammingLanguage getById(int id) throws Exception {
//
//        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.getById(id);
//
//        if (programmingLanguage == null){
//            throw new Exception("There is no language to be brought with this id!");
//        }
//
//        return programmingLanguage;
//    }

    //This one works but in a list of millions of items it would be dead slow so i avoid using it!
//    public ProgrammingLanguage getById(int id) throws Exception{
//        List<ProgrammingLanguage> allLanguages = programmingLanguageRepository.findAll();
//        for (ProgrammingLanguage theLanguage : allLanguages) {
//            if (theLanguage.getId() == id){
//                return theLanguage;
//            }
//        }
//        return null;
//    }

    @Override
    public GetByIdProgrammingLanguageResponse getById(int id) throws Exception{
        Optional<ProgrammingLanguage> optionalProgrammingLanguage = programmingLanguageRepository.findById(id);// Here i used Optional to be able to see if the given id is null or not

        if (optionalProgrammingLanguage.isEmpty()){
            throw new Exception("There is no language to be brought with this id!");
        }
        GetByIdProgrammingLanguageResponse response = this.modelMapperService
                .forResponse().map(optionalProgrammingLanguage, GetByIdProgrammingLanguageResponse.class);
        return response;
    }

    @Override
    public void deleteById(int id) throws Exception {

        if(getById(id) == null){
            throw new Exception("There is no language with this id");
        }

        this.programmingLanguageRepository.deleteById(id);
    }

    @Override
    public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception{

        if (createProgrammingLanguageRequest.getName() == null){
            throw new Exception("Programming name can not be empty!");
        }
        for (ProgrammingLanguage theLanguage : programmingLanguageRepository.findAll()) {
            if (theLanguage.getName().equalsIgnoreCase(createProgrammingLanguageRequest.getName())){
                throw new Exception("Programming language can not repeat!");
            }
        }
        ProgrammingLanguage programmingLanguage = this.modelMapperService
                .forRequest()
                .map(createProgrammingLanguageRequest, ProgrammingLanguage.class);
        this.programmingLanguageRepository.save(programmingLanguage);

        // Veritabanı Programming Language'dan anlıyor. O yüzden programmingLanguage döndürüyoruz.
        //Manuel Mapping
//        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
//        programmingLanguage.setName(createProgrammingLanguageRequest.getName());
//        this.programmingLanguageRepository.save(programmingLanguage);

    }

    @Override
    public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguage) throws Exception {

        ProgrammingLanguage programmingLanguage = this.modelMapperService
                .forRequest()
                .map(updateProgrammingLanguage, ProgrammingLanguage.class);
        this.programmingLanguageRepository.save(programmingLanguage);

//        try {
//            UpdateProgrammingLanguageRequest theLanguage = getById(updateProgrammingLanguage.getId());
//
//                theLanguage.setName(updateProgrammingLanguage.getName());
//                this.programmingLanguageRepository.save(theLanguage);
//
//        }
//        catch (Exception e){
//            throw new Exception("There is no such Programming Language with this name to update --> " + updateProgrammingLanguage.getId());
//        }


//        for (ProgrammingLanguage theLanguage : allLanguages) {
//            if(theLanguage.getId() == programmingLanguage.getId()){
//                theLanguage.setName(programmingLanguage.getName());
//                this.programmingLanguageRepository.save(theLanguage);
//                return; //The Programming Language name is updated and function is finished and ended. If not then exception will be thrown...
//            }
//        }

    }


    //This function is unnecessary. Because the items would have a unique parameter which is "id" so that function written for fun :D
    //Because in a list of million items that would be so slow function. Like for long terms it's not recommended!
    @Override
    public void deleteByName(String name) throws Exception {

        List<ProgrammingLanguage> allLanguages = programmingLanguageRepository.findAll();

        for (ProgrammingLanguage theLanguage : allLanguages) {
            if (theLanguage.getName().equalsIgnoreCase(name)){
                this.programmingLanguageRepository.delete(theLanguage);
                return;
            }
        }
        throw new Exception("There is no such Programmin Language with this name --> " + name);
    }

}
