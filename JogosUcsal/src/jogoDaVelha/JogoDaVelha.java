package jogoDaVelha;

import java.util.Scanner;

public class JogoDaVelha {
	static String[][] tabuleiro = new String[3][3];
	static Scanner sc = new Scanner(System.in);
	static char peca;
	static String pecaString = "" + peca; // transforma char em string
	static int jogadas = 1; //controlador de jogadas

	public static void executor() { // cabe�alho
		System.out.println("--------------------------------------------");
		System.out.println();
		System.out.println("          <<< JOGO DA VELHA >>>");
		System.out.println();
		System.out.println("Quem come�a, 'x' ou 'o' ?");
		peca = sc.next().charAt(0);
		pecaString = "" + peca;
		System.out.println("A pe�a " + peca + " come�a o jogo");
		efetuarJogada(); //Executa o metodo
	}

	//constroi o Tabuleiro 
	public static void inicializaMatriz() { // Construir Tabuleiro
		for (int l = 0; l < 3; l++) {// preenche as linhas com elementos de 0 a 2//
			for (int c = 0; c < 3; c++) {// preenche as colunas com elementos de 0 a 2//
				tabuleiro[l][c] = " ";
			}
		}
	}

	public static void jogada() { //Efetuar Jogada
		int linha = 0, coluna = 0;

		imprimeTabuleiro();
		System.out.print(jogadas + "� jogada da pe�a '" + pecaString + "' Escolha a linha (0 a 2): ");
		linha = sc.nextInt(); //recebe a jogada l
		System.out.print(jogadas + "� jogada da pe�a '" + pecaString + "' Escolha a coluna (0 a 2): ");
		coluna = sc.nextInt(); // recebe a jogada c
		if ((linha >= 0 && linha <= 2) && (coluna >= 0 && coluna <= 2)) {
			tabuleiro[linha][coluna] = pecaString;
			imprimeTabuleiro();
		} else {
			System.out.println("Voc� digitou uma combina��o de valores que n�o representa uma posi��o, perdeu a vez");
		}
	}

	public static void efetuarJogada() { //Validar Jogada
		inicializaMatriz(); //executa o metodo do tabuleiro

		while (jogadas != 100) {
			switch (pecaString) {
			case "x":
				jogada();
				pecaString = "o";
				jogadas++;
				break;
			case "o":
				jogada();
				pecaString = "x";
				jogadas++;
				break;
			}	
			
			validarJogada();

			if (jogadas == 10) {
				System.out.println("Velha!!!!");
				jogadas = 100;
			}
		}
	}
	
	public static void validarJogada() { //identificarVencedorPerdedor
//		1� Diagonal
		if ((tabuleiro[0][0].equals("x") && tabuleiro[1][1].equals("x") && tabuleiro[2][2].equals("x"))) {
			System.out.println("Jogador da pe�a 'x' ganhou");
			jogadas = 100;
		}
		if((tabuleiro[0][0].equals("o") && tabuleiro[1][1].equals("o") && tabuleiro[2][2].equals("o"))) {
			System.out.println("Jogador da pe�a 'o' ganhou");
			jogadas = 100;
		}
//		2� Diagonal
		if ((tabuleiro[0][2].equals("x") && tabuleiro[1][1].equals("x") && tabuleiro[2][0].equals("x"))) {
			System.out.println("Jogador da pe�a 'x' ganhou");
			jogadas = 100;
		}
		if ((tabuleiro[0][2].equals("o") && tabuleiro[1][1].equals("o") && tabuleiro[2][0].equals("o"))) {
			System.out.println("Jogador da pe�a 'o' ganhou");
			jogadas = 100;
		}
//		1� Linha
		if ((tabuleiro[0][0].equals("x") && tabuleiro[0][1].equals("x") && tabuleiro[0][2].equals("x"))) {
			System.out.println("Jogador da pe�a 'x' ganhou");
			jogadas = 100;	
		}
		if ((tabuleiro[0][0].equals("o") && tabuleiro[0][1].equals("o") && tabuleiro[0][2].equals("o"))) {
			System.out.println("Jogador da pe�a 'o' ganhou");
			jogadas = 100;
			
		}
//		2� Linha
		if ((tabuleiro[1][0].equals("x") && tabuleiro[1][1].equals("x") && tabuleiro[1][2].equals("x"))) {
			System.out.println("Jogador da pe�a 'x' ganhou");
			jogadas = 100;
			
		}
		if ((tabuleiro[1][0].equals("o") && tabuleiro[1][1].equals("o") && tabuleiro[1][2].equals("o"))) {
			System.out.println("Jogador da pe�a 'o' ganhou");
			jogadas = 100;
			
		}
//		3� Linha
		if ((tabuleiro[2][0].equals("x") && tabuleiro[2][1].equals("x") && tabuleiro[2][2].equals("o"))) {
			System.out.println("Jogador da pe�a 'x' ganhou");
			jogadas = 100;
			
		}
		if ((tabuleiro[2][0].equals("o") && tabuleiro[2][1].equals("o") && tabuleiro[2][2].equals("o"))) {
			System.out.println("Jogador da pe�a 'o' ganhou");
			jogadas = 100;
			
		}
//		1� Coluna
		if ((tabuleiro[0][0].equals("x") && tabuleiro[1][0].equals("x") && tabuleiro[2][0].equals("x"))) {
			System.out.println("Jogador da pe�a 'x' ganhou");
			jogadas = 100;	
		}
		if ((tabuleiro[0][0].equals("o") && tabuleiro[1][0].equals("o") && tabuleiro[2][0].equals("o"))) {
			System.out.println("Jogador da pe�a 'o' ganhou");
			jogadas = 100;	
		}
		
//		2� Coluna
		if ((tabuleiro[0][1].equals("x") && tabuleiro[1][1].equals("x") && tabuleiro[2][1].equals("x"))) {
			System.out.println("Jogador da pe�a 'x' ganhou");
			jogadas = 100;
			
		}
		if ((tabuleiro[0][1].equals("o") && tabuleiro[1][1].equals("o") && tabuleiro[2][1].equals("o"))) {
			System.out.println("Jogador da pe�a 'o' ganhou");
			jogadas = 100;
			
		}
		
//		3� Coluna
		if ((tabuleiro[0][2].equals("x") && tabuleiro[1][2].equals("x") && tabuleiro[2][2].equals("o"))) {
			System.out.println("Jogador da pe�a 'x' ganhou");
			jogadas = 100;
			
		}
		if ((tabuleiro[0][2].equals("o") && tabuleiro[1][2].equals("o") && tabuleiro[2][2].equals("o"))) {
			System.out.println("Jogador da pe�a 'o' ganhou");
			jogadas = 100;
			
		}	
	}

	public static void imprimeTabuleiro() {
		System.out.println();
		System.out.println("    0   1   2"); // numero da coluna
		System.out.println("  -------------");
		for (int l = 0; l < 3; l++) {// preenche as linhas com elementos de 0 a 2//
			System.out.print(l + " "); // numero da linhas do lado do tabuleiro
			for (int c = 0; c < 3; c++) {// preenche as colunas com elementos de 0 a 2//
				System.out.print("| " + tabuleiro[l][c] + " ");
			}
			System.out.println("|");
			System.out.println("  -------------");
		}
	}
}
