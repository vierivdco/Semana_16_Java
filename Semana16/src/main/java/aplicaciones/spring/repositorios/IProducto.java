package aplicaciones.spring.repositorios;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import aplicaciones.spring.modelo.Producto;
@Repository
public interface IProducto extends JpaRepository<Producto, Serializable>{
	public abstract Producto findById(Long id);
	public abstract Producto findByNombre(String producto);
}
