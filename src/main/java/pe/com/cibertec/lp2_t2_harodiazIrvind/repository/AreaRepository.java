package pe.com.cibertec.lp2_t2_harodiazIrvind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.cibertec.lp2_t2_harodiazIrvind.model.entity.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {
}
