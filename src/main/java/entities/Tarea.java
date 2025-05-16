package entities;

import jakarta.persistence.*;
@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "proyecto_id") // Es el nombre de la tabla

    private Proyecto proyecto;

    //Constructor vacio
    public Tarea(){}

    // Constructor Completo
    public Tarea (String descripcion, Proyecto proyecto){
        this.descripcion = descripcion;
        this.proyecto = proyecto;
    }
// Getter and Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
}
