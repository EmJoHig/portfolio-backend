package portfolio.backend.controlador;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
//import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/*import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;*/
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import portfolio.backend.repositorio.UsuarioRepositorio;
//import portfolio.backend.security.jwt.JwtProvider;
import portfolio.backend.repositorio.ProyectoRepositorio;
import portfolio.backend.repositorio.SkillsRepositorio;
import portfolio.backend.repositorio.IdiomaRepositorio;
import portfolio.backend.repositorio.EducacionRepositorio;
import portfolio.backend.repositorio.ExperienciaRepositorio;
import portfolio.backend.repositorio.InteresRepositorio;

import portfolio.backend.excepciones.ResourceNotFoundException;
import portfolio.backend.modelo.Proyecto;
import portfolio.backend.modelo.Usuario;
import portfolio.backend.modelo.Skills;
import portfolio.backend.modelo.Idioma;
import portfolio.backend.modelo.Educacion;
import portfolio.backend.modelo.Experiencia;
import portfolio.backend.modelo.Interes;
import portfolio.backend.modelo.Mensaje;
//import portfolio.backend.modelo.JwtDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import portfolio.backend.modelo.Usuario;

//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import portfolio.backend.security.service.UsuarioService;
//import portfolio.backend.security.jwt.JwtProvider; 
//import portfolio.backend.security.service.RolService;




@RestController
@RequestMapping("/api/v1")
//@Import(SecurityConfig.class)
//@CrossOrigin(origins="http://localhost:4200/")
@CrossOrigin(origins="https://frontprueba-4d0fb.web.app")
public class UsuarioControllador {

	@Autowired
	private UsuarioRepositorio repositorio;
	
	@Autowired
	private ProyectoRepositorio repositorioProyecto;
	
	@Autowired
	private SkillsRepositorio repositorioSkills;
	
	@Autowired
	private IdiomaRepositorio repositorioIdioma;
	
	@Autowired
	private EducacionRepositorio repositorioEducacion;
	
	@Autowired
	private ExperienciaRepositorio repositorioExperiencia;
	
	@Autowired
	private InteresRepositorio repositorioInteres;
	
	/*@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;*/

	//@Autowired
	//JwtProvider jwtProvider;
	
	
	@GetMapping("/usuarios")
	public List<Usuario> listarTodosLosUsuarios() {
		return repositorio.findAll();
	}

	@GetMapping("/usuario")
	public Usuario buscarUsuarioPorNombre(@RequestParam("nombreusuario") String nombreusuario) {
		Usuario usuario = repositorio.buscarPorNombreUsuario(nombreusuario);
	    return usuario;
	}
	
	
	@GetMapping("/usuario/{id}")
	public Usuario buscarUsuarioPorId(@PathVariable Long id) {
		Usuario usuario = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("No hay usuario con ese identificador"));
	    return usuario;
	}
	
	//PROYECTOS
	@PutMapping("/editarproyectousuario/{id}")
	public ResponseEntity<Proyecto> editarProyectoUsuario(@PathVariable Long id, @RequestBody Proyecto proyectoEdit) {
		
		 Usuario usuario = repositorio.findById(id)
		            .orElseThrow(() -> new ResourceNotFoundException("No hay usuario con ese identificador"));

		 Proyecto proyecto = repositorioProyecto.findByUsuario_Id(id,proyectoEdit.getId());
		 

		 proyecto.setNombre(proyectoEdit.getNombre());
		 proyecto.setDescripcion(proyectoEdit.getDescripcion());
		 proyecto.setFecha(proyectoEdit.getFecha());	 
		 proyecto.setLink(proyectoEdit.getLink());
		 
		 proyecto.setImagen(proyectoEdit.getImagen());
			
		 Proyecto proyectoActualizado = repositorioProyecto.save(proyecto);
		 //System.out.println(proyectoActualizado);
		 return ResponseEntity.ok(proyectoActualizado);
	}
	
	
		//este metodo sirve para eliminar un Proyecto
		@DeleteMapping("/eliminarProyectoUsuario/{id}")
		public ResponseEntity<Map<String,Boolean>> eliminarProyectoUsuario(@PathVariable Long id){
			Proyecto proyecto = repositorioProyecto.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el Proyecto con el ID : " + id));
			
			repositorioProyecto.delete(proyecto);
			Map<String, Boolean> respuesta = new HashMap<>();
			respuesta.put("eliminar",Boolean.TRUE);
			return ResponseEntity.ok(respuesta);
	    }
		
		
		
		
		//SKILLS
		@PostMapping("/nuevaSkillUsuario/{id}")
		public Skills guardarNuevaSkill(@PathVariable Long id, @RequestBody Skills skill) {
			
			Usuario usuario = repositorio.findById(id)
		            .orElseThrow(() -> new ResourceNotFoundException("No hay usuario con ese identificador"));

			skill.setUsuario(usuario);
			
			//System.out.println(skill.getUsuario().getNombre());
			
			return repositorioSkills.save(skill);
			//return skill;
		}
		
		/*@PutMapping("/editarSkillUsuario/{id}")
		public ResponseEntity<Skills> editarSkillUsuario(@PathVariable Long id, @RequestBody Skills skillEdit) {
			
			 Skills skill = repositorioSkills.findByUsuario_Id(id,skillEdit.getId());
			 skill.setNombre(skillEdit.getNombre());
			 skill.setPorcentaje(skillEdit.getPorcentaje());
			 Skills skillActualizada = repositorioSkills.save(skill);
			 return ResponseEntity.ok(skillActualizada);
		}*/
		
		@PutMapping("/editarSkillUsuario/{id}")
		public ResponseEntity<Skills> editarSkillUsuario(@PathVariable Long id, @RequestBody Skills skillEdit) {
			
			Skills skill = repositorioSkills.findByUsuario_Id(id,skillEdit.getId());
			 skill.setNombre(skillEdit.getNombre());
			 skill.setPorcentaje(skillEdit.getPorcentaje());
			 Skills skillActualizada = repositorioSkills.save(skill);
			 return ResponseEntity.ok(skillActualizada);
 
		}
		
		//este metodo sirve para eliminar un skill
		@DeleteMapping("/eliminarSkillUsuario/{id}")
		public ResponseEntity<Map<String,Boolean>> eliminarSkillUsuario(@PathVariable Long id){
			Skills skill = repositorioSkills.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el Proyecto con el ID : " + id));
			
			repositorioSkills.delete(skill);
			Map<String, Boolean> respuesta = new HashMap<>();
			respuesta.put("eliminar",Boolean.TRUE);
			return ResponseEntity.ok(respuesta);
	    }
	
		
		// IDIOMAS
		@PostMapping("/nuevoIdiomaUsuario/{id}")
		public Idioma guardarNuevoIdioma(@PathVariable Long id, @RequestBody Idioma idioma) {
			
			Usuario usuario = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("No hay usuario con ese identificador"));

			idioma.setUsuario(usuario);
			
			//System.out.println(skill.getUsuario().getNombre());
			
			return repositorioIdioma.save(idioma);
			//return skill;
		}
		
		@PutMapping("/editarIdiomaUsuario/{id}")
		public ResponseEntity<Idioma> editarIdiomaUsuario(@PathVariable Long id, @RequestBody Idioma idiomaEdit) {
			
			 Usuario usuario = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("No hay usuario con ese identificador"));
			 Idioma idioma = repositorioIdioma.findByUsuario_Id(id,idiomaEdit.getId());
			 idioma.setNombre(idiomaEdit.getNombre());
			 idioma.setPorcentaje(idiomaEdit.getPorcentaje());
				
			 Idioma idiomaoActualizado = repositorioIdioma.save(idioma);
			 //System.out.println(idiomaoActualizado);
			 return ResponseEntity.ok(idiomaoActualizado);
 
		}
		
		//este metodo sirve para eliminar un Proyecto
		@DeleteMapping("/eliminarIdiomaUsuario/{id}")
		public ResponseEntity<Map<String,Boolean>> eliminarIdiomaUsuario(@PathVariable Long id){
			Idioma idioma = repositorioIdioma.findById(id).orElseThrow(() -> new ResourceNotFoundException("No existe el Proyecto con el ID : " + id));
			
			repositorioIdioma.delete(idioma);
			Map<String, Boolean> respuesta = new HashMap<>();
			respuesta.put("eliminar",Boolean.TRUE);
			return ResponseEntity.ok(respuesta);
	    }
		
		
		//EDUCACION
		
		@PostMapping("/nuevoEducacionUsuario/{id}")
		public Educacion guardarNuevaEduacion(@PathVariable Long id, @RequestBody Educacion educacion) {
			
			Usuario usuario = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("No hay usuario con ese identificador"));

			educacion.setUsuario(usuario);
						
			return repositorioEducacion.save(educacion);
		}
		
		@PutMapping("/editarEducacionUsuario/{id}")
		public ResponseEntity<Educacion> editarEduacionUsuario(@PathVariable Long id, @RequestBody Educacion educacionEdit) {
			
			 Usuario usuario = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("No hay usuario con ese identificador"));
			 Educacion educacion = repositorioEducacion.findByUsuario_Id(id,educacionEdit.getId());
			 educacion.setNombre(educacionEdit.getNombre());
			 educacion.setTitulocarrera(educacionEdit.getTitulocarrera());
			 educacion.setFechainicio(educacionEdit.getFechainicio());
			 educacion.setFechafin(educacionEdit.getFechafin());
			 educacion.setLogo(educacionEdit.getLogo());
			 Educacion eduacionActualizada = repositorioEducacion.save(educacion);
			 //System.out.println(eduacionActualizada);
			 return ResponseEntity.ok(eduacionActualizada);
 
		}
		
		//este metodo sirve para eliminar un Eduacion
		@DeleteMapping("/eliminarEducacionUsuario/{id}")
		public ResponseEntity<Map<String,Boolean>> eliminarEducacionUsuario(@PathVariable Long id){
			Educacion educacion = repositorioEducacion.findById(id).orElseThrow(() -> new ResourceNotFoundException("No existe el Eduacion con el ID : " + id));
			
			repositorioEducacion.delete(educacion);
			Map<String, Boolean> respuesta = new HashMap<>();
			respuesta.put("eliminar",Boolean.TRUE);
			return ResponseEntity.ok(respuesta);
	    }
		
		
		
		//EXPERIENCIA
		
		@PostMapping("/nuevaExperienciaUsuario/{id}")
		public Experiencia guardarNuevaExperiencia(@PathVariable Long id, @RequestBody Experiencia experiencia) {
			
			Usuario usuario = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("No hay usuario con ese identificador"));

			experiencia.setUsuario(usuario);
						
			return repositorioExperiencia.save(experiencia);
		}
		
		@PutMapping("/editarExperienciaUsuario/{id}")
		public ResponseEntity<Experiencia> editarExperienciaUsuario(@PathVariable Long id, @RequestBody Experiencia experienciaEdit) {
			
			 Usuario usuario = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("No hay usuario con ese identificador"));
			 			 		 
			 
			 Experiencia experiencia = repositorioExperiencia.findByUsuario_Id(id,experienciaEdit.getId());
			 experiencia.setTitulo(experienciaEdit.getTitulo());		
			 experiencia.setFechainicio(experienciaEdit.getFechainicio());		 
			 experiencia.setFechafin(experienciaEdit.getFechafin());		 
			 experiencia.setActividades(experienciaEdit.getActividades());		 
			 experiencia.setImagen(experienciaEdit.getImagen());
			 			 		 
			 Experiencia experienciaActualizada = repositorioExperiencia.save(experiencia);
			 return ResponseEntity.ok(experienciaActualizada);
 
		}
		
		//este metodo sirve para eliminar una EXPERIENCIA
		@DeleteMapping("/eliminarExperienciaUsuario/{id}")
		public ResponseEntity<Map<String,Boolean>> eliminarExperienciaUsuario(@PathVariable Long id){
			Experiencia experiencia = repositorioExperiencia.findById(id).orElseThrow(() -> new ResourceNotFoundException("No existe la Experiencia con el ID : " + id));
			
			repositorioExperiencia.delete(experiencia);
			Map<String, Boolean> respuesta = new HashMap<>();
			respuesta.put("eliminar",Boolean.TRUE);
			return ResponseEntity.ok(respuesta);
	    }
		
		
		
		//INTERESES
		
		@PostMapping("/nuevoInteresUsuario/{id}")
		public Interes guardarNuevaInteres(@PathVariable Long id, @RequestBody Interes interes) {
			
			Usuario usuario = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("No hay usuario con ese identificador"));

			interes.setUsuario(usuario);
						
			return repositorioInteres.save(interes);
		}
		
		@PutMapping("/editarInteresUsuario/{id}")
		public ResponseEntity<Interes> editarInteresUsuario(@PathVariable Long id, @RequestBody Interes interesEdit) {
			
			 Usuario usuario = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("No hay usuario con ese identificador"));
			 Interes interes = repositorioInteres.findByUsuario_Id(id,interesEdit.getId());
			 interes.setDescripcion(interesEdit.getDescripcion());			 			 
			 
			 Interes eduacionActualizada = repositorioInteres.save(interes);
			 //System.out.println(eduacionActualizada);
			 return ResponseEntity.ok(eduacionActualizada);
 
		}
		
		//este metodo sirve para eliminar un INTERESES
		@DeleteMapping("/eliminarInteresUsuario/{id}")
		public ResponseEntity<Map<String,Boolean>> eliminarInteresUsuario(@PathVariable Long id){
			Interes interes = repositorioInteres.findById(id).orElseThrow(() -> new ResourceNotFoundException("No existe el Interes con el ID : " + id));
			
			repositorioInteres.delete(interes);
			Map<String, Boolean> respuesta = new HashMap<>();
			respuesta.put("eliminar",Boolean.TRUE);
			return ResponseEntity.ok(respuesta);
	    }
		
		//DATOS USUARIO EDICION
		
		@PutMapping("/editarDatosUsuario")
		public ResponseEntity<Usuario> editarDatosUsuario(@RequestBody Usuario usuarioEdit) {
			
			 Usuario usuario = repositorio.findById(usuarioEdit.getId()).orElseThrow(() -> new ResourceNotFoundException("No hay usuario con ese identificador"));
			 usuario.setNombre(usuarioEdit.getNombre());			 			 
			 usuario.setApellido(usuarioEdit.getApellido());
			 
			 usuario.setTitulo(usuarioEdit.getTitulo());
			 usuario.setFechaNacimiento(usuarioEdit.getFechaNacimiento());
			 usuario.setNombre(usuarioEdit.getNombre());
			 usuario.setImagenUsuario(usuarioEdit.getImagenUsuario());
			 
			 Usuario usuarioActualizado = repositorio.save(usuario);
			 //System.out.println(usuarioActualizado);
			 return ResponseEntity.ok(usuarioActualizado);
 
		}
		
		
		
		//LOGIN
		
		
		/*@PostMapping("/login")
		public ResponseEntity<JwtDTO> login(@RequestBody Usuario loginUsuario) {
			System.out.println("LLEGA");
			
			System.out.println("LLEGA");
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					loginUsuario.getNombreUsuario(), loginUsuario.getContrasena()));
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			String jwt = jwtProvider.generateToken(authentication);
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			System.out.println("LLEGA A HACER EL JWT");
			System.out.println(jwt);
			JwtDTO jwtDto = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
			
			return new ResponseEntity(jwtDto, HttpStatus.OK);
		}*/
		
}











