package Repository;

import entities.Proyecto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

    List<Proyecto> findByNombre(String nombre);

    List<Proyecto> finByFechaInicio(LocalDate fechaInicio);

    @Query("SELECT p FROM Proyecto p WHERE p.activo = true")
    List<Proyecto> buscarProyectosActivos();
}

