package br.ufrpe.so.simuladores.ntfs.entity;

import java.util.ArrayList;

public class Volume {
	String nomeVolume;
	public Bloco[] blocos;
	private int blocosLivres;

	public Volume() {
		
	}
	
	/**/
	public Volume(String nomeVolume, int tamListaBlocos) {
		this.nomeVolume = nomeVolume;
		blocos = new Bloco[tamListaBlocos];
		/* inicializa os blocos no array */ 
		for (int i = 0; i < blocos.length; i++) {
			Bloco b = new Bloco();
			b.nome = "bloco " + i;
			b.nomeArquivo = " - ";
			b.disponivel = true;
			blocos[i] = b;
		}
		/* inicializa os blocos livres. Como o Volume acabou de ser criado
		 * nenhum bloco está ocupado. Logo os blocos livres são todos os blocos. 
		 * Considerando que os blocos serão de 1KB, então se o usuário entrar com tamanho 100
		 * teremos 100 blocos de 1KB cada. E, inicialmente, todos livres.*/
		this.blocosLivres = tamListaBlocos;
	}

	public void aloca(ArrayList<Bloco> blocos, Arquivo arq) {
		int alocados = 0;
		
		for (int i = 0; i < this.blocos.length; i++) {
			if (this.blocos[i].disponivel && alocados < blocos.size()) {
				
				this.blocos[i].disponivel = false;
				this.blocos[i].nomeArquivo = arq.nomeArquivo;
				alocados++;
				blocosLivres--;
			}
			
		}
		
	}

	public boolean temEspaco(int tamanho) {
		if (tamanho <= blocosLivres) {
			return true;
		}
		
		return false;
		
	}

	public void desaloca(String nomeArq) {
		for (int i = 0; i < this.blocos.length; i++) {
			if (this.blocos[i].nomeArquivo.equals(nomeArq)) {
				
				this.blocos[i].disponivel = true;
				this.blocos[i].nomeArquivo = "-";
				blocosLivres++;
			}
			
		}
	}

}
