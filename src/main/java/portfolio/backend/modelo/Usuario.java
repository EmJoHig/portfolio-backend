package portfolio.backend.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import java.util.List;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "usuario")

public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombreusuario", nullable = false)
	private String nombreusuario;

	@Column(name = "nombre", nullable = false)
	private String Nombre;

	@Column(name = "apellido", nullable = false)
	private String Apellido;
	
	@Column(name = "titulo")
	private String Titulo;

	@Column(name = "contrasena", nullable = false)
	private String Contrasena;

	@Column(name = "imagenusuario")
	private String ImagenUsuario;

	@Column(name = "informacionpersonal")
	private String InformacionPersonal;
	
	@Column(name = "fechanacimiento")
	private Timestamp FechaNacimiento;
	
	@Column(name = "mail")
	private String Mail;

	@OneToMany(mappedBy = "Usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Interes> Intereses = new ArrayList<>();
	
	@OneToMany(mappedBy = "Usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Experiencia> Experiencias = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "Usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Educacion> Educaciones = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "Usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Skills> Skills = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "Usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Proyecto> Proyectos = new ArrayList<>();
	
	@OneToMany(mappedBy = "Usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Idioma> Idiomas = new ArrayList<>();
	
	//@ManyToMany(fetch = FetchType.EAGER)
	//@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),inverseJoinColumns = @JoinColumn(name = "rol_id"))
	//private Set<Rol> roles = new HashSet<>();
	
	public Usuario() {

	}

	public Usuario(Long id, String nombreusuario, String nombre, String apellido, String contrasena,
			Byte[] imagenbanner, String imagenUsuario, String informacionPersonal, String titulo, Timestamp fechaNacimiento, String mail, 
			List<Interes> intereses, List<Experiencia> experiencias, List<Educacion> educaciones, List<Skills> skills, List<Proyecto> proyectos, List<Idioma> idiomas) {
		super();
		this.id = id;
		nombreusuario = nombreusuario;
		Nombre = nombre;
		Apellido = apellido;
		Titulo = titulo;
		Contrasena = contrasena;
		ImagenUsuario = imagenUsuario;
		InformacionPersonal = informacionPersonal;
		FechaNacimiento = fechaNacimiento;
		Mail = mail;
		Intereses = intereses;
		Experiencias = experiencias;
		Educaciones = educaciones;
		Skills = skills;
		Proyectos = proyectos;
		Idiomas = idiomas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreusuario;
	}

	public void setNombreUsuario(String nombreusuario) {
		nombreusuario = nombreusuario;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	
	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getContrasena() {
		return Contrasena;
	}

	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}

	public String getImagenUsuario() {
		return ImagenUsuario;
	}

	public void setImagenUsuario(String imagenUsuario) {
		ImagenUsuario = imagenUsuario;
	}

	public String getInformacionPersonal() {
		return InformacionPersonal;
	}

	public void setInformacionPersonal(String informacionPersonal) {
		InformacionPersonal = informacionPersonal;
	}
	
	public Timestamp getFechaNacimiento() {
        return FechaNacimiento;
    }
	
	public void setFechaNacimiento(Timestamp fechaNacimiento) {
        this.FechaNacimiento = fechaNacimiento;
    }
	
	public String getMail() {
        return Mail;
    }
	
	public void setMail(String mail) {
        this.Mail = mail;
    }
	
	public List<Interes> getIntereses() {
	    return Intereses;
	}
	
	public void setIntereses(List<Interes> intereses) {
	    this.Intereses = intereses;
	}
	
	public List<Experiencia> getExperiencias() {
		return Experiencias;
	}

	public void setExperiencias(List<Experiencia> experiencias) {
		Experiencias = experiencias;
	}
		
	public List<Educacion> getEducaciones() {
		return Educaciones;
	}

	public void setEducaciones(List<Educacion> educaciones) {
		Educaciones = educaciones;
	}
		
	public List<Skills> getSkills() {
		return Skills;
	}

	public void setSkills(List<Skills> skills) {
		Skills = skills;
	}
		
	public List<Proyecto> getProyectos() {
		return Proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		Proyectos = proyectos;
	}
		
	public List<Idioma> getIdiomas() {
		return Idiomas;
	}

	public void setIdiomas(List<Idioma> idiomas) {
		Idiomas = idiomas;
	}
	
	/*public Set<Rol> getRoles() {
		return roles;
	}


	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}*/
}
