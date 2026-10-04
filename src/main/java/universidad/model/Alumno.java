package universidad.model;

public class Alumno {
    private String nombre;
    private Area especialidad;
    private byte ciclo;
    private String id;

    public Alumno(String id, String nombre, Area especialidad, byte ciclo) {
        if (ciclo < 1 || ciclo > 10) {
            throw new IllegalArgumentException("El ciclo no existe");
        }
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.ciclo = ciclo;
    }

    public String getNombre() {
        return nombre;
    }

    public Area getEspecialidad() {
        return especialidad;
    }

    public byte getCiclo() {
        return ciclo;
    }

    public String getId() {
        return id;
    }

    public void consultarEstado(){
        System.out.println(" alumno " + nombre + " especialidad "+ especialidad + " ciclo " + ciclo);
    }
}
