package lab1_javaExercicios_5;
public class Mercado {
    //Atributos

    Prateleira prateleira_1, prateleira_2;

    //Construtor

    public Mercado (Prateleira prateleira_1, Prateleira prateleira_2) {
        this.prateleira_1 = prateleira_1;
        this.prateleira_2 = prateleira_2;
    };

    //Métodos de acesso

    public Prateleira getPrateleira1 () {
        return prateleira_1;
    };

    public Prateleira getPrateleira2 () {
        return prateleira_2;
    };

    //Métodos

    public Double mediaValorProdutos () {
        //Variáveis necessárias

        Integer qtdProdutos = 0;
        Double somaProdutos = 0.0;

        //Sentenças de seleção para verificar se há ou não produtos em cada prateleira

        if (prateleira_1.getProduto1() != null) {
            qtdProdutos++;
            somaProdutos = prateleira_1.getProduto1().getPreco();
        }

        if (prateleira_1.getProduto2() != null) {
            qtdProdutos++;
            somaProdutos = prateleira_1.getProduto2().getPreco();
        }

        if (prateleira_1.getProduto3() != null) {
            qtdProdutos++;
            somaProdutos = prateleira_1.getProduto3().getPreco();
        }

        if (prateleira_2.getProduto1() != null) {
            qtdProdutos++;
            somaProdutos = prateleira_2.getProduto1().getPreco();
        };

        if (prateleira_2.getProduto2() != null) {
            qtdProdutos++;
            somaProdutos = prateleira_2.getProduto2().getPreco();
        }

        if (prateleira_2.getProduto3() != null) {
            qtdProdutos++;
            somaProdutos = prateleira_2.getProduto3().getPreco();
        }

        if (qtdProdutos == 0) {
            return 0.0;
        } else {
            return somaProdutos / qtdProdutos;
        }
        
    }
}
