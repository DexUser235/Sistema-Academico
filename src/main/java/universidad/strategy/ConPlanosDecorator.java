package universidad.strategy;

import universidad.decorator.DictadoDecorator;

public class ConPlanosDecorator extends DictadoDecorator {
    public ConPlanosDecorator(EstrategiaDictado estrategia) {
        super(estrategia);
    }

    @Override
    public void dictarClases() {
        super.dictarClases();
        System.out.println("metodologia con planos");
    }
}
