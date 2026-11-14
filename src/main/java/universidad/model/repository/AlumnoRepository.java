
package universidad.model.repository;

import universidad.database.ConexionSingleton;
import universidad.model.Alumno;
import universidad.model.Area;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlumnoRepository implements IAlumnoRepository {

    @Override
    public List<Alumno> listarTodos() throws SQLException {

        String sql = """
                SELECT id_alumno, nombre, id_area, ciclo
                FROM Alumno
                ORDER BY nombre
                """;

        List<Alumno> alumnos = new ArrayList<>();

        try (Connection cn = ConexionSingleton.getInstancia().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Alumno alumno = new Alumno(
                        rs.getString("id_alumno"),
                        rs.getString("nombre"),
                        Area.buscarPorId(rs.getByte("id_area")),
                        rs.getByte("ciclo")
                );

                alumnos.add(alumno);
            }
        }

        return alumnos;
    }

    @Override
    public Optional<Alumno> buscarPorId(String id) throws SQLException {

        String sql = """
                SELECT id_alumno, nombre, id_area, ciclo
                FROM Alumno
                WHERE id_alumno = ?
                """;

        try (Connection cn = ConexionSingleton.getInstancia().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Alumno alumno = new Alumno(
                            rs.getString("id_alumno"),
                            rs.getString("nombre"),
                            Area.buscarPorId(rs.getByte("id_area")),
                            rs.getByte("ciclo")
                    );

                    return Optional.of(alumno);
                }
            }
        }

        return Optional.empty();
    }

    @Override
    public void registrar(Alumno alumno) throws SQLException {

        String sql = """
                INSERT INTO Alumno
                (id_alumno, nombre, ciclo, id_area)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection cn = ConexionSingleton.getInstancia().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, alumno.getId());
            ps.setString(2, alumno.getNombre());
            ps.setByte(3, alumno.getCiclo());
            ps.setByte(4, alumno.getEspecialidad().getId());

            ps.executeUpdate();
        }
    }

    @Override
    public void actualizar(Alumno alumno) throws SQLException {

        String sql = """
                UPDATE Alumno
                SET nombre = ?, ciclo = ?, id_area = ?
                WHERE id_alumno = ?
                """;

        try (Connection cn = ConexionSingleton.getInstancia().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, alumno.getNombre());
            ps.setByte(2, alumno.getCiclo());
            ps.setByte(3, alumno.getEspecialidad().getId());
            ps.setString(4, alumno.getId());

            ps.executeUpdate();
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {

        String sql = "DELETE FROM Alumno WHERE id_alumno = ?";

        try (Connection cn = ConexionSingleton.getInstancia().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, id);

            ps.executeUpdate();
        }
    }
}
