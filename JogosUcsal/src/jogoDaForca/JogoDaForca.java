package jogoDaForca;

import java.util.Random;
import java.util.Scanner;
	
public class JogoDaForca {
	
	final static int LINHA = 6;	
	final static int COLUNA = 7;
	static String tentativa;
	static String[] espacoPalavra;
	
	public static void executor() {
		cabecalho();
		validarJogada();
	}
	
	public static void cabecalho() {
		System.out.println("------------------------------------------------------");
		System.out.println("");
		System.out.println("<<< JOGO DA FORCA >>>");
		System.out.println("Você deverá acertar a palavra em 6 tentativas para vencer o jogo.");		
	}
	
	public static void efetuarJogada(int erro) {
		Scanner sc = new Scanner(System.in);
		System.out.println(erro+1 + "º tentativa, informe uma letra:");
		imprimir(espacoPalavra); // imprime _ na mesma qtdd de letras da palavra
		tentativa = sc.nextLine(); // armazena a tentativa do usuário
	}

	public static void validarJogada() {
		
		String[] palavra = definirPalavra(); //"java", "ucsal", "logica", "algoritmo", "tecnologia"
		int erro = 0, erroComparacao = 0, cont;

		// --------------
		espacoPalavra = new String[palavra.length]; //vetor do mesmo tamanho de palavra fragmentada

		// Preenche _ em espacoPalavra
		for (int i = 0; i < espacoPalavra.length; i++) {  
			espacoPalavra[i] = "_"; 
		}

		// -------------
	
		while (erro < 6) {
			constrirForca(erro); //metodo de construção da forca 
			efetuarJogada(erro);
			erroComparacao = 0;
			for (int i = 0; i < palavra.length; i++) {
				if (palavra[i].equals(tentativa)) { // Compara a letra digitada com as letras da palavra
					espacoPalavra[i] = tentativa; // guarda a letra certa em tentativa no local correto									
				} else {
					erroComparacao++;
				}
				if (erroComparacao == palavra.length) {
					erro++; //se em toda palavra não possuir a letra digitada erro ++
				}				
			}
			cont = 0;
			for (int i = 0; i < palavra.length; i++) {
				if(!espacoPalavra[i].equals("_")) { // verifica os espaços vazios
					cont++;
					if(cont == espacoPalavra.length) { //ganhou - vê if do erro 7 abaixo
						erro = 7;
					}
				}
			}

		}
		
		identificarVencedorPerdedor(erro,palavra);

		
	}
	// metodo erro6 = jogador perdeu
	public static void identificarVencedorPerdedor(int error,String [] palavrar) {
		if (error == 6) {
			constrirForca(6);
			System.out.println("R.I.P bonequinho");
			System.out.print("A palavra era: ");
			imprimir(palavrar);
			System.out.println();
			System.out.println();
			menuJogo.MenuJogos.escolherJogo();
		}


		if (error == 7) { //define que houve um ganhador
			imprimir(palavrar);
			System.out.println("\nVocê acertou a palavra \nObrigado por jogar!");
			System.out.println("------------------------------------------------------");
			menuJogo.MenuJogos.escolherJogo();
		}
	}

	public static void constrirForca(int vlr) {
		String[][] forca = new String[COLUNA][LINHA];

		for (int i = 0; i < COLUNA; i++) {
			for (int j = 0; j < LINHA; j++) {
				if (j == 1) {
					forca[i][j] = "|";
				}
				if (j == 0) {
					forca[i][j] = " ";
				}
				if (i == 0) {
					if (j != 0) {
						forca[i][j] = "_";
					}
				}
				if (i == 6) {
					forca[i][j] = "_";
				}

			}
		}
		// Ex
		forca[6][1] = "|";
		forca[0][1] = " ";
		forca[1][3] = "    |";
		if (vlr == 1)
			forca[2][3] = "    O";
		if (vlr == 2) {
			forca[2][3] = "    O";
			forca[3][3] = "    |";
		}	
		if (vlr == 3) {
			forca[2][3] = "    O";
			forca[3][3] = "|";
			forca[3][2] = "   /";
		}
		if (vlr == 4) {
			forca[2][3] = "    O";
			forca[3][3] = "|";
			forca[3][2] = "   /";
			forca[3][4] = "\\";
		}
		if (vlr == 5) {
			forca[2][3] = "    O";
			forca[3][3] = "|";
			forca[3][2] = "   /";
			forca[3][4] = "\\";
			forca[4][2] = "   /";
		}
		if (vlr == 6) {
			forca[2][3] = "    O";
			forca[3][3] = "|";
			forca[3][2] = "   /";
			forca[3][4] = "\\";
			forca[4][2] = "   /";
			forca[4][2] = "   /";
			forca[4][4] = " \\";
		}
		for (int i = 0; i < COLUNA; i++) {
			for (int j = 0; j < LINHA; j++) {
				if (forca[i][j] == null) {
					forca[i][j] = "";
				}
			}
		}


		imprimir(forca);
	}
	
//	Definir aleatoridade
	public static int aleatorio() {
		Random random = new Random();
		int num = random.nextInt(5);
				
		return num;
	}
	
	public static String [] definirPalavra() { //uso de random para escolher palavra

		String palavra[] = { "java", "ucsal", "logica", "algoritmo", "tecnologia" };
		String temporaria = palavra[aleatorio()];
		String palavraFragmentada[] = new String[temporaria.length()];
		
		
		for (int i = 0; i < palavraFragmentada.length; i++) {
			palavraFragmentada[i]=temporaria.substring(i, i+1);
			
		}
		return palavraFragmentada;
	}

	
//	Metodos de impressão

	public static void imprimir(String[][] vlr) { //Imprime matriz (bidimensional)
		for (int i = 0; i < COLUNA; i++) {
			System.out.println("");
			for (int j = 0; j < LINHA; j++) {
				System.out.print(vlr[i][j]);
			}
		}
		System.out.println("");
	}

	public static void imprimir(String[] vlr) { //Imprime vetor (unidimensional)
		for (int i = 0; i < vlr.length; i++) {
			System.out.print(vlr[i] + " ");
		}
	}
}
