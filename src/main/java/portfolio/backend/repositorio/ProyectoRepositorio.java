package portfolio.backend.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import portfolio.backend.modelo.Proyecto;
import portfolio.backend.modelo.Usuario;

@Repository	
public interface ProyectoRepositorio extends JpaRepository<Proyecto,Long>{
	
	//@Query("SELECT p FROM Proyecto p WHERE p.Usuario.id = :id")
	//List<Proyecto> findByUsuario_Id(@Param("id") Long id);
	
	@Query("SELECT p FROM Proyecto p WHERE p.Usuario.id = :usuarioId AND p.id = :proyectoId")
	Proyecto findByUsuario_Id(@Param("usuarioId") Long usuarioId, @Param("proyectoId") Long proyectoId);


}
