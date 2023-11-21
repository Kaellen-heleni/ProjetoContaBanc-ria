package conta;

import java.util.Scanner;
import conta.util.Cores;
import conta.model.Conta;

public class Menu {

	public static void main(String[] args) {
		
		Conta c1 = new Conta(1, 123, 1, "Adriana",  1000.0f);
		c1.visualizar();
		c1.sacar(12000.0f);
		c1.visualizar();
		c1.depositar(5000.0f);
		c1.visualizar();
		
		Scanner receba = new Scanner(System.in);
	

		int opcao;

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

			opcao = receba.nextInt();

			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco PU - Seu próximo passo para um futuro melhor! ");
				sobre();
				receba.close();
				System.exit(0);

			}
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Abrir uma Conta\n\n");
				break;
			case 2:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Listar todas as Contas\n\n");
				break;
			case 3:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Consultar dados da Conta - por número\n\n");
				break;
			case 4:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Atualizar os Dados da Conta\n\n");
				break;
			case 5:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Encerrar a Conta\n\n");
				break;
			case 6:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Realizar um Saque\n\n");
				break;
			case 7:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Realizar um Depósito na Conta\n\n");
				break;
			case 8:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Realizar Transferência entre Contas\n\n");
				break;
			default:
				System.out.println(Cores.TEXT_RED_UNDERLINED + Cores.ANSI_BLACK_BACKGROUND + "\nOpção Inválida!\n");

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

}