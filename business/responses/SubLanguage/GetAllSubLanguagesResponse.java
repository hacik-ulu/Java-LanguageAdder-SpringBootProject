package kodlama.io.LanguageAdder.business.responses.SubLanguage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor



public class GetAllSubLanguagesResponse {

	private int id;
	private String name;
	private String language;
	
}
