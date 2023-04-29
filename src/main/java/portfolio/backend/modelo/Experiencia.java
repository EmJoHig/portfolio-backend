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
import java.util.List;

@Entity
@Table(name = "experiencia")

public class Experiencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "titulo")
	private String Titulo;
	
	@Column(name = "fechainicio")
	private Timestamp Fechainicio;
	
	@Column(name = "fechafin")
	private Timestamp Fechafin;
	
	@Column(name = "imagen")
	private String Imagen;
	
	@Column(name = "actividades")
	private String Actividades;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "usuario_id")
	  private Usuario Usuario;
	
	public Experiencia() {

	}
	
	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}

	public Experiencia(Long id, String titulo, Timestamp fechainicio, Timestamp fechafin, String imagen, String actividades) {
		super();
		this.id = id;
		Titulo = titulo;
		Fechainicio = fechainicio;
		Fechafin = fechafin;
		Imagen = imagen;
		Actividades = actividades;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitulo() {
		return Titulo;
	}


	public void setTitulo(String titulo) {
		Titulo = titulo;
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


	public String getImagen() {
		return Imagen;
	}


	public void setImagen(String imagen) {
		Imagen = imagen;
	}


	public String getActividades() {
		return Actividades;
	}


	public void setActividades(String actividades) {
		Actividades = actividades;
	}


	
	
}
