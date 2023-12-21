/**As lógicas testadas e que não atenderam aos requisitos do exercício, embora funcionem para outras situações e contextos
 */

/**	---Consegue calcular o valor total da primeira linha retornando todos os termos um de cada vez----
		for (int produto = 0; produto < arr.length - 1; produto++)
		{
			for (double[] item : arr)
			{
				valorTotalVendedor += item[produto];
			}
			System.out.printf("%13.1f ", valorTotalVendedor);
			break;
		}
	*/


	
	/**	----Consegue calcular o valor total das colunas, mas retorna apenas o último valor---
		for (int produto = 0; produto < arr.length; produto += 1)
		{
			for (double x : arr[produto])
			{
				valorTotalVendedor += x;
				
				if (produto == 4)
				{
					System.out.printf("%13.1f ", valorTotalVendedor);	
				}//fim da sentença de seleção condicional simples
				break;
			};//fim da sentença de iteração for aprimorado		
		};//fim da sentença de iteração for
		
	*/	
	




/**	
		//Abaixo foi possível criar uma progressão linear aritmética cujo valor da razão é o valor do primeiro item do array
		for (double coluna : arr[x])
		{
			for (int produto = 0; produto < arr[produto].length; produto += 1)
			{
				valorTotalVendedor += coluna;
				System.out.printf("%13.1f ", valorTotalVendedor);	
				break;
			}
			x++;
		}
	*/
		