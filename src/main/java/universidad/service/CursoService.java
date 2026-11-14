package universidad.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import universidad.model.Alumno;
import universidad.model.Area;
import universidad.model.Curso;
import universidad.model.Matricula;



@Service
public class CursoService {

    private final List<Curso> cursos = new ArrayList<>();
    private final DocenteService docenteService;
    private final AlumnoService alumnoService;

    public CursoService(DocenteService docenteService, AlumnoService alumnoService) {
        this.docenteService = docenteService;
        this.alumnoService = alumnoService;

        // Cursos de ejemplo, ya con docente asignado
        cursos.add(crear("Programación I", Area.Sistemas, "Juan Pérez"));
        cursos.add(crear("Estructuras de Datos", Area.Sistemas, "Carlos Ramírez"));
        cursos.add(crear("Resistencia de Materiales", Area.Civil, "María López"));
        cursos.add(crear("Anatomía", Area.Medicina, null));
    }

    private Curso crear(String nombre, Area area, String nombreDocente) {
        Curso curso = new Curso();
        curso.setNombreCurso(nombre);
        curso.setEspecialidad(area);

        if (nombreDocente != null) {
            docenteService.listar(nombreDocente).stream()
                    .findFirst()
                    .ifPresent(curso::asignarDocente);
        }
        return curso;
    }

    public List<Curso> listar() {
        return cursos;
    }

    public Curso buscar(String nombreCurso) {
        return cursos.stream()
                .filter(c -> c.getNombreCurso().equalsIgnoreCase(nombreCurso))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));
    }

    public void matricular(String idAlumno, String nombreCurso) {
        Alumno alumno = alumnoService.buscarPorId(idAlumno);
        Curso curso = buscar(nombreCurso);
        curso.matricularAlumno(alumno);
    }
    public List<Matricula> listarMatriculas() {
    List<Matricula> todas = new ArrayList<>();
    for (Curso c : cursos) {
        todas.addAll(c.getMatriculas());
    }
    return todas;
}
}