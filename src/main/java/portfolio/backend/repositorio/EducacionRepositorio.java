package portfolio.backend.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import portfolio.backend.modelo.Proyecto;
import portfolio.backend.modelo.Educacion;

@Repository	
public interface EducacionRepositorio extends JpaRepository<Educacion,Long>{
	
	@Query("SELECT p FROM Educacion p WHERE p.Usuario.id = :usuarioId AND p.id = :educacionId")
	Educacion findByUsuario_Id(@Param("usuarioId") Long usuarioId, @Param("educacionId") Long educacionId);
	
}