package portfolio.backend.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
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
@Table(name = "educacion")

public class Educacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre")
	private String Nombre;
	
	@Column(name = "logo")
	private String Logo;
	
	@Column(name = "titulocarrera")
	private String Titulocarrera;
	
	@Column(name = "fechainicio")
	private Timestamp Fechainicio;
	
	@Column(name = "fechafin")
	private Timestamp Fechafin;
	
	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "usuario_id")
	  private Usuario Usuario;
	
	public Educacion() {

	}

	public Educacion(Long id, String nombre, Timestamp fechainicio, Timestamp fechafin, String logo, String titulocarrera) {
		super();
		this.id = id;
		Nombre = nombre;
		Fechainicio = fechainicio;
		Fechafin = fechafin;
		Logo = logo;
		Titulocarrera = titulocarrera;
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

	public String getLogo() {
		return Logo;
	}

	public void setLogo(String logo) {
		Logo = logo;
	}

	public String getTitulocarrera() {
		return Titulocarrera;
	}

	public void setTitulocarrera(String titulocarrera) {
		Titulocarrera = titulocarrera;
	}

	public Timestamp getFechainicio() {
		return Fechainicio;
	}

	public void setFechainicio(Timestamp fechainicio) {
		Fechainicio = fechainicio;
	}

	public Timestamp getFechafin() {
		return Fechafin;
	}

	public void setFechafin(Timestamp fechafin) {
		Fechafin = fechafin;
	}	
}
