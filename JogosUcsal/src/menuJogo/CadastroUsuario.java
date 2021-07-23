package menuJogo;

import java.util.Scanner;

public class CadastroUsuario {
	
	static String nome = null;
	//Método para retornar o nome do jogador
	public String getNome() {
		return nome;
	}	
	
	//Método para gravar a variavel nome
	public static void cadastro() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Por favor insira seu nome");
		nome = sc.nextLine();
		//Aviso caso o jogador tente entrar sem digitar um nome
		while (nome.isEmpty()) {
			System.out.println("Nome não definido, por favor insira seu nome para iniciar a aplicação");
			nome = sc.nextLine();
		}
		if (nome!= null) {
			System.out.println("Obrigado por ter nos informado seu nome "+nome+" :)");
			System.out.println("Desejamos a você um bom jogo");
			System.out.println("------------------------------------------------------");
			System.out.print("\n");
		}
		
		
	}

}
