package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import conta.util.Cores;
import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

	public static void main(String[] args) {
		ContaController contas = new ContaController();
		
		Scanner receba = new Scanner(System.in);
	     int opcao, numero, agencia, tipo, aniversario;
	     String titular;
	     float saldo, limite;
	     
	     System.out.println("\nCriar Contas\n");
	     ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Maite Peroni", 10000f, 1000.0f);
	     contas.cadastrar(cc1);
	     ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Dulce Maria", 40000f, 2000.0f);
	     contas.cadastrar(cc2);
	     ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Christian Chavez", 1000f, 12); 
	    contas.cadastrar(cp1);
	     ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 126, 2, "Christopher Ucker", 1000f, 05);
		contas.cadastrar(cp2);
		contas.listarTodas();
		
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
				System.out.println("Digite o Numero da Agência: ");
				agencia = receba.nextInt();
				System.out.println("Digite o Nome do Titular da conta: ");
				receba.skip("\\R?");
				titular = receba.nextLine();
				do {
				System.out.println("Digite o Tipo da Conta (1 para Conta Corrente e 2 para Conta Poupança");
				tipo = receba.nextInt();
				}while (tipo <1 && tipo > 2);
				System.out.println("Digite o Saldo da Conta(R$): ");
				saldo = receba.nextFloat();
				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o Limite de Crédito(R$): ");
					limite = receba.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 ->{
				System.out.println("Digite o dia do Aniversario da Conta: ");
		        aniversario = receba.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}}
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Listar todas as Contas\n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Consultar dados da Conta - por número\n\n");
				System.out.println("Digite o número da conta: ");
				numero = receba.nextInt();
				contas.procurarPorNumero(numero);
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Atualizar os Dados da Conta\n\n");
				System.out.println("Digite o número da conta: ");
				numero = receba.nextInt();
				var buscaConta = contas.buscarNaCollection(numero);
				if(buscaConta != null) {
					tipo = buscaConta.getTipo();
					System.out.println("Digite Número da Agência: ");
					agencia = receba.nextInt();
					System.out.println("Digite o Nome do Titular: ");
					receba.skip("\\R?");
					titular = receba.nextLine();
					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = receba.nextFloat();
					switch(tipo) {
					case 1 -> {
						System.out.println("Digite o Limite de Crédito (R$): ");
						limite = receba.nextFloat();
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite ));
					}
					case 2 ->{
						System.out.println("Digite o dia do Aniversário da Conta: ");
						aniversario = receba.nextInt();
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					default -> {
						System.out.println("Tipo de Conta inválido!!");
					}
					}
				}else {
					System.out.println("A Conta não foi encontrada!");
				}
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Deletar uma Conta\n\n");
				System.out.println("Digite o número da conta: ");
				numero = receba.nextInt();
				contas.deletar(numero);
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