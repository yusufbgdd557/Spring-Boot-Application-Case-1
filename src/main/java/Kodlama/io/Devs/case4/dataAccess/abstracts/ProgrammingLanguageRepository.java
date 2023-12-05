package Kodlama.io.Devs.case4.dataAccess.abstracts;

import Kodlama.io.Devs.case4.entities.concretes.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer> {
    ProgrammingLanguage getByName(String name);

}
