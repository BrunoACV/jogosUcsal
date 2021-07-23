package menuJogo;

import java.util.Scanner;

public class MenuJogos {

	public static void escolherJogo() {
		CadastroUsuario obj = new CadastroUsuario();
		int status=0;
		//Repete enquanto o usuário não escolher numero de 1 - 4
		while (status == 0) {
			
			
		System.out.println(obj.getNome()+" escolha qual dos Jogos você deseja jogar: ");
		System.out.println("(1) Jogo da Forca \n(2) Batalha Naval \n(3) Jogo da Velha \n(4) Sair");
		
		Scanner ac = new Scanner(System.in); //não pode fechar o scanner!

		String n = ac.next(); //grava variavel string "n"
		
		
		//Switch Case para escolher o jogo ou sair
		switch (n) {
		case "1":
			jogoDaForca.JogoDaForca.executor();
			break;
		case "2":
			batalhaNaval.BatalhaNaval.executor();
			break;
		case "3":
			jogoDaVelha.JogoDaVelha.executor();
			break;
		case "4":
			status = 1;
			System.out.println("Execução Finalizada!");
			System.exit(0);
			break;
		default:
			System.out.println("");
			System.out.println("Essa opção não existe por favor tente novamente");
			System.out.println("");
			break;
		}
		}


	}
}
