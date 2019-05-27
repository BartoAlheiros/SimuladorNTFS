package br.ufrpe.so.simuladores.ntfs.app;

import java.util.ArrayList;
import java.util.Scanner;

import br.ufrpe.so.simuladores.ntfs.entity.Arquivo;
import br.ufrpe.so.simuladores.ntfs.entity.Bloco;
import br.ufrpe.so.simuladores.ntfs.entity.Volume;

public class SimuladorNTFS {
	
	Volume vol = new Volume();

	private Volume criaVolume(String nome, int tamanho) {
		Volume vol = new Volume(nome, tamanho);
		return vol;
	}
	
	/**
	 * Retorna um ponteiro para um arquivo.
	 * 
	 * @param tam
	 *            tamanho do arquivo cuja lista de blocos é retornada.
	 * @return ponteiro para a lista de blocos do arquivo criado.
	 */
	private ArrayList<Bloco> criaArquivo(int tamanho, String nomeArquivo) {
		Arquivo arq = new Arquivo(nomeArquivo, tamanho);
		// cria os blocos do arquivo
		for (int i = 1; i <= tamanho; i++) {
			Bloco bloco = new Bloco();
			if(i == 1) {
				bloco.nome = "bloco 1";
			} else {
				bloco.nome = ("bloco " + i);
			}
		}
		
		return ( new ArrayList<Bloco>() );
	}

	public void run() throws InterruptedException {
		menu();
	}

	private void menu() throws InterruptedException {
		Scanner input = new Scanner(System.in);
		String entrada; 

		System.out.println("========NTFS SiMU==========");
		System.out.println("Versão 0.1. Maio 2019");
		System.out.println("Autor: Barto Alheiros");
		System.out.println("email: alheirosb@gmail.com");
		System.out.println("/help para ajuda");
		entrada = input.next();
		
		opcoes(entrada);
				
		input.close();

		
	}

	private void opcoes(String entrada) throws InterruptedException {
		Scanner input = new Scanner(System.in);
		
		switch (entrada) {
		case "/vol":
			int tamanhoVol;
			String nomeVol;
			// System.out.println("Vamos criar o arquivo jajá...");
			/* Chama método desse Simulador, que cria um novo volume de disco */
			System.out.println("Digite o tamanho da unidade: ");
			tamanhoVol = Integer.parseInt(input.next());
			System.out.println("Digite o nome da unidade: ");
			nomeVol = input.next();
			System.out.println("Criando novo volume de disco...");
			Thread.sleep(3000);
			vol = criaVolume(nomeVol, tamanhoVol);
			/* Mostra a unidade criada. */
			mostraUnidade();
			System.out.println();
			opcoes(input.next());
		
			// break;
			
		case "/help":
			System.out.println("/vol para criar novo volume");
			opcoes(input.next());
			
		case "/file":
			Arquivo arq = new Arquivo();
			String nomeArq = "";
			System.out.println("Digite o nome do arquivo ");
			nomeArq = input.next();
			// System.out.println("Nome " + arq.nomeArquivo + "\n" + "Confirmar? Y or N");
			confirmarNome(nomeArq, input);
			arq.nomeArquivo = nomeArq;
			System.out.println("Nome do arquivo é  "+ arq.nomeArquivo);
			
			System.out.println("Digite o tamanho do arquivo ");
			arq.tamanho = input.nextInt();
			
			aloca(arq, arq.tamanho, vol);
			
			
			mostraUnidade();
			System.out.println();
			opcoes(input.next());
			
		case "/delete":
			String nomeArqDel = ""; 
			System.out.println("Digite o nome do arquivo que voce quer deletar ");
			nomeArqDel = input.next();
			desaloca(nomeArqDel);
			mostraUnidade();
			opcoes(input.next());
			
		default:
			break;
		}
		
		input.close();
		
		
	}

	private void desaloca(String nomeArq) {
		vol.desaloca(nomeArq);
	}

	private void mostraUnidade() throws InterruptedException {
		for (int i = 0; i < vol.blocos.length; i++) {
			if (i % 10 == 0) {
				System.out.println();
			}
			System.out.print(vol.blocos[i].nome + " ");
			System.out.print(vol.blocos[i].nomeArquivo + " ");
		}
		
		
	}

	private void aloca(Arquivo arq, int tamanho, Volume vol) {
		arq.fragmenta();
	
		if (vol.temEspaco(tamanho)) {
			vol.aloca(arq.blocos, arq);
		}
		
	}

	private void confirmarNome(String nomeArq, Scanner input) {
		String confirma = "";
		
		do {
			System.out.println("Nome " + nomeArq + "\n" + "Confirmar? Y or N");
			confirma = input.next();
		} while(!confirma.equals("Y") && !confirma.equals("N")
				&& !confirma.equals("y") && !confirma.equals("n"));
	}

}

