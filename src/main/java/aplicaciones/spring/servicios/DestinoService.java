package aplicaciones.spring.servicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aplicaciones.spring.modelo.Destino;
import aplicaciones.spring.repositorios.IDestino;
@Service("destino")
public class DestinoService {
	@Autowired
	IDestino iDestino;	
	public void guardar(Destino destino) {		
		iDestino.save(destino);
	}
	
	public List<Destino> listar(){		
		return iDestino.findAll();
	}
	
	public Destino buscar(Long id) {
		return iDestino.findById(id);
	}
	
	public boolean eliminar(Long id) {
		try {
			iDestino.delete(iDestino.findById(id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public Destino buscar(String nombre) {
		return iDestino.findByNombre(nombre);
	}
}
