package universidad.model;

import java.util.List;

public class CursoBuilderConcreto implements CursoBuilder{
    private Curso curso;

    public CursoBuilderConcreto(Curso curso) {
        this.curso = curso;
    }

    @Override
    public void construirCurso(String nombreCurso, Area especialidad) {
        curso.setNombreCurso(nombreCurso);
        curso.setEspecialidad(especialidad);
    }

    @Override
    public void construirDocente(Docente docente) {
        curso.asignarDocente(docente);
    }

    @Override
    public void construirAlumnos(List<Alumno> alumnos) {
        curso.asignarAlumnos(alumnos);
    }

    @Override
    public void construirAlumno(Alumno alumno) {
        curso.asignarAlumno(alumno);
    }

    @Override
    public Curso getResultado() {
        return this.curso;
    }
}
