package pe.com.cibertec.lp2_t2_harodiazIrvind.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import pe.com.cibertec.lp2_t2_harodiazIrvind.model.entity.Empleado;
import pe.com.cibertec.lp2_t2_harodiazIrvind.service.EmpleadoService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/listar")
    public String listarEmpleados(Model model) {
        List<Empleado> empleados = empleadoService.listarEmpleados();
        model.addAttribute("empleados", empleados);
        return "empleado-list";
    }

    @GetMapping("/buscar/{dni}")
    public String buscarEmpleado(@PathVariable("dni") String dni, Model model) {
        Optional<Empleado> empleado = empleadoService.obtenerEmpleadoPorDni(dni);
        if (empleado.isPresent()) {
            model.addAttribute("empleado", empleado.get());
            return "empleado-detalle";
        } else {
            return "empleado-no-encontrado";
        }
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoEmpleado(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "empleado-form";
    }

    @PostMapping("/guardar")
    public String guardarEmpleado(@ModelAttribute Empleado empleado) {
        empleadoService.guardarEmpleado(empleado);
        return "redirect:/empleados/listar";
    }

    @GetMapping("/editar/{dni}")
    public String mostrarFormularioEditar(@PathVariable("dni") String dni, Model model) {
        Optional<Empleado> empleado = empleadoService.obtenerEmpleadoPorDni(dni);
        if (empleado.isPresent()) {
            model.addAttribute("empleado", empleado.get());
            return "empleado-form";
        } else {
            return "empleado-no-encontrado";
        }
    }

    @PostMapping("/actualizar/{dni}")
    public String actualizarEmpleado(@PathVariable("dni") String dni, @ModelAttribute Empleado empleadoActualizado) {
        empleadoService.guardarEmpleado(empleadoActualizado);
        return "redirect:/empleados/listar";
    }

    @GetMapping("/eliminar/{dni}")
    public String eliminarEmpleado(@PathVariable("dni") String dni) {
        empleadoService.eliminarEmpleado(dni);
        return "redirect:/empleados/listar";
    }
}
