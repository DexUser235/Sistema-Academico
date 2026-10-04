package universidad.model;

public class ConTeoriaDecartor extends DictadoDecorator {
    public ConTeoriaDecartor(EstrategiaDictado estrategia) {
        super(estrategia);
    }

    @Override
    public void dictarClases() {
        super.dictarClases();
        System.out.println(" Metodologia con teoria");
    }
}
