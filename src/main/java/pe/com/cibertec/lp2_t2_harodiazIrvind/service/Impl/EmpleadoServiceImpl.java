package pe.com.cibertec.lp2_t2_harodiazIrvind.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.cibertec.lp2_t2_harodiazIrvind.model.entity.Empleado;
import pe.com.cibertec.lp2_t2_harodiazIrvind.repository.EmpleadoRepository;
import pe.com.cibertec.lp2_t2_harodiazIrvind.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	
    @Autowired
    private EmpleadoRepository empleadoRepository;

	@Override
	public List<Empleado> listarEmpleados() {
		// TODO Auto-generated method stub
		return empleadoRepository.findAll();
	}

	@Override
	public Optional<Empleado> obtenerEmpleadoPorDni(String dni) {
		// TODO Auto-generated method stub
		 return empleadoRepository.findById(dni);
	}

	@Override
	public void guardarEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		empleadoRepository.save(empleado);
	}

	@Override
	public void eliminarEmpleado(String dni) {
		// TODO Auto-generated method stub
		empleadoRepository.deleteById(dni);
	}

    
}