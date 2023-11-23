package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import conta.util.Cores;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

	public static void main(String[] args) {
		int opcao = 0;
	
		// Teste da classe conta corrente
		ContaCorrente cc1 = new ContaCorrente(2, 123, 1,"Kaellen", 15000.0f, 1000.0f);
		cc1.visualizar();
		cc1.sacar(12000.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();
		
		// Teste da classe conta poupança
		ContaPoupanca cp1 = new ContaPoupanca(3, 123, 2, "Victor", 100000.0f, 15);
		cp1.visualizar();
		cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();
		
		Scanner receba = new Scanner(System.in);
	
		while (true) {
			System.out.println(Cores.TEXT_BLACK_BOLD + Cores.ANSI_WHITE_BACKGROUND
					+ "•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
			System.out.println("                                                                                    ");
			System.out.println("                         BANCO FUTURAMA                      ");
			System.out.println("                                                                                    ");
			System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
			System.out.println("                                                                                    ");
			System.out.println("                       1 - Abrir uma Conta                         ");
			System.out.println("                      2 - Listar todas as Contas                ");
			System.out.println("                      3 - Buscar Conta por Número        ");
			System.out.println("                      4 - Atualizar os Dados da Conta   ");
			System.out.println("                      5 - Encerrar Conta                           ");
			System.out.println("                      6 - Realizar Saque                             ");
			System.out.println("                      7 - Realizar Depósito                       ");
			System.out.println("                      8 - Transferência entre Contas     ");
			System.out.println("                      9 - Sair                                                ");
			System.out.println("                                                                                    ");
			System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
			System.out.println(" Entre com a opção desejada:                                ");
			System.out.println("                                                                                    "
					+ Cores.TEXT_RESET);

			try {
			opcao = receba.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!!");
				receba.nextLine();
				opcao=0;
			}

			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco PU - Seu próximo passo para um futuro melhor! ");
				sobre();
				receba.close();
				System.exit(0);

			}
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Abrir uma Conta\n\n");
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Listar todas as Contas\n\n");
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Consultar dados da Conta - por número\n\n");
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Atualizar os Dados da Conta\n\n");
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Encerrar a Conta\n\n");
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Realizar um Saque\n\n");
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Realizar um Depósito na Conta\n\n");
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Realizar Transferência entre Contas\n\n");
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_UNDERLINED + Cores.ANSI_BLACK_BACKGROUND + "\nOpção Inválida!\n");
                 keyPress();
                 break;
			}

		}

	}

	public static void sobre() {
		System.out.println("••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
		System.out.println("Projeto Desenvolvido por: Kaellen Heleni Santos Oliveira");
		System.out.println("Kaellen Heleni - kaellenheleni@icloud.com");
		System.out.println("github.com/Kaellen-heleni");
		System.out.println("••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");

	}
	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET+"\n\nPressione Enter para Continuar...");
			System.in.read();
		}catch(IOException e) {
			System.out.println("Você pressionou uma tecla diferente de Enter!");
		}
		
	}

}