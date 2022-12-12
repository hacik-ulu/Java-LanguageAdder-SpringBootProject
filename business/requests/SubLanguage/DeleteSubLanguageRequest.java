package kodlama.io.LanguageAdder.business.requests.SubLanguage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DeleteSubLanguageRequest {

	DeleteSubLanguageRequest deleteSubLanguageRequest;
	private int Id;

	public DeleteSubLanguageRequest getName() {
		return deleteSubLanguageRequest;
	}

	
}
