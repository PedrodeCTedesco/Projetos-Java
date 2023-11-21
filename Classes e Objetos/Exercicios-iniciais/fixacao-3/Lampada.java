package lab1_javaExercicios_3;

public class Lampada {
    //Atributos

    private Boolean acessa;

    //Construtor

    public Lampada (Boolean acessa) {
        this.acessa = acessa;
    };

    //Métodos de acesso (getters)

    public Boolean getAcessa () {
        return this.acessa;
    };

    //Métodos de configuração (setters)

    public void setAcessa (Boolean acessa) {
        this.acessa = acessa;
    };
};