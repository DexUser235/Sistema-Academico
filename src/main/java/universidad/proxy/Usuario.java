package universidad.proxy;

public class Usuario {
    private final String idUsuario;
    private final RolUsuario rol;

    public Usuario(String idUsuario, RolUsuario rol) {
        this.idUsuario = idUsuario;
        this.rol = rol;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public RolUsuario getRol() {
        return rol;
    }
}
