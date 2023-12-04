package Kodlama.io.Devs.case4.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SubTechnologies")
@Entity
public class SubTechnology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "programming_language_id", referencedColumnName = "id")//Programming Language sınıfındaki "Id"den besleniyor ve bu tabloya eklenen yeni kolonun adı "programming_language_id" olacak
    private ProgrammingLanguage programmingLanguage;

}
