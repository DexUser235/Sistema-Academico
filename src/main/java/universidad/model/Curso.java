package universidad.model;

import java.util.ArrayList;
import java.util.List;

public class Curso{
    private String nombreCurso;
    private Area especialidad;
    private List<Alumno> alumnos;
    private List<Docente>docentes;

    public Curso(String nombreCurso, Area especialidad) {
        this.nombreCurso = nombreCurso;
        this.especialidad = especialidad;
        this.alumnos = new ArrayList<>();
        this.docentes = new ArrayList<>();
    }
    public void asignarDocente(Docente docente){
        for (Docente d : docentes) {
            if (d.getNombre().equals(docente.getNombre())){
                throw  new IllegalArgumentException("El docente ya está asignado a este curso");
            }
        }
        docentes.add(docente);

    }
    public void asignarAlumno(Alumno alumno){
        for (Alumno a : alumnos) {
            if (a.getNombre().equals(alumno.getNombre())){
                throw new IllegalArgumentException("El alumno ya está registrado a este curso");
            }
        }

        alumnos.add(alumno);
    }
}