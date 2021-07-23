package batalhaNaval;

import java.util.Scanner;

public class BatalhaNaval {

	public static String tabuleiro1[][] = new String [10][10]; //executa o tabuleiro 1
	public static int posicao1[][] = new int[10][10]; // executa os barcos no tabuleiro 1
	public static String tabuleiro2[][] = new String [10][10]; //executa o tabuleiro 2
	public static int posicao2[][] = new int[10][10]; //executa o tabuleiro 2

	public static void zerarPosicoes() {
		for(int l = 0; l < 10; l++) {
			for(int c = 0; c < 10; c++) {
				posicao1[l][c] = 0;
				posicao2[l][c] = 0;
			}			
		}
	}
	
	// Metodo para definir posição dos navios nos tabuleiros 1 e 2
	public static void posicaoDosNavios() {
		//(1) 1 Porta-Aviões (5 posições)
		posicao1[4][1] = 1;
		posicao1[5][1] = 1;
		posicao1[6][1] = 1;
		posicao1[7][1] = 1;
		posicao1[8][1] = 1;
		
		posicao2[2][7] = 1;
		posicao2[3][7] = 1;
		posicao2[4][7] = 1;
		posicao2[5][7] = 1;
		posicao2[6][7] = 1;
		
		//(2) 2 Navios-Taque (4 posições)
		posicao1[9][6] = 2;
		posicao1[9][7] = 2;
		posicao1[9][8] = 2;
		posicao1[9][9] = 2;
		
		posicao1[1][2] = 2;
		posicao1[1][3] = 2;
		posicao1[1][4] = 2;
		posicao1[1][5] = 2; 
		
		posicao2[6][2] = 2;
		posicao2[7][2] = 2;
		posicao2[8][2] = 2;
		posicao2[9][2] = 2;
		
		posicao2[3][9] = 2;
		posicao2[4][9] = 2;
		posicao2[5][9] = 2;
		posicao2[6][9] = 2;
		
		//(3) 2 Contratorpedeiros (3 posições)
		posicao1[4][5] = 3;
		posicao1[5][5] = 3;
		posicao1[6][5] = 3;
		
		posicao1[3][7] = 3;
		posicao1[3][8] = 3;
		posicao1[3][9] = 3;
		
		posicao2[5][4] = 3;
		posicao2[5][5] = 3;
		posicao2[5][6] = 3;
		
		posicao2[0][0] = 3;
		posicao2[0][1] = 3;
		posicao2[0][2] = 3;
		
		
		//(4) Submarinos (2 posições)
		posicao1[8][4] = 4;
		posicao1[8][5] = 4;
		
		posicao1[0][7] = 4;
		posicao1[1][7] = 4;
		
		posicao1[7][6] = 4;
		posicao1[7][7] = 4;
		
		posicao2[2][0] = 4;
		posicao2[2][1] = 4;	
		
		posicao2[4][0] = 4;
		posicao2[4][1] = 4;
		
		posicao2[9][7] = 4;
		posicao2[9][8] = 4;
		
	}
	
	// Metodo para imprimir o tabuleiro 1
	public static void imprimeTabuleiro1(){ //Contruir Tabuleiros
		System.out.println();
        System.out.println("               TABULEIRO 1\n");
		System.out.println("    0   1   2   3   4   5   6   7   8   9"); //numero da coluna
        System.out.println("  -----------------------------------------"); // separa as linha 
        for(int l=0;l<10;l++){//preenche as linhas com elementos de 0 a 9
              System.out.print(l + " ");   //numero da linhas do lado do tabuleiro
             for(int c=0;c<10;c++){//preenche as colunas com elementos de 0 a 9
                  System.out.print("| "+tabuleiro1[l][c]+" ");
             }
             System.out.println("|"); //separa as colunas
             System.out.println("  -----------------------------------------");
         }
	}
	
	// Metodo para imprimir o tabuleiro 2
	public static void imprimeTabuleiro2() { //Construir Tabuleiro 2
		System.out.println();
		System.out.println("               TABULEIRO 2\n");
		System.out.println("    0   1   2   3   4   5   6   7   8   9"); //numero da coluna
        System.out.println("  -----------------------------------------");
        for(int l=0;l<10;l++){//preenche as linhas com elementos de 0 a 9//
              System.out.print(l + " ");   //numero da linhas do lado do tabuleiro
             for(int c=0;c<10;c++){//preenche as colunas com elementos de 0 a 9//
                  System.out.print("| "+tabuleiro2[l][c]+" ");
             }
             System.out.println("|");
             System.out.println("  -----------------------------------------");
         }
	}
	
	// Metodo para preencher o tabuleiro - 2 arrays bidimensionais
	public static void inicializaMatriz(){
         for(int l=0;l<10;l++){//preenche as linhas com elementos de 0 a 9//
             for(int c=0;c<10;c++){//preenche as colunas com elementos de 0 a 9//
                  tabuleiro1[l][c]=" ";
                  tabuleiro2[l][c]=" ";
             }
         }
	 }
	
	public static void cabecalho() {
		System.out.println("-----------------------------------------------------------------------");
		System.out.println();
		System.out.println("                     <<< BATALHA NAVAL >>>");
		System.out.println();
		System.out.println("O objetivo é afundar os navios inimigos antes que ele afunde os seus.\n"
				+ "Cada jogada certa te dá o direito de uma nova jogada na sequência.\n"
				+ "Escolha a posição em que se deseja atirar, \ndigitando uma linha e coluna entre 0 e 9.\n"
				+ "Os tipos de barcos são: \n(1) 1 porta-aviões (cinco quadrados), "
				+ "\n(2) 2 navios-tanque (quatro quadrados), "
				+ "\n(3) 2 contratorpedeiros (três quadrados)  \n(4) 3 submarinos (dois quadrados). ");
	}
	
	//Metodo para contar se os navios acertados, quando controle zera o oponente ganha.
	public static void iniciarJogo() {
		int portaAvioes1 = 5, naviosTanque1 = 8, contratorpedeiros1 = 6, submarinos1 = 6;
		int portaAvioes2 = 5, naviosTanque2 = 8, contratorpedeiros2 = 6, submarinos2 = 6; 
		int controle = 1;
		Scanner sc = new Scanner(System.in);
		while(controle == 1) { // enquanto houver barcos no tabuleiro, o tabuleiro será impresso
			imprimeTabuleiro2();
			System.out.print("Jogador 1: \n"
					+ " Digite uma linha (0-9): ");
			int l1 = sc.nextInt();
			System.out.print(" Digite uma coluna (0-9): ");
			int c1 = sc.nextInt();
			System.out.println();
			int escolha1 = posicao2[l1][c1];
			if(tabuleiro2[l1][c1] == " ") {
				switch(escolha1) { 
				case 0:                     
					tabuleiro2[l1][c1] = "O";  // Água
					imprimeTabuleiro2(); 
					controle = 2;
					break;
				case 1:
					tabuleiro2[l1][c1] = "1";
					portaAvioes2 --; //diminui uma unidade do portaAvioes
					imprimeTabuleiro2();
					break;
				case 2:
					tabuleiro2[l1][c1] = "2";
					naviosTanque2 --; //diminui uma unidade do naviosTanque2
					imprimeTabuleiro2();
					break;
				case 3:
					tabuleiro2[l1][c1] = "3";
					contratorpedeiros2 --; //diminui uma unidade de cruzador
					imprimeTabuleiro2();
					break;
				case 4:
					tabuleiro2[l1][c1] = "4";
					submarinos2 --; //diminui uma unidade de navio
					imprimeTabuleiro2();
					break;
				}
			}
			if(portaAvioes2==0 && naviosTanque2==0  && contratorpedeiros2==0 && submarinos2==0) { // IdentificarVencedorPerdedor
				System.out.println("Jogador 1 ganhou!!!!!!!!");
				controle = 0;
			}
			while(controle == 2) {
				imprimeTabuleiro1();
				System.out.print("Jogador 2: \n"
						+ " Digite uma linha (0-9): ");
				int l2 = sc.nextInt();
				System.out.print(" Digite uma coluna (0-9): ");
				int c2 = sc.nextInt();
				System.out.println();
				int escolha2 = posicao1[l2][c2];
				if(tabuleiro1[l2][c2] == " ") {
					switch(escolha2) {
					case 0:                     
						tabuleiro1[l2][c2] = "O";    //Água
						imprimeTabuleiro1();
						controle = 1;
						break;
					case 1:
						tabuleiro1[l2][c2] = "1";
						portaAvioes1 --; //diminui uma unidade do portaAvioes
						imprimeTabuleiro1();
						break;
					case 2:
						tabuleiro1[l2][c2] = "2";
						naviosTanque1 --; //diminui uma unidade do naviosTanque2
						imprimeTabuleiro1();
						break;
					case 3:
						tabuleiro1[l2][c2] = "3";
						contratorpedeiros1 --; //diminui uma unidade de cruzador
						imprimeTabuleiro1();
						break;
					case 4:
						tabuleiro1[l2][c2] = "4";
						submarinos1 --; //diminui uma unidade de navio
						imprimeTabuleiro1();
						break;
					}
				}
				if(portaAvioes1==0 && naviosTanque1==0  && contratorpedeiros1==0 && submarinos1==0) { // IdentificarVencedorPerdedor
					System.out.println("Jogador 2 ganhou!!!!!!!!");
					controle = 0;
				}
			}
		}
		System.out.println("Fim!!");
		menuJogo.MenuJogos.escolherJogo();
	}
	
	public static void executor() {
		zerarPosicoes();
		posicaoDosNavios();
		inicializaMatriz();
		cabecalho();
		iniciarJogo();
	}
	
}
