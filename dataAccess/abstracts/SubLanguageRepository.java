package kodlama.io.LanguageAdder.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.LanguageAdder.entities.concretes.SubLanguage;

public interface SubLanguageRepository extends JpaRepository<SubLanguage,Integer> {

}
