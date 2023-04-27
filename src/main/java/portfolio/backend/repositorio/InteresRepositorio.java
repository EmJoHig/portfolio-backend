package portfolio.backend.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import portfolio.backend.modelo.Interes;

@Repository	
public interface InteresRepositorio extends JpaRepository<Interes,Long>{
	
	@Query("SELECT p FROM Interes p WHERE p.Usuario.id = :usuarioId AND p.id = :interesId")
	Interes findByUsuario_Id(@Param("usuarioId") Long usuarioId, @Param("interesId") Long interesId);
	
}