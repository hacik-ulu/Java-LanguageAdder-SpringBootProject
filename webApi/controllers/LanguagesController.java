package kodlama.io.LanguageAdder.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.LanguageAdder.business.abstracts.LanguageService;
import kodlama.io.LanguageAdder.business.requests.Language.CreateLanguageRequest;
import kodlama.io.LanguageAdder.business.requests.Language.DeleteLanguageRequest;
import kodlama.io.LanguageAdder.business.requests.Language.UpdateLanguageRequest;
import kodlama.io.LanguageAdder.business.responses.Language.GetAllLanguagesResponse;
import kodlama.io.LanguageAdder.business.responses.Language.GetLanguagesByIdResponse;

//LanguageService'i kullanır.

@RestController//annotation
@RequestMapping("/api/languages")
public class LanguagesController {

	private LanguageService languageService;
	
	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
	public List<GetAllLanguagesResponse>getAll(){
		return languageService.getAll();
		
	}
	
	@PostMapping("/add")
	public void add(CreateLanguageRequest createLanguageRequest) {
		this.languageService.add(createLanguageRequest);
	}
	
	
	@PutMapping("/update")
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		this.languageService.update(updateLanguageRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		this.languageService.delete(deleteLanguageRequest);
	}
	
	 @GetMapping("/getId/{id}")
	    public GetLanguagesByIdResponse getById(int id){
	        return languageService.getId(id);
	    }
}

//buraya bak