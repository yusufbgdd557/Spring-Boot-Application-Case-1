package Kodlama.io.Devs.case4.dataAccess.abstracts;

import Kodlama.io.Devs.case4.entities.concretes.SubTechnology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTechnologyRepository extends JpaRepository<SubTechnology, Integer> {

}
