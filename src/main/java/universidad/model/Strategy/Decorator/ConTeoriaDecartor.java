package universidad.model.Strategy.Decorator;

import universidad.model.Strategy.dictadoClases.EstrategiaDictado;

public class ConTeoriaDecartor extends DictadoDecorator {
    public ConTeoriaDecartor(EstrategiaDictado estrategia) {
        super(estrategia);
    }

    @Override
    public void dictarClases() {
        System.out.println("Explicacion teorica mediante diapositivas");
        super.dictarClases();
    }
}
