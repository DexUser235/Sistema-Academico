package universidad.model;

import java.util.List;

public interface CursoBuilder {
    void construirCurso(String nombreCurso, Area especialidad);
    void construirDocente(Docente docente);
    void construirAlumnos(List<Alumno> alumnos);
    void construirAlumno(Alumno alumno);
    Curso getResultado();
}