package kodlama.io.LanguageAdder.business.requests.SubLanguage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSubLanguageRequest {

	private String name;
	private int languageId;

}
