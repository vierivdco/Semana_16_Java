package aplicaciones.spring.repositorios;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import aplicaciones.spring.modelo.Destino;
@Repository
public interface IDestino extends JpaRepository<Destino, Serializable>{
	public abstract Destino findById(Long id);
	public abstract Destino findByNombre(String destino);
}
