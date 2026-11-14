
package universidad.proxy;

import universidad.model.Matricula;

public class BoletaProxy implements IBoleta {

    private final IBoleta boletaReal;

    public BoletaProxy(IBoleta boletaReal) {
        if (boletaReal == null) {
            throw new IllegalArgumentException("La boleta real no puede ser nula");
        }
        this.boletaReal = boletaReal;
    }

    @Override
    public String consultarBoleta(Usuario usuario, Matricula matricula) {

        if (usuario == null || matricula == null) {
            return "Solicitud inválida.";
        }

        switch (usuario.getRol()) {

            case ALUMNO:
                if (!usuario.getIdUsuario().equalsIgnoreCase(
                        matricula.getAlumno().getId())) {
                    return "Acceso denegado: solo puedes consultar tu propia boleta.";
                }
                break;

            case DOCENTE:
                return "Acceso pendiente: no se puede verificar la asignación del curso.";

            case ADMINISTRADOR:
                break;

            default:
                return "Acceso denegado: rol no reconocido.";
        }

        return boletaReal.consultarBoleta(usuario, matricula);
    }
}
