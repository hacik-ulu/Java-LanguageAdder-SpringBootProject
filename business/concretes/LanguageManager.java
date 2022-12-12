package kodlama.io.LanguageAdder.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.LanguageAdder.business.abstracts.LanguageService;
import kodlama.io.LanguageAdder.business.requests.Language.CreateLanguageRequest;
import kodlama.io.LanguageAdder.business.requests.Language.DeleteLanguageRequest;
import kodlama.io.LanguageAdder.business.requests.Language.UpdateLanguageRequest;
import kodlama.io.LanguageAdder.business.responses.Language.GetAllLanguagesResponse;
import kodlama.io.LanguageAdder.business.responses.Language.GetLanguagesByIdResponse;
import kodlama.io.LanguageAdder.dataAccess.abstracts.LanguageRepository;
import kodlama.io.LanguageAdder.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllLanguagesResponse>getAll(){
		
		List<Language> languages = languageRepository.findAll(); //veritabanından gelen sonuclar.
		List<GetAllLanguagesResponse> languagesResponse = new ArrayList<GetAllLanguagesResponse>(); // boş liste oluşturuldu.
		
		for (Language language : languages){
            GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
            responseItem.setId(language.getId());
            responseItem.setName(language.getName());

            languagesResponse.add(responseItem);
        }
        
        return languagesResponse;
    }

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {

		Language language = new Language();
		language.setName(createLanguageRequest.getName());
		if(!isExist(language)) {
		this.languageRepository.save(language);
		} else {
			throw new RuntimeException("Bu dil zaten ekli!");
		}
	}

	public boolean isExist(Language language){
        boolean exist = false;
        List<Language> languages = languageRepository.findAll();
        for (Language lang : languages){
            if (lang.getName().toLowerCase().equals(language.getName().toLowerCase())) {
                exist = true;
                return exist;
            }
        }
        return exist;
    }

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) {

		Language language = this.languageRepository.findById(updateLanguageRequest.getId()).get();
		if(!isExist(language)) {
			language.setName(updateLanguageRequest.getName());
			this.languageRepository.save(language);
		}else {
			 throw new RuntimeException("Bu dil mevcut");
		}
		
		
	}

	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		 this.languageRepository.deleteById(deleteLanguageRequest.getId());

	}

	@Override
	public GetLanguagesByIdResponse getId(int id) {
		 Language language = this.languageRepository.findById(id).get();
	     GetLanguagesByIdResponse byIdResponse =  new GetLanguagesByIdResponse();
	     byIdResponse.setName(language.getName());
	     byIdResponse.setId(language.getId());
		 return byIdResponse;		
	}


	

}


//buraya bak