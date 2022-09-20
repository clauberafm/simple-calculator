package ClauberMelo;

/**
 * @Aluno: Clauber A. F. de Melo
 *Projeto Calculadora para a disciplina Prog. II
 */

import java.util.Scanner;    

public class Calculadora {//<-- Classe unica exigida

    public static void main (String args[]){   
   
        short opr;
        double n1, n2; 
        
        Scanner input = new Scanner(System.in);
        
        do {//<-- Estrutura de menu e loop
             System.out.println("Selecione a operacao abaixo:");
             System.out.println("  1. Somar");      
             System.out.println("  2. Subtrair");      
             System.out.println("  3. Multiplicar");      
             System.out.println("  4. Dividir");      
             System.out.println("  5. Potenciacao"); 
             System.out.println("  0. Encerrar programa");
             System.out.print("\nOperacao: ");
             opr = input.nextShort();
             
             if (opr == 0) {
            	 System.out.println("\nCalculadora desligada!");
            	 break;
             }
             
             if (!CondOpr(opr)) {
            	 continue;
             }
             
             System.out.print("Insira o primeiro valor: ");
             n1 = input.nextDouble();
             System.out.print("Insira o segundo valor: ");
             n2 = input.nextDouble();
             if (!ConfirmaNum(opr, n1, n2)) {
            	 continue;
             }
             System.out.println("\nResultado da " + getOprID(opr) + " : " + MetodoCalculo(opr, n1, n2) + "\n");
        } while (opr != 0);
    }
    
    //Metodos para cada operacao
    static double MetodoCalculo (short opr, double n1, double n2) {
    	double calculo = 0;
    	switch (opr) {
    		case 1: //soma
    			calculo = n1 + n2;
    			break;
    		case 2: //sub
    			calculo = n1 - n2;
    			break;
    		case 3: //mult
    			calculo = n1 * n2;
    			break;
    		case 4: //div
    			calculo = n1 / n2;
    			break;
                case 5: //pot
    			calculo = Math.pow(n1, n2);
    			break;
    	}
    	return calculo;
    }
    
    //Para delimitar a entrada de dados no MENU
    static boolean CondOpr (short opr) {
       	boolean recebe = true;
    	if (opr > 5) {
       		System.out.println("Opcao inexistente!\n");
       		recebe = false;
       	}
    	return recebe;
    }
    
    //Estabelecimento de regra para a operacao de divisao
    static boolean ConfirmaNum (short opr, double n1, double n2) {
    	boolean recebe = true; 
    	if (opr == 4 & n2 == 0) {
        	 System.out.println("Invalido! Por favor, insira um numero diferente de zero (0).\n");
        	 recebe = false;
        }
    	return recebe;
    }
    
    //Exibicao de operacao selecionada no final do calculo
    static String getOprID (short opr) {
    	
    	switch (opr) {
		case 1:
			return "soma";
		case 2:
			return "subtracao";
		case 3: 
			return "multiplicacao";
		case 4: 
			return "divisao";
                case 5: 
			return "potencia";
                default:
                        return "indefinido";
    	}
    	
    }
} 
