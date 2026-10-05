package universidad.model;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombreCurso;
    private Area especialidad;
    private final List<Matricula> matriculas;
    private Docente docente;

    public Curso() {
        matriculas = new ArrayList<>();
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Area getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Area especialidad) {
        this.especialidad = especialidad;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public Docente getDocente() {
        return docente;
    }

    public void asignarDocente(Docente nuevoDocente){
        if (this.docente != null) {
            System.out.println("El curso ya tiene un docente asignado.");
            return;
        }

        if (this.especialidad != null && nuevoDocente.getEspecialidades() != this.especialidad) {
            System.out.println("El docente " + nuevoDocente.getNombre() +
                    " (" + nuevoDocente.getEspecialidades() + ") no pertenece al área del curso (" + this.especialidad + ")");
            return;
        }

        this.docente = nuevoDocente;
    }

    public void matricularAlumnos(List<Alumno> nuevosAlumnos) {
        if (nuevosAlumnos == null) return;

        if (this.matriculas.size() + nuevosAlumnos.size() > 30) {
            System.out.println("La lista excede el límite de 30 matriculas para el curso");
            return;
        }

        for (Alumno a : nuevosAlumnos) {
            matricularAlumno(a);
        }
    }

    public void matricularAlumno(Alumno alumno) {
        if (alumno == null) return;

        if (this.matriculas.size() >= 30) {
            System.out.println("No se pueden añadir más matriculas");
            return;
        }

        if (this.especialidad != null && alumno.getEspecialidad() != this.especialidad) {
            System.out.println("Error: El alumno " + alumno.getNombre() +
                    " (" + alumno.getEspecialidad() + ") no pertenece al área del curso (" + this.especialidad + ").");
            return;
        }

        Matricula nuevaMatricula = new Matricula(alumno, this);
        this.matriculas.add(nuevaMatricula);
    }

    @Override
    public String toString() {
        return String.format("- Curso: %s \n- Docente: %s \n- alumnos matriculados: %d", getNombreCurso(), getDocente().getNombre(), getMatriculas().size());
    }
}