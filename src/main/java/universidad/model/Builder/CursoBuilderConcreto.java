package universidad.model.Builder;

import universidad.model.Alumno;
import universidad.model.Area;
import universidad.model.Curso;
import universidad.model.Docente;

import java.util.List;

public class CursoBuilderConcreto implements CursoBuilder{
    private Curso curso;

    public CursoBuilderConcreto() {
        this.curso = new Curso();
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
        curso.matricularAlumnos(alumnos);
    }

    @Override
    public void construirAlumno(Alumno alumno) {
        curso.matricularAlumno(alumno);
    }

    @Override
    public Curso getResultado() {
        return this.curso;
    }
}
