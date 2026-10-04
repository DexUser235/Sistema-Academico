package universidad.model;

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
