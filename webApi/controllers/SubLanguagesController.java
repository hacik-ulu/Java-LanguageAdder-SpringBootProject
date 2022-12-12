package kodlama.io.LanguageAdder.webApi.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.LanguageAdder.business.abstracts.SubLanguageService;
import kodlama.io.LanguageAdder.business.requests.SubLanguage.CreateSubLanguageRequest;
import kodlama.io.LanguageAdder.business.requests.SubLanguage.DeleteSubLanguageRequest;
import kodlama.io.LanguageAdder.business.requests.SubLanguage.UpdateSubLanguageRequest;
import kodlama.io.LanguageAdder.business.responses.Language.GetAllLanguagesResponse;
import kodlama.io.LanguageAdder.business.responses.Language.GetLanguagesByIdResponse;

@RestController
@RequestMapping("/api/sub-languages")

public class SubLanguagesController {

	private SubLanguageService subLanguageService;

	@Autowired
	public SubLanguagesController(SubLanguageService subLanguageService) {
		this.subLanguageService = subLanguageService;
	}
	
	@GetMapping("/get-subLanguage")
    public List<GetAllLanguagesResponse> getAll(){
       return this.subLanguageService.getAll(); 
    }
	
	@PostMapping("/add-subLanguage")
    public void add(CreateSubLanguageRequest createLanguageRequest) throws Exception{
        this.subLanguageService.add(createLanguageRequest);
    }
	
	@DeleteMapping("/delete-subLanguage")
	public void delete(DeleteSubLanguageRequest deleteSubLanguageRequest) {
		this.subLanguageService.delete(deleteSubLanguageRequest);
	}
	
	@PutMapping("/update-subLanguage")
	public void update(UpdateSubLanguageRequest updateSubLanguageRequest) {
		this.subLanguageService.update(updateSubLanguageRequest);
	}
	
	@GetMapping("/get-tech/{id}")
    public GetLanguagesByIdResponse getId(int id){
        return this.subLanguageService.getId(id);
    }

}


//buraya bak