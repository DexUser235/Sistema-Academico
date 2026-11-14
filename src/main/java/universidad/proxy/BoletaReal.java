package universidad.proxy;

import universidad.model.InfoCursos;
import universidad.model.Matricula;

public class BoletaReal implements IBoleta{

    private final InfoCursos infoCursos;

    public BoletaReal(InfoCursos infoCursos) {
        this.infoCursos = infoCursos;
    }


    public String consultarBoleta(Usuario usuario, Matricula matricula) {
        if (matricula == null) {
            return "No se puede generar la boleta: matrícula no válida.";
        }
        return infoCursos.mostrarNotasAlumno(matricula);
    }

}
