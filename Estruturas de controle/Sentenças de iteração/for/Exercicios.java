package lab1_javaExercicios_8_for;


import java.util.Scanner;
import java.util.ArrayList;

public class Exercicios {
    //Atributos

    Scanner input = new Scanner(System.in);

    //Métodos

    public void exercicio1 (Integer num) {
        //Lista para armazenar os nomes
        ArrayList<String> nomes = new ArrayList<String>();
        String s;

        for (Integer i = 0; i < num; i++) {
            System.out.print("Insira o nome da pessoa: ");
            s = input.nextLine();
            nomes.add(s);
        };
    };

    public void exercicio2 (Integer num) {

        for (Integer i = 0; i <= num; i++) {
            System.out.print(i + "\n");
        };

    };

    public void exercicio3 (Integer num) {
        //Verificação

        if (num < 0) {
            System.out.print("Informe um número que não seja negativo.");
        }

        for (Integer i = 0; i < num; i++) {
            System.out.print(i + "\n");
            i++;
        };


    }

    public void exercicio4 (Integer num) {
        //Verificação

        if (num < 0) {
            System.out.print("Informe um número que não seja negativo.");
        }

        for (Integer i = num; i == 0; i--) {
            System.out.print(i + "\n");
        };


    };

    public void exercicio5 (Integer num) {
        //Declarando as variáveis necessárias
        ArrayList<String> torcedorGremio = new ArrayList<String>();
        ArrayList<String> storeInformation = new ArrayList<String>();
        String info;

        for (Integer i = 0; i < num; i++) {
            //Array para armazenar os times dos usuários; variável para armazenar os dados de entrada
            storeInformation = new ArrayList<String>();
           
            //Solicitando os dados de entrada
            System.out.print("Informe os times dos " + num + " usuários: ");
            info = input.nextLine();

            //Armazenando os dados no array
            storeInformation.add(info);
        };

        for (Integer i = 0; i < storeInformation.size(); i++) {
            if (storeInformation.get(i) == "Grêmio") {
                torcedorGremio.add(storeInformation.get(i));
            };
        };

        System.out.println("Temos " + torcedorGremio.size() + " torcedores do Grêmio.");

    };

    public void exercicio6 (Integer num) {
        //Declarando as variáveis necessárias
        ArrayList<Float> floatNumbers = new ArrayList<Float> ();
        Float floatInput;
        Double soma = 0.0;

        //Sentença de iteração

        for (Integer i = 0; i < num; i++) {
            //Solicitando a entrada dos números de ponto flutuante
            System.out.print("Insira os números de ponto flutuante: ");
            floatInput = Float.parseFloat(input.nextLine());

            floatNumbers.add(floatInput);

            soma = 0.0; 
            soma = soma + floatNumbers.get(i);
        };

        System.out.print(soma);
    }

    public void exercicio7 (Integer num) {
        //Declarando as variáveis necessárias
        ArrayList<Integer> intNumbers = new ArrayList<Integer> ();
        Integer intInput;
        Integer soma = 0;

        //Armazenando os valores no array

        for (Integer i = 0; i < num; i++) {

            System.out.print("Insira os números inteiros: ");
            intInput = Integer.parseInt(input.nextLine());

            intNumbers.add(intInput);

            soma = soma + intNumbers.get(i);
        };

        System.out.print("A soma é: " + soma);
    }

    public void exercicio8 (Integer num) {
        //Declarando variáveis
        ArrayList<Integer> intArray = new ArrayList<Integer> ();
        Integer intNumber;

        //Sentença de iteração
        for (Integer i = 0; i < num; i++) {
            //Solicitando que o usuário digite os números
            System.out.print("Digite os números: ");
            intNumber = Integer.parseInt(input.nextLine());

            intArray.add(intNumber);
        };

        for (Integer intEach : intArray) {
            if (intEach > 0) {
                System.out.print("O número " + intEach + " é positivo.\n");
            } else if (intEach == 0) {
                System.out.print("O número " + intEach + " é zero.\n");
            } else {
                System.out.print("O número " + intEach + " é negativo.\n");
            };
        };

    };

    public void exercicio9 (Integer num1, Integer num2) {
        //Declarando variáveis necessárias
        Integer inicio;
        Integer fim;

        //Verificação
        if (num1 <= 0 || num2 <= 0) {
            System.out.print("Um dos números indicados é menor do que zero ou é zero.");
        };

        //Determinando o início da iteração e o término dela

        if (num1 > num2) {
            inicio = num2;
            fim = num1;
        } else {
            inicio = num1;
            fim = num2;
        }

        //Sentença de verificação de número inicial par ou ímpar

        if (inicio % 2 == 0) {
            inicio = inicio + 2;

            for (Integer i = inicio; i < fim; i++) {
                System.out.print(i);
                i++;
            }

        } else {
            inicio++;
            for (Integer i = inicio; i < fim; i++) {
                System.out.print(i);
            }
        };

    };

    public void exercicio10 (Integer num) {
        //Declarando variáveis
        Integer soma = 0;

        if (num == 1) {
            for (Integer i = 0; i < 198; i++) {
                soma = soma + i;
            }   
        };

        System.out.print("A soma é: " + soma + "\n");
        
    };

    public void exercicio11 (Integer num1, Integer num2) {
        //Declarando as variáveis necessárias
        Integer soma = 0;
        ArrayList<Integer> numeros = new ArrayList<Integer> ();
        ArrayList<Integer> numerosImpares = new ArrayList<Integer> ();

        //Verificação

        if (num2 == 0) {
            System.out.print("O número final não pode ser zero.");
        };

        if (num2 >= num1) {
            System.out.print("O número final não pode ser menor ou igual ao número inicial.");
        };

        //Sentença de iteração para verificar o número de início

        if (num1 % 2 == 0) {
            num1 = num1 + 1;

            for (Integer i = num1; i < num2; i++) {
                numeros.add(i);
            };
        } else {
            for (Integer i = num1; i < num2; i++) {
            numeros.add(i);
            };
        };

        //Armazenando apenas os números ímpares

        for (Integer impares : numeros) {

            if (impares % 2 != 0) {
                numerosImpares.add(impares);
            };
        };

        //Soma dos números ímpares

        for (Integer i = 0; i < numerosImpares.size(); i++) {
            soma = soma + numerosImpares.get(i);
        };

        System.out.print("A soma dos números ímpares entre " + num1 + " e" + num2 + " é: " + soma + "\n");
    };

    public void exercicio12 () {
        //Variáveis
        ArrayList<Integer> numerosDigitados = new ArrayList<Integer> ();
        Integer soma, num, media;
        soma = 0;

        //Início do método
        num = 0;

        while (num >= 0) {
            System.out.print("Informe um número: ");
            num = Integer.parseInt(input.nextLine());

            numerosDigitados.add(num);
        };

        //Após a inserção de um número negativo

        for (Integer i = 0; i < numerosDigitados.size(); i++) {
           soma = 0;
           soma = soma + numerosDigitados.get(i);
        };

        media = soma / numerosDigitados.size();

        System.out.print("A média dos números digitados é: " + media);
    };

    public void exercicio13 (Integer num) {
        //Variáveis
        Integer fatorial = 1;

        //Lógica do fatorial

        for (Integer i = num; i == 1; i--) {
            fatorial = fatorial * i;
        };

        System.out.print("O fatorial de " + num + " é: " + fatorial);
    };

    public Boolean exercicio14 (Integer num) {

        if (num % num == 0 && num % 1 == num) {
            return true;
        } else {
            return false;
        }
    };

    public void exercicio15 (Integer num) {
        //Variáveis
        ArrayList<Integer> numeros = new ArrayList<Integer> ();
        Integer soma = 0;

        //Verificação se o número inserido é primo

        if (num % num == 0 && num % 1 == num) {
            System.out.print("O número " + num + " é primo.");
        } else {
            System.out.print("O número " + num + " não é primo.");
        };

        //Saber quantos números primos entre 0 e num

        for (Integer i = 0; i < num; i++) {
            if (i % i ==0 && i % 1 == i) {
                numeros.add(i);
            };
        };

        System.out.print("Há " + numeros.size() + " números primos entre 0 e " + num);

        //Soma dos números primos

        for (Integer i = 0; i < numeros.size(); i++) {
            soma = soma + numeros.get(i);
        }

        //Retornando a soma
        System.out.print("A soma dos números primos entre 0 e " + num + " é: " + soma);

    };

}
