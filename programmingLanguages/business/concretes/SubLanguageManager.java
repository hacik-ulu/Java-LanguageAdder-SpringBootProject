package kodlama.io.programmingLanguages.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.LanguageAdder.business.abstracts.SubLanguageService;
import kodlama.io.LanguageAdder.business.requests.SubLanguage.CreateSubLanguageRequest;
import kodlama.io.LanguageAdder.business.requests.SubLanguage.DeleteSubLanguageRequest;
import kodlama.io.LanguageAdder.business.requests.SubLanguage.UpdateSubLanguageRequest;
import kodlama.io.LanguageAdder.business.responses.Language.GetAllLanguagesResponse;
import kodlama.io.LanguageAdder.business.responses.Language.GetLanguagesByIdResponse;
import kodlama.io.LanguageAdder.dataAccess.abstracts.SubLanguageRepository;
import kodlama.io.LanguageAdder.entities.concretes.SubLanguage;


@Service
public abstract class SubLanguageManager implements SubLanguageService {
	
	 private SubLanguageRepository subLanguageRepository;
	 private SubLanguageRepository languageRepository;
	
	public SubLanguageManager(SubLanguageRepository subLanguageRepository, SubLanguageRepository languageRepository) {
		super();
		this.subLanguageRepository = subLanguageRepository;
		this.languageRepository = languageRepository;
	}

	public SubLanguageManager(SubLanguageRepository subLanguageRepository) {
		this.subLanguageRepository = subLanguageRepository;
	}

	@Override
	public List<GetAllLanguagesResponse> getAll() {
		 List<SubLanguage> subLanguages = subLanguageRepository.findAll();
	     List<GetAllLanguagesResponse> subLanguagesResponse = new ArrayList<GetAllLanguagesResponse>();

	        for (SubLanguage subLanguage : subLanguages) {
	            GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
	            responseItem.setId(subLanguage.getId());
	            responseItem.setName(subLanguage.getName());

	            subLanguagesResponse.add(responseItem);
	        }
		return subLanguagesResponse;
	}

	@Override
	public void add(CreateSubLanguageRequest createSubLanguageRequest) {
		 SubLanguage subLanguage = new SubLanguage();
	        subLanguage.setName(createSubLanguageRequest.getName());
	        SubLanguage sublanguage = languageRepository.findById(createSubLanguageRequest.getLanguageId()).get();
	        subLanguage.setLanguage(sublanguage);
	        if (!isExist(sublanguage)) {
	            subLanguageRepository.save(sublanguage);
	        } else {
	            throw new RuntimeException("Bu dil zaten eklenmiş.");
	        }

		
	}

	@Override
	public GetLanguagesByIdResponse getId(int id) {
		
		SubLanguage subLanguageTechnology = this.subLanguageRepository.findById(id).get();
        GetLanguagesByIdResponse getLanguageTechByIdResponse = new GetLanguagesByIdResponse();

        getLanguageTechByIdResponse.setName(subLanguageTechnology.getName());
        getLanguageTechByIdResponse.setId(id);


        return getLanguageTechByIdResponse;
	}

	 public boolean isExist(SubLanguage subLanguageTechnology) {
	        boolean exist = false;
	        List<SubLanguage> subLanguage = subLanguageRepository.findAll();
	        for (SubLanguage subLangTech : subLanguage) {
	            if (subLanguageTechnology.getName().toLowerCase().equals(subLangTech.getName().toLowerCase())) {
	                if (subLanguageTechnology.getLanguage().equals(subLangTech.getLanguage())) {
	                    exist = true;
	                    return exist;
	                }
	            }
	        }
	        return exist;
	    }

	@Override
	public void delete(DeleteSubLanguageRequest deleteSubLanguageRequest) {
		this.subLanguageRepository.deleteById(deleteSubLanguageRequest.getId());
		
	}

	@Override
	public void update(int id,UpdateSubLanguageRequest updateSubLanguageRequest) {
		    SubLanguage subLanguage = subLanguageRepository.findById(updateSubLanguageRequest.getId()).get();
	        subLanguage.setName(updateSubLanguageRequest.getName());
	        SubLanguage language = languageRepository.findById(updateSubLanguageRequest.getLanguageId()).get();
	        subLanguage.setLanguage(language);
	        this.subLanguageRepository.save(subLanguage);		
	}

	

	

	
	
}