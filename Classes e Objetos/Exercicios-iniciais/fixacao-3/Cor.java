package lab1_javaExercicios_3;

public class Cor {
    //Atributos

    private Integer r, g, b;

    //Construtor

    public Cor (Integer r, Integer g, Integer b) {
        this.r = r;
        this.g = g;
        this.b = b;
    };

    //Métodos de acesso (getters)

    public Integer getR () {
        return this.r;
    };

    public Integer getG () {
        return this.g;
    };

    public Integer getB () {
        return this.b;
    };

    //Métodos de configuração (setters)

    public void setR (Integer r) {
        this.r = r;
    };

    public void setG (Integer g) {
        this.g = g;
    };

    public void setB (Integer b) {
        this.b = b;
    };
}
