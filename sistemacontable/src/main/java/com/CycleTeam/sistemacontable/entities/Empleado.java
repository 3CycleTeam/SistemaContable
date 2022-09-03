// Clase empleado


package com.CycleTeam.sistemacontable.entities;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "empleados")
public class Empleado {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String nombre
  @ManyToOne
  @JoinColumn(name = "empresa_pertenece_id")
  private Empresa empresaPertenece;
  private String correo:
  private String rolEmpleado;
  
  //Constructor 
  
  public Empleado(String nombre, String correo, String empresaPertenece, String rolEmpleado) {
        this.nombre = nombre;
        this.correo = correo;
        this.empresaPertenece = empresaPertenece;
        this.rolEmpleado = rolEmpleado;
    }

}


// By: 3CycleTeam


