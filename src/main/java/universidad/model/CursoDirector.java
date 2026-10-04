package universidad.model;

import java.util.List;

public class CursoDirector {
    public void construirCursoCompleto(CursoBuilder builder, String nombre, Area Especialidad, Docente docente, List<Alumno> alumnos) {
        builder.construirCurso(nombre, Especialidad);
        builder.construirDocente(docente);
        builder.construirAlumnos(alumnos);
    }

    public void construirCursoCompleto(CursoBuilder builder, String nombre, Area Especialidad, Docente docente, Alumno alumno) {
        builder.construirCurso(nombre, Especialidad);
        builder.construirDocente(docente);
        builder.construirAlumno(alumno);
    }
}
