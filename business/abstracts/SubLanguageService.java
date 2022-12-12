package kodlama.io.LanguageAdder.business.abstracts;

import java.util.List;

import kodlama.io.LanguageAdder.business.requests.SubLanguage.CreateSubLanguageRequest;
import kodlama.io.LanguageAdder.business.requests.SubLanguage.DeleteSubLanguageRequest;
import kodlama.io.LanguageAdder.business.requests.SubLanguage.UpdateSubLanguageRequest;
import kodlama.io.LanguageAdder.business.responses.Language.GetAllLanguagesResponse;
import kodlama.io.LanguageAdder.business.responses.Language.GetLanguagesByIdResponse;


public interface SubLanguageService {

	    List<GetAllLanguagesResponse>getAll();
	void add (CreateSubLanguageRequest createSubLanguageRequest ) throws Exception;
	void delete(DeleteSubLanguageRequest deleteSubLanguageRequest);
    void update(UpdateSubLanguageRequest updateSubLanguageRequest);
	GetLanguagesByIdResponse getId(int id);
	void update(int id, UpdateSubLanguageRequest updateSubLanguageRequest);
	static String getName(String name) {
		return name;
	}
	
}
