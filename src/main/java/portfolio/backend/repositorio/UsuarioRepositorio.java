package portfolio.backend.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import portfolio.backend.modelo.Usuario;

@Repository	
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long>{
	
	@Query("SELECT u FROM Usuario u WHERE u.nombreusuario = :nombreusuario")
	Usuario buscarPorNombreUsuario(@Param("nombreusuario") String nombreusuario);
	
}
