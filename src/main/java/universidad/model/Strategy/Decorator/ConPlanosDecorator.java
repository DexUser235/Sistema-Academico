package universidad.model.Strategy.Decorator;

import universidad.model.Strategy.dictadoClases.EstrategiaDictado;

public class ConPlanosDecorator extends DictadoDecorator {
    public ConPlanosDecorator(EstrategiaDictado estrategia) {
        super(estrategia);
    }

    @Override
    public void dictarClases() {
        super.dictarClases();
        System.out.println("Estudio de los planos impartidos en clase");
    }
}
