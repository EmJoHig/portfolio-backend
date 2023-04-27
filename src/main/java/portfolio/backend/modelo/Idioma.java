package portfolio.backend.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "idioma")

public class Idioma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre")
	private String Nombre;
	
	@Column(name = "porcentaje")
	private String Porcentaje;
	
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

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}

	public String getPorcentaje() {
		return Porcentaje;
	}

	public void setPorcentaje(String porcentaje) {
		Porcentaje = porcentaje;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	@JsonBackReference
	  private Usuario Usuario;
	
	public Idioma() {

	}

	public Idioma(Long id, String nombre, String porcentaje) {
		super();
		this.id = id;
		Nombre = nombre;
		Porcentaje = porcentaje;
	}
	
}
