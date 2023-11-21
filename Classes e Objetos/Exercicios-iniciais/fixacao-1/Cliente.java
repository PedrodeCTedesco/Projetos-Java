package lab1_javaExercicios;

public class Cliente {

    //Atributos
    private String nome, email, sexo;
    private Integer idade, senha;


    //Construtor

    public Cliente (String nome, String email, Integer idade, Integer senha, String sexo) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.senha = senha;
        this.sexo = sexo;
    }

    //Getters

    public String getNome () {
        return this.nome;
    };

    public String getEmail () {
        return this.email;
    };

    public Integer getIdade () {
        return this.idade;
    };

    public Integer getSenha () {
        return this.senha;
    };

    public String getSexo () {
        return this.sexo;
    };

    //Setters

    public void setNome (String nome) {
        this.nome = nome;
    };

    public void setEmail (String email) {
        this.email = email;
    };

    public void setIdade (Integer idade) {
        this.idade = idade;
    };

    public void setSenha (Integer senha) {
        this.senha = senha;
    };

    public void setSexo (String sexo) {
        this.sexo = sexo; 
    };

    //Métodos

    public void imprimeInformacoes () {
        System.out.println("Nome: " + this.nome);
        System.out.println("E-mail: " + this.email);
        System.out.println("Idade: " + this.idade);
        System.out.println("Senha: " + this.senha);
        System.out.println("Sexo: " + this.sexo);
    };
};
