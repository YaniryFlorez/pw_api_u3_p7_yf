package uce.edu.web.api.repository.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
 


@Entity
@Table(name ="persona")
public class Persona {
  private Integer id;
  private String nombre; 
  private String apellido;
  private LocalDateTime fechaNacimiento;

 @Id
public Integer getId() {
    return id;
}
public void setId(Integer id) {
    this.id = id;
}
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}
public String getApellido() {
    return apellido;
}
public void setApellido(String apellido) {
    this.apellido = apellido;
}
public LocalDateTime getFechaNacimiento() {
    return fechaNacimiento;
}
public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
}


    
}
