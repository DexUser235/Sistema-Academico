package universidad.model;

import universidad.model.Strategy.Prom.GestionCurso;
import universidad.model.Strategy.Prom.PromedioEstandarEstrategia;

public class InfoCursos {
    private GestionCurso gestionCurso;

    public InfoCursos() {
        this.gestionCurso = new GestionCurso(new PromedioEstandarEstrategia());
    }

    public String mostrarNotasAlumno(Matricula matricula) {
        if (matricula == null) return "";

        float promedio = gestionCurso.calcularPromedio(matricula);

        return String.format("""
                ===== BOLETA DE NOTAS =====
                Alumno: %s
                Curso: %s
                Nota 1: %.2f
                Nota 2: %.2f
                Nota 3: %.2f
                PA: %.2f
                promedio final: %.2f
                """, matricula.getAlumno().getNombre(), matricula.getCurso().getNombreCurso(), matricula.getNota1(),
                matricula.getNota2(), matricula.getNota3(), matricula.getPA(), promedio);
    }

    public void mostrarReporteCurso(Curso curso) {
        if (curso == null) return;
        System.out.println("REPORTE CONSOLIDADO: " + curso.getNombreCurso());

        for (Matricula m : curso.getMatriculas()) {
            mostrarNotasAlumno(m);
            System.out.println("------------------------------------------");
        }
    }
}
