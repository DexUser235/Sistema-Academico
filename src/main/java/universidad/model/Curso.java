package universidad.model;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombreCurso;
    private Area especialidad;
    private List<Alumno> alumnos;
    private Docente docente;

    public Curso() {
        alumnos = new ArrayList<>();
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

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public Docente getDocente() {
        return docente;
    }

    public void asignarDocente(Docente nuevoDocente){
        if (this.docente != null) {
            System.out.println("El curso ya tiene un docente asignado.");
            return;
        }
        this.docente = nuevoDocente;
    }

    public void asignarAlumno(Alumno alumno) {
        if (alumno == null) return;

        if (this.alumnos.size() >= 30) {
            System.out.println("No se pueden añadir más alumnos");
            return;
        }
        this.alumnos.add(alumno);
    }

    public void asignarAlumnos(List<Alumno> nuevosAlumnos) {
        if (nuevosAlumnos == null) return;

        if (this.alumnos.size() + nuevosAlumnos.size() > 30) {
            System.out.println("La lista excede el límite de 30 alumnos para el curso");
            return;
        }
        this.alumnos.addAll(nuevosAlumnos);
    }
}