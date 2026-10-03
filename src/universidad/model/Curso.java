package universidad.model;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombreCurso;
    private Area especialidad;
    private List<Alumno> alumnos;
;

    public Curso(String nombreCurso, Area especialidad) {
        this.nombreCurso = nombreCurso;
        this.especialidad = especialidad;
        this.alumnos = new ArrayList<>();
    }
    public void asignarDocentes(Docente docente){
           // nose xd
        System.out.println("hola mundo");
    }
    public void asignarAlumno(Alumno alumno){
      alumnos.add(alumno);
    }
}
