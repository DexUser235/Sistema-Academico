package universidad.model;

import universidad.strategy.EstrategiaDictado;

public class Docente  {
    private String nombre;
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

    public void impartirClase(){

        estrategia.dictarClases();
    }

    public void setEstrategia(EstrategiaDictado estrategia) {

        this.estrategia = estrategia;
    }
}
