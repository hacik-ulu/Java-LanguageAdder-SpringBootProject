package kodlama.io.LanguageAdder.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.LanguageAdder.entities.concretes.Language;

public interface LanguageRepository extends JpaRepository<Language,Integer> {

}
