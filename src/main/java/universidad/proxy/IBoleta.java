package universidad.proxy;

import universidad.model.Matricula;

public interface IBoleta {
    String consultarBoleta(Usuario usuario, Matricula matricula);
}
