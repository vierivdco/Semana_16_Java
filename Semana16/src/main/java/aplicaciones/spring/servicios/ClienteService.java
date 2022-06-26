package aplicaciones.spring.servicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aplicaciones.spring.modelo.Cliente;
import aplicaciones.spring.repositorios.ICliente;
@Service("cliente")
public class ClienteService {
	@Autowired
	private ICliente iCliente;
	public void guardar(Cliente cliente) {
		iCliente.save(cliente);
	}	
	public List<Cliente> listar (){
		 return iCliente.findAll();
	}	
	public  Cliente buscar(Long id) {
		return  iCliente.findById(id);
	}	
	public boolean eliminar (Long id) {
		try {
			iCliente.delete(iCliente.findById(id));
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
}
