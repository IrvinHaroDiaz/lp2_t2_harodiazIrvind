package pe.com.cibertec.lp2_t2_harodiazIrvind.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_contrato")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {

    @Id
    private String dniEmpleado;

    private String nombreEmpleado;
    private String apellidoEmpleado;
    private String fechaEmpleado;
    private String direccion;
    private String correo;

    @Column(name = "area_id")
    private int areaId;

    // Getters y Setters
}
