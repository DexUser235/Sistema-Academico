package universidad.model;

public class Alumno {
    private String nombre;
    private Area especialidad;
    private byte ciclo;

    public Alumno(String nombre, Area especialidad, byte ciclo) {
        if (ciclo < 1 || ciclo > 10) {
            throw new IllegalArgumentException("El ciclo no existe");
        }
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.ciclo = ciclo;

    }

    public void consultarEstado(){
        System.out.println(" alumno " + nombre + " especialidad "+ especialidad + " ciclo " + ciclo);
    }
}
