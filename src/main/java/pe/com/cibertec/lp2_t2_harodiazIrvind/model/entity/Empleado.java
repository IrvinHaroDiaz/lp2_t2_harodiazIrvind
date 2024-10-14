package pe.com.cibertec.lp2_t2_harodiazIrvind.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
    @Column(name = "dni_empleado", length = 8)
    private String dniEmpleado;

    @Column(name = "nombre_empleado", length = 45)
    private String nombreEmpleado;

    @Column(name = "apellido_empleado", length = 45)
    private String apellidoEmpleado;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "direccion", length = 45)
    private String direccion;

    @Column(name = "correo", length = 45)
    private String correo;

    @ManyToOne
    @JoinColumn(name = "area_id", referencedColumnName = "area_id")
    private Area area;
    // Getters y Setters
}
