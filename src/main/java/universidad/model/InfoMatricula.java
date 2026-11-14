package universidad.model;

import java.util.ArrayList;
import java.util.List;

public class InfoMatricula {

    public static Matricula buscarAlumno(List<Matricula> matriculas, String IdAlumno, Area area) {
        if (matriculas == null || IdAlumno == null || area == null) {
            return null;
        }
        for (Matricula m : matriculas) {
            boolean coincideAlumno = m.getAlumno().getId().equalsIgnoreCase(IdAlumno);
            boolean coincideArea = m.getAlumno().getEspecialidad() == area || m.getCurso().getEspecialidad() == area;

            if (coincideAlumno && coincideArea) {
                return m;
            } else {
                System.out.println("No se encontró el alumno");
            }
        }
        return null;
    }

    public static void filtrarPorArea(List<Matricula> matriculas, Area area) {
        List<Alumno> filtrado = new ArrayList<>();
        if (matriculas == null || area == null) return;

        for (Matricula m : matriculas) {
            if (m.getAlumno().getEspecialidad() == area || m.getCurso().getEspecialidad() == area) {
                filtrado.add(m.getAlumno());
            } else {
                System.out.println("No se pudo filtrar");
            }
        }
        for (Alumno alumno : filtrado) {
            System.out.printf("""
                    - Alumno: %s | ciclo: %d
                    """, alumno.getNombre(), alumno.getCiclo());
        }
    }
}
