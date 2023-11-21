package lab1_javaExercicios_4;
public class Empresa {
    //Atributos

    private String nomeEmpresa, funcionario_1, funcionario_2;
    
    //Construtores

    public Empresa (String nomeEmpresa, String funcionario_1, String funcionario_2) {
        this.nomeEmpresa = nomeEmpresa;
        this.funcionario_1 = funcionario_1;
        this.funcionario_2 = funcionario_2;
    };

    public Empresa (String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
        this.funcionario_1 = null;
        this.funcionario_2 = null;
    };

    public Empresa () {
        this.nomeEmpresa = "Nova empresa";
        this.funcionario_1 = null;
        this.funcionario_2 = null;
    };
    
    //Métodos de acesso

    public String getNomeEmpresa () {
        return this.nomeEmpresa;
    };

    public String getFuncionario1 () {
        return this.funcionario_1;
    };

    public String getFuncionario2 () {
        return this.funcionario_2;
    };

    //Métodos de configuração

    public void setNomeEmpresa (String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    };

    public void setNomeFuncionario1 (String funcionario_1) {
        this.funcionario_1 = funcionario_1;
    };

    public void setNomeFuncionario2 (String funcionario_2) {
        this.funcionario_2 = funcionario_2;
    };

    public void imprimeInfoEmpresa () {
        System.out.println("Nome da empresa: " + this.nomeEmpresa);
        System.out.println("Nome do primeiro funcionário do caixa: " + this.funcionario_1);
        System.out.println("Nome do segundo funcionário do caixa: " + this.funcionario_2);
    };

}   
