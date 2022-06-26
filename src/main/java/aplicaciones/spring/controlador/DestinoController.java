package aplicaciones.spring.controlador;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import aplicaciones.spring.modelo.Destino;
import aplicaciones.spring.servicios.DestinoService;
@Controller
@RequestMapping("/destino")
@SessionAttributes("destino")
public class DestinoController {
	@Autowired
	@Qualifier("destino")
	DestinoService destinoService;
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Destino> destino = destinoService.listar();
		model.addAttribute("destino",destino);
		model.addAttribute("titulo","Lista de Productos");
		return "destinoListar";
	}
	
	@RequestMapping("/form")
	public String formulario (Map<String, Object> model) {
		Destino destino = new Destino();
		model.put("destino",destino);
		model.put("btn", "Añadir destino");
		return "destinoForm";
	}
	
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("destino",destinoService.buscar(id));
		model.addAttribute("btn","Actualiza Registro");
		return "destinoForm";
	}
	
	@RequestMapping(value="/insertar",method=RequestMethod.POST)
	public String guardar(@Validated Destino destino,BindingResult result,Model model) {		
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			destino = new Destino();
			model.addAttribute("destino",destino);
			model.addAttribute("btn","Añadir destino");
			return "destinoForm";
		}else {
		destinoService.guardar(destino);
		return "redirect:/destino/listar";
		}
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		destinoService.eliminar(id);
		return "redirect:/destino/listar";
	}
}
