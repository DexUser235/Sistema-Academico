package universidad.model;

public class Alumno {
    private String nombre;
    private Area especialidad;
    private int ciclo;

    public Alumno(String nombre, Area especialidad, int ciclo) {
        if (ciclo < 1 || ciclo > 10) {
       throw new IllegalArgumentException("El ciclo no existe");
        }
        this.nombre = nombre;
        this.especialidad = especialidad;

    }

    public void ConsultarEstado(){
        System.out.println(" alumno " + nombre + " especoalidad "+ especialidad + " ciclo " + ciclo);
    }
}
