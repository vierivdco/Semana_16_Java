package aplicaciones.spring.repositorios;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import aplicaciones.spring.modelo.Venta;
@Repository
public interface IVenta extends JpaRepository<Venta, Serializable>{
	public abstract Venta findById(Long id);
}
