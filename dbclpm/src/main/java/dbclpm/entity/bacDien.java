package dbclpm.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class bacDien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long price;
	
	private String name;
	
	private String description;
	
	@OneToMany(mappedBy = "bacDien")
	private List<luongDienTieuThu> list = new ArrayList<>();
	

	public bacDien() {
		// TODO Auto-generated constructor stub
	}

}