package universidad.model.Strategy.Prom;

import universidad.model.Matricula;

public class PromedioEstandarEstrategia implements EstrategiaPromedio {

    @Override
    public float calcular(Matricula matricula) {
        if (matricula == null) {
            throw new IllegalArgumentException("La matrícula no puede ser nula");
        }
        return (matricula.getNota1() * 0.20f) + (matricula.getNota2() * 0.30f) + (matricula.getNota3() * 0.30f) + (matricula.getPA() * 0.20f);
    }
}
