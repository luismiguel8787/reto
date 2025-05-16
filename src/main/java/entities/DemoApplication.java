package entities;

import entities.Proyecto;

import entities.Tarea;

import Repository.ProyectoRepository;

import Repository.TareaRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private TareaRepository tareaRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Crear dos proyectos
        Proyecto proyecto1 = new Proyecto("Proyecto Alpha", LocalDate.of(2025, 5, 1), true);
        Proyecto proyecto2 = new Proyecto("Proyecto Beta", LocalDate.of(2025, 6, 15), false);

        proyectoRepository.save(proyecto1);
        proyectoRepository.save(proyecto2);

        // Crear cinco tareas
        Tarea tarea1 = new Tarea("Diseñar la interfaz", proyecto1);
        Tarea tarea2 = new Tarea("Implementar backend", proyecto1);
        Tarea tarea3 = new Tarea("Configurar base de datos", proyecto2);
        Tarea tarea4 = new Tarea("Escribir documentación", proyecto1);
        Tarea tarea5 = new Tarea("Pruebas unitarias", proyecto2);

        tareaRepository.save(tarea1);
        tareaRepository.save(tarea2);
        tareaRepository.save(tarea3);
        tareaRepository.save(tarea4);
        tareaRepository.save(tarea5);

        // Consultas de prueba
        System.out.println("\n✅ Proyectos activos:");
        proyectoRepository.buscarProyectosActivos()
                .forEach(p -> System.out.println(p.getNombre()));

        System.out.println("\n🔎 Buscar por nombre 'Proyecto Alpha':");
        proyectoRepository.findByNombre("Proyecto Alpha")
                .forEach(p -> System.out.println(p.getNombre() + " - " + p.getFechaInicio()));

        System.out.println("\n📅 Buscar por fecha 2025-06-15:");
        proyectoRepository.findByFechaInicio(LocalDate.of(2025, 6, 15))
                .forEach(p -> System.out.println(p.getNombre()));

        System.out.println("\n📝 Tareas de Proyecto Alpha:");
        tareaRepository.findByProyecto(proyecto1)
                .forEach(t -> System.out.println(t.getDescripcion()));

        System.out.println("\n📝 Tareas de Proyecto Beta:");
        tareaRepository.findByProyecto(proyecto2)
                .forEach(t -> System.out.println(t.getDescripcion()));
    }
}
