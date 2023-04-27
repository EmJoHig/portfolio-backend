package portfolio.backend.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import portfolio.backend.modelo.Proyecto;
import portfolio.backend.modelo.Skills;

@Repository	
public interface SkillsRepositorio extends JpaRepository<Skills,Long>{
	
	@Query("SELECT p FROM Skills p WHERE p.Usuario.id = :usuarioId AND p.id = :skillId")
	Skills findByUsuario_Id(@Param("usuarioId") Long usuarioId, @Param("skillId") Long skillId);
	
}
