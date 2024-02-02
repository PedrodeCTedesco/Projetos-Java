package org.conductor.arrays.arraysDePrimitivos;

public class Exercicios
{
    public void exercicio1 (int[] arr)
    {
        System.out.printf("A ordem dos elementos originais do array: ");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(" " + arr[i]);
        };//fim da sentença de iteração for

        System.out.printf("\nA ordem ao contrário: ");
        for(int i = 1; i <= arr.length; i++)
        {
            try
            {
                System.out.print(" " + arr[arr.length - i]);

            } catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.print(e);
                System.out.printf("\nErro no elemento: array[%d]", i);
            }

        };//fim da sentença de iteração for
    };//fim do método exercicio1(int[] arr);

    public int[] exercicio3 (int[] arr)
    {
        /**São criadas 4 variáveis:
         * int: b -> serve como variável que define o tamanho do array e/ou a condição de parada
         * do laço while. Seria como a condição de cessação de um for com contador.
         *
         * int: i -> serve como posição de índice do array passado como argumento. Seria a variável
         * integer da primeira condição do for com contador.
         *
         * int: j -> serve como posição de índice do novo array que será retornado pelo método.
         *
         * int[] arr2 -> o novo array que será retornado. Note que ele é especificado como 5, mas
         * poderia ter ali a variável b.*/
        int b = arr.length;
        int[] arr2 = new int[5];
        int i = 0;
        int j = 0;

        /**A sentença de iteração while é utilizada para garantir que todas as
         * posições do novo array sejam preenchidas pelos números pares do
         * array passado como argumento.
         * */

        while (i < b)
        {
            if(arr[i] % 2 == 0)
            {
                arr2[j] = arr[i];
                j++;
            };//fim do if
            i++;
        };//fim do while
        System.out.printf("Os números pares do array: ");
        for (int number : arr2)
        {
            System.out.printf(" %d ", number);
        };
        return arr2;
    };//fim do método exercicio3(int[]arr)

    public int exercicio4 (String[] arr, String x)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i].equalsIgnoreCase(x))
            {
                System.out.printf("%nPosição da string %s é %d%n", arr[i], i);
                return i;
            }//fim do if
        };//fim da sentença de iteração for
        System.out.printf("Essa string não consta no array");
        return -1;
    };//fim do método exercicio4(String[] arr, String x);

    public int[] exercicio5(boolean[] bool)
    {
        /**Lógica similar ao exercício 4*/
        int tamanho = bool.length;
        int i = 0; //Será o valor da posição de índice do array bool;
        int j = 0; //Será o valor da posição de índice do array de inteiros;
        int[] arr = new int[tamanho]; //O array de inteiros que será retornado.

        while (i < tamanho)
        {
            if (bool[i] == true)
            {
                arr[j] = 1;
                j++;
            }//fim do if

            if (bool[i] == false)
            {
                arr[j] = 0;
                j++;
            }//fim do if
            i++;
        };//fim do while
        System.out.print("O array original continha: ");
        for (boolean boolElement : bool)
        {
            System.out.printf(" %b ", boolElement);
        };//fim da sentença de iteração;

        System.out.print("\nO array modificado: ");
        for (int counter = 0; counter < arr.length; counter++)
        {
            System.out.printf(" %d ", arr[counter]);
        };//fim da sentença de iteração;
        return arr;
    };//fim do método exercicio5(boolean[]bool);

    public int[] exercicio6(int[]arr1, int[]arr2)
    {
        /**Variante da lógica dos exercício 4 e 6*/
        int tamanho = arr1.length + arr2.length;
        int i = 0; //Valor da posição de índice do primeiro array;
        int z = 0; //Valor da posição de índice do terceiro array (array de retorno);
        int[] arr3 = new int[tamanho]; //Array de retorno.


        for (int counter = 0; counter < arr1.length; counter++)
        {
            arr3[z] = arr1[counter];
            z++;
            i++;
        };//fim da sentença de iteração for

        for (int counter2 = 0; counter2 < arr2.length; counter2++)
        {
            arr3[i] = arr2[counter2];
            i++;
        };//fim da sentença de iteração for

        System.out.print("O primeiro array tinha os componentes: ");
        for (int countArr1 = 0; countArr1 < arr1.length; countArr1++)
        {
            System.out.printf(" %d ", arr1[countArr1]);
        };//fim da sentença de iteração for;

        System.out.print("\nO segundo array tinha os componentes: ");
        for (int countArr2 = 0; countArr2 < arr2.length; countArr2++)
        {
            System.out.printf(" %d ", arr2[countArr2]);
        };//fim da sentença de iteração for

        System.out.print("\nO terceiro array possui os componentes: ");
        for (int countArr3 = 0; countArr3 < arr3.length; countArr3++)
        {
            System.out.printf(" %d ", arr3[countArr3]);
        };//Fim da sentença de iteração for
        return arr3;
    };//fim do método exercicio6(int[]arr1, int[]arr2)

    public int[] exercicio7(int[] arr1, int[] arr2)
    {
        /**O primeiro array deve conter apenas os números negativos dos dois
         * arrays recebidos por parâmetro.
         * Criar uma variável que armazenará os valores negativos;
         * Criar uma variável que armazenará os valores positivos.
         * */
        int countNegativos = 0;
        int countPositivos = 0;
        int j = 0;
        int z = 0;
        int a = 0;
        int b = 0;
        int tamanho = arr1.length + arr2.length;
        int[] teste = {1};

        /**Sentença de iteração para identificar os números negativos
         * de ambos os arrays passados como argumentos*/
        for (int i = 0; i < arr1.length; i++)
        {
            //Sentença de seleção para armazenar apenas valores negativos
            if (arr1[i] < 0)
            {
                countNegativos++;
            }
        }//Fim do for arr1

        for (int i = 0; i < arr2.length; i++)
        {
            if (arr2[i] < 0)
            {
                countNegativos++;
            }
        }//fim do for arr2

        /**Criando o array que armazenará os valores negativos dos arrays*/
        int[] arrayNegativos = new int[countNegativos];

        /**Sentença de iteração para armazenar os valores negativos dos arrays*/
        for (int i = 0; i < arr1.length; i += 1)
        {
            if (arr1[i] < 0)
            {
                arrayNegativos[j] = arr1[i];
                j++;
            }
        }//fim do for

        for (int i = 0; i < arr2.length; i++)
        {
            if (arr2[i] < 0)
            {
                arrayNegativos[j] = arr2[i];
                j++;
            }
        };//fim do for

        /**Agora criar a mesma lógica para os números positivos.*/
        for (int i = 0; i < arr1.length; i++)
        {
            //Sentença de seleção para armazenar apenas valores negativos
            if (arr1[i] >= 0)
            {
                countPositivos++;
            }
        }//Fim do for arr1

        for (int i = 0; i < arr2.length; i++)
        {
            if (arr2[i] >= 0)
            {
                countPositivos++;
            }
        }//fim do for arr2

        /**Criando o array que armazenará os valores negativos dos arrays*/
        int[] arrayPositivos = new int[countPositivos];

        /**Sentença de iteração para armazenar os valores negativos dos arrays*/
        for (int i = 0; i < arr1.length; i += 1)
        {
            if (arr1[i] >= 0)
            {
                arrayPositivos[z] = arr1[i];
                z++;
            }
        }//fim do for

        for (int i = 0; i < arr2.length; i++)
        {
            if (arr2[i] >= 0)
            {
                arrayPositivos[z] = arr2[i];
                z++;
            }
        };//fim do for

        /**Criação do array cuja primeira parte contém os valores negativos
         * e na segunda parte os valores positivos.
         * */
        int tamanhoArrFinal = countNegativos + countPositivos;
        int[] arrayFinal = new int[tamanhoArrFinal];

        for (int i = 0; i < arrayNegativos.length; i++)
        {
            arrayFinal[a] = arrayNegativos[i];
            a++;
            b++;
        };//fim do for

        for (int i = 0; i < arrayPositivos.length; i++)
        {
            arrayFinal[b] = arrayPositivos[i];
            b++;
        };//fim do for

        //Controle
        System.out.print("Valores no array final: ");
        for (int i = 0; i < arrayFinal.length; i++)
        {
            System.out.printf(" %d ", arrayFinal[i]);
        };//fim do for

        return arrayFinal;
    };//fim do método exercicio7(int[]arr1, int[]arr2);

    public void exercicio8 (char[] char1)
    {
        /**Imprimindo na tela todos os elementos do array*/
        System.out.printf("Os elementos do array são: ");
        for (int i = 0; i < char1.length; i +=1)
        {
            System.out.printf(" %s ", char1[i]);
        };//fim do for
    };//fim do método exercicio8(char[] char1);

    public int exercicio9 (int[] arr)
    {
        /**Criação das variáveis locais necessárias para o método.*/
        int soma = 0;
        int media = 0;

        for (int i = 0; i < arr.length; i += 1)
        {
            soma += arr[i];
        };//fim do for

        media = (soma / arr.length);

        System.out.printf("A média dos itens do array é: %d", media);
        return media;
    };//fim do método exercicio9(int[] arr)

    public int exercicio10 (int[]arr)
    {
        /**Criação das variáveis locais:
         * arrayPares: int[] -> array dos elementos pares;
         * soma: int -> variável para armazenar a soma dos elementos pares;
         * media:int -> variável para armazenar a média dos valores pares;
         * j:int -> variável que servirá de posição de índice do array de elementos pares;
         * count:int -> variável para armazenar a quantidade de itens pares do array e que servirá de tamanho do array de elementos pares;
         *  */
        int count = 0;
        int soma = 0;
        int media = 0;
        int j = 0;

        /**Identificando os elementos pares do array.*/
        for (int i = 0; i < arr.length; i += 1)
        {
            if (arr[i] % 2 == 0)
            {
                count += 1;
            }//fim do if
        };//fim do for

        /**Inicializando o array de pares*/

        int[]arrayPares = new int[count];

        /**Criando o array de elementos pares*/
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] % 2 == 0)
            {
                arrayPares[j] = arr[i];
                j++;
            };//fim do ir
        };//fim do for;

        /**Calculando a média dos elementos pares*/
        for (int i = 0; i < arrayPares.length; i += 1)
        {
            soma += arrayPares[i];
        };//fim do for

        media = (soma / arrayPares.length);

        System.out.printf("A média dos elementos pares do array é: %d", media);
        return media;
    };//fim do método exercicio10(int[]arr);

    public int exercicio11 (int[]arr, int x)
    {
        /**Criando as variáveis locais necessárias.
         * positin:int -> o valor do elemento do array na posição dada por x.
         * */
        int position = 0;
        for (int positionX : arr)
        {
            if (positionX == arr[x]) {
                positionX = arr[x];
                position = positionX;
            }
        };//fim do for aprimorado
        System.out.printf("O valor do elemento na posição %d é %d", x, position);
        return position;
    };//fim do método exercicio11(int[]arr, int x);

    public boolean exercicio12 (double[] d)
    {
        /**Criando as variáveis necessárias.*/
        int count = 0;

        for (int i = 0; i < d.length; i +=1)
        {
            if (d[i] < 0.0)
            {
                count++;
            }
        };//fim do for

        if (count > 0.0)
        {
            boolean result = true;
            System.out.printf("Existe número negativo: %b", result);
            return true;
        } else
        {
            boolean result = false;
            System.out.printf("Existe número negativo: %b", result);
            return false;
        }
    };//fim do método exercicio12(double[])

    public int exercicio13 (int[] arr)
    {
        /**Criando as variáveis necessárias*/
        int maxValue = Integer.MIN_VALUE;
        int indiceDoMaiorValor = 0;

        /**Organizando o array*/
        for (int i = 0; i < arr.length - 1; i += 1)
        {
            if (arr[i] > maxValue)
            {
                maxValue = arr[i];
                indiceDoMaiorValor = i;
            };//fim do if
        };//Fim do for

        //controle
        System.out.printf("Max value: %d na posição de índice: %d", maxValue, indiceDoMaiorValor);
        return maxValue;
    };//fim do método exercicio13(int[]arr);

    public int exercicio14 (int[] arr)
    {
        /**Criando as variáveis necessárias*/
        int maxValue = Integer.MIN_VALUE;
        int indiceDoMaiorValor = 0;

        /**Organizando o array*/
        for (int i = 0; i < arr.length - 1; i += 1)
        {
            if (arr[i] >= maxValue)
            {
                maxValue = arr[i];
                indiceDoMaiorValor = i;
            };//fim do if
        };//Fim do for

        //controle
        System.out.printf("Posição de índice do maior valor do array: %d", indiceDoMaiorValor);
        return indiceDoMaiorValor;

    };//fim do método exercicio14(int[]arr)

    public int exercicio15 (int[]arr)
    {
        /**Lógica inversa do exercício anterior.
         * Criando as variáveis necessárias.*/
        int menorValor = Integer.MAX_VALUE;

        /**Organizando o loop*/
        for (int i = 0; i < arr.length; i += 1)
        {
            if (arr[i] < menorValor)
            {
                menorValor = arr[i];
            };//fim do ir
        };//fim do for

        System.out.printf("O menor valor do array é: %d", menorValor);
        return menorValor;
    };//fim do exercicio15(int[] arr);

    public int exercicio16 (int[] arr)
    {
        /**Lógica inversa do exercício anterior.
         * Criando as variáveis necessárias.*/
        int menorValor = Integer.MAX_VALUE;
        int indice = 0;

        /**Organizando o loop*/
        for (int i = 0; i < arr.length; i += 1)
        {
            if (arr[i] <= menorValor)
            {
                menorValor = arr[i];
                indice = i;
            };//fim do ir
        };//fim do for

        System.out.printf("O índice do menor valor do array é: %d", indice);
        return indice;
    };//fim do método exercicio16(int[]arr);

    public boolean exercicio17(int[]arr1, int[]arr2)
    {
        /**A ideia é comparar os dois arrays. Se o valor de arr1[i] for diferente
         * do valor de arr[j] (com ambos índices iniciando em 0) então os arrays
         * não são iguais.
         * */
        int tamanho = arr1.length + arr2.length;
        boolean resultado = true;
        int j = 0;

        for (int i = 0; i < tamanho; i += 1)
        {
            if (arr1[i] != arr2[j])
            {
                resultado = false;
                j++;
                System.out.printf("Os arrays são iguais? %b\n Itens diferentes na posição %d do segundo array", resultado, j);
                return resultado;

            } else
            {
                resultado = true;
                j++;
            }
        };//fim do for
        System.out.printf("Os arrays são iguais: %b", resultado);
        return resultado;
    };//fim do método exercicio17(int[]arr1, int[]arr2)

    public String exercicio18(char[]char1)
    {

        String palavra = new String(char1);

        System.out.printf("%s", palavra);
        return palavra;
    };//fim do método exercicio18(char[]char1);

    public String exercicio19 (int[] arr)
    {
        String numerosArray = arr.toString();

        System.out.printf(" %s ", numerosArray);
        return numerosArray;
    };//fim do método exercicio19(int[]arr);
}
