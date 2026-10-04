package universidad.model.Strategy.Prom;

import universidad.model.Matricula;

public class PromedioPractico implements EstrategiaPromedio {

    @Override
    public float calcular(Matricula matricula) {
        if (matricula == null) {
            throw new IllegalArgumentException("La matrícula no puede ser nula");
        }
        return (matricula.getNota1() * 0.25f) + (matricula.getNota2() * 0.25f) + (matricula.getNota3() * 0.25f) + (matricula.getPA() * 0.25f);
    }
}
