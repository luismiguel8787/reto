package Repository;
import entities.Tarea;
import entities.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TareaRepository extends JpaRepository<Tarea, Long> {

    // Consulta derivada para obtener tareas por proyecto
    List<Tarea> findByProyecto(Proyecto proyecto);
}
