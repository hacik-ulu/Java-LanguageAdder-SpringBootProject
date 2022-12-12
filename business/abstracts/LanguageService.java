package kodlama.io.LanguageAdder.business.abstracts;

import java.util.List;

import kodlama.io.LanguageAdder.business.requests.Language.CreateLanguageRequest;
import kodlama.io.LanguageAdder.business.requests.Language.DeleteLanguageRequest;
import kodlama.io.LanguageAdder.business.requests.Language.UpdateLanguageRequest;
import kodlama.io.LanguageAdder.business.responses.Language.GetAllLanguagesResponse;
import kodlama.io.LanguageAdder.business.responses.Language.GetLanguagesByIdResponse;


//İş kurallarının yapılacağı yapı hazırlanır.


public interface LanguageService {

	    List<GetAllLanguagesResponse>getAll();
	void add(CreateLanguageRequest createLanguageRequest);
	void update(UpdateLanguageRequest updateLanguageRequest );
	void delete(DeleteLanguageRequest deleteLanguageRequest);
	GetLanguagesByIdResponse getId(int id);
}
