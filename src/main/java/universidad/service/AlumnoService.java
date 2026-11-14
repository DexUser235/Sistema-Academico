package universidad.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import universidad.model.Alumno;
import universidad.model.Area;

@Service
public class AlumnoService {

    private final List<Alumno> alumnos = new ArrayList<>();
    private int contador = 1;

    public List<Alumno> listar(String q) {
        if (q == null || q.isBlank()) {
            return alumnos;
        }
        String filtro = q.toLowerCase();
        return alumnos.stream()
                .filter(a -> a.getId().toLowerCase().contains(filtro)
                          || a.getNombre().toLowerCase().contains(filtro))
                .toList();
    }

    public void registrar(String nombre, Area area, byte ciclo) {
        String id = String.format("A%03d", contador);
        Alumno alumno = new Alumno(id, nombre, area, ciclo); // valida el ciclo
        alumnos.add(alumno);
        contador++;
    }
    public Alumno buscarPorId(String id) {
    return alumnos.stream()
            .filter(a -> a.getId().equalsIgnoreCase(id))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado"));
}
}