package universidad.main ;

import universidad.database.ConexionSingleton;
import universidad.model.*;
import universidad.model.Builder.CursoBuilder;
import universidad.model.Builder.CursoBuilderConcreto;
import universidad.model.Builder.CursoDirector;
import universidad.model.Curso;
import universidad.model.Strategy.dictadoClases.EstrategiaDictado;
import universidad.model.Strategy.dictadoClases.EstrategiaSistemas;
import universidad.model.proxy.BoletaProxy;
import universidad.model.proxy.BoletaReal;
import universidad.model.proxy.RolUsuario;
import universidad.model.proxy.Usuario;
import universidad.model.repository.AlumnoRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) throws SQLException {
        /*EstrategiaDictado sistemas = new EstrategiaSistemas();
        InfoCursos info = new InfoCursos();

        Docente docente = new Docente(sistemas, Area.Sistemas, "Matt");

        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("1", "Juan Gómez", Area.Sistemas, (byte) 1));
        alumnos.add(new Alumno("2","Maria López", Area.Civil, (byte) 1));
        alumnos.add(new Alumno("3","Maria López", Area.Sistemas, (byte) 1));

        CursoBuilderConcreto builder = new CursoBuilderConcreto();
        CursoDirector director = new CursoDirector();
        director.construirCurso(builder,"Algoritmos I", Area.Sistemas, docente, alumnos);
        Curso director = builder.getResultado();

        System.out.println(director);

        Matricula matriculaJuan = Matricula.buscarAlumno(director.getMatriculas(),"1", Area.Sistemas);
        matriculaJuan.setNotas(15.0f, 16.0f, 14.0f, 18.0f);

        System.out.println("\nRESULTADO EVALUACIÓN:");
        System.out.println(info.mostrarNotasAlumno(matriculaJuan));

        System.out.println("---Visualización de como se trasmiten las clases:---");
        DictadoDecorator decorator = new ConTeoriaDecartor(new EstrategiaSistemas());
        docente.impartirClase();
        System.out.println("#¬ el docente quiere ver las diapositivas: #¬");
        docente.setEstrategia(decorator);
        docente.impartirClase();*/


        ConexionSingleton conexion1 =
                ConexionSingleton.getInstancia();

        ConexionSingleton conexion2 =
                ConexionSingleton.getInstancia();

        System.out.println(conexion1 == conexion2);


        AlumnoRepository repository = new AlumnoRepository();

        try {
            List<Alumno> alumnos = repository.listarTodos();

            if (alumnos.isEmpty()) {
                System.out.println("No hay alumnos registrados.");
            } else {
                for (Alumno alumno : alumnos) {
                    alumno.consultarEstado();
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar alumnos: " + e.getMessage());
        }

        Optional<Alumno> resultado = repository.buscarPorId("ALU001");

        if (resultado.isPresent()) {
            resultado.get().consultarEstado();
        } else {
            System.out.println("Alumno no encontrado.");
        }

        Alumno nuevoAlumno = new Alumno(
                "ALU005",
                "Pedro Castillo",
                Area.Sistemas,
                (byte) 4
        );

        try {
            repository.registrar(nuevoAlumno);
            System.out.println("Alumno registrado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al registrar: " + e.getMessage());
        }

        Alumno alumnoActualizado = new Alumno(
                "ALU005",
                "Pedro Castillo",
                Area.Civil,
                (byte) 5
        );

        try {
            repository.actualizar(alumnoActualizado);
            System.out.println("Alumno actualizado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }

        try {
            repository.eliminar("ALU005");
            System.out.println("Alumno eliminado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }

        System.out.println("\n===== PRUEBA DEL PATRÓN PROXY =====");
        Alumno alumno1 = new Alumno(
                "ALU001",
                "Juan Gómez",
                Area.Sistemas,
                (byte) 1
        );


        EstrategiaDictado estrategia = new EstrategiaSistemas();

        Docente docente = new Docente(
                estrategia,
                Area.Sistemas,
                "Matt"
        );

        CursoBuilder builder = new CursoBuilderConcreto();
        CursoDirector director = new CursoDirector();

        director.construirCurso(builder, "Algoritmos I", Area.Sistemas, docente, alumno1);

        Curso curso = builder.getResultado();

        Matricula matricula = new Matricula(alumno1, curso);

        matricula.setNotas(15, 16, 14, 18);

        InfoCursos infoCursos = new InfoCursos();

        BoletaReal boletaReal = new BoletaReal(infoCursos);

        BoletaProxy boletaProxy = new BoletaProxy(boletaReal);

        Usuario usuarioAlumno = new Usuario(
                "ALU001",
                RolUsuario.ALUMNO
        );

        System.out.println(boletaProxy.consultarBoleta(usuarioAlumno, matricula));
    }
}
