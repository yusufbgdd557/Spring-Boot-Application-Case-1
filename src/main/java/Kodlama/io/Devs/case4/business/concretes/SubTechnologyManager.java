package Kodlama.io.Devs.case4.business.concretes;

import Kodlama.io.Devs.case4.business.abstracts.SubTechnologyService;
import Kodlama.io.Devs.case4.core.utilities.mappers.ModelMapperService;
import Kodlama.io.Devs.case4.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.case4.dataAccess.abstracts.SubTechnologyRepository;
import Kodlama.io.Devs.case4.dtos.requests.CreateSubTechnologyRequest;
import Kodlama.io.Devs.case4.entities.concretes.ProgrammingLanguage;
import Kodlama.io.Devs.case4.entities.concretes.SubTechnology;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubTechnologyManager implements SubTechnologyService {

    @Autowired
    private final SubTechnologyRepository subTechnologyRepository;
    @Autowired
    private final ModelMapperService modelMapperService;
    @Autowired
    private final ProgrammingLanguageRepository programmingLanguageRepository;

    @Override
    public void addSubTechnology(CreateSubTechnologyRequest createSubTechnologyRequest) {
        // Create a new SubTechnology object from the request using ModelMapper
        SubTechnology subTechnology = this.modelMapperService.forRequest().map(createSubTechnologyRequest, SubTechnology.class);

        // Get the programming language by name from the repository
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.getByName(createSubTechnologyRequest.getProgrammingLanguageName());

        // Set the programming language for the subTechnology
        subTechnology.setProgrammingLanguage(programmingLanguage);
        // Set the sub technology name
        subTechnology.setName(createSubTechnologyRequest.getSubTechnologyName());

        // Save the subTechnology to the repository
        this.subTechnologyRepository.save(subTechnology);
    }


//    @Override
//    public void addSubTechnology(CreateSubTechnologyRequest createSubTechnologyRequest) {
//
//        SubTechnology subTechnology = this.modelMapperService.forRequest().map(createSubTechnologyRequest, SubTechnology.class);
//        this.subTechnologyRepository.save(subTechnology);
//
////        SubTechnology subTechnology = new SubTechnology();
////        subTechnology.setName(createSubTechnologyRequest.getSubTechnologyName());
////        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.getByName(createSubTechnologyRequest.getProgrammingLanguageName());
////        subTechnology.setProgrammingLanguage(programmingLanguage);
////        subTechnologyRepository.save(subTechnology);
//    }
}
