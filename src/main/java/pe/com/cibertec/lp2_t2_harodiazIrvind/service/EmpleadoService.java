package pe.com.cibertec.lp2_t2_harodiazIrvind.service;

import java.util.List;
import java.util.Optional;

import pe.com.cibertec.lp2_t2_harodiazIrvind.model.entity.Empleado;

public interface EmpleadoService {
    List<Empleado> listarEmpleados();
    Optional<Empleado> obtenerEmpleadoPorDni(String dni);
    void guardarEmpleado(Empleado empleado);
    void eliminarEmpleado(String dni);
}