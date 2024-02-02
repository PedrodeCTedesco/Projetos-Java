package org.conductor.arrays.arraysMultidimensionais.passeioDoCavalo;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Random;
import java.util.ArrayList;

public class PasseioDoCavalo
{
    public static void main(String[]args)
    {
        /**Para mover o cavalo temos que pegar o valor da posição de índice dos vetores HORIZONTAL e VERTICAL
        e em seguida subtrair ou adicionar o valor das posições ao valor atual da posição de índice do cavalo.
        Exemplo:
        HORIZONTAL[3] = -2 "pegar o valor da posição de índice dos vetores" = -2
        VERTICAL[3] = -1 "pegar o valor da posição de índice dos vetores" = -1
        Em seguida: "subtrair ou adicionar o valor das posições ao valor atual da posição de índice do cavalo"
        board[3][4] --> linha 3, coluna 4
        O valor da posição de índice board[3], 3 - 1 = 2. Novo valor da posição de índice: board[2]; (decrementar/incrementar)
        O valor da posição de índice board[][4], 4 - 2 = 2. Novo valor da posição de índice: board[][2]; (decrementar/incrementar)
        Valor final da posição do cavalo será dado pelos valores do índices: board[2][2]; */
        int contador = 0;
        Random randomNumber = new Random();

        int[] initialPosition = {randomNumber.nextInt(0,8), randomNumber.nextInt(0,8)};

        while (contador != 64)
        {
            int currentRow = decomposeArrayRow(initialPosition);
            int currentColumn = decomposeArrayColumn(initialPosition);

            //if para verificar se a posição de currentRow e currentColumn já está ocupada, i.e., o cavalo já passou por lá
            if (Objects.equals(board[currentRow][currentColumn], "K"))
            {

                while (Objects.equals(board[currentRow][currentColumn], "K"))
                {
                    int[]arr1 = nextPosition(initialPosition);

                    currentRow+=decomposeArrayRow(arr1);
                    currentColumn+=decomposeArrayColumn(arr1);

                    initialPosition[0] = currentRow;
                    initialPosition[1] = currentColumn;

                    board[currentRow][currentColumn] = "k";
                };//fim da sentença de iteração while
            };//fim da sentença de seleção condicional simples

            board[currentRow][currentColumn] = "K";
            System.out.printf("1) Current row: %d%nCurrent column: %d%n", currentRow, currentColumn);

            //Visualizando o tabuleiro
            print(board);

            int[]arr1 = nextPosition(initialPosition);

            currentRow+=decomposeArrayRow(arr1);
            currentColumn+=decomposeArrayColumn(arr1);

            System.out.printf("2) Current row: %d%nCurrent column: %d%n", currentRow, currentColumn);
            System.out.println();

            //board[currentRow][currentColumn] = "k";

            //print(board);

            initialPosition[0] = currentRow;
            initialPosition[1] = currentColumn;

            System.out.printf("3) Current row: %d%nCurrent column: %d%n", currentRow, currentColumn);
            contador+=1;
        };//fim da sentença de iteração while

        //teste
        int[] a = {4, 4};
        nextPositionAccess(a);


    };//fim do método main


    /**Campos
     * -board: int[][] --> tabuleiro de xadrez. É uma matriz bidimensional 8 por 8 (8linhas e 8 colunas)
     * -HORIZONTAL: int[] --> representa as possibilidades de movimento horizontal do cavalo. Movimentos para a esquerda possuem valores negativos.
     * -VERTICAL: int[] --> representa as possibilidades de movimento vertical do cavalo. Movimentos verticais ascendentes possuem valores negativos.
     * */
    private static final String[][] board = new String[8][8];
    private static final int[] HORIZONTAL = {2, 1, -1, -2, -2, -1, 1, 2}; //mudança de coluna
    private static final int[] VERTICAL = {-1, -2, -2, -1, 1, 2, 2, 1}; //mudança de linha

    /**Métodos implementação */

    private static void print(String[][] arr)
    {
        //Visualizando todas as casas do tabuleiro
        //Nota: Todas as casas do tabuleiro inicializam com o valor padrão
        System.out.printf("%s%n", "Tabuleiro");

        for (String[] strings : arr) {
            for (int coluna = 0; coluna < arr.length; coluna += 1) {
                System.out.printf("%s ", (strings[coluna] == null) ? "*" : strings[coluna]);
            }
            ;//fim da sentença de iteração for interna
            System.out.println();
        };//end of enhanced for
    };//end of print() method;

    private static int[] nextPosition(int[] arr)
    {
        //Retornar o valor armazenado na posição de índice do array unidimensional HORIZONTAL (colunas) e VERTICAL (linhas)
        Random randomNumber = new Random();
        int moveNumber = randomNumber.nextInt(0, 8);

        //Array para armazenar os valores da próxima posição
        int[] nextPositionRowAndColumn = new int[2];

        //Validação dos movimentos.
        //Canto esquerdo (críticas). Não são permitidos movimentos à esquerda (números negativos de coluna)
        for (PosicoesCriticas positionLeft : EnumSet.range(PosicoesCriticas.A8, PosicoesCriticas.B7))
        {
            if (positionLeft.getIndexRow() == decomposeArrayRow(arr) && positionLeft.getIndexColumn() == decomposeArrayColumn(arr))
            {
                //Se estiver no canto esquerdo não são válidas as posições de índice: 1, 2, 3, 4, 5, 6
                //Se for B7, então não são válidas as posições: 1, 2, 3, 4, 5
                moveNumber = randomNumber.nextInt(0, 8);

                //Verificação de B7
                //checkForB7(decomposeArrayRow(arr), decomposeArrayColumn(arr));
                if (PosicoesCriticas.B7.getIndexRow() == decomposeArrayRow(arr) && PosicoesCriticas.B7.getIndexColumn() == decomposeArrayColumn(arr))
                {
                    while (moveNumber >= 1 || moveNumber >= 6 )
                    {
                        moveNumber = randomNumber.nextInt(0, 8);
                    };//fim da sentença de iteração while
                    nextPositionRowAndColumn[0] = VERTICAL[moveNumber];
                    nextPositionRowAndColumn[1] = HORIZONTAL[moveNumber];

                    return nextPositionRowAndColumn;
                }//fim da sentença de seleção condicional simples


                while (moveNumber >= 1 && moveNumber <=6)
                {
                    moveNumber = randomNumber.nextInt(0, 8);
                };//fim da sentença de iteração while
                nextPositionRowAndColumn[0] = VERTICAL[moveNumber];
                nextPositionRowAndColumn[1] = HORIZONTAL[moveNumber];

                return nextPositionRowAndColumn;
            }//fim da sentença de seleção condicional simples
        }//fim da sentença de iteração for aprimorada

        //Validação de movimentos
        //Canto direito (críticas). Não são permitidos movimentos à direita (números positivos de coluna)
        for (PosicoesCriticas positionRight : EnumSet.range(PosicoesCriticas.H7, PosicoesCriticas.G6))
        {
            if (positionRight.getIndexRow() == decomposeArrayRow(arr) && positionRight.getIndexColumn() == decomposeArrayColumn(arr))
            {
                //Se estiver no canto direito não são válidos valores: 0, 1, 3, 4, 5, 6, 7
                //Se for H7 temos uma verificação especial, pois somente seria válido o valor da posição 5
                moveNumber = randomNumber.nextInt(0, 8);

                //Verificação de H7
                if (PosicoesCriticas.H7.getIndexRow() == decomposeArrayRow(arr) && PosicoesCriticas.H7.getIndexColumn() == decomposeArrayColumn(arr))
                {
                    while (moveNumber != 5)
                    {
                        moveNumber = randomNumber.nextInt(0, 8);
                    };//fim da sentença de iteração while
                    nextPositionRowAndColumn[0] = VERTICAL[moveNumber];
                    nextPositionRowAndColumn[1] = HORIZONTAL[moveNumber];

                    return nextPositionRowAndColumn;
                }//fim da sentença de seleção condicional simples

                while (moveNumber != 2)
                {
                    moveNumber = randomNumber.nextInt(0, 8);
                };//fim da sentença de iteração while
                nextPositionRowAndColumn[0] = VERTICAL[moveNumber];
                nextPositionRowAndColumn[1] = HORIZONTAL[moveNumber];

                return nextPositionRowAndColumn;
            }//fim da sentença de seleção condicional simples
        }//fim da sentença de iteração for aprimorada

        //Canto superior (críticas). Não são permitidos movimentos para cima (números negativos de linha)
        for (PosicoesCriticas positionTop : EnumSet.range(PosicoesCriticas.B8, PosicoesCriticas.G7))
        {
            if (positionTop.getIndexRow() == decomposeArrayRow(arr) && positionTop.getIndexColumn() == decomposeArrayColumn(arr))
            {
                //Se estiver no canto superior não são válidos valores: 0, 1, 2, 3, 4, 7
                moveNumber = randomNumber.nextInt(0, 8);

                while (moveNumber <= 4 || moveNumber == 7)
                {
                    moveNumber = randomNumber.nextInt(0, 8);
                };//fim da sentença de iteração while

                nextPositionRowAndColumn[0] = VERTICAL[moveNumber];
                nextPositionRowAndColumn[1] = HORIZONTAL[moveNumber];

                return nextPositionRowAndColumn;
            }//fim da sentença de seleção condicional simples
        };//fim da sentença de iteração for aprimorada

        //Validação de movimentos
        //Canto inferior (críicas). Não são permitidos movimentos para baixo (números positivos de linha)
        for (PosicoesCriticas positionBottom : EnumSet.range(PosicoesCriticas.G1, PosicoesCriticas.F2))
        {
            if (positionBottom.getIndexRow() == decomposeArrayRow(arr) && positionBottom.getIndexColumn() == decomposeArrayColumn(arr))
            {
                //Posições no canto inferior do tabuleiro. Não são válidos valores: 0, 3, 4, 5, 6, 7
                moveNumber = randomNumber.nextInt(0, 8);

                while (moveNumber >= 3 || moveNumber == 0)
                {
                    moveNumber = randomNumber.nextInt(0, 8);
                };//fim da sentença de iteração while
                nextPositionRowAndColumn[0] = VERTICAL[moveNumber];
                nextPositionRowAndColumn[1] = HORIZONTAL[moveNumber];
                return nextPositionRowAndColumn;
            }//fim da sentença de seleção condicional simples
        }//fim da sentença de iteração for aprimorada

        //Se nenhuma condição for aceita retornar na posição padrão
        nextPositionRowAndColumn[0] = VERTICAL[moveNumber];
        nextPositionRowAndColumn[1] = HORIZONTAL[moveNumber];
        return nextPositionRowAndColumn;
    };//fim do método nextPosition()

    private static int decomposeArrayRow(int[]arr)
    {
        return arr[0];
    };//fim do método decomposeArrayRow(int[]arr);

    private static int decomposeArrayColumn(int[]arr)
    {
        return arr[1];
    };//fim do método decomposeArrayColumn(int[]arr);

    private static void nextPositionAccess(int[]arr)
    {
        /**Se o cavalo estiver em C6 ele tem acesso as casas: B8 (3) A7 (3) A5 (4) B4 (4) D4 (8) E5(8) E7 (6) D8 (4)
         * De acordo com a heurística da acessibilidade o cavalo deve se mover preferencialmente para B8 ou A7.
         *
         * A ideia é:
         * --deixar o método de retorno como int[]
         *
         * 1. Iniciamos com a geração de uma posição aleatória para o cavalo (recebe como argumento)
         * 2. Primeiro armazenamos o índice de acessibilidade da posição.
         * 3. Depois do for usamos um switch. Esse switch avalia a variável que armazena o valor do índice de acessibilidade da
         * posição atual.Os case (8, 6, 4, 3, 2). Para cada case nós geramos todas as posições possíveis utilizando os arrays HOZIONTAL e VERTICAL.
         * 4. A partir de todas as posições possíveis nós extraímos o valor de índice de cada uma.
         * 5. Esse valor de índice será então comparado e o menor valor determinará a posição que o cavalo se moverá.
         * 6. Ao sair do swtich os valores da posição atual serão utilizados para refazer o processo.
         *
         * */

        //1
        int currentRow = decomposeArrayRow(arr);
        int currentColumn = decomposeArrayColumn(arr);
        int accessIndex = 0;

        //2
        for (PosicoesAcessibilidade currentPosition : EnumSet.range(PosicoesAcessibilidade.C3, PosicoesAcessibilidade.H8))
        {
            if (currentRow == currentPosition.getRow() && currentColumn == currentPosition.getColumn())
            {
                accessIndex = currentPosition.getAccess();
            };//fim da sentença de seleção condicional simples
        };//fim da sentença de iteração for aprimorado
        //System.out.printf("Valor de índice inicial da posição C6: %d%n", accessIndex);

        //3
        switch(accessIndex)
        {
            case 8:

                //System.out.printf("Valor de índice inicial da posição C6 dentro do switch: %d%n", accessIndex);
                //System.out.printf("Valor de currentRow e currentColumn dentro do switch: %d / %d%n", currentRow, currentColumn);
                //Definindo as casas passíveis de ser alcançadas. Os valores de cada array são diferentes e indicam as coordenadas
                //da nova posição do cavalo.
                int cr1 = decomposeArrayRow(arr);
                int cc1 = decomposeArrayRow(arr);
                cr1+=MovimentosDoCavalo.Mov0.getRow();
                cc1+=MovimentosDoCavalo.Mov0.getColumn();
                int[] position1 = {cr1, cc1}; //Nessas variáveis temos a nova casa ocupada pelo cavalo

                int cr2 = decomposeArrayRow(arr);
                int cc2 = decomposeArrayRow(arr);
                cr2+=MovimentosDoCavalo.Mov1.getRow();
                cc2+=MovimentosDoCavalo.Mov1.getColumn();
                int[] position2 = {cr2, cc2};

                int cr3 = decomposeArrayRow(arr);
                int cc3 = decomposeArrayRow(arr);
                cr3+=MovimentosDoCavalo.Mov2.getRow();
                cc3+=MovimentosDoCavalo.Mov2.getColumn();
                int[] position3 = {cr3, cc3};

                int cr4 = decomposeArrayRow(arr);
                int cc4 = decomposeArrayRow(arr);
                cr4+=MovimentosDoCavalo.Mov3.getRow();
                cc4+=MovimentosDoCavalo.Mov3.getColumn();
                int[] position4 = {cr4, cc4};

                int cr5 = decomposeArrayRow(arr);
                int cc5 = decomposeArrayRow(arr);
                cr5+=MovimentosDoCavalo.Mov4.getRow();
                cc5+=MovimentosDoCavalo.Mov4.getColumn();
                int[] position5 = {cr5, cc5};

                int cr6 = decomposeArrayRow(arr);
                int cc6 = decomposeArrayRow(arr);
                cr6+=MovimentosDoCavalo.Mov5.getRow();
                cc6+=MovimentosDoCavalo.Mov5.getColumn();
                int[] position6 = {cr6, cc6};

                int cr7 = decomposeArrayRow(arr);
                int cc7 = decomposeArrayRow(arr);
                cr7+=MovimentosDoCavalo.Mov6.getRow();
                cc7+=MovimentosDoCavalo.Mov6.getColumn();
                int[] position7 = {cr7, cc7};

                int cr8 = decomposeArrayRow(arr);
                int cc8 = decomposeArrayRow(arr);
                cr8+=MovimentosDoCavalo.Mov7.getRow();
                cc8+=MovimentosDoCavalo.Mov7.getColumn();
                int[] position8 = {cr8, cc8};

                //4
                //Iterar pelas posições de acessibilidade para encontrar o menor índice de acordo com as 8 posições
                int accessIndexP1 = 0;
                int accessIndexP2 = 0;
                int accessIndexP3 = 0;
                int accessIndexP4 = 0;
                int accessIndexP5 = 0;
                int accessIndexP6 = 0;
                int accessIndexP7 = 0;
                int accessIndexP8 = 0;

                for (PosicoesAcessibilidade p : EnumSet.range(PosicoesAcessibilidade.C3, PosicoesAcessibilidade.H8))
                {

                    if (p.getRow() == decomposeArrayRow(position1) && p.getColumn() == decomposeArrayColumn(position1))
                    {
                        accessIndexP1 = p.getAccess();
                    };//fim da sentença de seleção condicional simples

                    if (p.getRow() == decomposeArrayRow(position2) && p.getColumn() == decomposeArrayColumn(position2))
                    {
                        accessIndexP2 = p.getAccess();
                    };//fim da sentença de seleção condicional simples

                    if (p.getRow() == decomposeArrayRow(position3) && p.getColumn() == decomposeArrayColumn(position3))
                    {
                        accessIndexP3 = p.getAccess();
                    };//fim da sentença de seleção condicional simples

                    if (p.getRow() == decomposeArrayRow(position4) && p.getColumn() == decomposeArrayColumn(position4))
                    {
                        accessIndexP4 = p.getAccess();
                    };//fim da sentença de seleção condicional simples

                    if (p.getRow() == decomposeArrayRow(position5) && p.getColumn() == decomposeArrayColumn(position5))
                    {
                        accessIndexP5 = p.getAccess();
                    };//fim da sentença de seleção condicional simples

                    if (p.getRow() == decomposeArrayRow(position6) && p.getColumn() == decomposeArrayColumn(position6))
                    {
                        accessIndexP6 = p.getAccess();
                    };//fim da sentença de seleção condicional simples

                    if (p.getRow() == decomposeArrayRow(position7) && p.getColumn() == decomposeArrayColumn(position7))
                    {
                        accessIndexP7 = p.getAccess();
                    };//fim da sentença de seleção condicional simples

                    if (p.getRow() == decomposeArrayRow(position8) && p.getColumn() == decomposeArrayColumn(position8))
                    {
                        accessIndexP8 = p.getAccess();
                    };//fim da sentença de seleção condicional simples
                };//fim da sentença de iteração for aprimorado

                System.out.printf("Valores: %d / %d / %d / %d / %d / %d / %d / %d /", accessIndexP1, accessIndexP2, accessIndexP3, accessIndexP4,
                        accessIndexP5, accessIndexP6, accessIndexP7, accessIndexP8);

                //5
                //Nos arrayList eu tenho os índices e suas posições. Isso me permite selecionar qual posição ir quando houver mais de 1 menor
                int[] allAccessIndex = {accessIndexP1,accessIndexP2,accessIndexP3,accessIndexP4,accessIndexP5,accessIndexP6,accessIndexP7,accessIndexP8};
                int maxValue = Integer.MAX_VALUE;
                ArrayList<Integer> allMinAccessValues = new ArrayList<Integer>();
                ArrayList<Integer> allMinAccessValuesIndex = new ArrayList<Integer>();

                for(int i = 0; i < allAccessIndex.length; i+=1)
                {
                    if (allAccessIndex[i] <= maxValue)
                    {
                        maxValue = allAccessIndex[i];
                        allMinAccessValues.add(maxValue);
                        allMinAccessValuesIndex.add(i);
                    };//fim da sentença de seleção condicional simples
                };//fim da sentença de iteração for

                //6
                //Descobrir qual é o array (position1...8) para retornar
                for (PosicoesAcessibilidade p : EnumSet.range(PosicoesAcessibilidade.C3, PosicoesAcessibilidade.H8))
                {
                    //
                };//fim da sentença de iteração for aprimorado

                break;
        };//fim da sentença de seleção múltipla

    };//fim do método nextPositionAccess(int[]arr)

};//end of PasseioDoCavalo class
