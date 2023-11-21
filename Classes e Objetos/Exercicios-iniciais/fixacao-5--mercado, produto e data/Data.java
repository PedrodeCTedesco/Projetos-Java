package lab1_javaExercicios_5;

public class Data {
    //Atributos

    Integer dia, mes, ano;

    //Construtor

    public Data (Integer dia, Integer mes, Integer ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    };

    public Data () {};

    //Métodos de acesso

    public Integer getDia() {
        return this.dia;
    };

    public Integer getMes () {
        return this.mes;
    };

    public Integer getAno () {
        return this.ano;
    };

    //Métodos de configuração

    public void setDia (Integer dia) {
        this.dia = dia;
    };

    public void setMes (Integer mes) {
        this.mes = mes;
    };

    public void setAno (Integer ano) {
        this.ano = ano;
    };

    //Sobreposição

    @Override

    public String toString () {
        return "Representação textual do objeto: \n Dia: " + this.dia + "\n Mês: " + this.mes + "\n Ano: " + this.ano;
    };

    
}
