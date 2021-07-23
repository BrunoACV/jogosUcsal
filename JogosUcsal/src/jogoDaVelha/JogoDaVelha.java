package jogoDaVelha;

import java.util.Scanner;

public class JogoDaVelha {
	static String[][] tabuleiro = new String[3][3];
	static Scanner sc = new Scanner(System.in);
	static char peca;
	static String pecaString = "" + peca; // transforma char em string
	static int jogadas = 1; //controlador de jogadas

	public static void executor() { // cabeçalho
		System.out.println("--------------------------------------------");
		System.out.println();
		System.out.println("          <<< JOGO DA VELHA >>>");
		System.out.println();
		System.out.println("Quem começa, 'x' ou 'o' ?");
		peca = sc.next().charAt(0);
		pecaString = "" + peca;
		System.out.println("A peça " + peca + " começa o jogo");
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
		System.out.print(jogadas + "ª jogada da peça '" + pecaString + "' Escolha a linha (0 a 2): ");
		linha = sc.nextInt(); //recebe a jogada l
		System.out.print(jogadas + "ª jogada da peça '" + pecaString + "' Escolha a coluna (0 a 2): ");
		coluna = sc.nextInt(); // recebe a jogada c
		if ((linha >= 0 && linha <= 2) && (coluna >= 0 && coluna <= 2)) {
			tabuleiro[linha][coluna] = pecaString;
			imprimeTabuleiro();
		} else {
			System.out.println("Você digitou uma combinação de valores que não representa uma posição, perdeu a vez");
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
//		1º Diagonal
		if ((tabuleiro[0][0].equals("x") && tabuleiro[1][1].equals("x") && tabuleiro[2][2].equals("x"))) {
			System.out.println("Jogador da peça 'x' ganhou");
			jogadas = 100;
		}
		if((tabuleiro[0][0].equals("o") && tabuleiro[1][1].equals("o") && tabuleiro[2][2].equals("o"))) {
			System.out.println("Jogador da peça 'o' ganhou");
			jogadas = 100;
		}
//		2º Diagonal
		if ((tabuleiro[0][2].equals("x") && tabuleiro[1][1].equals("x") && tabuleiro[2][0].equals("x"))) {
			System.out.println("Jogador da peça 'x' ganhou");
			jogadas = 100;
		}
		if ((tabuleiro[0][2].equals("o") && tabuleiro[1][1].equals("o") && tabuleiro[2][0].equals("o"))) {
			System.out.println("Jogador da peça 'o' ganhou");
			jogadas = 100;
		}
//		1º Linha
		if ((tabuleiro[0][0].equals("x") && tabuleiro[0][1].equals("x") && tabuleiro[0][2].equals("x"))) {
			System.out.println("Jogador da peça 'x' ganhou");
			jogadas = 100;	
		}
		if ((tabuleiro[0][0].equals("o") && tabuleiro[0][1].equals("o") && tabuleiro[0][2].equals("o"))) {
			System.out.println("Jogador da peça 'o' ganhou");
			jogadas = 100;
			
		}
//		2º Linha
		if ((tabuleiro[1][0].equals("x") && tabuleiro[1][1].equals("x") && tabuleiro[1][2].equals("x"))) {
			System.out.println("Jogador da peça 'x' ganhou");
			jogadas = 100;
			
		}
		if ((tabuleiro[1][0].equals("o") && tabuleiro[1][1].equals("o") && tabuleiro[1][2].equals("o"))) {
			System.out.println("Jogador da peça 'o' ganhou");
			jogadas = 100;
			
		}
//		3º Linha
		if ((tabuleiro[2][0].equals("x") && tabuleiro[2][1].equals("x") && tabuleiro[2][2].equals("o"))) {
			System.out.println("Jogador da peça 'x' ganhou");
			jogadas = 100;
			
		}
		if ((tabuleiro[2][0].equals("o") && tabuleiro[2][1].equals("o") && tabuleiro[2][2].equals("o"))) {
			System.out.println("Jogador da peça 'o' ganhou");
			jogadas = 100;
			
		}
//		1º Coluna
		if ((tabuleiro[0][0].equals("x") && tabuleiro[1][0].equals("x") && tabuleiro[2][0].equals("x"))) {
			System.out.println("Jogador da peça 'x' ganhou");
			jogadas = 100;	
		}
		if ((tabuleiro[0][0].equals("o") && tabuleiro[1][0].equals("o") && tabuleiro[2][0].equals("o"))) {
			System.out.println("Jogador da peça 'o' ganhou");
			jogadas = 100;	
		}
		
//		2º Coluna
		if ((tabuleiro[0][1].equals("x") && tabuleiro[1][1].equals("x") && tabuleiro[2][1].equals("x"))) {
			System.out.println("Jogador da peça 'x' ganhou");
			jogadas = 100;
			
		}
		if ((tabuleiro[0][1].equals("o") && tabuleiro[1][1].equals("o") && tabuleiro[2][1].equals("o"))) {
			System.out.println("Jogador da peça 'o' ganhou");
			jogadas = 100;
			
		}
		
//		3º Coluna
		if ((tabuleiro[0][2].equals("x") && tabuleiro[1][2].equals("x") && tabuleiro[2][2].equals("o"))) {
			System.out.println("Jogador da peça 'x' ganhou");
			jogadas = 100;
			
		}
		if ((tabuleiro[0][2].equals("o") && tabuleiro[1][2].equals("o") && tabuleiro[2][2].equals("o"))) {
			System.out.println("Jogador da peça 'o' ganhou");
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
