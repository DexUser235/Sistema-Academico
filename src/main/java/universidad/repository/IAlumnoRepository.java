
package universidad.repository;

import universidad.model.Alumno;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IAlumnoRepository {

    List<Alumno> listarTodos() throws SQLException;

    Optional<Alumno> buscarPorId(String id) throws SQLException;

    void registrar(Alumno alumno) throws SQLException;

    void actualizar(Alumno alumno) throws SQLException;

    void eliminar(String id) throws SQLException;
}
