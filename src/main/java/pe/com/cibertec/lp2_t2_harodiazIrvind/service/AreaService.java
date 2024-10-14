package pe.com.cibertec.lp2_t2_harodiazIrvind.service;

import java.util.List;
import pe.com.cibertec.lp2_t2_harodiazIrvind.model.entity.Area;

public interface AreaService {
    List<Area> listarAreas();
    Area obtenerAreaPorId(int areaId);
}
