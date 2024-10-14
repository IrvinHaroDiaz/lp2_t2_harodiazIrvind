package pe.com.cibertec.lp2_t2_harodiazIrvind.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.lp2_t2_harodiazIrvind.model.entity.Area;
import pe.com.cibertec.lp2_t2_harodiazIrvind.repository.AreaRepository;
import pe.com.cibertec.lp2_t2_harodiazIrvind.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {
	
	 @Autowired
	    private AreaRepository areaRepository;

	@Override
	public List<Area> listarAreas() {
		// TODO Auto-generated method stub
		 return areaRepository.findAll();
	}

	@Override
	public Area obtenerAreaPorId(int areaId) {
		// TODO Auto-generated method stub
		return areaRepository.findById(areaId).orElse(null);
	}

    
}