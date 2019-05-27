package br.ufrpe.so.simuladores.ntfs.entity;

import java.util.ArrayList;

public class Arquivo {
	// Volume volume;
	public ArrayList<Bloco> blocos;
	public String nomeArquivo;
	public int tamanho;
	
	public Arquivo() {
		this.blocos = new ArrayList<>();
	}
	
	public Arquivo(String nomeArquivo, int tamanho) {
		// this.volume = volume;
		this.tamanho = tamanho;
		this.nomeArquivo = nomeArquivo;
		this.blocos = new ArrayList<>();
		fragmenta();
	}
	
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	/**
	 * Fragmenta o arquivo em blocos de 1KB.
	 *
	 */
	public void fragmenta() {
		for (int i = 0; i < tamanho; i++) {
			Bloco b = new Bloco();
			b.nomeArquivo = this.nomeArquivo;
			this.blocos.add(b);
		}
	}
	
	/**
	 * Aloca o arquivo na unidade de disco.
	 * 
	 * @param tam
	 *            tamanho do arquivo cuja lista de blocos é retornada.
	 * @return ponteiro para a lista de blocos do arquivo criado.
	 */
	public void aloca(Volume vol) {
		for (int i = 0; i < blocos.size(); i++) {
			Bloco bloco = blocos.get(i);
			// vol.firstFit(bloco);
		}
	}
}
