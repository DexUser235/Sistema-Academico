package universidad.model.Builder;

import universidad.model.Alumno;
import universidad.model.Area;
import universidad.model.Docente;

import java.util.List;

public class CursoDirector {

    public void construirCurso(CursoBuilder builder, String nombre, Area Especialidad, Docente docente, List<Alumno> alumnos) {
        builder.construirCurso(nombre, Especialidad);
        builder.construirDocente(docente);
        builder.construirAlumnos(alumnos);
    }

    public void construirCurso(CursoBuilder builder, String nombre, Area Especialidad, Docente docente, Alumno alumno) {
        builder.construirCurso(nombre, Especialidad);
        builder.construirDocente(docente);
        builder.construirAlumno(alumno);
    }
}
