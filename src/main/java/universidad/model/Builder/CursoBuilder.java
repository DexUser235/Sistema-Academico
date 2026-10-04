package universidad.model.Builder;

import universidad.model.Alumno;
import universidad.model.Area;
import universidad.model.Curso;
import universidad.model.Docente;

import java.util.List;

public interface CursoBuilder {
    void construirCurso(String nombreCurso, Area especialidad);
    void construirDocente(Docente docente);
    void construirAlumnos(List<Alumno> alumnos);
    void construirAlumno(Alumno alumno);
    Curso getResultado();
}