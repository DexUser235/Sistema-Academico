package universidad.model;

public class GestionCurso {
    public float calcularPromedio(Matricula matricula){
        double promedio = matricula.getNota1() * 0.2 + matricula.getNota2() * 0.2 + matricula.getNota3() * 0.2 + matricula.getPA() * 0.4;
        return (float) promedio;
    }
}
