package portfolio.backend.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import portfolio.backend.modelo.Proyecto;
import portfolio.backend.modelo.Idioma;

@Repository	
public interface IdiomaRepositorio extends JpaRepository<Idioma,Long>{
	
	@Query("SELECT p FROM Idioma p WHERE p.Usuario.id = :usuarioId AND p.id = :idiomaId")
	Idioma findByUsuario_Id(@Param("usuarioId") Long usuarioId, @Param("idiomaId") Long idiomaId);
	
}