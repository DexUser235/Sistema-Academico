package universidad.decorator;


import universidad.strategy.EstrategiaDictado;

public  abstract class DictadoDecorator implements EstrategiaDictado {
    protected EstrategiaDictado estrategia;

    public DictadoDecorator(EstrategiaDictado estrategia) {
        this.estrategia = estrategia;
    }

    @Override
    public void dictarClases() {
        estrategia.dictarClases();
    }
}
