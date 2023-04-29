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
import java.util.List;

@Entity
@Table(name = "proyecto")

public class Proyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre")
	private String Nombre;
		
	@Column(name = "descripcion")
	private String Descripcion;
	
	@Column(name = "fecha")
	private Timestamp Fecha;
	
	@Column(name = "imagen")
	private String Imagen;
	
	@Column(name = "link")
	private String Link;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "usuario_id")
	@JsonBackReference
	  private Usuario Usuario;
	
	public Proyecto() {

	}
	
	public Proyecto(Long id, String nombre, String descripcion, Timestamp fecha, String imagen, String link) {
		super();
		this.id = id;
		Nombre = nombre;
		Descripcion = descripcion;
		Fecha = fecha;
		Imagen = imagen;
		Link = link;
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

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Timestamp getFecha() {
		return Fecha;
	}

	public void setFecha(Timestamp fecha) {
		Fecha = fecha;
	}

	public String getImagen() {
		return Imagen;
	}

	public void setImagen(String imagen) {
		Imagen = imagen;
	}

	public String getLink() {
		return Link;
	}

	public void setLink(String link) {
		Link = link;
	}
	
	
}
