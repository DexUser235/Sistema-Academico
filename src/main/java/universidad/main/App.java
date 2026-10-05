package universidad.main;

import universidad.model.*;
import universidad.model.Curso;
import universidad.model.Builder.CursoBuilderConcreto;
import universidad.model.Builder.CursoDirector;
import universidad.model.Strategy.Decorator.ConTeoriaDecartor;
import universidad.model.Strategy.Decorator.DictadoDecorator;
import universidad.model.Strategy.dictadoClases.EstrategiaDictado;
import universidad.model.Strategy.dictadoClases.EstrategiaSistemas;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EstrategiaDictado sistemas = new EstrategiaSistemas();
        InfoCursos info = new InfoCursos();

        Docente docente = new Docente(sistemas, Area.Sistemas, "Matt");

        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("1", "Juan Gómez", Area.Sistemas, (byte) 1));
        alumnos.add(new Alumno("2","Maria López", Area.Civil, (byte) 1));
        alumnos.add(new Alumno("3","Maria López", Area.Sistemas, (byte) 1));

        CursoBuilderConcreto builder = new CursoBuilderConcreto();
        CursoDirector director = new CursoDirector();
        director.construirCurso(builder,"Algoritmos I", Area.Sistemas, docente, alumnos);
        Curso curso = builder.getResultado();

        System.out.println(curso);

        Matricula matriculaJuan = Matricula.buscarAlumno(curso.getMatriculas(),"1", Area.Sistemas);
        matriculaJuan.setNotas(15.0f, 16.0f, 14.0f, 18.0f);

        System.out.println("\nRESULTADO EVALUACIÓN:");
        System.out.println(info.mostrarNotasAlumno(matriculaJuan));

        System.out.println("---Visualización de como se trasmiten las clases:---");
        DictadoDecorator decorator = new ConTeoriaDecartor(new EstrategiaSistemas());
        docente.impartirClase();
        System.out.println("#¬ el docente quiere ver las diapositivas: #¬");
        docente.setEstrategia(decorator);
        docente.impartirClase();
    }
}
