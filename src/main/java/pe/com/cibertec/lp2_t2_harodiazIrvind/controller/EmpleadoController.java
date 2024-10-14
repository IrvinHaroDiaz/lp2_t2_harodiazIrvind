package pe.com.cibertec.lp2_t2_harodiazIrvind.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.cibertec.lp2_t2_harodiazIrvind.model.entity.Area;
import pe.com.cibertec.lp2_t2_harodiazIrvind.model.entity.Empleado;
import pe.com.cibertec.lp2_t2_harodiazIrvind.service.AreaService;
import pe.com.cibertec.lp2_t2_harodiazIrvind.service.EmpleadoService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;
    
    @Autowired
    private AreaService areaService;

    
    @GetMapping("/listar")
    public String listarEmpleados(Model model) {
        List<Empleado> empleados = empleadoService.listarEmpleados();
        model.addAttribute("empleados", empleados);
        return "empleados-listar";
    }

    
    @GetMapping("/nuevo")
    public String mostrarFormularioDeEmpleado(Model model) {
        List<Area> areas = areaService.listarAreas(); 
        model.addAttribute("areas", areas);
        model.addAttribute("empleado", new Empleado());
        return "empleado-form";
    }
    
    @PostMapping("/guardar")
    public String guardarEmpleado(@ModelAttribute("empleado") Empleado empleado) {
        empleadoService.guardarEmpleado(empleado);
        return "redirect:/empleados/listar";
    }

    
    @GetMapping("/editar")
    public String mostrarFormularioEditar(@PathVariable("dni") String dni, Model model) {
        Optional<Empleado> empleado = empleadoService.obtenerEmpleadoPorDni(dni);
        if (empleado.isPresent()) {
            model.addAttribute("empleado", empleado.get());
            return "empleado-form";
        } else {
            return "empleado-no-encontrado"; // Asegúrate de que esta vista exista
        }
    }

    @PostMapping("/actualizar")
    public String actualizarEmpleado(@PathVariable("dni") String dni, @ModelAttribute Empleado empleadoActualizado) {
        empleadoService.guardarEmpleado(empleadoActualizado);
        return "redirect:/empleados/listar";
    }

    @GetMapping("/eliminar")
    public String eliminarEmpleado(@PathVariable("dni") String dni) {
        empleadoService.eliminarEmpleado(dni);
        return "redirect:/empleados/listar";
    }

    // Buscar empleado por DNI
    @GetMapping("/buscar/{dni}")
    public String buscarEmpleado(@PathVariable String dni, Model model) {
        Empleado empleado = empleadoService.obtenerEmpleadoPorDni(dni).orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado: " + dni));
        model.addAttribute("empleado", empleado);
        return "empleado-detalle"; 
    }
}
