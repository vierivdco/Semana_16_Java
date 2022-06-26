package aplicaciones.spring.repositorios;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import aplicaciones.spring.modelo.Cliente;
@Repository
public interface ICliente extends JpaRepository<Cliente, Serializable>{
	public abstract Cliente findById(Long id);
}
