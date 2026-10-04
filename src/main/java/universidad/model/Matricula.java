package universidad.model;

public class Matricula {
    private Alumno alumno;
    private Curso curso;
    private float nota1;
    private float nota2;
    private float nota3;
    private float PA;

    public Matricula(Alumno alumno, Curso curso) {
        this.alumno = alumno;
        this.curso = curso;
        this.nota1=0;
        this.nota2=0;
        this.nota3=0;
        this.PA=0;
    }
    public void guardarNotas(float nota1, float nota2, float nota3, float PA){
        if (    nota1<0 || nota1>20 ||
                nota2<0 || nota2>20 ||
                nota3<0 || nota3>20 ||
                PA<0 || PA>20 ){
            throw new IllegalArgumentException("las notas deben estar en un rango de 0 a 20");
        }
        this.nota1=nota1;
        this.nota2=nota2;
        this.nota3=nota3;
        this.PA=PA;
    }

}
