package br.ufrpe.so.simuladores.ntfs.app;

import java.util.ArrayList;
import java.util.Scanner;

import br.ufrpe.so.simuladores.ntfs.entity.Arquivo;
import br.ufrpe.so.simuladores.ntfs.entity.Bloco;

public class SimuladorNTFS {

	private ArrayList<Bloco> criaVolume() {
		return ( new ArrayList<Bloco>() );
	}
	
	/**
	 * Retorna um ponteiro para um arquivo.
	 * 
	 * @param tam
	 *            tamanho do arquivo cuja lista de blocos é retornada.
	 * @return ponteiro para a lista de blocos do arquivo criado.
	 */
	private ArrayList<Bloco> criaArquivo(int tam) {
		Arquivo arq = new Arquivo();
		// cria os blocos do arquivo
		for (int i = 1; i <= tam; i++) {
			
		}
		
		return ( new ArrayList<Bloco>() );
	}

	public void run() throws InterruptedException {
		Scanner input = new Scanner(System.in);
		String entrada; 

		System.out.println("========Menu==========");
		System.out.println("Escolha a opcão desejada:");
		System.out.println("1 - Criar Arquivo");
		System.out.println("2 - Sair");
		entrada = input.next();

		switch (entrada) {
		case "1":
			// System.out.println("Vamos criar o arquivo jajá...");
			/* Chama método desse Simulador, que cria um novo volume de disco */
			System.out.println("Criando novo volume de disco...");
			Thread.sleep(3000);
			criaVolume();
			
			break;
		case "2":
			System.out.println("Fechando Gerenciador de Arquivos...");

		default:
			break;
		}
		
		input.close();

	}

}

