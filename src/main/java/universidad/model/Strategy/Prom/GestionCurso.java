package universidad.model.Strategy.Prom;

import universidad.model.Matricula;

public class GestionCurso {

    private EstrategiaPromedio estrategia;

    public GestionCurso(EstrategiaPromedio estrategia) {
        this.estrategia = estrategia;
    }

    public void cambiarEstrategia(EstrategiaPromedio estrategia) {
        this.estrategia = estrategia;
    }

    public float calcularPromedio(Matricula matricula) {
        if (this.estrategia == null) {
            throw new IllegalStateException("No hay estrategia");
        }
        return this.estrategia.calcular(matricula);
    }
}