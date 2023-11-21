package lab1_javaExercicios_5;
import java.util.ArrayList;
import java.util.Collections;

public class Prateleira {
    //Atributos

    Produto produto1, produto2, produto3;
    ArrayList<Produto> produtos;

    //Construtor

    public Prateleira (Produto produto1, Produto produto2, Produto produto3) {
        this.produto1 = produto1;
        this.produto2 = produto2;
        this.produto3 = produto3;
    };

    public Prateleira (){};

    //Métodos de acesso

    public Produto getProduto1 () {
        return this.produto1;
    };

    public Produto getProduto2 () {
        return this.produto2;
    };

    public Produto getProduto3 () {
        return this.produto3;
    };

    //Métodos de configuração

    public void setProduto1 (Produto produto1) {
        this.produto1 = produto1;
    };

    public void setProduto2 (Produto produto2) {
        this.produto2 = produto2;
    };

    public void setProduto3 (Produto produto3) {
        this.produto3 = produto3;
    };

    //Métodos

    public Produto produtoMaisCaro (ArrayList<Produto> produtos) {

        Double precoProduto1 = produtos.get(0).getPreco();
        Double precoProduto2 = produtos.get(1).getPreco();
        Double precoProduto3 = produtos.get(2).getPreco();

        ArrayList<Double> precosProdutos = new ArrayList<Double> ();
        precosProdutos.add(precoProduto1);
        precosProdutos.add(precoProduto2);
        precosProdutos.add(precoProduto3);

        Collections.sort(precosProdutos);

        if (precosProdutos.get(2) == produtos.get(0).getPreco()) {
            return produtos.get(0);

        } else if (precosProdutos.get(2) == produtos.get(1).getPreco()) {
            return produtos.get(1);

        } else {
            return produtos.get(2);
        }
        }


        //Métodos de sobreposição

        public String toString () {
            return "Os produtos disponíveis são: \n" + this.produto1 + "\n " + this.produto2 + "\n " + this.produto3;
        };
}
