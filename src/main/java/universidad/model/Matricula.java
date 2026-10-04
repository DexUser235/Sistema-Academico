package universidad.model;

import java.util.ArrayList;
import java.util.List;

public class Matricula {
    private final Alumno alumno;
    private final Curso curso;
    private float nota1;
    private float nota2;
    private float nota3;
    private float PA;

    public Matricula(Alumno alumno, Curso curso) {
        if (alumno == null || curso == null) {
            throw new IllegalArgumentException("Alumno y Curso no pueden ser nulos");
        }
        this.alumno = alumno;
        this.curso = curso;
        this.nota1 = 0f;
        this.nota2 = 0f;
        this.nota3 = 0f;
        this.PA = 0f;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Curso getCurso() {
        return curso;
    }

    public float getNota1() {
        return nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public float getNota3() {
        return nota3;
    }

    public float getPA() {
        return PA;
    }

    public void setNotas(float nota1, float nota2, float nota3, float PA) {
        setNota1(nota1);
        setNota2(nota2);
        setNota3(nota3);
        setPA(PA);
    }

    public void setNota1(float nota1) {
        if (validarNotas(nota1)) {
            this.nota1 = nota1;
        }
    }

    public void setNota2(float nota2) {
        if (validarNotas(nota2)) {
            this.nota2 = nota2;
        }
    }

    public void setNota3(float nota3) {
        if (validarNotas(nota3)) {
            this.nota3 = nota3;
        }
    }

    public void setPA(float PA) {
        if (validarNotas(PA)) {
            this.PA = PA;
        }
    }

    private boolean validarNotas(float nota){
        return nota >= 0f || nota <= 20f;
    }

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


    public static List<Matricula> filtrarPorArea(List<Matricula> matriculas, Area area) {
        List<Matricula> filtrado = new ArrayList<>();
        if (matriculas == null || area == null) return filtrado;

        for (Matricula m : matriculas) {
            if (m.getAlumno().getEspecialidad() == area || m.getCurso().getEspecialidad() == area) {
                filtrado.add(m);
            } else {
                System.out.println("No se pudo filtrar");
            }
        }
        return filtrado;
    }
}
