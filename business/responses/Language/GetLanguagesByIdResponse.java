package kodlama.io.LanguageAdder.business.responses.Language;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetLanguagesByIdResponse {

	private int id;
	private String name;
	
}
