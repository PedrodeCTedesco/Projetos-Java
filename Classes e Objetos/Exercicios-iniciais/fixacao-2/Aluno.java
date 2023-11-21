package lab1_javaExercicios_2;

public class Aluno {
    //Atributos

    private String nome;
    private Integer matricula;
    private Double notaGrauA, notaGrauB;

    //Construtor

    public Aluno (String nome, Integer matricula, Double notaGrauA, Double notaGrauB) {
        this.nome = nome;
        this.matricula = matricula;
        this.notaGrauA = notaGrauA;
        this.notaGrauB = notaGrauB;
    };

    //Métodos de acesso (Getters)

    public String getNome () {
        return this.nome;
    };

    public Integer getMatricula () {
        return this.matricula;
    };

    public Double getNotaGrauA () {
        return this.notaGrauA;
    };

    public Double getNotaGrauB () {
        return this.notaGrauB;
    };

    //Métodos de configuração (Setters)

    public void setNome (String nome) {
        this.nome = nome;
    };

    public void setMatricula (Integer matricula) {
        this.matricula = matricula;
    };

    public void setNotaGrauA (Double notaGrauA) {
        this.notaGrauA = notaGrauA;
    };

    public void setNotaGrauB (Double notaGrauB) {
        this.notaGrauB = notaGrauB;
    };

    //Métodos

    public Double calculaMediaFinal (Double notaGrauA, Double notaGrauB) {
        
        Double media = ((notaGrauA * 0.33) + (notaGrauB * 0.67));
        return media;
    };

    public void imprimeInfo() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Matrícula: " + this.matricula);
        System.out.println("Média: " + this.calculaMediaFinal(notaGrauA, notaGrauB));
    };  

    @Override

    public String toString() {
        return "Nome: " + this.nome + "Matrícula: " + this.matricula + "Média: " + this.calculaMediaFinal(notaGrauA, notaGrauB);
    };

}
