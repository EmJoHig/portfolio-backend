package portfolio.backend.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import java.sql.Timestamp;

@Entity
@Table(name = "skills")

public class Skills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre")
	private String Nombre;
	
	@Column(name = "porcentaje")
	private String Porcentaje;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "usuario_id")
	@JsonBackReference
	  private Usuario Usuario;
	
	public Skills() {

	}

	public Skills(Long id, String nombre, String porcentaje) {
		super();
		this.id = id;
		Nombre = nombre;
		Porcentaje = porcentaje;
		//this.Usuario = usuario;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getPorcentaje() {
		return Porcentaje;
	}

	public void setPorcentaje(String porcentaje) {
		Porcentaje = porcentaje;
	}
	
	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.Usuario = usuario;
	}

	
	
}
