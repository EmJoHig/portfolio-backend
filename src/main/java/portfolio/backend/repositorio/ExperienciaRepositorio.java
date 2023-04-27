package portfolio.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import portfolio.backend.modelo.Experiencia;

@Repository	
public interface ExperienciaRepositorio extends JpaRepository<Experiencia,Long>{
	
	@Query("SELECT p FROM Experiencia p WHERE p.Usuario.id = :usuarioId AND p.id = :experienciaId")
	Experiencia findByUsuario_Id(@Param("usuarioId") Long usuarioId, @Param("experienciaId") Long experienciaId);
	
}