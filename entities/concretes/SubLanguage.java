package kodlama.io.LanguageAdder.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="subLanguage")
public class SubLanguage {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name="name")
	private String Name;
	
	
	
	@ManyToOne
	@JoinColumn(name = "language_id")
	private Language language;



	public String setName(String string) {
       return string;	
	}



	public SubLanguage setLanguage(SubLanguage language2) {
      return language2;		
	}
}
