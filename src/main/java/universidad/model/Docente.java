package universidad.model;

import universidad.model.Strategy.dictadoClases.EstrategiaDictado;

public class Docente  {
    private String nombre;
    private int idDocente;
    private Area especialidades;
    private EstrategiaDictado estrategia;

    public Docente(EstrategiaDictado estrategia, Area especialidades, String nombre) {
        this.estrategia = estrategia;
        this.especialidades = especialidades;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public Area getEspecialidades() {
        return especialidades;
    }

    public EstrategiaDictado getEstrategia() {
        return estrategia;
    }

    public void impartirClase() {
        System.out.println("Docente: " + getNombre() + " Ha iniciado la sesion");
        estrategia.dictarClases();
    }

    public void setEstrategia(EstrategiaDictado estrategia) {
        this.estrategia = estrategia;
    }
}
